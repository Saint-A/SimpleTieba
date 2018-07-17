package Action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.ArticleDAO;
import DAO.CommentDAO;
import DAO.SimplearticleDAO;
import bean.Article;
import bean.Comment;
import bean.Simplearticle;

import com.opensymphony.xwork2.ActionSupport;

public class DeleteBlog extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	public DeleteBlog(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
		
	}
	
	public String execute() throws Exception{ 
		Simplearticle sa=(Simplearticle)session.getAttribute("sa");
		SimplearticleDAO  sadao=new SimplearticleDAO();
		Article a=sa.getArticle();
		ArticleDAO adao=new ArticleDAO();
		CommentDAO codao=new CommentDAO();
		codao.deleteByProperty("simplearticle", sa);
		adao.delete(a);
		sadao.delete(sa);
		return "success";
	}
}
