package pl.accenture.spring_exercise.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.accenture.spring_exercise.entity.Hobbit;
import pl.accenture.spring_exercise.repository.HobbitRepository;

@RestController
public class HobbitController {

    private final HobbitRepository hobbitRepository;

    @Autowired
    public HobbitController(HobbitRepository hobbitRepository){
        this.hobbitRepository = hobbitRepository;
    }

    @GetMapping("/hobbit/{id}")
    public Hobbit stworzHobbita(@PathVariable Float id){
        return hobbitRepository.findById(id).get();
    }
}
