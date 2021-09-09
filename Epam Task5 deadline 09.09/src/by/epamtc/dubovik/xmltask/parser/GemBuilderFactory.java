package by.epamtc.dubovik.xmltask.parser;

import java.util.HashMap;
import java.util.Map;

import javax.xml.validation.Schema;

import by.epamtc.dubovik.xmltask.parser.builder.*;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public class GemBuilderFactory {
	
	private Map<ParserType, AbstractGemBuilder> parserMap;
	
	public GemBuilderFactory(Schema xsdSchema) throws XMLParserException {
		parserMap = new HashMap<ParserType, AbstractGemBuilder>();
		parserMap.put(ParserType.SAX, new GemSAXBuilder(xsdSchema));
		parserMap.put(ParserType.DOM, new GemDOMBuilder(xsdSchema));
		parserMap.put(ParserType.STAX, new GemStAXBuilder(xsdSchema));
	}
	
	public AbstractGemBuilder createGemBuilder(ParserType type) {
		return parserMap.get(type);
	}

}
