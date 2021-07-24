package edu.cs401group3.crm.common;

import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.SimpleFormatter;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Log {
	private static FileHandler logFile;	
	private static SimpleFormatter textFormatter;
    public final static Logger LOGGER = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
    
    public Log() {
        Logger logger = Logger.getLogger(Logger.GLOBAL_LOGGER_NAME);
        
        logger.setLevel(Level.INFO);
        try {
        	logFile = new FileHandler("Logging.txt");
        	
        } catch (IOException e) {
        	e.printStackTrace();
        }
        
    	textFormatter = new SimpleFormatter();
    	logFile.setFormatter(textFormatter);
        logger.addHandler(logFile);
    }
}
