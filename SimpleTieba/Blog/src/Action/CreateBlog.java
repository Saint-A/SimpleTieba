package Action;

import java.util.Date;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;

import DAO.ArticleDAO;
import DAO.SimplearticleDAO;
import bean.Article;
import bean.Simplearticle;
import bean.User;

import com.opensymphony.xwork2.ActionSupport;

public class CreateBlog extends ActionSupport {
	private Simplearticle simplearticle;
	private Article article;
	private HttpServletRequest request;
	private HttpSession session;
	public Simplearticle getSimplearticle() {
		return simplearticle;
	}
	public void setSimplearticle(Simplearticle simplearticle) {
		this.simplearticle = simplearticle;
	}
	public Article getArticle() {
		return article;
	}
	public void setArticle(Article article) {
		this.article = article;
	}
	
	public CreateBlog(){
		request=ServletActionContext.getRequest();
		session=request.getSession();
	}
	public String execute() throws Exception{
		SimplearticleDAO sadao=new SimplearticleDAO();
		ArticleDAO articledao=new ArticleDAO();
		Date date=new Date();
		System.out.println(date);
		
		
		simplearticle.setUpdateTime(date);
		
		User user=(User)session.getAttribute("User");
		simplearticle.setUser(user);
		List<Simplearticle> list=(List<Simplearticle>)sadao.findByProperty("user", user);
		
		//simplearticle.setArticleId(list.size());
		//System.out.println(simplearticle.getArticleId());
		System.out.println(simplearticle.getTitle());
		System.out.print(article.getContent());
		sadao.save(simplearticle);
		article.setSaticle(simplearticle);
		articledao.save(article);
		
		System.out.println("success");
		return "success";
	}
}
