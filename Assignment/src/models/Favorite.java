package models;

import java.util.Date;

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
@Table(name = "Favorite",uniqueConstraints = {
		@UniqueConstraint(columnNames = {"iduser","idvideo"})
})
public class Favorite {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	Long idfavor;
	
	public Favorite(Long idfavor, Users users, Videos videos, Date likedate) {
		super();
		this.idfavor = idfavor;
		this.users = users;
		this.videos = videos;
		this.likedate = likedate;
	}

	@ManyToOne @JoinColumn(name = "iduser")
	Users users;
	@ManyToOne @JoinColumn(name = "idvideo")
	Videos videos;
	
	@Temporal(TemporalType.DATE)
	Date likedate	= new Date();

	public Favorite() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Long getIdfavor() {
		return idfavor;
	}

	public void setIdfavor(Long idfavor) {
		this.idfavor = idfavor;
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

	public Date getLikedate() {
		return likedate;
	}

	public void setLikedate(Date likedate) {
		this.likedate = likedate;
	}
	
	
	
}
