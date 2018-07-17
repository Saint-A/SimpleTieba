package Action;

import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.SimplearticleDAO;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class findblogbyusers extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	public findblogbyusers(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	
	public String execute() throws Exception{
		System.out.println("½øÈëaction");
		String method=request.getParameter("method");
		
		User user=new User();
		if(method==null)
		{
			user=(User)session.getAttribute("User");
			System.out.println(user);
		}
		else
		{
			System.out.println("dianjileibiao");
			String idstr=request.getParameter("id");
			Integer id=Integer.parseInt(idstr);
			String username=request.getParameter("name");
			user.setId(id);
			user.setUsername(username);
		}
		if(user==null)
		{
			return "nologin";
		}
		
		else
		{
			SimplearticleDAO sadao=new SimplearticleDAO();
			List salist=sadao.findByProperty("user", user);
			System.out.println(salist.size());
			session.setAttribute("salist", salist);
			return "success";
		}
	}
}
