package grocery.api.deals;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.annotation.Generated;
import java.util.List;

@Generated("com.robohorse.robopojogenerator")
public class DealList {

	@JsonProperty("dealList")
	private List<Deal> dealList;


	public void setDealList(List<Deal> dealList){
		this.dealList = dealList;
	}

	public List<Deal> getDealList(){
		return dealList;
	}

	@Override
 	public String toString(){
		return 
			"DealList{" +
			"dealList = '" + dealList + '\'' +
			"}";
		}
}