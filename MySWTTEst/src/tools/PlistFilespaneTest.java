package tools;

import javax.swing.JFrame;

import org.junit.Test;

public class PlistFilespaneTest extends PlistFilespane {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	JFrame frame = new JFrame();

	@Test
	public final void testPlistFilespane() {
		
	    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		PlistFilespane pfp=new PlistFilespane();
		frame.add(pfp);
		frame.setSize(300, 150);
	    frame.setVisible(true);
		//fail("Not yet implemented"); // TODO
	}

}
