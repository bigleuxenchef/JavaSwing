import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenu;

import tools.PlistFiles;
import tools.XMLTree;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import javax.swing.JCheckBoxMenuItem;
import javax.swing.JTabbedPane;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JEditorPane;
import javax.swing.JList;
import javax.swing.JSeparator;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.Canvas;


public class Main {

	private JFrame frame;
	XMLTree myTree;
	JEditorPane dtrpnPlistfile;
	PlistFiles plf;
	JList<String> list;
	JScrollPane scrollPane;
	private JCheckBoxMenuItem chckbxmntmSystem;
	private JCheckBoxMenuItem chckbxmntmUser;
	private JCheckBoxMenuItem chckbxmntmLaunchagents;
	private JCheckBoxMenuItem chckbxmntmLaunchdaemons;
	private JMenu mnView;
	private JCheckBoxMenuItem chckbxmntmDisplayTreeView;
	private Canvas canvas;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main window = new Main();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	/**
	 * Create the application.
	 */
	public Main() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		frame = new JFrame();
		frame.setBounds(100, 100, 912, 418);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(true);
		
		 plf=new PlistFiles(false,true,false,true);
		 list = new JList<String>(plf.vfiles);
		
		 JMenuBar menuBar = new JMenuBar();
		 frame.setJMenuBar(menuBar);
		 
		 JMenu mnSelection = new JMenu("Selection");
		
		 menuBar.add(mnSelection);
		 
		 chckbxmntmSystem = new JCheckBoxMenuItem("System",plf.iscSystem());
		 chckbxmntmSystem.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		plf.setcSystem(chckbxmntmSystem.isSelected());
		 		
		 		//list = new JList<String>(plf.vfiles);
		 		list.removeAll();
		 		list.setListData(plf.vfiles);

		 		
		 		
		 	}
		 });
		 mnSelection.add(chckbxmntmSystem);
		 
		 chckbxmntmUser = new JCheckBoxMenuItem("User",plf.iscUser());
		 chckbxmntmUser.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		plf.setcUser(chckbxmntmUser.isSelected());
		 		plf.GetList();
		 		//list = new JList<String>(plf.vfiles);
		 		list.removeAll();
		 		list.setListData(plf.vfiles);
		 	}
		 });
		 mnSelection.add(chckbxmntmUser);
		 
		 JSeparator separator = new JSeparator();
		 mnSelection.add(separator);
		 
		 chckbxmntmLaunchagents = new JCheckBoxMenuItem("LaunchAgents",plf.iscAgent());
		 chckbxmntmLaunchagents.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		plf.setcAgent(chckbxmntmLaunchagents.isSelected());
		 		plf.GetList();
		 		//list = new JList<String>(plf.vfiles);
		 		list.removeAll();
		 		list.setListData(plf.vfiles);
		 	}
		 });
		 
		 
		 mnSelection.add(chckbxmntmLaunchagents);
		 
		 chckbxmntmLaunchdaemons = new JCheckBoxMenuItem("LaunchDaemons",plf.iscSystem());
		 chckbxmntmLaunchdaemons.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		plf.setcDaemon(chckbxmntmLaunchdaemons.isSelected());
		 		plf.GetList();
		 		//list = new JList<String>(plf.vfiles);
		 		list.removeAll();
		 		list.setListData(plf.vfiles);
		 	}
		 });
		 
		 mnSelection.add(chckbxmntmLaunchdaemons);
		 
		 mnView = new JMenu("View");
		 menuBar.add(mnView);
		 
		 chckbxmntmDisplayTreeView = new JCheckBoxMenuItem("Display Tree view");
		 chckbxmntmDisplayTreeView.addChangeListener(new ChangeListener() {
		 	public void stateChanged(ChangeEvent e) {
		 		
		 		myTree.setVisible(chckbxmntmDisplayTreeView.isSelected());
		 		scrollPane.setVisible(chckbxmntmDisplayTreeView.isSelected());
		 		//frame.getContentPane().remove(scrollPane);
		 	
		 		
		 	}
		 });
		 mnView.add(chckbxmntmDisplayTreeView);
		 
		 
		 
	 GridBagLayout gridBagLayout = new GridBagLayout();
	 gridBagLayout.columnWidths = new int[]{264, 251, 266, 0};
	 gridBagLayout.rowHeights = new int[]{0, 315, 0};
	 gridBagLayout.columnWeights = new double[]{8.0, 1.0, 1.0, Double.MIN_VALUE};
	 gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
	 frame.getContentPane().setLayout(gridBagLayout);

	 canvas = new Canvas();
	 GridBagConstraints gbc_canvas = new GridBagConstraints();
	 gbc_canvas.fill = GridBagConstraints.HORIZONTAL;
	 gbc_canvas.insets = new Insets(0, 0, 5, 0);
	 gbc_canvas.gridx = 2;
	 gbc_canvas.gridy = 0;
	 frame.getContentPane().add(canvas, gbc_canvas);
	 
	 JScrollPane scrollPane_1 = new JScrollPane();
	 GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
	 gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
	 gbc_scrollPane_1.insets = new Insets(0, 0, 0, 5);
	 gbc_scrollPane_1.gridx = 0;
	 gbc_scrollPane_1.gridy = 1;
	 frame.getContentPane().add(scrollPane_1, gbc_scrollPane_1);
	
	 
	 
	 list.addMouseListener(new MouseAdapter() {
	 	@Override
	 	public void mouseClicked(MouseEvent e) {
	 		System.out.println(list.getSelectedValue());
	 		String plistfile = list.getSelectedValue();
	 		
	 		myTree.Init(plistfile);
	 		System.out.println("Opening file .... " + plistfile);
	 		
	 		Scanner in = null;
	 		String content = null;
			try {
				in = new Scanner(new File(plistfile));
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	 		while (in.hasNext()) { // iterates each line in the file
	 		    content += in.nextLine() + "\n";
	 		    // do something with line
	 		}

	 		in.close(); // don't forget to close resource leaks

	 		dtrpnPlistfile.setText(content);
	 	}
	 
	 });

	 scrollPane_1.setViewportView(list);
	 
	
	 plf.GetList();
	 int i=0;
	 if (plf.files.length != 0)
		  for(String afiles : plf.files)
		  { 
			System.out.println(i + " - " + afiles);
			i++;
		  }
	    list.setVisible(true);
	    
	    
	    
	 myTree = new XMLTree("/Users/rumi/helloworld.xml");
	 
	 scrollPane = new JScrollPane(myTree);
	 
	

	 GridBagConstraints gbc_scrollPane = new GridBagConstraints();
	 gbc_scrollPane.insets = new Insets(0, 0, 0, 5);
	 gbc_scrollPane.fill = GridBagConstraints.BOTH;
	 
	 
	 gbc_scrollPane.gridx = 1;
	 gbc_scrollPane.gridy = 1;
	 frame.getContentPane().add(scrollPane, gbc_scrollPane);
	 
	 JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.TOP);
	 GridBagConstraints gbc_tabbedPane_1 = new GridBagConstraints();
	 gbc_tabbedPane_1.fill = GridBagConstraints.BOTH;
	 gbc_tabbedPane_1.gridx = 2;
	 gbc_tabbedPane_1.gridy = 1;
	 frame.getContentPane().add(tabbedPane_1, gbc_tabbedPane_1);
	 
	 
	 dtrpnPlistfile = new JEditorPane();
	 dtrpnPlistfile.setText("PlistFile");
	 dtrpnPlistfile.setEditable(true);
	 dtrpnPlistfile.setVisible(true);
	
	 dtrpnPlistfile.setFont(new Font("Courier New", Font.ITALIC, 10));
	 
	 tabbedPane_1.addTab("com.apple.<example>.plist", null, dtrpnPlistfile, null);
	
	        frame.setVisible(true);
		
		
		
	}

	

	public JCheckBoxMenuItem getChckbxmntmSystem() {
		return chckbxmntmSystem;
	}
	public JCheckBoxMenuItem getChckbxmntmUser() {
		return chckbxmntmUser;
	}
	public JCheckBoxMenuItem getChckbxmntmLaunchagents() {
		return chckbxmntmLaunchagents;
	}
	public JCheckBoxMenuItem getChckbxmntmLaunchdaemons() {
		return chckbxmntmLaunchdaemons;
	}
}
