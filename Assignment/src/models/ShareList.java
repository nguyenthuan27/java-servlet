package models;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class ShareList {
	@Id
	String sendername;
	String senderemail;
	String receivermail;
	Date senddate;
	
	
	public ShareList() {
		super();
		// TODO Auto-generated constructor stub
	}


	public ShareList(String sendername, String senderemail, String receivermail, Date senddate) {
		super();
		this.sendername = sendername;
		this.senderemail = senderemail;
		this.receivermail = receivermail;
		this.senddate = senddate;
	}


	public String getSendername() {
		return sendername;
	}


	public void setSendername(String sendername) {
		this.sendername = sendername;
	}


	public String getSenderemail() {
		return senderemail;
	}


	public void setSenderemail(String senderemail) {
		this.senderemail = senderemail;
	}


	public String getReceivermail() {
		return receivermail;
	}


	public void setReceivermail(String receivermail) {
		this.receivermail = receivermail;
	}


	public Date getSenddate() {
		return senddate;
	}


	public void setSenddate(Date senddate) {
		this.senddate = senddate;
	}
	
	
	
}
