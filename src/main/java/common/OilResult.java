package common;

public class OilResult {

	public String getTradeDay() {
		return tradeDay;
	}

	public void setTradeDay(String tradeDay) {
		this.tradeDay = tradeDay;
	}

	public String getInstrumentCode() {
		return instrumentCode;
	}

	public void setInstrumentCode(String instrumentCode) {
		this.instrumentCode = instrumentCode;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDeliveryBasisName() {
		return deliveryBasisName;
	}

	public void setDeliveryBasisName(String deliveryBasisName) {
		this.deliveryBasisName = deliveryBasisName;
	}

	public String getDealVolume() {
		return dealVolume;
	}

	public void setDealVolume(String dealVolume) {
		this.dealVolume = dealVolume;
	}

	public String getDealAmount() {
		return dealAmount;
	}

	public void setDealAmount(String dealAmount) {
		this.dealAmount = dealAmount;
	}

	public String getStockPriceDiff() {
		return stockPriceDiff;
	}

	public void setStockPriceDiff(String stockPriceDiff) {
		this.stockPriceDiff = stockPriceDiff;
	}

	public String getStockPriceDelta() {
		return stockPriceDelta;
	}

	public void setStockPriceDelta(String stockPriceDelta) {
		this.stockPriceDelta = stockPriceDelta;
	}

	public String getMinPrice() {
		return minPrice;
	}

	public void setMinPrice(String minPrice) {
		this.minPrice = minPrice;
	}

	public String getMaxPrice() {
		return maxPrice;
	}

	public void setMaxPrice(String maxPrice) {
		this.maxPrice = maxPrice;
	}

	public String getStockPrice() {
		return stockPrice;
	}

	public void setStockPrice(String stockPrice) {
		this.stockPrice = stockPrice;
	}

	public String getBestBuyPrice() {
		return bestBuyPrice;
	}

	public void setBestBuyPrice(String bestBuyPrice) {
		this.bestBuyPrice = bestBuyPrice;
	}

	public String getBestSellPrice() {
		return bestSellPrice;
	}

	public void setBestSellPrice(String bestSellPrice) {
		this.bestSellPrice = bestSellPrice;
	}

	public String getDealCount() {
		return dealCount;
	}

	public void setDealCount(String dealCount) {
		this.dealCount = dealCount;
	}

	@Override
	public String toString() {
		return "OilResultEntity [tradeDay=" + tradeDay + ", instrumentCode=" + instrumentCode + ", productName="
				+ productName + ", deliveryBasisName=" + deliveryBasisName + ", dealVolume=" + dealVolume
				+ ", dealAmount=" + dealAmount + ", stockPriceDiff=" + stockPriceDiff + ", stockPriceDelta="
				+ stockPriceDelta + ", minPrice=" + minPrice + ", maxPrice=" + maxPrice + ", stockPrice=" + stockPrice
				+ ", bestBuyPrice=" + bestBuyPrice + ", bestSellPrice=" + bestSellPrice + ", dealCount=" + dealCount
				+ "]";
	}

	private String tradeDay;
	private String instrumentCode;
	private String productName;
	private String deliveryBasisName;
	private String dealVolume;
	private String dealAmount;
	private String stockPriceDiff;
	private String stockPriceDelta;
	private String minPrice;
	private String maxPrice;
	private String stockPrice;
	private String bestBuyPrice;
	private String bestSellPrice;
	private String dealCount;
}
