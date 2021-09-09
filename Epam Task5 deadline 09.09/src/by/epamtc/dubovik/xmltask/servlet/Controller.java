package by.epamtc.dubovik.xmltask.servlet;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import by.epamtc.dubovik.xmltask.entity.Gem;
import by.epamtc.dubovik.xmltask.entity.Preciousness;
import by.epamtc.dubovik.xmltask.parser.ParserFromServletContext;
import by.epamtc.dubovik.xmltask.parser.ParserType;
import by.epamtc.dubovik.xmltask.parser.helper.Helper;
import by.epamtc.dubovik.xmltask.parser.helper.XMLParserException;

public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static Logger logger = LogManager.getLogger();
	private static String XSDLOCATION = "/WEB-INF/classes/resources/gemSchema.xsd";
	private static String XMLLOCATION = "/WEB-INF/classes/resources/gems.xml";
	private static String COMMAND = "command";
	
    public Controller() {
        super();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			ParserType parserType = ParserType.valueOf(request.getParameter(COMMAND).toUpperCase());
			List<Gem> gems = ParserFromServletContext.takeGems(getServletContext(), 
					XSDLOCATION, 
					XMLLOCATION, 
					parserType);
			System.out.println("Драгоценные камни:");
			for(Gem current : gems) {
				System.out.println(gemToFormattedString(current));
			}
		} catch (XMLParserException e) {
			logger.error(e);
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private String gemToFormattedString(Gem gem) {
		StringBuffer buffer = new StringBuffer();
		buffer.append("ID : " + gem.getId());
		buffer.append("\nЦенность : ");
		buffer.append(Preciousness.PRECIOUS.equals(gem.getPreciousness())?"драгоценный":"полудрагоценный");
		buffer.append("\nНазвание : " + gem.getName());
		if(gem.getOrigin() != null) {
			buffer.append("\nМесто добычи : " + gem.getOrigin());
		}
		if(gem.getOriginDate() != null) {
			buffer.append("\nДата добычи : " + gem.getOriginDate());
		}
		buffer.append("\nВнешние характеристики : ");
		buffer.append("\nЦвет : " + gem.getColor());
		buffer.append("\nПрозрачность : " + gem.getTransparency());
		buffer.append("\nКоличество граней : " + gem.getEdgeNumber());
		buffer.append("\nВес (карат) : " + gem.getValue());
		buffer.append("\n");
		return buffer.toString();
	}
}
