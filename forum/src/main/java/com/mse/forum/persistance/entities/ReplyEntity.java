package com.mse.forum.persistance.entities;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "replies")
public class ReplyEntity {

	@Id
	@GeneratedValue
	private Long id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "topic_id", nullable = false)
	private TopicEntity topic;

	@Column(name = "reply_content")
	private String replyContent;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "modified_on")
	private Date modifiedOn;

	@PrePersist
	public void setDates() {
		this.modifiedOn = new Date();
		this.createdOn = new Date();
	}

	@PreUpdate
	public void updateDates() {
		this.modifiedOn = new Date();
	}

}
