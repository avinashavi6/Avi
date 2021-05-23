package com.capgeminijpa.model;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
@Entity
@Table(name="pageTable")
public class Page {
	@Id
	private int pageNo;
	private String pageName;
	private String pageContent;
	@ManyToOne
	@JoinColumn(name="book_no")
	private Book book;
	public Page() {}
	public Page(int pageNo, String pageName, String pageContent, Book book) {
		super();
		this.pageNo = pageNo;
		this.pageName = pageName;
		this.pageContent = pageContent;
		this.book = book;
	}
	public int getPageNo() {
		return pageNo;
	}
	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}
	public String getPageName() {
		return pageName;
	}
	public void setPageName(String pageName) {
		this.pageName = pageName;
	}
	public String getPageContent() {
		return pageContent;
	}
	public void setPageContent(String pageContent) {
		this.pageContent = pageContent;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	@Override
	public String toString() {
		return "Page [pageNo=" + pageNo + ", pageName=" + pageName + ", pageContent=" + pageContent + ", book=" + book
				+ "]";
	}
}
