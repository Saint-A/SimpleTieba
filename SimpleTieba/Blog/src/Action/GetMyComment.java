package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.CommentDAO;

import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class GetMyComment extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	public GetMyComment(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	public String execute() throws Exception{
		CommentDAO commentdao=new CommentDAO();
		User user=new User();
		user=(User)session.getAttribute("User");
		List commentlist=commentdao.findByProperty("user", user);
		request.setAttribute("comments", commentlist);
		return "success";
	}
}
