package Model ;

public class Comments {
	private String idComment;
	private String comment;
	private String userID;
	private String idImage;
	private String commentDay;
	public Comments() {
		// TODO Auto-generated constructor stub
	}
	public Comments(String idComment, String comment, String userID, String idImage, String commentDay) {
		super();
		this.idComment = idComment;
		this.comment = comment;
		this.userID = userID;
		this.idImage = idImage;
		this.commentDay = commentDay;
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
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
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
