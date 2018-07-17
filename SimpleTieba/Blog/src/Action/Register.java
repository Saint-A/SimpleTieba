package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.UserDAO;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;

public class Register extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	
	public Register(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	public String execute() throws Exception{
		User user=new User();
		String username=request.getParameter("username");
		user.setUsername(username);
		String pwd=request.getParameter("pwd");
		user.setPassword(pwd);
		UserDAO userdao=new UserDAO();
		userdao.save(user);
		User response=userdao.findById(user.getId());
		session.setAttribute("User", response);
		return "success";
	}
	
}
