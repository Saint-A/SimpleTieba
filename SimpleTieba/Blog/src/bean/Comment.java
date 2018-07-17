package bean;

public class Comment {
	private Integer commentId;
	private Simplearticle simplearticle;
	private User user;
	private String comment;
	public Integer getCommentId() {
		return commentId;
	}
	public void setCommentId(Integer commentId) {
		this.commentId = commentId;
	}
	public Simplearticle getSimplearticle() {
		return simplearticle;
	}
	public void setSimplearticle(Simplearticle simplearticle) {
		System.out.println("…Ë÷√simplearticle");
		this.simplearticle = simplearticle;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public Comment(){}
	
}
