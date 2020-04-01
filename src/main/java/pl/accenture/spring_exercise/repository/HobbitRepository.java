package pl.accenture.spring_exercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.accenture.spring_exercise.model.Hobbit;

public interface HobbitRepository extends JpaRepository<Hobbit, Long> {
}
