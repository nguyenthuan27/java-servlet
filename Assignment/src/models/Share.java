package models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "Share",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"iduser","idvideo"})
})
public class Share {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	long  idshare;
	
	@ManyToOne @JoinColumn(name = "iduser")
	Users users;
	@ManyToOne @JoinColumn(name = "idvideo")
	Videos videos;
	
	@Column(name = "emails")
	String emails;
	
	@Temporal(TemporalType.DATE)
	Date sharedate	= new Date();

	public Share() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Share(long idshare, Users users, Videos videos, String emails, Date sharedate) {
		super();
		this.idshare = idshare;
		this.users = users;
		this.videos = videos;
		this.emails = emails;
		this.sharedate = sharedate;
	}

	public long getIdshare() {
		return idshare;
	}

	public void setIdshare(long idshare) {
		this.idshare = idshare;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

	public Videos getVideos() {
		return videos;
	}

	public void setVideos(Videos videos) {
		this.videos = videos;
	}

	public String getEmails() {
		return emails;
	}

	public void setEmails(String emails) {
		this.emails = emails;
	}

	public Date getSharedate() {
		return sharedate;
	}

	public void setSharedate(Date sharedate) {
		this.sharedate = sharedate;
	}
	
}
