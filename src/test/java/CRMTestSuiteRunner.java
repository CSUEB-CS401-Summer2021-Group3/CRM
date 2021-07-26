import edu.cs401group3.crm.fileio.FileOperationTest;
import edu.cs401group3.crm.messages.*;
import edu.cs401group3.crm.record.RecordTest;
import edu.cs401group3.crm.storage.StorageManagerTest;
import edu.cs401group3.crm.auth.*;

import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;


public class CRMTestSuiteRunner {
	public static void main(String[] args) {
		int totalTestCases = 0;
		int totalFailedCases = 0;
		System.out.println("Running Message Test Suite");
		System.out.println("####################################################");
		System.out.println("Running Command Message Test");
		Result result = JUnitCore.runClasses(CommandMessageTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());

		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		   
		System.out.println("####################################################");
		System.out.println("Running Storage Message Test");
		result = JUnitCore.runClasses(StorageMessageTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		   
		System.out.println("####################################################");
		System.out.println("Running Authentication Message Test");
		result = JUnitCore.runClasses(AuthenticationMessageTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		   
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		
		System.out.println("####################################################");
		System.out.println("Running FileOperation Test");
		result = JUnitCore.runClasses(FileOperationTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		   
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		
		System.out.println("####################################################");
		System.out.println("Running StorageManager Test");
		result = JUnitCore.runClasses(StorageManagerTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		   
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		
		System.out.println("####################################################");
		System.out.println("Running Record Test");
		result = JUnitCore.runClasses(RecordTest.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		   
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		
		System.out.println("####################################################");
		System.out.println("Running Login Test");
		result = JUnitCore.runClasses(login_test.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		   
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		
		System.out.println("####################################################");
		System.out.println("Running SHA Test");
		result = JUnitCore.runClasses(SHA_test.class);
		for (Failure failure : result.getFailures()) {
			System.out.println(failure.toString());
		}
		   
		System.out.println("\nTest Case Summary");
		System.out.println("Total test cases ran: " + result.getRunCount());
		System.out.println("Total failed test caes: " + result.getFailureCount());
		System.out.println("Test case was successful? : " + result.wasSuccessful());
		totalTestCases += result.getRunCount();
		totalFailedCases += result.getFailureCount();
		System.out.println("####################################################\n");
		
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("####################################################\n");
		System.out.println("Total Ran Test Cases: " + totalTestCases);
		System.out.println("Total Failed Test Cases: " + totalFailedCases);
	}
}
