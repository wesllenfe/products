package crud.products.service;

import crud.products.dto.*;
import crud.products.entity.Product;
import crud.products.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductRegisterOutputDTO register(ProductRegisterInputDTO input){

        Product product = Product.newProduct(
                input.name(),
                input.description(),
                input.brand(),
                input.category(),
                input.barcode(),
                input.quantity(),
                input.costPrice(),
                input.salePrice()
        );

        final var saveProduct = productRepository.save(product);

        return ProductRegisterOutputDTO.output(saveProduct.getId());
    }

    public UpdateProductOutputDTO update(String id, UpdateProductInputDTO input) {

        final var product = productRepository.findById(id).orElseThrow();

        product.update(
                input.description(),
                input.barcode(),
                input.quantity()
        );

        final var updatedProduct = productRepository.save(product);

        return UpdateProductOutputDTO.output(updatedProduct.getId());
    }

    public FindProductOutputDTO find(String id){
        final var product = productRepository.findById(id).orElseThrow();

        return FindProductOutputDTO.output(product);
    }

    public List<ListProductsOutputDTO> list(){
        final var products = productRepository.findAll();

        return products.stream().map(ListProductsOutputDTO::output).toList();
    }

    public void delete(String id){
        productRepository.deleteById(id);
    }
}
