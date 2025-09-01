package com.example.crud.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String email;
    private String location;

    // Many Users can have one Position
    @ManyToOne
    @JoinColumn(name = "position_id") // foreign key column
    private Position position;

}
