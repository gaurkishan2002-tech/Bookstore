package bookStore.BookStore.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

import java.math.BigDecimal;

@Entity
@Table(name = "books")
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "book title is must be require")
    @Column(nullable = false)
    private String title;

    @NotBlank(message = "book auther name is must be require")
    @Column(nullable = false)
    private String auther;

    @NotBlank(message = "book tcategory is must be require")
    private String category;

    @NotBlank(message = "book title is must require")
    @DecimalMin(value = "0.01" ,message = "price must be grater then zero")
    @Digits(integer = 10,fraction = 2)
    @Column(nullable = false ,precision = 12 ,scale = 2)
    private BigDecimal price;


    @NotBlank(message = "book quntity is must require")
    @Column(nullable = false)
    @Min(value = 0,message = "value can not lessThen zero")
    private Integer quntity;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuther() {
        return auther;
    }

    public void setAuther(String auther) {
        this.auther = auther;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuntity() {
        return quntity;
    }

    public void setQuntity(Integer quntity) {
        this.quntity = quntity;
    }
}
