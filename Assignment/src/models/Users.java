package models;



import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Users {
	@Id
	@Column(name="id")
	String id;
	
	@Column(name="password")
	String password;
	
	@Column(name="fullname")
	String fullname;
	
	@Column(name="email")
	String email;
	
	@Column(name="admin")
	boolean admin;

	@OneToMany(mappedBy = "users")
	List<Favorite> favorites;
	@OneToMany(mappedBy = "users")
	List<Share> faShares;
	public Users() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Users(String id, String password, String fullname, String email, boolean admin) {
		super();
		this.id = id;
		this.password = password;
		this.fullname = fullname;
		this.email = email;
		this.admin = admin;
	}
	
	public List<Favorite> getFavorite() {
		return favorites;
	}
	public List<Share> getShares() {
		return faShares;
	}
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
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

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	
}
