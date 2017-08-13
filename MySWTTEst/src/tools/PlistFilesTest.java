package tools;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class PlistFilesTest extends PlistFiles {
	
	PlistFiles testList;
	
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	
	
	
	
	@Test
	public final void testGetListFromDefaultConstructor() {
		System.out.println("*** testGetList()");
		this.GetList();
		//fail("Not yet implemented"); // TODO
	}
	
	
	
	public void TestPListFilesString()
	{
		System.out.println("*** TestPListFilesString()");

	  testList = new PlistFiles("/usr");
		
	}
	
	@Test
	public void testGetListFromStringConstructor() {
		System.out.println("*** testGetListFromStringConstructor()");
		TestPListFilesString();
		testList.GetList();
		//fail("Not yet implemented"); // TODO
	}
	
	@Test
	public void Testfiles()
	{int i=0;
	System.out.println("*** Testfiles()");

	testGetListFromStringConstructor();
	
	if (testList.files.length != 0)
	  for(String afiles : testList.files)
	  {
		System.out.println(i + " - " + afiles);
		i++;
	  }
	
	}

}
