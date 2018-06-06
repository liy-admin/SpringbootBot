package com.github.unafraid.spring.model;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author UnAfraid
 */
@Entity
@Table(name = "users")
public class User extends AbstractEntity {
	@Id
	@Column(unique = true, nullable = false)
	private Integer id;
	@Column(unique = true, nullable = false)
	private String name;
	private Integer level;

	public User() {
		this.createdDate = LocalDateTime.now();
		this.modifiedDate = LocalDateTime.now();
	}

	public User(int id, String name, int level) {
		this.id = id;
		this.name = name;
		this.level = level;
		this.createdDate = LocalDateTime.now();
		this.modifiedDate = LocalDateTime.now();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLevel() {
		return this.level;
	}

	public void setLevel(int level) {
		this.level = level;
	}
}
