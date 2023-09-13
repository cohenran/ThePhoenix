package com.homework.services;

import com.homework.dal.ProductRepository;
import com.homework.dal.PropertiesRepository;
import com.homework.model.ProductEntity;
import com.homework.model.PropertiesEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
	@Resource
	private ProductRepository productRepository;
	@Resource
	private PropertiesRepository propertiesRepository;

	public ProductEntity buyNewProduct(PropertiesEntity propertiesEntity) {
		propertiesEntity = propertiesRepository.save(propertiesEntity);
		
		ProductEntity productEntity = new ProductEntity(propertiesEntity);

		productEntity = buyNewProduct(productEntity);
		return productEntity;
	}

	public ProductEntity buyNewProduct(ProductEntity productEntity) {
		return productRepository.save(productEntity);
	}

	public ProductEntity updateProdcuts(Integer id, PropertiesEntity propertiesEntity) {
		propertiesEntity = saveProperties(propertiesEntity);

		Optional<ProductEntity> productEntityOpt = productRepository.findById(id);

		if (productEntityOpt.isEmpty()) {
			throw new RuntimeException("NO SUCH PRODUCT!");
		}

		ProductEntity productEntity = productEntityOpt.get();
		productRepository.delete(productEntity);

		ProductEntity newProductEntity = new ProductEntity(propertiesEntity);

		return productRepository.save(newProductEntity);
	}

	private PropertiesEntity saveProperties(PropertiesEntity propertiesEntity) {
		propertiesEntity = propertiesRepository.save(propertiesEntity);

		return propertiesEntity;
	}
}
