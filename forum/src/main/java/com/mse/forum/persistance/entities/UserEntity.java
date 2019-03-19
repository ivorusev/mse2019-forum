package com.mse.forum.persistance.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity(name = "users")
public class UserEntity {

	@Id
	@GeneratedValue
	@Column(unique = true)
	private Long id;

	@Column(unique = true)
	private String username;

	private String password;

	private String email;

	@OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<ReplyEntity> replies;

	private Roles role;

}
