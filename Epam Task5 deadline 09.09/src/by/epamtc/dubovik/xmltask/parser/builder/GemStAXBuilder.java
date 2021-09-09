package by.epamtc.dubovik.xmltask.parser.builder;

import java.io.InputStream;
import java.util.LinkedList;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.validation.Schema;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;
import by.epamtc.dubovik.xmltask.parser.AbstractGemBuilder;
import by.epamtc.dubovik.xmltask.parser.helper.GemEnum;
import by.epamtc.dubovik.xmltask.parser.helper.Helper;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public class GemStAXBuilder extends AbstractGemBuilder{
	
	private XMLInputFactory inputFactory;
	private Schema schema;
	
	public GemStAXBuilder(Schema xsd) throws XMLParserException {
		inputFactory = XMLInputFactory.newInstance();
		schema = xsd;
	}
	
	@Override
	public void buildListGems(InputStream xmlStream) throws XMLParserException {
		
		XMLStreamReader reader = null;
		String name;
		gems = new LinkedList<Gem>();
		try {
			reader = inputFactory.createXMLStreamReader(xmlStream);
			while(reader.hasNext()) {
				int type = reader.next();
				if(type == XMLStreamConstants.START_ELEMENT) {
					name = reader.getLocalName();
					if(GemEnum.valueOf(name.toUpperCase()) == GemEnum.GEM) {
						Gem gem = buildGem(reader);
						if(Helper.isValid(gem)) {
							gems.add(gem);
						}
					}
				}
			}
		} catch (XMLStreamException e) {
			throw new XMLParserException("XMLStreamException during StAX parse", e); 
		}
	}
	
	private Gem buildGem(XMLStreamReader reader) throws XMLParserException{
		Gem gem = new Gem();
		gem.setPreciousness(Preciousness.SEMIPRECIOUS);
		for(int i = 0; i < reader.getAttributeCount(); i++) {
			GemEnum attrName = GemEnum.valueOf(reader.getAttributeLocalName(i).toUpperCase());
			switch(attrName) {
			case ID:
				gem.setId(reader.getAttributeValue(i));
				break;
			case PRECIOUSNESS:
				gem.setPreciousness(Helper.takePreciousness(reader.getAttributeValue(i)));
				break;
			case ORIGIN:
				gem.setOrigin(reader.getAttributeValue(i));
				break;
			case ORIGINDATE:
				String dateString = reader.getAttributeValue(i);
				gem.setOriginDate(Helper.takeDate(dateString));
				break;
			}
		}
		String name;
		try {
			while(reader.hasNext()) {
				int type = reader.next();
				switch(type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					switch(GemEnum.valueOf(name.toUpperCase())) {
					case NAME:
						gem.setName(takeXMLText(reader));	
						break;
					case VISUALPARAMETERS:
						takeVisualParameters(reader, gem);
						break;
					}
					break;
				case XMLStreamConstants.END_ELEMENT:
					name = reader.getLocalName();
					if(GemEnum.valueOf(name.toUpperCase()) == GemEnum.GEM) {
						return gem;
					}
					break;
				}
			}

		}
		catch (XMLStreamException e){	
			throw new XMLParserException("XMLStreamException during StAX parse of gem", e); 
		}
		throw new XMLParserException("Unknown element in StAX parse of gem"); 	
	}
	
	private void takeVisualParameters(XMLStreamReader reader, Gem gem) throws XMLParserException {
		int type;
		String name;
		try {
			while(reader.hasNext()) {
				type = reader.next();
				switch(type) {
				case XMLStreamConstants.START_ELEMENT:
					name = reader.getLocalName();
					String text;
					switch(GemEnum.valueOf(name.toUpperCase())) {
					case COLOR:
						gem.setColor(takeXMLText(reader));
						break;
					case TRANSPARENCY:
						text = takeXMLText(reader);
						if(Helper.isDouble(text)) {
							gem.setTransparency(Double.parseDouble(text));
						}
						break;
					case EDGENUMBER:
						text = takeXMLText(reader);
						if(Helper.isInt(text)) {
							gem.setEdgeNumber(Integer.parseInt(text));
						}
						break;
					case VALUE:
						text = takeXMLText(reader);
						if(Helper.isDouble(text)) {
							gem.setValue(Double.parseDouble(text));
						}
						break;
				}
					break;
				case XMLStreamConstants.END_ELEMENT:
					name = reader.getLocalName();
					if(GemEnum.valueOf(name.toUpperCase()) == GemEnum.VISUALPARAMETERS) {
						return;
				}
					break;
				}
			}
		}
		catch (XMLStreamException e){	
			throw new XMLParserException("Exception during StAX parse of visual parameters", e); 
		}
		throw new XMLParserException("Unknown element in StAX parse of visual parameters"); 	
	}
	
	private String takeXMLText(XMLStreamReader reader) throws XMLStreamException {
		String text = null;
		if(reader.hasNext()) {
			reader.next();
			text = reader.getText();
		}
		return text;
	}
}
