package com.greymatter.product.mapper;

import com.greymatter.product.dto.ProductPurchaseResponse;
import com.greymatter.product.dto.ProductRequest;
import com.greymatter.product.dto.ProductResponse;
import com.greymatter.product.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    @Mapping(target = "category", ignore = true)
    Product toProduct(ProductRequest productRequest);

    @Mappings({
            @Mapping(target = "categoryId", source = "category.id"),
            @Mapping(target = "categoryName", source = "category.name"),
            @Mapping(target = "categoryDescription", source = "category.description")
    })
    ProductResponse toProductResponse(Product product);

    @Mapping(source = "product.id", target = "productId")
    @Mapping(target = "quantity", source = "quantity")
    ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity);
}
