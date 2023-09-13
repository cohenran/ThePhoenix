package com.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
@Table(name = "client")
@NoArgsConstructor
@AllArgsConstructor
public class ClientEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@OneToOne
	@JoinColumn(name = "authentication_id")
	private Authentication authentication;

	@OneToMany
	@JoinColumn(name = "product_id")
	private Set<ProductEntity> products;
}
