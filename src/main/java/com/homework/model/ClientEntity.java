package com.homework.model;

import lombok.*;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@Column(name = "is_authorized")
	private Boolean isAuthorized;

	@NonNull
	@OneToOne
	@JoinColumn(name = "authentication_method_id")
	private AuthenticationMethod authenticationMethod;

	@OneToMany(fetch = FetchType.EAGER,
			cascade = CascadeType.ALL)
	private Set<ProductEntity> products;
}
