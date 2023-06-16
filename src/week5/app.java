package week5;

	public class app {
	    public static void main(String[] args) {
	        Logger asteriskLogger = new AsteriskLogger();
	        Logger spacedLogger = new SpacedLogger();

	        asteriskLogger.log("Hello");
	        asteriskLogger.error("Hello");

	        System.out.println("============");

	        spacedLogger.log("Hello");
	        spacedLogger.error("Hello");
	    }
	}
