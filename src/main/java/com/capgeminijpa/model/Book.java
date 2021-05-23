package com.capgeminijpa.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="bookDetailsTable")
public class Book
{
	@Id
	private int bookNo;
	private String bookName;
	private double bookCost;
	@OneToMany(targetEntity=Page.class,mappedBy="book",cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	Set<Page> pageSet;
	public Book(){}
	public Book(int bookNo, String bookName, double bookCost, Set<Page> pageSet) {
		super();
		this.bookNo = bookNo;
		this.bookName = bookName;
		this.bookCost = bookCost;
		this.pageSet = pageSet;
	}
	public int getBookNo() {
		return bookNo;
	}
	public void setBookNo(int bookNo) {
		this.bookNo = bookNo;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public double getBookCost() {
		return bookCost;
	}
	public void setBookCost(double bookCost) {
		this.bookCost = bookCost;
	}
	public Set<Page> getPageSet() {
		return pageSet;
	}
	public void setPageSet(Set<Page> pageSet) {
		this.pageSet = pageSet;
	}
	@Override
	public String toString() {
		return "Book [bookNo=" + bookNo + ", bookName=" + bookName + ", bookCost=" + bookCost + ", pageSet=" + pageSet
				+ "]";
	}
}
