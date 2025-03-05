package crud.products.dto;

public record ProductRegisterInputDTO(
        String name,
        String description,
        String brand,
        String category,
        String barcode,
        Double quantity,
        Double costPrice,
        Double salePrice
) {}
