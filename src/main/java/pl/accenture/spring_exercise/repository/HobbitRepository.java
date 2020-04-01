package pl.accenture.spring_exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.accenture.spring_exercise.model.Hobbit;

import java.util.List;
import java.util.Optional;

public interface HobbitRepository extends JpaRepository<Hobbit, Long> {
    public Optional<List<Hobbit>> findAllByLastName(String name);
}
