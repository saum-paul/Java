package org.smacknologs.template;

import java.io.FileInputStream;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.XMLEvent;

public class XmlFileProcessor extends FileProcessor {
	XMLInputFactory factory = XMLInputFactory.newInstance();

	@Override
	boolean validate(String fileName) {
		return fileName.toLowerCase().endsWith(".xml");
	}

	@Override
	void processFile(String fileName) {

		String comment = null;

		try {
			XMLEventReader eventReader = factory
					.createXMLEventReader(
							new FileInputStream(fileName));

			while (eventReader.hasNext()) {
				XMLEvent xmlEvent = eventReader.nextEvent();
				
				switch (xmlEvent.getEventType()) {
				
				case XMLStreamConstants.COMMENT:
					comment = xmlEvent.toString();
					System.out.println(comment);
					break;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
