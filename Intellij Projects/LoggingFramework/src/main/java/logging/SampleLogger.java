package logging;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Created by admin on 10/16/16.
 */
public class SampleLogger {

    private static Logger logger= LogManager.getRootLogger();

    public static void main(String[] args){

        //System.setProperty("log4j.configurationFile", "/Users/admin/Desktop/LoggingFramework/src/main/resources/configuration.xml");

        logger.error("This is error message");
        logger.info("this is info message");
        logger.fatal("this is fatal message");
        logger.debug("this is debug message");

    }


}
