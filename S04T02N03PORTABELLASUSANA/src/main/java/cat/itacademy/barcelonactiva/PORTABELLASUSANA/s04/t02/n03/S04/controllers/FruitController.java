package cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n03.S04.controllers;

import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n03.S04.model.domain.Fruit;
import cat.itacademy.barcelonactiva.PORTABELLASUSANA.s04.t02.n03.S04.model.service.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/fruits")

public class FruitController {

    @Autowired
    FruitService fruitService;

    @PostMapping("/add")
    public ResponseEntity<Fruit> addFruit(@RequestBody Fruit f) {

        try {
            Fruit fruit = new Fruit(f.getId(), f.getName(), f.getQuantity());
            fruitService.createFruit(fruit);
            return ResponseEntity.ok().body(fruit);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits() {
        try {
            List<Fruit> fruits;
            fruits = fruitService.findAll();

            if (fruits.isEmpty()) {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            } else {
                return ResponseEntity.ok().body(fruits);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/getOne/{id}")
    public ResponseEntity<Optional<Fruit>> getOneFruit(@PathVariable(value = "id") Long id) {
        try {
            Optional<Fruit> fruit = fruitService.findById(id);
            if (fruit.isPresent())
                return ResponseEntity.ok().body(fruit);
            else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Fruit> updateOneFruit(@PathVariable(value = "id") Long id,
                                                @RequestBody Fruit fruit) {
        try {
            Optional<Fruit> fruitOptional = fruitService.findById(id);
            if (fruitOptional.isPresent()) {
                Fruit newFruit = fruitOptional.get();
                if (fruit.getName() != null)
                    newFruit.setName(fruit.getName());
                if (fruit.getQuantity() != null)
                    newFruit.setQuantity(fruit.getQuantity());
                fruitService.saveFruit(newFruit);
                return ResponseEntity.ok().body(newFruit);
            } else {
                return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
            }

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Optional<Fruit>> deleteOneFruit(@PathVariable(value = "id") Long id) {
        try {
            Optional<Fruit> fruitOptional = fruitService.findById(id);
            if (fruitOptional.isPresent()) {
                fruitService.deleteById(id);
                return ResponseEntity.ok().body(fruitOptional);
            } else
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}

