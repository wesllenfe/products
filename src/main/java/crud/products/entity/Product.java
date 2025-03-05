package crud.products.entity;

import crud.products.utils.IdUtils;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity(name = "Product")
@Table(name = "product")
public class Product {

    @Id
    private String id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "brand", nullable = false)
    private String brand;

    @Column(name = "category", nullable = false)
    private String category;

    @Column(name = "barcode", nullable = false)
    private String barcode;

    @Column(name = "quantity", nullable = false)
    private Double quantity;

    @Column(name = "cost_price", nullable = false)
    private Double costPrice;

    @Column(name = "sale_price", nullable = false)
    private Double salePrice;

    @Column(name = "created_at", nullable = false, columnDefinition = "TIMESTAMP(6)")
    private LocalDateTime createdAt;

    public Product() {}

    private Product(String id, String name, String description, String brand, String category, String barcode, Double quantity, Double costPrice, Double salePrice, LocalDateTime createdAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.brand = brand;
        this.category = category;
        this.barcode = barcode;
        this.quantity = quantity;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.createdAt = createdAt;
    }

    public static Product newProduct(String name, String description, String brand, String category, String barcode, Double quantity, Double costPrice, Double salePrice) {
        String id = IdUtils.uuid();
        LocalDateTime createdAt = LocalDateTime.now();
        return new Product(id, name, description, brand, category, barcode, quantity, costPrice, salePrice, createdAt);
    }

    public Product update(String description, String barcode, Double quantity){
        this.description = description;
        this.barcode = barcode;
        this.quantity = quantity;

        return this;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public String getBrand() {
        return brand;
    }

    public String getCategory() {
        return category;
    }

    public String getBarcode() {
        return barcode;
    }

    public Double getQuantity() {
        return quantity;
    }

    public Double getCostPrice() {
        return costPrice;
    }

    public Double getSalePrice() {
        return salePrice;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
