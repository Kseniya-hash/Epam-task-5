package by.epamtc.dubovik.xmltask.parser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletContext;
import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.xml.sax.SAXException;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public class ParserFromServletContext {
	
	public static Schema takeSchema(InputStream xsdStream) throws XMLParserException {
		StreamSource xsdSource = new StreamSource(xsdStream);
		SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
		Schema schema;
		try {
			schema = sf.newSchema(xsdSource);
		} catch (SAXException e) {
			throw new XMLParserException("Cant create schema", e);
		}
        return schema;
	}
	
	public static List<Gem> takeGems(ServletContext context, 
			String xsdLocation, 
			String xmlLocation,
			ParserType parseType) throws XMLParserException{
		
		List<Gem> gems = null;
		InputStream xsdStream = null;
		InputStream xmlStream = null;
		try {
			xsdStream = context.getResourceAsStream(xsdLocation);
			Schema schema = takeSchema(xsdStream);
			
			xmlStream = context.getResourceAsStream(xmlLocation);
			
			GemBuilderFactory factory = new GemBuilderFactory(schema);
			AbstractGemBuilder builder = factory.createGemBuilder(parseType);
			builder.buildListGems(xmlStream);
			gems = builder.getGems();
		} finally {
			if(xsdStream != null) {
				try {
					xsdStream.close();
				} catch (IOException e) {
					throw new XMLParserException("Cant close XSD InputStream", e);
				}
			}
			
			if(xmlStream != null) {
				try {
					xmlStream.close();
				} catch (IOException e) {
					throw new XMLParserException("Cant close XML InputStream", e);
				}
			}
		}
		
		return gems;
	}
}
