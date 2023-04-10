package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n02.S04T02N02PORTABELLASUSANA.model.repository;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n02.S04T02N02PORTABELLASUSANA.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    Optional<Fruit> findById(Long id);

    @Override
    void deleteById(Long aLong);

}
