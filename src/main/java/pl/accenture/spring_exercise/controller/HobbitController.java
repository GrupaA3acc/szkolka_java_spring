package pl.accenture.spring_exercise.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pl.accenture.spring_exercise.domain.Hobbit;
import pl.accenture.spring_exercise.repository.HobbitRepository;

@RestController
public class HobbitController {

    private HobbitRepository hobbitRepository;

    public HobbitController(HobbitRepository hobbitRepository) {
        this.hobbitRepository = hobbitRepository;
    }

    @GetMapping("/hobbit/{id}")
    public Hobbit pokazHobbita(@PathVariable Long id)
    {
        return hobbitRepository.findById(id).get();
    }


}
