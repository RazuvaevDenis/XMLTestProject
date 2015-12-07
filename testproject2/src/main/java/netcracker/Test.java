package netcracker;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class Test {

	static ArrayList<Student> students=new ArrayList<Student>();
	static ArrayList<Lecturer> lecturers=new ArrayList<Lecturer>();
	public static void main(String[] args) {
		DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
		DocumentBuilder dBuilder;
		try {
		dBuilder = dbFactory.newDocumentBuilder();
		Document doc = dBuilder.parse(new File("src/main/resources/test.xml"));
		doc.getDocumentElement().normalize();
		XPathFactory factory=XPathFactory.newInstance();
		XPath path=factory.newXPath();
		XPathExpression expr=path.compile("//student[faculty='CSF']/firstname/text()");
		Object oList1=expr.evaluate(doc, XPathConstants.NODESET);
		NodeList nList1=(NodeList)oList1;
		NodeList nList2=doc.getElementsByTagName("lecturer");
		for(int temp=0;temp<nList1.getLength();temp++){
			Student s=new CSFStudent((nList1.item(temp).getNodeValue()),"Ivanov",20);
			students.add(s);
		}
		for(int temp=0;temp<nList2.getLength();temp++){
			Node nNode=nList2.item(temp);
			if (nNode.getNodeType() == Node.ELEMENT_NODE) {
				Element eElement = (Element) nNode;
				Lecturer l;
				if(eElement.getElementsByTagName("science").item(0).getTextContent().equals("chemistry"))
                   l=new ChemistryLecturer(eElement.getElementsByTagName("firstname").item(0).getTextContent(),eElement.getElementsByTagName("lastname").item(0).getTextContent(),Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent()));
				else
					l=new PhysicsLecturer(eElement.getElementsByTagName("firstname").item(0).getTextContent(),eElement.getElementsByTagName("lastname").item(0).getTextContent(),Integer.parseInt(eElement.getElementsByTagName("age").item(0).getTextContent()));
				lecturers.add(l);
			}
		}
         for (int i=0;i<students.size();i++){
        	 Student s=students.get(i);
        	 System.out.println(s.getName());
        	 System.out.println(s.getSurname());
        	 System.out.println(s.getAge());
        	 System.out.println(s.getPosition());
        	 System.out.println(s.faculty());
         }
         for(int i=0;i<lecturers.size();i++){
        	 Lecturer l=lecturers.get(i);
        	 System.out.println(l.getName());
        	 System.out.println(l.getSurname());
        	 System.out.println(l.getAge());
        	 System.out.println(l.getPosition());
        	 System.out.println(l.science());
         }
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (XPathExpressionException e) {
			e.printStackTrace();
		}
	}
}
