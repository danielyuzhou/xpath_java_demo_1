package xpath_java_demo_1;
import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class maindemo {

  public static void main(String[] args)  {

	  try {
		DoWork("book.xml", "//book/title/text()");
		DoWork("book.xml", "//book[price>39]/title/text()");
		DoWork("book.xml", "//book/title[@lang='eng']/text()");
		DoWork("book.xml", "//book/title[@lang]/@lang");
	} catch (XPathExpressionException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ParserConfigurationException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SAXException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
  public static void DoWork(String filepath,String xpath) throws ParserConfigurationException, SAXException, IOException, XPathExpressionException
  {
	  System.out.println("--------------start--------------");
	  System.out.println("xpath-->"+xpath);
	  DocumentBuilderFactory builderFactory=DocumentBuilderFactory.newInstance();
	 // builderFactory.setNamespaceAware(true);
	  DocumentBuilder builder=builderFactory.newDocumentBuilder();
	  Document document =builder.parse(new File(filepath));
	  XPathFactory factory=XPathFactory.newInstance();
	  XPath path=factory.newXPath();
	  XPathExpression expression=path.compile(xpath);
	  Object res=expression.evaluate(document, XPathConstants.NODESET);
	  NodeList results=(NodeList)res;
	  for(int i=0;i<results.getLength();i++)
		  System.out.println(i+" "+results.item(i).getNodeValue().toString());
	  System.out.println("--------------end--------------");
  }
}