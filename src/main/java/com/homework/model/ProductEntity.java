package com.homework.model;

import lombok.*;
import org.springframework.context.annotation.Lazy;

import javax.persistence.*;

@Data
@Entity
@Table(name = "products")
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class ProductEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@NonNull
	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "properties")
	private PropertiesEntity properties;
}
