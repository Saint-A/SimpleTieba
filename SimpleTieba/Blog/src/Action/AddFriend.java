package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.GuanzhuDAO;
import bean.Guanzhu;
import bean.Simplearticle;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class AddFriend extends ActionSupport {
	
	private HttpServletRequest request;
	private HttpSession session;
	
	public AddFriend(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	
	public String execute() throws Exception{
		Guanzhu guanzhu=new Guanzhu();
		System.out.println("进入添加关注");
		User user=(User)session.getAttribute("User");
		
		guanzhu.setUser(user);
		
		Simplearticle sa=(Simplearticle)session.getAttribute("sa");
		
		guanzhu.setFirendid(sa.getUser().getId());
		guanzhu.setFirendName(sa.getUser().getUsername());
		
		GuanzhuDAO gzdao=new GuanzhuDAO();
		if(gzdao.findexist(guanzhu).size()>0){
			System.out.println(gzdao.findByExample(guanzhu).size());
			return "error";
		}
		gzdao.save(guanzhu);
		return "success";
	}
}
