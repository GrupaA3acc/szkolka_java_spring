package pl.accenture.spring_exercise.entity;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
@NoArgsConstructor
public class HobbitEntity {

    @Id
    private float id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;

}
