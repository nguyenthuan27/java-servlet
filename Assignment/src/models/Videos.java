package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Videos {
	@Id
	@Column(name = "id")
	String id;
	
	@Column(name = "title")
	String title;
	
	@Column(name = "poster")
	String poster;
	
	@Column(name = "viewss")
	Integer viewss;
	
	@Column(name = "descriptions")
	String descriptions;
	
	@Column(name = "active")
	Boolean active;
	@OneToMany(mappedBy = "videos")
	List<Favorite> favorites;
	@OneToMany(mappedBy = "videos")
	List<Share> shares;
	public Videos() {
		super();
		// TODO Auto-generated constructor stub
	}

	public List<Favorite> getFavorites() {
		return favorites;
	}

	public void setFavorites(List<Favorite> favorites) {
		this.favorites = favorites;
	}

	public List<Share> getShares() {
		return shares;
	}

	public void setShares(List<Share> shares) {
		this.shares = shares;
	}

	public Videos(String id, String title, String poster, Integer viewss, String descriptions, Boolean active) {
		super();
		this.id = id;
		this.title = title;
		this.poster = poster;
		this.viewss = viewss;
		this.descriptions = descriptions;
		this.active = active;
	}
	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Integer getViewss() {
		return viewss;
	}

	public void setViewss(Integer viewss) {
		this.viewss = viewss;
	}

	public String getDescriptions() {
		return descriptions;
	}

	public void setDescriptions(String descriptions) {
		this.descriptions = descriptions;
	}

	public Boolean getActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}
	
	
	
}
