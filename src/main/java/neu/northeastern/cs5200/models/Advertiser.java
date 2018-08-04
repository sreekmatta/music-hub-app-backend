package neu.northeastern.cs5200.models;

import java.io.Serializable;
import java.util.List;

public class Advertiser extends Person implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private List<Advertisement> ads;

	public List<Advertisement> getAds() {
		return ads;
	}

	public void setAds(List<Advertisement> ads) {
		this.ads = ads;
	}
	
}