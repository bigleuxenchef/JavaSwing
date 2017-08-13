package tools;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.BoxLayout;

public class PlistFilespane extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTable table;
	public PlistFiles plistfiles;
	/**
	 * Create the panel.
	 */
	public PlistFilespane() {
		setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
		
		plistfiles= new PlistFiles("/Library/LaunchAgents");
		plistfiles.GetList();
		table = new JTable(plistfiles.files.length,1);
		
		add(table);
		
	

	}


}
