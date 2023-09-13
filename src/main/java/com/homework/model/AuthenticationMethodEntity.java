package com.homework.model;

import lombok.*;

import javax.persistence.*;

@Data
@Entity
@Table(name = "authentication_method")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class AuthenticationMethodEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(name = "authentication_method_type")
	private String authenticationMethodType;

	@NonNull
	@Column(name = "authentication_method_value")
	private String authenticationMethodValue;
}
