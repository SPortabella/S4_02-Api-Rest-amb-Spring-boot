package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n01.S04T02N01PORTABELLASUSANA.model.repository;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n01.S04T02N01PORTABELLASUSANA.model.domain.Fruit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface FruitRepository extends JpaRepository<Fruit, Long> {

    Optional<Fruit> findById(Long id);

    @Override
    void deleteById(Long aLong);

}
