package by.epamtc.dubovik.xmltask.parser.builder;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import javax.xml.validation.Schema;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;

import by.epamtc.dubovik.xmltask.parser.AbstractGemBuilder;
import by.epamtc.dubovik.xmltask.parser.helper.ParseErrorHandler;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public class GemSAXBuilder extends AbstractGemBuilder{
	
	private GemSAXContentHandler handler;
	private SAXParser parser;
	private XMLReader reader;
	
	public GemSAXBuilder(Schema xsd) throws XMLParserException{
		handler = new GemSAXContentHandler();
		
		try {
			SAXParserFactory spf = SAXParserFactory.newInstance();
			spf.setSchema(xsd);
			spf.setNamespaceAware(true);
			parser = spf.newSAXParser();
			reader = parser.getXMLReader();
			reader.setErrorHandler(new ParseErrorHandler());
			reader.setContentHandler(handler);
		} catch (SAXException e) {
			throw new XMLParserException("SAXException during SAXBuilder", e);
		} catch (ParserConfigurationException e) {
			throw new XMLParserException("ParserConfigurationException during SAXBuilder", e);
		}
	}
	
	@Override
	public void buildListGems(InputStream xmlStream) throws XMLParserException {
		try {
			InputSource xmlSource = new InputSource(xmlStream);
			reader.parse(xmlSource);
		} catch (IOException e) {
			throw new XMLParserException("IOException during SAX parse", e);
		} catch (SAXException e) {
			throw new XMLParserException("SAXException during SAX parse", e);
		}
		gems = handler.getGems();
	}
}
