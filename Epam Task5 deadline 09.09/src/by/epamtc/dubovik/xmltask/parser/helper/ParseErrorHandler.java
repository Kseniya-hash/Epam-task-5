package by.epamtc.dubovik.xmltask.parser.helper;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXParseException;

public class ParseErrorHandler implements ErrorHandler {
	private static Logger logger = LogManager.getLogger();
	
	@Override
	public void warning(SAXParseException e) {
		logger.warn(e);
	}
	
	@Override
	public void error(SAXParseException e) throws SAXParseException {
		logger.error(e);
	}
	
	@Override
	public void fatalError(SAXParseException e) {
		logger.fatal(e);
	}
}
