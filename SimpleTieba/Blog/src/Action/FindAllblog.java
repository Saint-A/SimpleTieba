package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.SimplearticleDAO;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class FindAllblog extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	public FindAllblog(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	public String execute() throws Exception{
		System.out.println("½øÈëfidallblogaction");
	
			SimplearticleDAO sadao=new SimplearticleDAO();
			List salist=sadao.findAll();
			System.out.println(salist.size());
			session.setAttribute("salistall", salist);
			return "success";
	}
}
