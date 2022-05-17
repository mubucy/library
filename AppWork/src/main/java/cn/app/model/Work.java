package cn.app.model;

import java.io.FileInputStream;
import java.io.InputStream;

public class Work {
	private int workid;   //书籍id
	private String workname;  //书名
	private String author;//作者
	private long ISBN;  //ISBN
 
	public void setWName(String workname) {
		this.workname = workname;
	}
	public String getWName() {
		return workname;
	}
	
	public int getWId() {
		return workid;
	}
	public void setWId(int workid) {
		this.workid = workid;
	}
	
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	
	public Long getWI() {
		return ISBN;
	}
	public void setWI(Long ISBN) {
		this.ISBN = ISBN;
	}
	
}
