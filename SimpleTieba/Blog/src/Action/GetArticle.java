package Action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.ArticleDAO;
import DAO.CommentDAO;
import DAO.SimplearticleDAO;

import bean.Article;
import bean.Simplearticle;

import com.opensymphony.xwork2.ActionSupport;

public class GetArticle extends ActionSupport {
	private HttpServletRequest request;
	private HttpSession session;
	public GetArticle(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	public String execute() throws Exception{
		System.out.println("½øÈëgetablogaction");
			String articleId=request.getParameter("articleId");
			Integer articleid=Integer.parseInt(articleId);
			System.out.println(articleId);
			SimplearticleDAO sadao=new SimplearticleDAO();
			ArticleDAO articledao=new ArticleDAO();
			CommentDAO commentdao=new CommentDAO();
			Simplearticle sa=sadao.findById(articleid);
			Article article=articledao.findById(articleid);
			List commentlist=commentdao.findByProperty("simplearticle", sa);
			session.setAttribute("sa", sa);
			session.setAttribute("article", article);
			session.setAttribute("commentlist", commentlist);
			return "success";
	}
}
