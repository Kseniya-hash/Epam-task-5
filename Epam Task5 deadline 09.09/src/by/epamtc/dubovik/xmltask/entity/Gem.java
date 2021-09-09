package by.epamtc.dubovik.xmltask.entity;

import java.io.Serializable;
import java.time.LocalDate;

public class Gem implements Serializable{
	
	private String id;
	private String name;
	private String origin;
	private LocalDate originDate;
	private Preciousness preciousness;
	private String color;
	private double transparency;
	private int edgeNumber;
	private double value;
	
	public Gem() {}
	
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getOrigin() {
		return this.origin;
	}
	
	public void setOrigin(String origin) {
		this.origin = origin;
	}
	
	public LocalDate getOriginDate() {
		return this.originDate;
	}
	
	public void setOriginDate(LocalDate originDate) {
		this.originDate = originDate;
	}
	
	public Preciousness getPreciousness() {
		return this.preciousness;
	}
	
	public void setPreciousness(Preciousness preciousness) {
		this.preciousness = preciousness;
	}

	public String getColor() {
		return this.color;
	}
	
	public void setColor(String color) {
		this.color = color;
	}
	
	public double getTransparency() {
		return this.transparency;
	}
	
	public void setTransparency(double transparency) {
		this.transparency = transparency;
	}
	
	public double getEdgeNumber() {
		return this.edgeNumber;
	}
	
	public void setEdgeNumber(int edgeNumber) {
		this.edgeNumber = edgeNumber;
	}
	
	public double getValue() {
		return this.value;
	}
	
	public void setValue(double value) {
		this.value = value;
	}
	
	@Override
	public boolean equals(Object o) {
		if(this == o)
			return true;
		if(o == null)
			return false;
		if(this.getClass() != o.getClass())
			return false;
		Gem other = (Gem)o;
		if(	equalsWithNull(this.id, other.getId()) &&
			equalsWithNull(this.name, other.getName()) &&
			equalsWithNull(this.origin, other.getOrigin()) &&
			equalsWithNull(this.originDate, other.getOriginDate()) &&
			equalsWithNull(this.preciousness, other.getPreciousness()) &&
			equalsWithNull(this.color, other.getColor()) &&
			this.transparency == other.getTransparency() &&
			this.edgeNumber == other.getEdgeNumber() &&
			this.value == other.getValue()) {
			return true;
		}
		return false;
	}
	
	private boolean equalsWithNull(Object o1, Object o2) {
		return o1 != null ? o1.equals(o2) : o2 == null;
	}
	
	@Override
	public int hashCode() {
		int result = 1;
		int prime = 31;
		result = result * prime + hashCodeWithNull(id);
		result = result * prime + hashCodeWithNull(name);
		result = result * prime + hashCodeWithNull(origin);
		result = result * prime + hashCodeWithNull(originDate);
		result = result * prime + hashCodeWithNull(preciousness);
		result = result * prime + hashCodeWithNull(color);
		result = result * prime + (int)transparency;
		result = result * prime + edgeNumber;
		result = result * prime + (int)value;
		return result;
	}
	
	private int hashCodeWithNull(Object o) {
		return o != null ? o.hashCode() : 0;
	}
	
	@Override
	public String toString() {
		StringBuffer result = new StringBuffer(this.getClass().getName() + "@");
		result.append(id + ",");
		result.append(name + ",");
		result.append(origin + ",");
		result.append(originDate + ",");
		result.append(preciousness + ",");
		result.append(color + ",");
		result.append(transparency + ",");
		result.append(edgeNumber + ",");
		result.append(value);
		return result.toString();
	}
}
