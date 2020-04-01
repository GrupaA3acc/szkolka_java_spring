package com.example.demo.domain;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
@RequiredArgsConstructor //Not working ?
@NoArgsConstructor       //Not working
public class Hobbit {

    @Id
    private Long id;
    @NonNull
    private String name;
    @NonNull
    private String lastName;

    /*public Hobbit(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }

    public Hobbit() {
        super();
    }*/

}
