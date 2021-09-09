package by.epamtc.dubovik.xmltask.parser.helper;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;

public class Helper {
	
	private static final String DATEPATTERN = "yyyy-MM-dd";
	
	public static boolean isValid(Gem gem) {
		boolean flag = true;
		if(gem.getPreciousness() == null) {
			flag = false;
		}
		if(gem.getOriginDate() != null && gem.getOriginDate().equals(LocalDate.MIN)) {
			flag = false;
		}
		if(gem.getTransparency() < 0 || gem.getTransparency() > 100) {
			flag = false;
		}
		if(gem.getEdgeNumber() < 4 || gem.getEdgeNumber() > 15) {
			flag = false;
		}
		if(gem.getValue() <= 0) {
			flag = false;
		}
		return flag;
	}
	
	public static boolean isDouble(String textDouble) {
		boolean flag = false;
		try {
			Double.parseDouble(textDouble);
			flag = true;
		} catch (NumberFormatException e) {}
		return flag;
	}
	
	public static boolean isInt(String textInt) {
		boolean flag = false;
		try {
			Integer.parseInt(textInt);
			flag = true;
		} catch (NumberFormatException e) {}
		return flag;
	}
	
	public static Preciousness takePreciousness(String text) {
		Preciousness preciousness = null;
		try {
			preciousness = Preciousness.valueOf(text.toUpperCase());
		}catch (IllegalArgumentException e) {}
		return preciousness;
	}

	public static LocalDate takeDate(String textDate) {
		LocalDate date = null;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATEPATTERN);
		try {
			date = LocalDate.parse(textDate, formatter);
		} catch (DateTimeParseException e) {
			date = LocalDate.MIN;
		}
		return date;
	}
}
