package pl.accenture.spring_exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.accenture.spring_exercise.model.Hobbit;
import pl.accenture.spring_exercise.repository.HobbitRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HobbitController {

    private HobbitRepository hobbitRepository;

    @Autowired
    public HobbitController(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    @GetMapping("/hobbit/id/{id}")
    public Hobbit getHobbitByID(@PathVariable Long id){
        Optional<Hobbit> resultHobbit = hobbitRepository.findById(id);
        return resultHobbit.orElseGet(Hobbit::new);
    }

    @GetMapping("/hobbit/lastname/{lastName}")
    public List<Hobbit> getAllHobbitsByLastName(@PathVariable String lastName){
        Optional<List<Hobbit>> resultList = hobbitRepository.findAllByLastName(lastName);
        return resultList.orElseGet(ArrayList::new);
    }
}
