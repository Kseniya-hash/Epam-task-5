package by.epamtc.dubovik.xmltask.parser.builder;

import java.util.LinkedList;
import java.util.List;

import org.junit.Assert;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;
import by.epamtc.dubovik.xmltask.parser.helper.Helper;

public class ExpectedLists {
	
	public static List<Gem> expectedListAllValid;
	
	static {
		expectedListAllValid = new LinkedList<Gem>();
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Рубин");
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("красный");
		gem.setTransparency(0);
		gem.setEdgeNumber(10);
		gem.setValue(3);
		expectedListAllValid.add(gem);
		
		gem = new Gem();
		gem.setId("ID-2");
		gem.setName("Брилиант");
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("голубой");
		gem.setTransparency(20);
		gem.setEdgeNumber(15);
		gem.setValue(1.5);
		expectedListAllValid.add(gem);
		
		gem = new Gem();
		gem.setId("ID-3");
		gem.setName("Изумруд");
		gem.setOrigin("Колумбия");
		gem.setOriginDate(Helper.takeDate("2015-09-23"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("зеленый");
		gem.setTransparency(80);
		gem.setEdgeNumber(5);
		gem.setValue(10);
		expectedListAllValid.add(gem);
		
		gem = new Gem();
		gem.setId("ID-6");
		gem.setName("Аметист");
		gem.setPreciousness(Preciousness.SEMIPRECIOUS);
		gem.setColor("фиолетовый");
		gem.setTransparency(90);
		gem.setEdgeNumber(5);
		gem.setValue(4.5);
		expectedListAllValid.add(gem);
	}

	public static List<Gem> expectedListEmpty = new LinkedList<>();
	
	public static List<Gem> expectrdListHasInvalidGems;
	
	static {
		expectrdListHasInvalidGems = new LinkedList<Gem>();
		Gem gem = new Gem();
		gem.setId("ID-1");
		gem.setName("Брилиант");
		gem.setOriginDate(Helper.takeDate("2000-09-23"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("голубой");
		gem.setTransparency(0);
		gem.setEdgeNumber(10);
		gem.setValue(1);
		expectrdListHasInvalidGems.add(gem);
		
		gem = new Gem();
		gem.setId("ID-5");
		gem.setName("Сапфир");
		gem.setOrigin("США");
		gem.setOriginDate(Helper.takeDate("2000-09-23"));
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("синий");
		gem.setTransparency(50);
		gem.setEdgeNumber(12);
		gem.setValue(7.5);
		expectrdListHasInvalidGems.add(gem);
		
		gem = new Gem();
		gem.setId("ID-6");
		gem.setName("Аметист");
		gem.setPreciousness(Preciousness.SEMIPRECIOUS);
		gem.setColor("фиолетовый");
		gem.setTransparency(90);
		gem.setEdgeNumber(5);
		gem.setValue(4.5);
		expectrdListHasInvalidGems.add(gem);
		
		gem = new Gem();
		gem.setId("ID-8");
		gem.setName("Сапфир");
		gem.setOrigin("Индия");
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("синий");
		gem.setTransparency(30);
		gem.setEdgeNumber(8);
		gem.setValue(10);
		expectrdListHasInvalidGems.add(gem);
		
		gem = new Gem();
		gem.setId("ID-13");
		gem.setName("Брилиант");
		gem.setPreciousness(Preciousness.PRECIOUS);
		gem.setColor("желтый");
		gem.setTransparency(10);
		gem.setEdgeNumber(15);
		gem.setValue(10);
		expectrdListHasInvalidGems.add(gem);
	}
}
