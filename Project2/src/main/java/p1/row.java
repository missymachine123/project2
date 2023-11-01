package p1;

public class row {
private String productID;
private String productName;
private String productDesc;
private String pic;
private String category;
private Integer qty;
private float customerPrice;
private float importedPrice;
private Integer qtyOrder;

public row(String productID, String productName, String productDesc, String pic, String category, Integer qty, float customerPrice, float importedPrice) {
	this.productID = productID;
	this.productName = productName;
	this.productDesc = productDesc;
	this.pic = pic;
	this.category = category;
	this.qty = qty;
	this.customerPrice = customerPrice;
	this.importedPrice = importedPrice;
}
public row(String productID, String productName, String productDesc, String pic, Integer qtyOrder, float customerPrice) {
		this.productID = productID;
		this.productName = productName;
		this.productDesc = productDesc;
		this.pic = pic;
		this.qtyOrder = qtyOrder;
		this.customerPrice = customerPrice;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductDesc() {
		return productDesc;
	}
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public Integer getQty() {
		return qty;
	}
	public void setQty(Integer qty) {
		this.qty = qty;
	}
	public float getCustomerPrice() {
		return customerPrice;
	}
	public void setCustomerPrice(float customerPrice) {
		this.customerPrice = customerPrice;
	}
	public float getImportedPrice() {
		return importedPrice;
	}
	public void setImportedPrice(float importedPrice) {
		this.importedPrice = importedPrice;
	}
	public Integer getQtyOrder() {
		return qtyOrder;
	}
	public void setQtyOrder(Integer qtyOrder) {
		this.qtyOrder = qtyOrder;
	}
}
