package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ListLikeVideo {
	@Id
	String id;
	String fullname;
	String email;
	Date likedate;
	String title;
	public ListLikeVideo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ListLikeVideo(String id, String fullname, String email, Date likedate, String title) {
		super();
		this.id = id;
		this.fullname = fullname;
		this.email = email;
		this.likedate = likedate;
		this.title = title;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getFullname() {
		return fullname;
	}
	public void setFullname(String fullname) {
		this.fullname = fullname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getLikedate() {
		return likedate;
	}
	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
	
}
