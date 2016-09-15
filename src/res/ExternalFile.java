package res;

import java.awt.Image;
import java.io.InputStream;

import javax.swing.ImageIcon;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import io.github.trinnorica.utils.Version;

public class ExternalFile {
	
	
	
	public static void getDescriptionProperty(String list, String property){
		try {

			InputStream desc = ExternalFile.class.getResourceAsStream("description.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(desc);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName(list);
			
			for (int temp = 0; temp < nList.getLength(); temp++) {

				Node nNode = nList.item(temp);

				System.out.println("\nCurrent Element :" + nNode.getNodeName());

				if (nNode.getNodeType() == Node.ELEMENT_NODE) {

					Element eElement = (Element) nNode;

					System.out.println("Staff id : " + eElement.getAttribute("id"));
					System.out.println("First Name : " + eElement.getElementsByTagName("firstname").item(0).getTextContent());
					System.out.println("Last Name : " + eElement.getElementsByTagName("lastname").item(0).getTextContent());
					System.out.println("Nick Name : " + eElement.getElementsByTagName("nickname").item(0).getTextContent());
					System.out.println("Salary : " + eElement.getElementsByTagName("salary").item(0).getTextContent());

				}
			}
		    } catch (Exception e) {
		    	e.printStackTrace();
		    }
	}
	
	public static Image loadTexture(String resource){
		
		try {
			return new ImageIcon(ExternalFile.class.getResource("/res/images/" + resource)).getImage();
		} catch (Exception e) {
			try {
				return new ImageIcon(ExternalFile.class.getResource("/res/images/unknown.png")).getImage();
			} catch (Exception e1) {
				return null;
			}
		}
	}
	public static Version getVersion__BOOT_ONLY__() {
		try {
			InputStream desc = ExternalFile.class.getResourceAsStream("/description.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(desc);

			doc.getDocumentElement().normalize();

			NodeList nList = doc.getElementsByTagName("version");
			Node nNode = nList.item(0);
			Element e = (Element) nNode;
			
			return new Version(
					e.getElementsByTagName("major").item(0).getTextContent(),
					e.getElementsByTagName("minor").item(0).getTextContent(),
					e.getElementsByTagName("distro").item(0).getTextContent()
					);
			
		    } catch (Exception e) {
		    	e.printStackTrace();
		    	System.out.println("Couldn't read 'description.xml'. Assuming version to be '2.0.1'");
		    	return new Version("2","0","1");
		    }
	}

	
	
	
}