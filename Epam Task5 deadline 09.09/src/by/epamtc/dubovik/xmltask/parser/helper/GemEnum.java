package by.epamtc.dubovik.xmltask.parser.helper;

public enum GemEnum {

	GEMS("gems"),
	GEM("gem"),
	ID("id"),
	NAME("name"),
	ORIGIN("origin"),
	ORIGINDATE("originDate"),
	PRECIOUSNESS("preciousness"),
	COLOR("color"),
	TRANSPARENCY("transparency"),
	EDGENUMBER("edgeNumber"),
	VALUE("value"),
	VISUALPARAMETERS("visualParameters");
	
	private String value;
	
	private GemEnum(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
