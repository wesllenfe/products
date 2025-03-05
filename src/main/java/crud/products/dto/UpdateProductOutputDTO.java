package crud.products.dto;

public record UpdateProductOutputDTO(
        String id
) {
    public static UpdateProductOutputDTO output(String id){
        return new UpdateProductOutputDTO(id);
    }
}
