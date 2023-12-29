package com.example.springweb;

import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String location;
    private String mascot;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "team_id")
    private Set<Player> players = new HashSet<>();

    public Team() {
        // Пустой конструктор
    }

    public Team(String name, String location, String mascot) {
        this.name = name;
        this.location = location;
        this.mascot = mascot;
    }

    public Team(Long id, String name, String location, String mascot) {
        this.id = id;
        this.name = name;
        this.location = location;
        this.mascot = mascot;
    }

    public Team(String name, String location, String mascot, Set<Player> players) {
        this(name, location, mascot);
        this.players = players;
    }

    // Геттеры и сеттеры

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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMascot() {
        return mascot;
    }

    public void setMascot(String mascot) {
        this.mascot = mascot;
    }

    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }
}
