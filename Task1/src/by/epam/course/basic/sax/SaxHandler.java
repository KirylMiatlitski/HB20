package by.epam.course.basic.sax;

import java.util.ArrayList;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;
import org.xml.sax.helpers.DefaultHandler;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.beans.Status;
import by.epam.course.basic.sax.tags.TagName;

public class SaxHandler extends DefaultHandler {
	private List<SportProduct> itemList = new ArrayList<SportProduct>();
	private SportProduct sportProduct;
	private StringBuilder text;

	public List<SportProduct> getItemList() {
		return itemList;
	}

	public void startDocument() throws SAXException {
		System.out.println("Parsing SAX started.");
	}

	public void endDocument() throws SAXException {
		System.out.println("Parsing SAX ended.");
	}

	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		text = new StringBuilder();
		if (qName.equals("SportProduct")) {
			sportProduct = new SportProduct();
		}
	}

	public void characters(char[] buffer, int start, int length) {
		text.append(buffer, start, length);
	}

	public void endElement(String uri, String localName, String qName) throws SAXException {
		TagName tagName = TagName.valueOf(qName.toUpperCase().replace("-", "_"));
		switch (tagName) {
		case NAME:
			sportProduct.setName(text.toString());
			break;
		case DESCRIPTION:
			sportProduct.setDesctiption(text.toString());
			break;
		case OWNER_ID:
			sportProduct.setOwner_ID(Integer.parseInt(text.toString()));
			break;
		case STATUS:
			sportProduct.setStatus(Status.valueOf(text.toString()));
			break;
		case SPORTPRODUCT:
			itemList.add(sportProduct);
			sportProduct = null;
			break;
		}
	}

	public void warning(SAXParseException exception) {
		System.err.println("WARNING: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void error(SAXParseException exception) {
		System.err.println("ERROR: line " + exception.getLineNumber() + ": " + exception.getMessage());
	}

	public void fatalError(SAXParseException exception) throws SAXException {
		System.err.println("FATAL: line " + exception.getLineNumber() + ": " + exception.getMessage());
		throw (exception);
	}
}
