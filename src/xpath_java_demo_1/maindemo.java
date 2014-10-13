package xpath_java_demo_1;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.dom4j.Attribute;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.jaxen.JaxenException;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.dom4j.Dom4jXPath;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class maindemo {

	public static void main(String[] args) {

		try {
			DoWork("test.xml", "/books:booklist/fiction:book");
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
		} catch (JaxenException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// DoWork("book.xml", "//book/title/text()");
		// DoWork("book.xml", "//book[price>39]/title/text()");
		// DoWork("book.xml", "//book/title[@lang='eng']/text()");
		// DoWork("book.xml", "//book/title[@lang]/@lang");

		// TODO Auto-generated catch block

	}

	public static void DoWork(String filepath, String xpath)
			throws ParserConfigurationException, SAXException, IOException,
			XPathExpressionException, JaxenException, DocumentException {
		System.out.println("--------------start--------------");
		System.out.println("xpath-->" + xpath);
		SAXReader reader = new SAXReader();
		org.dom4j.Document document = reader.read(new File(filepath));
		org.jaxen.XPath path = new Dom4jXPath(xpath);
		Map<String, String> namesapce = new HashMap<String, String>();
		namesapce.put("fiction", "http://univNaSpResolver/fictionbook");
		namesapce.put("books", "http://univNaSpResolver/booklist");
		namesapce.put(XMLConstants.DEFAULT_NS_PREFIX,
				"http://univNaSpResolver/book");
		namesapce.put("science", "http://univNaSpResolver/sciencebook");
		path.setNamespaceContext(new SimpleNamespaceContext(namesapce));
		// List res=path.selectNodes(document);
		List res = path.selectNodes(document);
		System.out.println(res.size());
       //for(Iterator iterator)
		System.out.println("--------------end--------------");
	}

}