/* This pattern allows you to create multiple levels of responsiblity 
 * for your class structure. In this instance a Logger can be set to have
 * another instance of a Logger in it's hiacrchy. In this manner it is possible
 * to create a situation where you log something with the ErrorLogger (to the console)
 * as well as outputing something to the FileLogger (to a text file)  */

//----------------------------------------------------
// Main class
//----------------------------------------------------
public class cor{
    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers(); 

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.            " );
        loggerChain.logMessage(AbstractLogger.DEBUG,"This is an debug level information." );
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error information.      " );
    }

    private static AbstractLogger getChainOfLoggers(){
        AbstractLogger errorLogger   = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger    = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);

        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }
}

//----------------------------------------------------
// Abstract class for the Logger class. Manages the 
// level higharchy of the differnt loggers as well as 
// setting the level for the next Logger in the hiarchy
//----------------------------------------------------
abstract class AbstractLogger{
    public static int INFO  = 1;
    public static int DEBUG = 2;
    public static int ERROR = 3;

    protected int level;
    
    protected AbstractLogger nextLogger;
    
    public void setNextLogger(AbstractLogger nextLogger){
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message){
        if(this.level <= level){ //If this level is under another level write the log
            write(message);
        }
        if(nextLogger != null){ // If there is another level of logging then call the log message on that 
            nextLogger.logMessage(level,message);
        }
    }

    abstract protected void write(String message);
}

//----------------------------------------------------
// Concrete implementation of AbrstractLogger
//----------------------------------------------------
class ConsoleLogger extends AbstractLogger{

    public ConsoleLogger(int level){ // INFO = 1
        this.level = level;
    }

    @Override protected void write(String message){
        System.out.println("Standard Console::Logger: " + message);
    }
}

//----------------------------------------------------
// Concrete implementation of AbrstractLogger
//----------------------------------------------------
class ErrorLogger extends AbstractLogger{

    public ErrorLogger(int level){ // ERROR = 3
        this.level = level;
    }

    @Override protected void write(String message){
        System.out.println("Error::Logger: " + message);
    }
}

//----------------------------------------------------
// Concrete implementation of AbrstractLogger
//----------------------------------------------------
class FileLogger extends AbstractLogger{

    public FileLogger(int level){
        this.level = level;
    }

    @Override protected void write(String message){
        System.out.println("File::Logger: " + message);
    }
}

