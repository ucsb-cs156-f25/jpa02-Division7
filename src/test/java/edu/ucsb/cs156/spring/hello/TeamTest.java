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

    @Test
    public void checkFuntion(){
        Team team1 = new Team("team1");
        ArrayList<String> members = new ArrayList<>(List.of("Yue", "Perry", "Lucas"));
        team1.setMembers(members);

        Team team2 = new Team("team1");
        team2.setMembers(members);

        Team team3 = new Team("team1");

        Team team4 = new Team();
        team4.setMembers(members);

        assertEquals(team1, team2);
        assertNotEquals(team1, team);
        assertEquals(members, team1.getMembers());
        assertEquals(team1.hashCode(), team2.hashCode());
        assertNotEquals(team1.hashCode(), team.hashCode());
        assertNotEquals(team1.hashCode(), team3.hashCode());
        assertNotEquals(team1.hashCode(), team4.hashCode());

        int expected = "team1".hashCode() | List.of("Yue", "Perry", "Lucas").hashCode();
        assertEquals(team1.hashCode(), expected);

        
        assertNotEquals(team1.toString(), team.toString());
        assertEquals(team1.toString(), team2.toString());

        assert(team1.equals(team2));
        assert(!team1.equals(team));
        assert(team1.equals(team1)); 
        assert(!team1.equals(5));
        assert(!team1.equals(team3));
        assert(!team1.equals(team4));
    }

}
