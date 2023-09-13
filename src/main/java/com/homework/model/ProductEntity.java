package com.homework.model;

import lombok.*;

import javax.persistence.*;
import java.util.Properties;
import java.util.Set;

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
	@ManyToOne
	@JoinColumn(name = "properties")
	private PropertiesEntity properties;
}
