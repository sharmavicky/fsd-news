package com.cts.news.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "user")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "us_id")
	private int id;

	@NotNull(message = "User Name cannot be empty")
	@Column(name = "us_name")
	@Size( max = 70, message = "Name must not exceed 70 characters")
	private String name;

	@NotNull(message = "Email cannot be empty")
	@Size(max = 255, message = "Email must not exceed 255 characters")
	@Pattern(regexp = ".+@.+\\..+", message = "Email address is invalid")
	@Column(name = "us_email")
	private String email;

	@NotNull(message = "Password cannot be empty")
	@Size(min = 6, max = 50, message = "Password must be 6 to 50 characters")
	@Column(name = "us_password")
	private String password;

	@Column(name = "us_blacklist")
	private boolean blacklist;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_ro_id")

	private Role role;

	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "us_la_id")
	@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
	private Language language;

	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(name = "favorite_article", joinColumns = { @JoinColumn(name = "fa_us_id") }, inverseJoinColumns = {
			@JoinColumn(name = "fa_ar_id") })
	private List<Article> article;

	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	

	public boolean isBlacklist() {
		return blacklist;
	}

	public void setBlacklist(boolean blacklist) {
		this.blacklist = blacklist;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public List<Article> getArticle() {
		return article;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", password=" + password + ", blacklist="
				+ blacklist + ", role=" + role + ", language=" + language + ", article=" + article + "]";
	}

	public void setArticle(List<Article> article) {
		this.article = article;
	}

	

}
