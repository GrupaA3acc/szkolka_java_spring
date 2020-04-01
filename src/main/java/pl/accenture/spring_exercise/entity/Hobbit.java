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
public class Hobbit {

    @Id
    private Float id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;

}
