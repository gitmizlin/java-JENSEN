package com.jensen;

public class BlogPage {

	private int id;
	private String date;
	private String writer;
	private String title;	
	private String content;
	private String link;

	public BlogPage(int id, String date, String writer, String title, String content, String link) {
		this.id = id;
		this.date = date;
		this.writer = writer;
		this.content = content;
		this.link = link;			
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public String getTitle() {
		return title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getLink() {
		return link;
	}

	public void setLink(String link) {
		this.link = link;
	}
	
}