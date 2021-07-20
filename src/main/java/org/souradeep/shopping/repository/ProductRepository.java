package org.souradeep.shopping.repository;

import java.util.UUID;

import org.souradeep.shopping.data.entity.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends CrudRepository<Product, UUID> {

}
