package pl.accenture.spring_exercise.domain;


import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.management.ConstructorParameters;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor
public class Hobbit {

    @Id
    private Long id;
    private String name;
    private String lastName;
    private boolean hasSecondBreakfast;

    public Hobbit(Long id, String name, String lastName, boolean hasSecondBreakfast)
    {
        this.id = id;
        this.name = name;
        this.lastName = lastName;
        this.hasSecondBreakfast = hasSecondBreakfast;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setHasSecondBreakfast(boolean hasSecondBreakfast) {
        this.hasSecondBreakfast = hasSecondBreakfast;
    }

    public boolean isHasSecondBreakfast() {
        return hasSecondBreakfast;
    }
}
