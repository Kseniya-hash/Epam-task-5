package by.epamtc.dubovik.xmltask.parser.builder;

import org.junit.*;
import org.xml.sax.SAXException;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.Schema;
import javax.xml.validation.SchemaFactory;

import org.junit.Assert;

public class TestGemDOMBuilder {
	
	@Test
	public void getGemsTestAllGemsValid() throws XMLParserException, SAXException, FileNotFoundException {
		List<Gem> expected = ExpectedLists.expectedListAllValid;
		List<Gem> actual = null;
		
		String xsdLocation = "src/resources/gemSchema.xsd";
		String xmlLocation = "test/resources/testAllGemsValid.xml";
		
		InputStream xsdStream = null;
		InputStream xmlStream = null;
		try {
			xsdStream = new FileInputStream(xsdLocation);
			StreamSource xsdSource = new StreamSource(xsdStream);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(xsdSource);
			
			xmlStream = new FileInputStream(xmlLocation);
			
			GemDOMBuilder builder = new GemDOMBuilder(schema);
			builder.buildListGems(xmlStream);
			actual = builder.getGems();
		} finally {
			if(xsdStream != null) {
				try {
					xsdStream.close();
				} catch (IOException e) {}
			}
			
			if(xmlStream != null) {
				try {
					xmlStream.close();
				} catch (IOException e) {}
			}
		}
		
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void getGemsTestEmpty() throws XMLParserException, SAXException, FileNotFoundException {
		List<Gem> expected = ExpectedLists.expectedListEmpty;
		List<Gem> actual = null;
		
		String xsdLocation = "src/resources/gemSchema.xsd";
		String xmlLocation = "test/resources/testEmpty.xml";
		
		InputStream xsdStream = null;
		InputStream xmlStream = null;
		try {
			xsdStream = new FileInputStream(xsdLocation);
			StreamSource xsdSource = new StreamSource(xsdStream);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(xsdSource);
			
			xmlStream = new FileInputStream(xmlLocation);
			
			GemDOMBuilder builder = new GemDOMBuilder(schema);
			builder.buildListGems(xmlStream);
			actual = builder.getGems();
		} finally {
			if(xsdStream != null) {
				try {
					xsdStream.close();
				} catch (IOException e) {}
			}
			
			if(xmlStream != null) {
				try {
					xmlStream.close();
				} catch (IOException e) {}
			}
		}
		
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test
	public void getGemsTestHasInvalidGems() throws XMLParserException, SAXException, FileNotFoundException {
		List<Gem> expected = ExpectedLists.expectrdListHasInvalidGems;
		List<Gem> actual = null;
		
		String xsdLocation = "src/resources/gemSchema.xsd";
		String xmlLocation = "test/resources/testHasInvalidGems.xml";
		
		InputStream xsdStream = null;
		InputStream xmlStream = null;
		try {
			xsdStream = new FileInputStream(xsdLocation);
			StreamSource xsdSource = new StreamSource(xsdStream);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(xsdSource);
			
			xmlStream = new FileInputStream(xmlLocation);
			
			GemDOMBuilder builder = new GemDOMBuilder(schema);
			builder.buildListGems(xmlStream);
			actual = builder.getGems();
		} finally {
			if(xsdStream != null) {
				try {
					xsdStream.close();
				} catch (IOException e) {}
			}
			
			if(xmlStream != null) {
				try {
					xmlStream.close();
				} catch (IOException e) {}
			}
		}
		
		Assert.assertArrayEquals(expected.toArray(), actual.toArray());
	}
	
	@Test(expected = XMLParserException.class)
	public void buildListGemsTestInvalidXML() throws XMLParserException, SAXException, FileNotFoundException {
		List<Gem> actual = null;
		
		String xsdLocation = "src/resources/gemSchema.xsd";
		String xmlLocation = "test/resources/testInvalidXML.xml";
		
		InputStream xsdStream = null;
		InputStream xmlStream = null;
		try {
			xsdStream = new FileInputStream(xsdLocation);
			StreamSource xsdSource = new StreamSource(xsdStream);
			SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);
			Schema schema = sf.newSchema(xsdSource);
			
			xmlStream = new FileInputStream(xmlLocation);
			
			GemDOMBuilder builder = new GemDOMBuilder(schema);
			builder.buildListGems(xmlStream);
		} finally {
			if(xsdStream != null) {
				try {
					xsdStream.close();
				} catch (IOException e) {}
			}
			
			if(xmlStream != null) {
				try {
					xmlStream.close();
				} catch (IOException e) {}
			}
		}
	}

}
