package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotEquals;


public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
       assert(team.getName().equals("test-team"));
    }

   
    public void checkFuntion(){
        Team team1 = new Team("team1");
        ArrayList<String> members = new ArrayList<>(List.of("Yue", "Perry", "Lucas"));
        team1.setMembers(members);

        Team team2 = new Team("team1");
        team2.setMembers(members);

        assertEquals(team1, team2);
        assertEquals(members, team.getMembers());
        assertEquals(team1.hashCode(), team2.hashCode());

        assertNotEquals(team1, new Team());
        assertEquals(team1.toString(), team1.toString());
    }

}
