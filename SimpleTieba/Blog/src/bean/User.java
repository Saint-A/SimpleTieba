package bean;

import java.util.HashSet;
import java.util.Set;

/**
 * User entity. @author MyEclipse Persistence Tools
 */

public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String username;
	private String password;
	private Set simplearticles = new HashSet(0);
	private Set guanzhus = new HashSet(0);

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String username, String password, Set simplearticles,
			Set guanzhus) {
		this.username = username;
		this.password = password;
		this.simplearticles = simplearticles;
		this.guanzhus = guanzhus;
	}

	// Property accessors

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set getSimplearticles() {
		return this.simplearticles;
	}

	public void setSimplearticles(Set simplearticles) {
		this.simplearticles = simplearticles;
	}

	public Set getGuanzhus() {
		return this.guanzhus;
	}

	public void setGuanzhus(Set guanzhus) {
		this.guanzhus = guanzhus;
	}

}