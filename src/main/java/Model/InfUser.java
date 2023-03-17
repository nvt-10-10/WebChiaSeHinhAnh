package Model;

public class InfUser {
	private String userID;
	private String gmail;
	private String password;
	private String uImages;
	private String faceBook;
	private String soDienThoai;
	private String firstName;
	private String lastName;
	private String gender;
	private String idComment;
	private String comment;
	private String userID1;
	private String idImage;
	private String commentDay;
	public InfUser() {
		// TODO Auto-generated constructor stub
	}
	public InfUser(String userID, String gmail, String password, String uImages, String faceBook, String soDienThoai,
			String firstName, String lastName, String gender, String idComment, String comment, String userID1,
			String idImage, String commentDay) {
		super();
		this.userID = userID;
		this.gmail = gmail;
		this.password = password;
		this.uImages = uImages;
		this.faceBook = faceBook;
		this.soDienThoai = soDienThoai;
		this.firstName = firstName;
		this.lastName = lastName;
		this.gender = gender;
		this.idComment = idComment;
		this.comment = comment;
		this.userID1 = userID1;
		this.idImage = idImage;
		this.commentDay = commentDay;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getGmail() {
		return gmail;
	}
	public void setGmail(String gmail) {
		this.gmail = gmail;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getuImages() {
		return uImages;
	}
	public void setuImages(String uImages) {
		this.uImages = uImages;
	}
	public String getFaceBook() {
		return faceBook;
	}
	public void setFaceBook(String faceBook) {
		this.faceBook = faceBook;
	}
	public String getSoDienThoai() {
		return soDienThoai;
	}
	public void setSoDienThoai(String soDienThoai) {
		this.soDienThoai = soDienThoai;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getIdComment() {
		return idComment;
	}
	public void setIdComment(String idComment) {
		this.idComment = idComment;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getUserID1() {
		return userID1;
	}
	public void setUserID1(String userID1) {
		this.userID1 = userID1;
	}
	public String getIdImage() {
		return idImage;
	}
	public void setIdImage(String idImage) {
		this.idImage = idImage;
	}
	public String getCommentDay() {
		return commentDay;
	}
	public void setCommentDay(String commentDay) {
		this.commentDay = commentDay;
	}
		
}
