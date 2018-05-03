package grocery.api.deals;

import com.fasterxml.jackson.annotation.JsonProperty;
import javax.annotation.Generated;

@Generated("com.robohorse.robopojogenerator")
public class Deal{

	@JsonProperty("savingsAmount")
	private String savingsAmount;

	@JsonProperty("product")
	private String product;

	@JsonProperty("size")
	private String size;

	@JsonProperty("salePrice")
	private String salePrice;

	@JsonProperty("saleEndDate")
	private String saleEndDate;

	@JsonProperty("active")
	private boolean active;

	@JsonProperty("storeName")
	private String storeName;

	@JsonProperty("id")
	private int id;

	@JsonProperty("category")
	private String category;

	@JsonProperty("brand")
	private String brand;

	public void setSavingsAmount(String savingsAmount){
		this.savingsAmount = savingsAmount;
	}

	public String getSavingsAmount(){
		return savingsAmount;
	}

	public void setProduct(String product){
		this.product = product;
	}

	public String getProduct(){
		return product;
	}

	public void setSize(String size){
		this.size = size;
	}

	public String getSize(){
		return size;
	}

	public void setSalePrice(String salePrice){
		this.salePrice = salePrice;
	}

	public String getSalePrice(){
		return salePrice;
	}

	public void setSaleEndDate(String saleEndDate){
		this.saleEndDate = saleEndDate;
	}

	public String getSaleEndDate(){
		return saleEndDate;
	}

	public void setActive(boolean active){
		this.active = active;
	}

	public boolean isActive(){
		return active;
	}

	public void setStoreName(String storeName){
		this.storeName = storeName;
	}

	public String getStoreName(){
		return storeName;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}

	public void setCategory(String category){
		this.category = category;
	}

	public String getCategory(){
		return category;
	}

	public void setBrand(String brand){
		this.brand = brand;
	}

	public String getBrand(){
		return brand;
	}

	@Override
 	public String toString(){
		return 
			"Deal{" + 
			"savingsAmount = '" + savingsAmount + '\'' + 
			",product = '" + product + '\'' + 
			",size = '" + size + '\'' + 
			",salePrice = '" + salePrice + '\'' + 
			",saleEndDate = '" + saleEndDate + '\'' + 
			",active = '" + active + '\'' + 
			",storeName = '" + storeName + '\'' + 
			",id = '" + id + '\'' + 
			",category = '" + category + '\'' + 
			",brand = '" + brand + '\'' + 
			"}";
		}
}