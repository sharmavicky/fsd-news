package com.cts.news.bean;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "article")
public class Article {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ar_id")
	private int id;

	@Column(name = "ar_title")
	private String title;

	@Column(name = "ar_author")
	private String author;

	@Column(name = "ar_url")
	private String url;

	@Column(name = "ar_url_to_image")
	private String urlToImage;

	@Column(name = "ar_published_at")
	private Date publishedAt;

	@Column(name = "ar_content")
	private String content;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	 * 
	 * @JoinColumn(name = "ar_so_id") private Source source;
	 */

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUrlToImage() {
		return urlToImage;
	}

	public void setUrlToImage(String urlToImage) {
		this.urlToImage = urlToImage;
	}

	public Date getPublishedAt() {
		return publishedAt;
	}

	public void setPublishedAt(Date publishedAt) {
		this.publishedAt = publishedAt;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Override
	public String toString() {
		return "Article [id=" + id + ", title=" + title + ", author=" + author + ", url=" + url + ", urlToImage="
				+ urlToImage + ", publishedAt=" + publishedAt + ", content=" + content + "]";
	}

}
