package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n02.S04T02N02PORTABELLASUSANA.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor

@Table(name = "Fruit")
public class Fruit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private Integer quantity;

    public Fruit(String name, Integer quantity) {
        this.name = name;
        this.quantity = quantity;
    }
}
