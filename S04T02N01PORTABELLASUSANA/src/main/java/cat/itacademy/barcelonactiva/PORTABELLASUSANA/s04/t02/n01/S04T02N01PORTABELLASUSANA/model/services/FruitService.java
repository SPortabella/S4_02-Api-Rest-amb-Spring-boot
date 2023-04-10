package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n01.S04T02N01PORTABELLASUSANA.model.services;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n01.S04T02N01PORTABELLASUSANA.model.domain.Fruit;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n01.S04T02N01PORTABELLASUSANA.model.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

   @Autowired
   FruitRepository fruitRepository;

    public Fruit createFruit(Fruit fruit) {
        return fruitRepository.save(fruit);
    }

    public Optional<Fruit> findById(Long id) {
        return fruitRepository.findById(id);
    }

    public void deleteById(Long id) {
        fruitRepository.deleteById(id);
    }

    public void saveFruit(Fruit fruit) {
        fruitRepository.save(fruit);
    }

    public List<Fruit> findAll() {
        return fruitRepository.findAll();
    }
}
