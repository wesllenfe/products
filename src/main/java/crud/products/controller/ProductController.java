package crud.products.controller;

import crud.products.dto.*;
import crud.products.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/products")
@Tag(name = "Product", description = "Products management")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    @Operation(summary = "Register product")
    @ApiResponse(responseCode = "201", description = "Product successfully registered!")
    @ApiResponse(responseCode = "400", description = "Invalid request data!")
    @ApiResponse(responseCode = "500", description = "Internal server error!")
    public ResponseEntity<ProductRegisterOutputDTO> register(@RequestBody ProductRegisterInputDTO input){
        ProductRegisterOutputDTO output = productService.register(input);
        return ResponseEntity.created(URI.create("/products/" + output.id())).body(output);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Update product")
    @ApiResponse(responseCode = "200", description = "Product successfully updated!")
    @ApiResponse(responseCode = "400", description = "Invalid request data!")
    @ApiResponse(responseCode = "500", description = "Internal server error!")
    public ResponseEntity<UpdateProductOutputDTO> update(@PathVariable("id") String id, @RequestBody UpdateProductInputDTO input){
        UpdateProductOutputDTO output = productService.update(id, input);
        return ResponseEntity.ok(output);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "Find product")
    @ApiResponse(responseCode = "200", description = "Product found successfully!")
    @ApiResponse(responseCode = "400", description = "Invalid request data!")
    @ApiResponse(responseCode = "404", description = "Product not found!")
    @ApiResponse(responseCode = "500", description = "Internal server error!")
    public ResponseEntity<FindProductOutputDTO> find(@PathVariable("id") String id){
        FindProductOutputDTO output = productService.find(id);
        return  ResponseEntity.ok(output);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    @Operation(summary = "List products")
    @ApiResponse(responseCode = "200", description = "Products listed successfully!")
    @ApiResponse(responseCode = "400", description = "Invalid request data!")
    @ApiResponse(responseCode = "500", description = "Internal server error!")
    public ResponseEntity<List<ListProductsOutputDTO>> list(){
        List<ListProductsOutputDTO> output = productService.list();
        return ResponseEntity.ok(output);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @Operation(summary = "Delete product")
    @ApiResponse(responseCode = "204", description = "Product successfully deleted!")
    @ApiResponse(responseCode = "400", description = "Invalid request data!")
    @ApiResponse(responseCode = "404", description = "Product not found!")
    @ApiResponse(responseCode = "500", description = "Internal server error!")
    public ResponseEntity<Void> delete(@PathVariable("id") String id){
        productService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
