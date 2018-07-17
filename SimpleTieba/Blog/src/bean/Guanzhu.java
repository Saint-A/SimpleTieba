package bean;

public class Guanzhu {
	private Integer guanzhuId;
	private Integer firendid;
	private String firendName;
	private User user;
	
	
	public Integer getGuanzhuId() {
		return guanzhuId;
	}
	public void setGuanzhuId(Integer guanzhuId) {
		this.guanzhuId = guanzhuId;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		System.out.println("½øÈëÉèÖÃUser");
		this.user = user;
	}
	public Integer getFirendid() {
		return firendid;
	}
	public void setFirendid(Integer firendid) {
		this.firendid = firendid;
	}
	public String getFirendName() {
		return firendName;
	}
	public void setFirendName(String firendName) {
		this.firendName = firendName;
	}

}
