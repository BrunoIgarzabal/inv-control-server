package com.brunoIgarzabal.invcontrol.repositories;

import com.brunoIgarzabal.invcontrol.domain.products.Product;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface ProductRepository extends BaseRepository<Product> {

    @Transactional(readOnly = true)
    Product findByProductCode(String productCode);

}
