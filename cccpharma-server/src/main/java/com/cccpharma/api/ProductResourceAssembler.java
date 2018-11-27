package com.cccpharma.api;

import com.cccpharma.domain.orm.Product;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Component;

@Component
public class ProductResourceAssembler extends ResourceAssemblerSupport<Product, ProductResource> {

    public ProductResourceAssembler() {
        super(ProductRestService.class, ProductResource.class);
    }

    @Override
    public ProductResource toResource(Product product) {
        ProductResource productResource = createResourceWithId(product.getBarcode(), product);
        productResource.setAvailable(product.isAvailable());
        productResource.setCategoryName(product.getCategory().getName());
        productResource.setCategoryDiscount(product.getCategory().getDiscount());
        productResource.setName(product.getName());
        productResource.setPrice(product.getPrice());
        productResource.setBarcode(product.getBarcode());
        productResource.setManufacturer(product.getManufacturer());
        return productResource;
    }

    public Product toDomain(ProductResource productResource) {
        return Product.builder()
                .available(productResource.isAvailable())
                .barcode(productResource.getBarcode())
                .manufacturer(productResource.getManufacturer())
                .name(productResource.getName())
                .price(productResource.getPrice())
                .build();
    }
}
