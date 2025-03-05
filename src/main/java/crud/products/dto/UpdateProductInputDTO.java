package crud.products.dto;

public record UpdateProductInputDTO(
        String description,
        String barcode,
        Double quantity
) {
}
