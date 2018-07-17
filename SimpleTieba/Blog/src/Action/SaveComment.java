package Action;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;



import DAO.CommentDAO;
import bean.Article;
import bean.Comment;
import bean.Simplearticle;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class SaveComment extends ActionSupport {
	private Comment comment;
	private HttpServletRequest request;
	private HttpSession session;
	
	
	public Comment getComment() {
		return comment;
	}
	public void setComment(Comment comment) {
		this.comment = comment;
	}
	public SaveComment(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	public String execute() throws Exception{
		System.out.println("Ìí¼ÓÆÀÂÛ");
		Simplearticle sa=(Simplearticle)session.getAttribute("sa");
		
		User user=(User)session.getAttribute("User");
		System.out.println(sa.getTitle());
		System.out.println(comment);
		comment.setUser(user);
		comment.setSimplearticle(sa);
		CommentDAO commentdao=new CommentDAO();
		commentdao.save(comment);
		System.out.println("success");
		return "success";
	}
}
