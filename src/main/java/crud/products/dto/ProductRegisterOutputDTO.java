package crud.products.dto;

public record ProductRegisterOutputDTO(
        String id
) {
    public static ProductRegisterOutputDTO output(String id){
        return new ProductRegisterOutputDTO(id);
    }
}
