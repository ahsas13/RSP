package com.example.springweb;

import com.example.springweb.TeamRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@SpringBootApplication
public class SpringwebApplication {


	@Autowired
	private TeamRepository teamRepository;

	public static void main(String[] args) {
		SpringApplication.run(SpringwebApplication.class, args);
	}

	@PostConstruct
	public void init() {
		List<Team> list = new ArrayList<>();

		Set<Player> team1Players = new HashSet<>();
		team1Players.add(new Player("Anton Shunin", "GK"));
		team1Players.add(new Player("Eli Dasa", "Defender"));
		list.add(new Team("Dinamo", "Moscow", null, team1Players));

		Set<Player> team2Players = new HashSet<>();
		team2Players.add(new Player("Vyacheslav Grulyov", "FW"));
		list.add(new Team("CSKA", "Moscow", null, team2Players));

		teamRepository.saveAll(list);
	}
	}