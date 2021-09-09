package by.epamtc.dubovik.xmltask.entity;

public enum Preciousness {
	
	PRECIOUS("драгоценный"),
	SEMIPRECIOUS("полудрагоценный");
	
	private String value;
	
	private Preciousness(String value) {
		this.value = value;
	}
	
	public String getValue() {
		return value;
	}
}
