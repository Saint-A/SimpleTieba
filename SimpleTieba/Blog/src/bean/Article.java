package bean;

import java.awt.Image;
import java.util.List;

public class Article {
	private Integer articleId;
	private String content;
	//private List<Image> images;
	private Simplearticle saticle;
	
	public Integer getArticleId() {
		return articleId;
	}

	public void setArticleId(Integer articleId) {
		this.articleId = articleId;
	}

	public Simplearticle getSaticle() {
		return saticle;
	}

	public void setSaticle(Simplearticle saticle) {
		this.saticle = saticle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}
	
	public Article(){}
}
