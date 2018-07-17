package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.UserDAO;
import bean.User;
import com.opensymphony.xwork2.ActionSupport;
//�����¼��action
@SuppressWarnings("serial")
public class Login extends ActionSupport {
	private User user;
	private HttpServletRequest request;
	private HttpSession session;
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public Login(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	
	public String execute() throws Exception{
		UserDAO userdao=new UserDAO();
		System.out.println(user.getId());
		
		String checkcode=request.getParameter("checkcode");
		String truecheckcode=(String)session.getAttribute("checkCode");
		if(!truecheckcode.equals(checkcode))
		{
			System.out.println(truecheckcode+checkcode );
			request.setAttribute("errormessage", "��֤�����");
			return "loginerror";
		}
		if(user.getId()==null)
		{
			request.setAttribute("errormessage", "�˻�����Ϊ��");
			return "loginerror";
		}
		User response=userdao.findById(user.getId());
		if(response==null)
		{
			request.setAttribute("errormessage", "û�и��˻�");
			return "loginerror";
		}
		if(response.getPassword().equals(user.getPassword()))
		{
			session.setAttribute("iflogin", true);
			session.setAttribute("User", response);
			return "success";
		}
		request.setAttribute("errormessage", "�������");
		return "loginerror";
	}

}
