package com.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authentication")
@NoArgsConstructor
@AllArgsConstructor
public class Authentication {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "authentication_method_type")
	private String authenticationMethodType;

	@Column(name = "method_value")
	private String methodValue;
}
