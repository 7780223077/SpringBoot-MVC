package com.charan.entity;

import java.util.Set;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@Entity
@Table(name = "user_tab")
@AllArgsConstructor
@NoArgsConstructor
public class User {
	@Id
	@GeneratedValue
	private Integer id;
	private String username;
	private String password;
	private String name;
	@ElementCollection
	@CollectionTable(name = "roles_tab",
		joinColumns = @JoinColumn(referencedColumnName = "id"))
	@Column(name = "roles")
	private Set<String> roles;
}
