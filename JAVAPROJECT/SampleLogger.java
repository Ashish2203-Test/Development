
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class SampleLogger{

static Logger logger=LogManager.getRootLogger();

public static void main(String[] args){

logger.error("this is error");
logger.fatal("this is fatal");


}



}