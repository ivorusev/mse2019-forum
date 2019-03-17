package com.mse.forum.persistance.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "topics")
public class TopicEntity {

	@Id
	@GeneratedValue
	private Long id;

	@Column(unique = true)
	private String title;

	@Column(name = "user_id")
	private String userId;

	@Column(name = "created_on")
	private Date createdOn;

	@Column(name = "modified_on")
	private Date modifiedOn;

	@Column(name = "views_count")
	private long viewsCount;

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
