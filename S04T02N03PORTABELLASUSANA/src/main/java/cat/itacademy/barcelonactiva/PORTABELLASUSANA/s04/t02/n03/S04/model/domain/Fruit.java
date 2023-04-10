package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n03.S04.model.domain;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import org.springframework.data.mongodb.core.mapping.Document;


@Document(collection = "fruits")
@JsonPropertyOrder({"id", "name", "quantity"})
public class Fruit  {
    @Id
    private Long id;
    private String name;
    private Integer quantity;

    public Fruit(Long id, String name, Integer quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
