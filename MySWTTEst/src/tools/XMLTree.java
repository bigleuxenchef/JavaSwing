package tools;

import java.io.IOException;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeCellRenderer;
import javax.swing.tree.DefaultTreeModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;


public class  XMLTree extends JTree{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3470894385320099328L;
	DefaultTreeModel dtModel=null;

	    /**
	     * XmlJTree constructor
	     * @param filePath
	     */
	 
	 
	 private void expandAllNodes(JTree tree, int startingIndex, int rowCount){
		    for(int i=startingIndex;i<rowCount;++i){
		        tree.expandRow(i);
		    }

		    if(tree.getRowCount()!=rowCount){
		        expandAllNodes(tree, rowCount, tree.getRowCount());
		    }
		}
	 public void Init(String filePath)
	 {
		 if(filePath!=null)
		        setPath(filePath);
		        
		        ImageIcon leafIcon = new ImageIcon("src/leaf2.png","");
		        if (leafIcon != null) {
		            DefaultTreeCellRenderer renderer = 
		                new DefaultTreeCellRenderer();
		            renderer.setLeafIcon(leafIcon);
		            renderer.setSize(getMinimumSize());
		            this.setCellRenderer(renderer);
		        }
		        expandAllNodes(this, 0, this.getRowCount());
	 }
	    public XMLTree(String filePath){
	       
	    	Init(filePath);
	    	
	    }

	    public void setPath(String filePath){
	        Node root = null;
	        /*
	            Parse the xml file
	        */
	        try {
	            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
	            DocumentBuilder builder = factory.newDocumentBuilder();
	            Document doc = builder.parse(filePath);
	            root = (Node) doc.getDocumentElement();
	        } catch (IOException | ParserConfigurationException | SAXException ex) {
	            JOptionPane.showMessageDialog(null,"Can't parse file",
	                            "Error", JOptionPane.ERROR_MESSAGE);
	            return;
	        }
	        /*
	            if any result set the appropriate model to the jTree
	        */
	        if(root!=null){
	            dtModel= new DefaultTreeModel(builtTreeNode(root));
	            this.setModel(dtModel);
	        }
	    }

	    /**
	     * fullTreeNode Method
	     * construct the full jTree from any xml file
	     * this method is recursive
	     * @param root
	     * @return DefaultMutableTreeNode
	     */
	    private DefaultMutableTreeNode builtTreeNode(Node root){
	        DefaultMutableTreeNode dmtNode;

	        dmtNode = new DefaultMutableTreeNode(root.getNodeName());
	        
	            NodeList nodeList = root.getChildNodes();
	            
	            
	           if  (dmtNode.isLeaf() && nodeList.getLength() == 1)
                   {
                   	dmtNode.add(new DefaultMutableTreeNode(root.getTextContent()));
                   	System.out.println("Node Value" + root.getNodeValue() +" LocalName " + root.getLocalName() + " Text Content " + root.getTextContent());
                   	
                   }
	            
	            for (int count = 0; count < nodeList.getLength(); count++) {
	                Node tempNode = nodeList.item(count);
	                // make sure it's element node.
	                if (tempNode.getNodeType() == Node.ELEMENT_NODE) {
	                    if (tempNode.hasChildNodes()) {
	                        // loop again if has child nodes
	                        dmtNode.add(builtTreeNode(tempNode));
	                        }
	                   
	                }
	                
	                	
	               
	            }
	            
	        return dmtNode;
	    }

	   // public static void main(String[] args) {
	        /*
	            Create simple frame for the example
	        */
	     //   JFrame myFrame = new JFrame();
	  //      myFrame.setTitle("XmlJTreeExample");
	    //    myFrame.setSize(300, 500);
	      //  myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	     //   myFrame.setLocationRelativeTo(null);
	     //   JPanel pan = new JPanel(new GridLayout(1, 1));
	        /*
	            Add jTree
	        */
	       
	    
	}