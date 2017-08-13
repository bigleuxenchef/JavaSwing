package tools;

import java.io.File;
import java.util.Vector;

public class PlistFiles {
	
	public String dirPath = "/";
	File dir;
	public String[] files ;
	public Vector<String> vfiles;
	 
	public boolean iscSystem() {
		return cSystem;
	}
	public void setcSystem(boolean cSystem) {
		this.cSystem = cSystem;
	}
	public boolean iscUser() {
		return cUser;
	}
	public void setcUser(boolean cUser) {
		this.cUser = cUser;
	}
	public boolean iscDaemon() {
		return cDaemon;
	}
	public void setcDaemon(boolean cDaemon) {
		this.cDaemon = cDaemon;
	}
	public boolean iscAgent() {
		return cAgent;
	}
	public void setcAgent(boolean cAgent) {
		this.cAgent = cAgent;
	}

	boolean cSystem, cUser,  cDaemon, cAgent;
	
	public	PlistFiles() {
		
		vfiles = new Vector<String>();

			
			// TODO Auto-generated constructor stub
		}
	/**
	 * @param dirPath
	 */

		public PlistFiles(String dirPath) {
		super();
		vfiles = new Vector<String>();

		this.dirPath = dirPath;
		
	}
		
		/**
		 * @param System, User, Daemon, Agent
		 */	
		public PlistFiles(boolean lSystem, boolean lUser, boolean lDaemon,boolean lAgent) {
			super();
			vfiles = new Vector<String>();
			this.cSystem=lSystem;
			this.cUser=lUser;
			this.cDaemon=lDaemon;
			this.cAgent=lAgent;
			this.dirPath = null;
			
		}
/**
	 * 
	 */
/**
 * 
 */

private void GetListFromPath(String lPath)
{
	
	dir = new File(lPath);
	files = dir.list();
	
	if (files == null)
		return;
	
	if (files.length == 0) {
	    System.out.println("The directory is empty");
	} else {
	    for (String aFile : files) {
	    	//vfiles.addElement(aFile);

	    	vfiles.addElement(lPath + "/" + aFile);
	        
	    	System.out.println(lPath + aFile );
	    }
	}
}

public void GetList()
{	files = null;
vfiles.clear();
if (dirPath != null)
	{
	GetListFromPath(dirPath);
	return;
	}

if (cSystem)
{
	if (cDaemon) GetListFromPath("/Library/LaunchDaemons");
	if (cAgent)  GetListFromPath("/Library/LaunchAgents");
}

if (cUser)
{
//if (cDaemon) GetListFromPath("~/Library/LaunchDaemons");
//if (cAgent)  GetListFromPath("~/Library/LaunchAgents");
	
	if (cDaemon) GetListFromPath("/Users/rumi/Library/LaunchDaemons");
	if (cAgent)  GetListFromPath("/Users/rumi/Library/LaunchAgents");

}

	
	
}

}