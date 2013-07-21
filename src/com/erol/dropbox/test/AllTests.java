package com.erol.dropbox.test;

import junit.framework.Test;
import junit.framework.TestSuite;

public class AllTests {

	public static Test suite() {
		TestSuite suite = new TestSuite(AllTests.class.getName());
		//$JUnit-BEGIN$
		suite.addTest(TestSuite.createTest(TestDropBox.class, "testCreateFolder"));
		suite.addTest(TestSuite.createTest(TestDropBox.class, "testDeleteFolder"));
		suite.addTest(TestSuite.createTest(TestDropBox.class, "testCreateTxtFile"));
		//$JUnit-END$
		return suite;
	}

}
