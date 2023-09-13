package com.homework.services;

import com.homework.dal.ProductRepository;
import com.homework.dal.PropertiesRepository;
import com.homework.model.ProductEntity;
import com.homework.model.PropertiesEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Resource
	private ProductRepository productRepository;
	@Resource
	private PropertiesRepository propertiesRepository;

	public ProductEntity buyNewProduct(List<String> properties) {
		PropertiesEntity propertiesEntity = saveProperties(properties);

		ProductEntity productEntity = new ProductEntity(propertiesEntity);

		return buyNewProduct(productEntity);
	}

	public ProductEntity buyNewProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

	public ProductEntity updateProdcuts(Integer id, List<String> properties) {
		PropertiesEntity propertiesEntity = saveProperties(properties);

		Optional<ProductEntity> productEntityOpt = productRepository.findById(id);

		if (productEntityOpt.isEmpty()) {
			throw new RuntimeException("NO SUCH PRODUCT!");
		}

		ProductEntity productEntity = productEntityOpt.get();
		productRepository.delete(productEntity);

		productEntity.setProperties(propertiesEntity);

		return productRepository.save(productEntity);
	}

	private PropertiesEntity saveProperties(List<String> properties) {
		PropertiesEntity propertiesEntity = new PropertiesEntity(properties);
		propertiesEntity = propertiesRepository.save(propertiesEntity);

		return propertiesEntity;
	}
}
