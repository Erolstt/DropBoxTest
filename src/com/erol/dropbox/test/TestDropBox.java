package com.erol.dropbox.test;

import com.jayway.android.robotium.solo.Solo;

import android.test.ActivityInstrumentationTestCase2;

public class TestDropBox extends ActivityInstrumentationTestCase2 {
	
	private static final String FULL_CLASSNAME = "com.dropbox.android.activity.DropboxBrowser";
	private static Class DropBoxActivityClass;
	
	static {
		
		try {
			DropBoxActivityClass = Class.forName(FULL_CLASSNAME);
			
		} catch (ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public TestDropBox() throws ClassNotFoundException {
		super(DropBoxActivityClass);
		
	}
	
	private Solo solo;
	
	protected void setUp(){
		solo = new Solo(getInstrumentation(), getActivity());	
	}
	protected void tearDown() throws Exception{
		solo.finishOpenedActivities();
	}
	
	//vars
	String folderName= "Test Folder";
	String deleteVar = "Delete";
	String textFile = "Test Txt File";
	
	//Create Test Folder
	public void testCreateFolder(){
		
		solo.clickOnMenuItem("New folder");
		solo.typeText(0, folderName);
		solo.clickOnButton("Create");
		solo.waitForText(folderName);
		solo.goBack();
		//Assert Folder is created
		assertTrue("Folder NOT Created", solo.searchText(folderName));	
		
	}
	
	// Delete Test Folder
	public void testDeleteFolder(){
		
		solo.clickOnCheckBox(1);
		solo.waitForText(deleteVar);
		solo.clickOnButton(deleteVar);
		solo.clickOnButton(deleteVar);
		solo.waitForDialogToClose(3000);
		//assert that the file was deleted
		assertFalse("The file has not been deleted", solo.searchText(folderName));
		
	}
	
	//Create .txt File
	
	public void testCreateTxtFile(){
		
		solo.clickOnMenuItem("New text file");
		solo.typeText(0, textFile);
		solo.goBack();
		assertTrue("The dioalog box did not show up", solo.searchText("You have unsaved changes."));
		solo.clickOnButton("Save");
		solo.typeText(0, textFile);
		solo.clickOnButton("OK");
		//assert toast mesage
		assertTrue("Toast message did not show up", solo.waitForText("File saved"));
		
		
	}
	

}
