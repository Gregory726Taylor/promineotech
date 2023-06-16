package week5;

public interface Logger {
	    void log(String message);
	    void error(String message);
	}

	class AsteriskLogger implements Logger {
	    @Override
	    public void log(String message) {
	        System.out.println("***" + message + "***");
	    }

	    @Override
	    public void error(String message) {
	        System.out.println("****************");
	        System.out.println("***ERROR: " + message + "***");
	        System.out.println("****************");
	    }
	}

	class SpacedLogger implements Logger {
	    @Override
	    public void log(String message) {
	        StringBuilder spacedMessage = new StringBuilder();
	        for (int i = 0; i < message.length(); i++) {
	            spacedMessage.append(message.charAt(i)).append(" ");
	        }
	        System.out.println(spacedMessage.toString());
	    }

	    @Override
	    public void error(String message) {
	        StringBuilder spacedErrorMessage = new StringBuilder("ERROR: ");
	        for (int i = 0; i < message.length(); i++) {
	            spacedErrorMessage.append(message.charAt(i)).append(" ");
	        }
	        System.out.println(spacedErrorMessage.toString());
	    }
	}
	
