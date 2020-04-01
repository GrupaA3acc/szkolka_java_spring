package com.example.demo.repository;

import com.example.demo.domain.Hobbit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface HobbitRepository extends JpaRepository<Hobbit, Long> {
    public Optional<List<Hobbit>> findAllByLastName(String name);
}
