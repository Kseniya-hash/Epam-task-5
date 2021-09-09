package by.epamtc.dubovik.xmltask.parser.builder;

import java.io.IOException;
import java.io.InputStream;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.validation.Schema;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;
import by.epamtc.dubovik.xmltask.parser.AbstractGemBuilder;
import by.epamtc.dubovik.xmltask.parser.helper.GemEnum;
import by.epamtc.dubovik.xmltask.parser.helper.Helper;
import by.epamtc.dubovik.xmltask.parser.helper.ParseErrorHandler;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public class GemDOMBuilder extends AbstractGemBuilder {
	
	private DocumentBuilder docBuilder;
	
	public GemDOMBuilder(Schema xsd) throws XMLParserException {
		this.gems = new LinkedList<Gem>();
		DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
		
		factory.setSchema(xsd);
		factory.setNamespaceAware(true);
		try {
			docBuilder = factory.newDocumentBuilder(); 
			docBuilder.setErrorHandler(new ParseErrorHandler());
		} catch(ParserConfigurationException e) {
			throw new XMLParserException("Can not configurate DocumentBuilderFactory", e);
		}
	}
	
	@Override
	public void buildListGems(InputStream xmlStream) throws XMLParserException {
		Document doc = null;
		try {
			doc = docBuilder.parse(xmlStream);
			Element root = doc.getDocumentElement();
			
			NodeList gemsList = root.getElementsByTagName(GemEnum.GEM.getValue());
			for(int i = 0; i < gemsList.getLength(); i++) {
				Element gemElement = (Element)gemsList.item(i);
				Gem gem = buildGem(gemElement);
				if(Helper.isValid(gem)) {
					gems.add(gem);
				}
			}
		} catch (IOException e) {
			throw new XMLParserException("IOException in XML file", e);
		} catch (SAXException e){
			throw new XMLParserException("SAXException during DOM parse", e);
		}
	}
	
	private Gem buildGem(Element gemElement) {
		Gem gem = new Gem();
		gem.setId(gemElement.getAttribute(GemEnum.ID.getValue()));
		if(gemElement.hasAttribute(GemEnum.ORIGIN.getValue())) {
			gem.setOrigin(gemElement.getAttribute(GemEnum.ORIGIN.getValue()));
		}
		if(gemElement.hasAttribute(GemEnum.ORIGINDATE.getValue())) {
			String dateString = gemElement.getAttribute(GemEnum.ORIGINDATE.getValue());
			gem.setOriginDate(Helper.takeDate(dateString));
		}
		gem.setPreciousness(Preciousness.SEMIPRECIOUS);
		if(gemElement.hasAttribute(GemEnum.PRECIOUSNESS.getValue())) {
			String preciousnessString = gemElement.getAttribute(GemEnum.PRECIOUSNESS.getValue());
			gem.setPreciousness(Helper.takePreciousness(preciousnessString));
		}
		gem.setName(takeElementTextContent(gemElement, GemEnum.NAME.getValue()));
		Element visualParameters = (Element)gemElement.getElementsByTagName(GemEnum.VISUALPARAMETERS.getValue()).item(0);
		gem.setColor(takeElementTextContent(visualParameters, GemEnum.COLOR.getValue()));
		String text = takeElementTextContent(visualParameters, GemEnum.TRANSPARENCY.getValue());
		if(Helper.isDouble(text)) {
			gem.setTransparency(Double.parseDouble(text));
		}
		text = takeElementTextContent(visualParameters, GemEnum.EDGENUMBER.getValue());
		if(Helper.isInt(text)) {
			gem.setEdgeNumber(Integer.parseInt(text));
		}
		text = takeElementTextContent(visualParameters, GemEnum.VALUE.getValue());
		if(Helper.isDouble(text)) {
			gem.setValue(Double.parseDouble(text));
		}
		return gem;
	}
	
	private static String takeElementTextContent(Element element, String elementName) {
		NodeList nList = element.getElementsByTagName(elementName);
		Node node = nList.item(0);
		String text = node.getTextContent();
		return text;
	}
}
