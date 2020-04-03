package domParserDTD;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class DomParserDTD {

	public static void main(String[] args) {
		boolean flag = true;
		
		try {
			validate("employees.xml");
		} catch (ParserConfigurationException e) {
			flag = false;
		} catch (FileNotFoundException e) {
			flag = false;
		} catch (SAXException e) {
			flag = false;
		} catch (IOException e) {
			flag = false;
		}
		System.out.println("xml file is valid : " + flag);

	}

	private static void validate(String xmlFile) throws ParserConfigurationException, FileNotFoundException, SAXException, IOException {
		
		DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
		documentBuilderFactory.setValidating(true);
		DocumentBuilder documentBuilder = documentBuilderFactory.newDocumentBuilder();
		documentBuilder.setErrorHandler(new org.xml.sax.ErrorHandler() {

			@Override
			public void warning(SAXParseException exception) throws SAXException {
				throw exception;
				
			}

			@Override
			public void error(SAXParseException exception) throws SAXException {
				throw exception;
				
			}

			@Override
			public void fatalError(SAXParseException exception) throws SAXException {
				throw exception;
				
			}
			
		});
		documentBuilder.parse(new FileInputStream(xmlFile));
		
	}

}
