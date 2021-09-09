package by.epamtc.dubovik.xmltask.parser.helper;

import org.junit.Test;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;

import org.junit.Assert;

public class TestHelper {
	
	@Test
	public void isValidTestValid() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(50);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestPreciousnessNull() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(null);
		gem.setColor("красный");
		gem.setTransparency(50);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestWithoutDate() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(50);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestInvalidDate() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-19-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(50);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}

	@Test
	public void isValidTestTrasparencyLesserThan0() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(-1);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestTrasparency0() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(0);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestTrasparency100() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(100);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestTrasparencyMoreThan100() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(101);
		gem.setEdgeNumber(10);
		gem.setValue(5);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestEdgeNumberLesserThan4() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(100);
		gem.setEdgeNumber(3);
		gem.setValue(5);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestEdgeNumber4() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(100);
		gem.setEdgeNumber(4);
		gem.setValue(5);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestEdgeNumber15() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(100);
		gem.setEdgeNumber(15);
		gem.setValue(5);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestEdgeNumberMoreThan15() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(100);
		gem.setEdgeNumber(16);
		gem.setValue(5);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestValueLesserThan0() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(90);
		gem.setEdgeNumber(10);
		gem.setValue(-1);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestValue0() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(90);
		gem.setEdgeNumber(10);
		gem.setValue(0);
		
		boolean expected = false;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isValidTestValueMoreThan0() {
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setOriginDate(Helper.takeDate("2020-09-01"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(90);
		gem.setEdgeNumber(10);
		gem.setValue(0.1);
		
		boolean expected = true;
		boolean actual = Helper.isValid(gem);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isDoubleTestDouble() {
		String text =  "3.4";
		boolean expected = true;
		boolean actual = Helper.isDouble(text);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isDoubleTestNotDouble() {
		String text =  "3.4.";
		boolean expected = false;
		boolean actual = Helper.isDouble(text);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isIntTestInt() {
		String text =  "3";
		boolean expected = true;
		boolean actual = Helper.isDouble(text);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void isIntTestNotInt() {
		String text =  "3.";
		boolean expected = false;
		boolean actual = Helper.isInt(text);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void takePreciousnessTestPrecious() {
		String text =  "precious";
		Preciousness expected = Preciousness.PRECIOUS;
		Preciousness actual = Helper.takePreciousness(text);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void takePreciousnessTestSemiprecious() {
		String text =  "semiprecious";
		Preciousness expected = Preciousness.SEMIPRECIOUS;
		Preciousness actual = Helper.takePreciousness(text);
		
		Assert.assertEquals(expected, actual);
	}
	
	@Test
	public void takePreciousnessTestNotPrecious() {
		String text =  "semipr";
		Preciousness expected = null;
		Preciousness actual = Helper.takePreciousness(text);
		
		Assert.assertEquals(expected, actual);
	}
}
