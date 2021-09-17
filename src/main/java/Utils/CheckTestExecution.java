package Utils;

import org.testng.SkipException;

public class CheckTestExecution {
	
	public static void toCheckExecution(String executionRequired) {
		
		// if execution required field is no
		if(executionRequired.equalsIgnoreCase("no")) {
			throw new SkipException("Skipping this exception");
		}
		
		// if execution required field is empty
		if(executionRequired.equalsIgnoreCase("")) {
			throw new SkipException("Skipping this exception");
		}
	}
}
