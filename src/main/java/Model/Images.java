package Model ;

public class Images {
	private int idImage;
	private String images;
	private String idCategory;
	private String userID;
	private String tag;
	private float tieuCu;
	private String khauDo;
	private String tocDoManTrap;
	private String iSO;
	private String camera;
	private String loaiHinhAnh;
	private String date;
	private int view;
	private int ready;
	public Images() {
		// TODO Auto-generated constructor stub
	}
	public Images(int idImage, String images, String idCategory, String userID, String tag, float tieuCu, String khauDo,
			String tocDoManTrap, String iSO, String camera, String loaiHinhAnh, String date, int view, int ready) {
		super();
		this.idImage = idImage;
		this.images = images;
		this.idCategory = idCategory;
		this.userID = userID;
		this.tag = tag;
		this.tieuCu = tieuCu;
		this.khauDo = khauDo;
		this.tocDoManTrap = tocDoManTrap;
		this.iSO = iSO;
		this.camera = camera;
		this.loaiHinhAnh = loaiHinhAnh;
		this.date = date;
		this.view = view;
		this.ready = ready;
	}
	public int getIdImage() {
		return idImage;
	}
	public void setIdImage(int idImage) {
		this.idImage = idImage;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	public String getIdCategory() {
		return idCategory;
	}
	public void setIdCategory(String idCategory) {
		this.idCategory = idCategory;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public float getTieuCu() {
		return tieuCu;
	}
	public void setTieuCu(float tieuCu) {
		this.tieuCu = tieuCu;
	}
	public String getKhauDo() {
		return khauDo;
	}
	public void setKhauDo(String khauDo) {
		this.khauDo = khauDo;
	}
	public String getTocDoManTrap() {
		return tocDoManTrap;
	}
	public void setTocDoManTrap(String tocDoManTrap) {
		this.tocDoManTrap = tocDoManTrap;
	}
	public String getiSO() {
		return iSO;
	}
	public void setiSO(String iSO) {
		this.iSO = iSO;
	}
	public String getCamera() {
		return camera;
	}
	public void setCamera(String camera) {
		this.camera = camera;
	}
	public String getLoaiHinhAnh() {
		return loaiHinhAnh;
	}
	public void setLoaiHinhAnh(String loaiHinhAnh) {
		this.loaiHinhAnh = loaiHinhAnh;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getView() {
		return view;
	}
	public void setView(int view) {
		this.view = view;
	}
	public int getReady() {
		return ready;
	}
	public void setReady(int ready) {
		this.ready = ready;
	}
	
}
