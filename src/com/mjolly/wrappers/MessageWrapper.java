package com.mjolly.wrappers;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.mjolly.db.Messages;

//Wrapper class for messages
public class MessageWrapper 
{
	private Integer idmessages;
	private String username;
	private String message;
	private String createdAt;
	private Boolean private_;
	
	public MessageWrapper()
	{}
	
	public MessageWrapper(Messages m)
	{
		this.setIdmessages(m.getIdmessages());
		this.setUsername(m.getUsername());
		this.setMessage(m.getMessage());
		
		DateFormat df = new SimpleDateFormat("hh:mm a MM-dd-yyyy");
		setCreatedAt(df.format(m.getCreatedAt()));
		
		this.private_ = m.getPrivate_();
	}

	public Integer getIdmessages() {
		return idmessages;
	}

	public void setIdmessages(Integer idmessages) {
		this.idmessages = idmessages;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}

	public Boolean getPrivate_() {
		return private_;
	}

	public void setPrivate_(Boolean private_) {
		this.private_ = private_;
	}

}
