package by.epam.course.basic.stax;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;

import by.epam.course.basic.beans.SportProduct;
import by.epam.course.basic.beans.Status;
import by.epam.course.basic.sax.tags.TagName;

public class StAXParser {

	public static List<SportProduct> process(XMLStreamReader reader) throws XMLStreamException {
		List<SportProduct> items = new ArrayList<SportProduct>();
		SportProduct sportProduct = null;
		TagName elementName = null;
		while (reader.hasNext()) {
			int type = reader.next();
			switch (type) {
			case XMLStreamConstants.START_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case SPORTPRODUCT:
					sportProduct = new SportProduct();
					break;
				}
				break;
			case XMLStreamConstants.CHARACTERS:
				String text = reader.getText().trim();
				if (text.isEmpty()) {
					break;
				}
				switch (elementName) {
				case NAME:
					sportProduct.setName(text);
					break;
				case DESCRIPTION:
					sportProduct.setDesctiption(text);
					break;
				case OWNER_ID:
					sportProduct.setOwner_ID(Integer.parseInt(text));
					break;
				case STATUS:
					sportProduct.setStatus(Status.valueOf(text));
					break;
				}
				break;
			case XMLStreamConstants.END_ELEMENT:
				elementName = TagName.getElementTagName(reader.getLocalName());
				switch (elementName) {
				case SPORTPRODUCT:
					items.add(sportProduct);
				}
			}
		}
		return items;
	}

}
