package by.epamtc.dubovik.xmltask.parser.builder;

import java.util.LinkedList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.helpers.DefaultHandler;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;
import by.epamtc.dubovik.xmltask.parser.helper.GemEnum;
import by.epamtc.dubovik.xmltask.parser.helper.Helper;

public class GemSAXContentHandler extends DefaultHandler {

	private List<Gem> gems;
	private Gem gem = null;
	private GemEnum gemEnum = null;
	
	public GemSAXContentHandler() {
		gems = new LinkedList<Gem>();
	}
	
	public List<Gem> getGems(){
		return gems;
	}
	
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attrs) {
		if(GemEnum.GEM.getValue().equals(localName)) {
			gem = new Gem();
			gem.setId(attrs.getValue(0));
			gem.setPreciousness(Preciousness.SEMIPRECIOUS);
			for(int i = 0; i < attrs.getLength(); i++) {
				GemEnum attrName = GemEnum.valueOf(attrs.getLocalName(i).toUpperCase());
				switch(attrName) {
				case ID:
					gem.setId(attrs.getValue(i));
					break;
				case PRECIOUSNESS:
					gem.setPreciousness(Helper.takePreciousness(attrs.getValue(i)));
					break;
				case ORIGIN:
					gem.setOrigin(attrs.getValue(i));
					break;
				case ORIGINDATE:
					gem.setOriginDate(Helper.takeDate(attrs.getValue(i)));
					break;
				}
			}
		} else {
			if(isGemEnum(localName.toUpperCase())) {
				gemEnum = GemEnum.valueOf(localName.toUpperCase());
			}
		}
	}
	
	private boolean isGemEnum(String s) {
		boolean flag = false;
		for (GemEnum element : GemEnum.values()) {
	        if (element.name().equals(s)) {
	            flag = true;
	            break;
	        }
	    }
	    return flag;
	}
	
	@Override
	public void characters(char[] ch, int start, int length) {
		String text = new String(ch, start, length).trim();
		if(gemEnum != null) {
			switch(gemEnum) {
				case NAME:
					gem.setName(text);
					break;
				case COLOR:
					gem.setColor(text);
					break;
				case TRANSPARENCY:
					if(Helper.isDouble(text)) {
						gem.setTransparency(Double.parseDouble(text));
					}
					break;
				case EDGENUMBER:
					if(Helper.isInt(text)) {
						gem.setEdgeNumber(Integer.parseInt(text));
					}
					break;
				case VALUE:
					if(Helper.isDouble(text)) {
						gem.setValue(Double.parseDouble(text));
					}
					break;
			}
			gemEnum = null;
		}
	}
	
	@Override 
	public void endElement(String uri, String localName, String qName) {
		if(GemEnum.GEM.getValue().equals(localName)) {
			if(Helper.isValid(gem)) {
				gems.add(gem);
			}
		}
	}
}
