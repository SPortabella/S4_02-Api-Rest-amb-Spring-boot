package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n03.S04.model.repository;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n03.S04.model.domain.Fruit;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FruitRepository extends MongoRepository<Fruit, Long> {

}
