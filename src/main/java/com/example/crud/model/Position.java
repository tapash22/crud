package com.example.crud.model;

import com.example.crud.type.PositionType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // e.g., "Manager", "Developer"

    @Enumerated(EnumType.STRING)
    private PositionType type; // enum to declare type of the position

    @OneToMany(mappedBy = "position")
    private List<User> users;
}
