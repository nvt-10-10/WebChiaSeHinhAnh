package Model;

public class Web {
	String idBanner;
	String banner;
	String title1;
	String title2;
	String facebook;
	String instagram;
	String pinterest;

	public Web() {

	}

	public Web(String idBanner, String banner, String title1, String title2, String facebook, String instagram,
			String pinterest) {
		super();
		this.idBanner = idBanner;
		this.banner = banner;
		this.title1 = title1;
		this.title2 = title2;
		this.facebook = facebook;
		this.instagram = instagram;
		this.pinterest = pinterest;
	}

	public String getIdBanner() {
		return idBanner;
	}

	public void setIdBanner(String idBanner) {
		this.idBanner = idBanner;
	}

	public String getBanner() {
		return banner;
	}

	public void setBanner(String banner) {
		this.banner = banner;
	}

	public String getTitle1() {
		return title1;
	}

	public void setTitle1(String title1) {
		this.title1 = title1;
	}

	public String getTitle2() {
		return title2;
	}

	public void setTitle2(String title2) {
		this.title2 = title2;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getInstagram() {
		return instagram;
	}

	public void setInstagram(String instagram) {
		this.instagram = instagram;
	}

	public String getPinterest() {
		return pinterest;
	}

	public void setPinterest(String pinterest) {
		this.pinterest = pinterest;
	}

}
