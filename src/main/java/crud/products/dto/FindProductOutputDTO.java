package crud.products.dto;

import crud.products.entity.Product;

public record FindProductOutputDTO(
        String id,
        String name,
        String description,
        String brand,
        String category,
        String barcode,
        Double quantity,
        Double costPrice,
        Double salePrice
) {

    public static FindProductOutputDTO output(
           Product product
    ) {
        return new FindProductOutputDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getBrand(),
                product.getCategory(),
                product.getBarcode(),
                product.getQuantity(),
                product.getCostPrice(),
                product.getSalePrice()
        );
    }
}
