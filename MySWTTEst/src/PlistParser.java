import org.w3c.dom.*;
import javax.xml.parsers.*;


public class PlistParser {

	
		
	DocumentBuilderFactory docFactory;
	DocumentBuilder docBuilder;
	Document doc; 
	
	
	
	public PlistParser() {
		
		// TODO Auto-generated constructor stub
		try {
		docFactory = DocumentBuilderFactory.newInstance();
		docBuilder = docFactory.newDocumentBuilder();
		doc = docBuilder.parse("/Users/rumi/Library/LaunchAgents/com.dxo.OpticsPro11LaunchAgent.plist");
		doc = docBuilder.parse("/Users/rumi/helloworld.xml");
		
		}
		catch(Exception e) {
			
			e.printStackTrace();
		}
		
	}



	public void getDoc() {
		
		try {	
	        
	         doc.getDocumentElement().normalize();
	         System.out.println("Root element :" 
	            + doc.getDocumentElement().getNodeName());
	         NodeList nList = doc.getElementsByTagName("student");
	         System.out.println("----------------------------");
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            System.out.println("\nCurrent Element :" 
	               + nNode.getNodeName());
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               System.out.println("Student roll no : " 
	                  + eElement.getAttribute("rollno"));
	               System.out.println("First Name : " 
	                  + eElement
	                  .getElementsByTagName("firstname")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Last Name : " 
	               + eElement
	                  .getElementsByTagName("lastname")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Nick Name : " 
	               + eElement
	                  .getElementsByTagName("nickname")
	                  .item(0)
	                  .getTextContent());
	               System.out.println("Marks : " 
	               + eElement
	                  .getElementsByTagName("marks")
	                  .item(0)
	                  .getTextContent());
	            }
	         }
	      } catch (Exception e) {
	    	  e.printStackTrace();
	      }
	      
		return ;
	}



	public void setDoc(Document doc) {
		this.doc = doc;
	}
	
	
	//System.out.println("unit test : test");

	
	
	
	
	
	
	
}
