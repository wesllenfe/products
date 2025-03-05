package crud.products.dto;

import crud.products.entity.Product;

public record ListProductsOutputDTO(
        String id,
        String name,
        String description,
        String brand,
        String category,
        String barcode,
        Double quantity
) {

    public static ListProductsOutputDTO output(
            Product product
    ) {
        return new ListProductsOutputDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getCategory(),
                product.getBarcode(),
                product.getQuantity()
        );
    }
}
