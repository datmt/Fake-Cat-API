package com.datmt.fake_api.controller;


import com.datmt.fake_api.helpers.Cavatar;
import com.datmt.fake_api.model.Cat;
import com.datmt.fake_api.repository.CatRepository;
import com.github.javafaker.Faker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("cats")
public class CatController {

    @Autowired
    CatRepository catRepository;

    @GetMapping("raise/{numCat}")
    public List<Cat> raise(@PathVariable("numCat") int numCat) {
        List<Cat> cats = new ArrayList<>();
        Faker faker = new Faker();

        int maxId = 0;
        Optional<Cat> cat = catRepository.getAllCats().stream().max(Comparator.comparingInt(Cat::getId));
        if (cat.isPresent()) {
            maxId = cat.get().getId();
        }

        for (int i = 0; i < numCat; i++) {
            cats.add(new Cat(
                    ++maxId,
                    faker.cat().name(),
                    faker.cat().breed(),
                    faker.color().name(),
                    Cavatar.random()
            ));
        }

        catRepository.getAllCats().addAll(cats);
        return cats;
    }

    @GetMapping("list")
    public List<Cat> list() {
        return catRepository.getAllCats();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> bye(@PathVariable("id") int id) {
        Cat cat = catRepository.getAllCats().stream().filter(t -> t.getId() == id)
                .findAny().orElse(null);

        if (cat == null) {
            throw new RuntimeException("Cat does not exist");
        }
        catRepository.getAllCats().remove(cat);

        return ResponseEntity.status(HttpStatus.ACCEPTED).body("cat removed");
    }

    @GetMapping("/{id}")
    public ResponseEntity<Cat> getCat(@PathVariable("id") int id) {
        Cat cat = catRepository.getAllCats().stream().filter(t -> t.getId() == id)
                .findAny().orElse(null);

        if (cat == null) {
            throw new RuntimeException("Cat does not exist");
        }
        return ResponseEntity.status(HttpStatus.OK).body(cat);
    }

    @PutMapping()
    public ResponseEntity<Cat> updateCat(@RequestBody Cat mutatedCat) {
        Cat cat = catRepository.getAllCats().stream().filter(t -> t.getId() == mutatedCat.getId())
                .findAny().orElse(null);

        if (cat == null) {
            throw new RuntimeException("Cat does not exist");
        }
        int index = catRepository.getAllCats().indexOf(cat);
        catRepository.getAllCats().set(index, mutatedCat);
        return ResponseEntity.status(HttpStatus.OK).body(mutatedCat);
    }

    @GetMapping("/search/{name}")
    public List<Cat> search(@PathVariable("name") String name) {
        return catRepository.getAllCats().stream().filter(t -> t.getName().toLowerCase(Locale.ROOT).contains(name.toLowerCase(Locale.ROOT))).collect(Collectors.toList());
    }
}
