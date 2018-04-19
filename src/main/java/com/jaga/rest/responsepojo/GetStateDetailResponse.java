package com.jaga.rest.responsepojo;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * 
 * @author Jagatheshwaran
 * @since 10/4/2018
 *
 */
public class GetStateDetailResponse {

	@SerializedName("getStateDetails")
	@Expose
	private List<GetStateDetail> getStateDetails = null;

	public List<GetStateDetail> getGetStateDetails() {
		return getStateDetails;
	}

	public void setGetStateDetails(List<GetStateDetail> getStateDetails) {
		this.getStateDetails = getStateDetails;
	}

}
