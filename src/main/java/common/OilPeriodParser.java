package common;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

public class OilPeriodParser {

	/**
	 * 
	 * @param beginDate
	 * @param endDate
	 * @param instrumentCode
	 *            - если указать пустую строку ИЛИ null - то фильтр не
	 *            применится и функция вернет все элементы с любыми
	 *            instrumentCode
	 * @return - всегда возвращает List<OilResultEntity>. НЕ может быть null!
	 */
	public List<OilResult> sendRequest(String beginDate, String endDate, String instrumentCode) {

		List<OilResult> resultList = new ArrayList<OilResult>();
		Document doc = requestDocument(beginDate, endDate, instrumentCode);

		if (doc != null) {

			NodeList messageList = doc.getElementsByTagName("message");

			if (messageList.getLength() > 0) {

				Element message = (Element) doc.getElementsByTagName("message").item(0);
				NodeList oilResultNodes = message.getElementsByTagName("oil_result");

				for (int i = 0; i < oilResultNodes.getLength(); i++) {
					Node item = oilResultNodes.item(i);
					OilResult entity = extractResultEntity(item);
					if (entity != null) {
						resultList.add(entity);
					}
				}
			}
		}

		return resultList;
	}

	private OilResult extractResultEntity(Node item) {
		OilResult entity = null;
		if (item instanceof Element) {

			Element oilResult = (Element) item;
			entity = new OilResult();

			entity.setTradeDay(oilResult.getAttribute("trade_day"));
			entity.setInstrumentCode(oilResult.getAttribute("instrument_code"));
			entity.setProductName(oilResult.getAttribute("product_name"));
			entity.setDeliveryBasisName(oilResult.getAttribute("delivery_basis_name"));
			entity.setDealVolume(oilResult.getAttribute("deal_volume"));
			entity.setDealAmount(oilResult.getAttribute("deal_amount"));
			entity.setStockPriceDiff(oilResult.getAttribute("stock_price_diff"));
			entity.setStockPriceDelta(oilResult.getAttribute("stock_price_delta"));
			entity.setMinPrice(oilResult.getAttribute("min_price"));
			entity.setMaxPrice(oilResult.getAttribute("max_price"));
			entity.setStockPrice(oilResult.getAttribute("stock_price"));
			entity.setBestBuyPrice(oilResult.getAttribute("best_buy_price"));
			entity.setBestSellPrice(oilResult.getAttribute("best_sell_price"));
			entity.setDealCount(oilResult.getAttribute("deal_count"));
		}

		return entity;
	}

	private Document requestDocument(String beginDate, String endDate, String instrumentCode) {

		String instrumentCodeArg = "";

		if (instrumentCode != null && !instrumentCode.isEmpty()) {
			instrumentCodeArg = "&instrument_code=" + instrumentCode;
		}

		Document doc = null;
		InputStream in = null;

		try {
			URL url = new URL("http://mosenex.ru/mosenex_export_oil_result.asp?result_type=xml&begin_date=" + beginDate
					+ "&end_date=" + endDate + instrumentCodeArg);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			in = url.openStream();
			doc = db.parse(new InputSource(in));
			doc.getDocumentElement().normalize();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

		return doc;
	}
}
