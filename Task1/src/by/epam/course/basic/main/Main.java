package by.epam.course.basic.main;


import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.stream.XMLStreamWriter;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;
import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.sax.SaxHandler;
import by.epam.course.basic.stax.StAXParser;

/**
 * @author Kiryl_Miatlitski
 * 
 * date: 9 April 2017
 * 
 * Task: –аспарсите xml-файл, содержащий ассортимент магазина проката спортивных товаров в помощью SAX и StAX парсеров.
 */
public class Main {

	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {
		//SAX
		System.out.println("SAX Parser");
		XMLReader readerSAX = XMLReaderFactory.createXMLReader();
		SaxHandler handler = new SaxHandler();
		readerSAX.setContentHandler(handler);
		readerSAX.parse(new InputSource("SportProducts.xml"));
		List<SportProduct> menu = handler.getItemList();
		for (SportProduct sportProduct : menu) {
			System.out.println(sportProduct);
		}
		
		
		System.out.println();
		System.out.println();
		System.out.println();
		//StAX
		System.out.println("StAX Parser");
		XMLInputFactory inputFactory = XMLInputFactory.newInstance();
		try {
			InputStream input = new FileInputStream("SportProducts.xml");
			XMLStreamReader readerStAX = inputFactory.createXMLStreamReader(input);
			List<SportProduct> items = StAXParser.process(readerStAX);
			for (SportProduct sportProduct : items) {
				System.out.println(sportProduct);
			}
		} catch (XMLStreamException e) {
			e.printStackTrace();
		}
	}

}
