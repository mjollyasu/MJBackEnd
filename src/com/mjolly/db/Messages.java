package com.mjolly.db;

// Generated Dec 28, 2015 2:35:41 AM by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Messages generated by hbm2java
 */
@Entity
@Table(name = "messages", catalog = "msg")
public class Messages implements java.io.Serializable {

	private Integer idmessages;
	private String username;
	private String message;
	private Date createdAt;
	private Boolean private_;

	public Messages() {
	}

	public Messages(String username, String message, Date createdAt,
			Boolean private_) {
		this.username = username;
		this.message = message;
		this.createdAt = createdAt;
		this.private_ = private_;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "idmessages", unique = true, nullable = false)
	public Integer getIdmessages() {
		return this.idmessages;
	}

	public void setIdmessages(Integer idmessages) {
		this.idmessages = idmessages;
	}

	@Column(name = "username", length = 45)
	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	@Column(name = "message", length = 140)
	public String getMessage() {
		return this.message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "createdAt", length = 19)
	public Date getCreatedAt() {
		return this.createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	@Column(name = "private")
	public Boolean getPrivate_() {
		return this.private_;
	}

	public void setPrivate_(Boolean private_) {
		this.private_ = private_;
	}

}
