package common;

import java.io.IOException;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

public class Main {
	public static void main(String[] args) throws ParserConfigurationException, SAXException, IOException {

		OilPeriodParser p = new OilPeriodParser();	
		List<OilResult> resultList = p.sendRequest("21.07.2016", "01.08.2016", "PCPBOSN0033F");
		for (OilResult entity : resultList) {
			System.out.println(entity.toString());
		}
	}
}
