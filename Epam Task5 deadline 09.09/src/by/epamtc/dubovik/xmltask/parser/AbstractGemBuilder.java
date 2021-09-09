package by.epamtc.dubovik.xmltask.parser;

import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public abstract class AbstractGemBuilder {
	protected List<Gem> gems;
	
	public AbstractGemBuilder() {
		gems = new LinkedList<Gem>();
	}
	
	public List<Gem> getGems(){
		return gems;
	}
	
	abstract public void buildListGems(InputStream xmlStream) throws XMLParserException;
}
