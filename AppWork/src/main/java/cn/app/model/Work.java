package cn.app.model;

import java.io.FileInputStream;
import java.io.InputStream;

public class Work {
	private int workid;   //�鼮id
	private String workname;  //����
	private String author;//����
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
