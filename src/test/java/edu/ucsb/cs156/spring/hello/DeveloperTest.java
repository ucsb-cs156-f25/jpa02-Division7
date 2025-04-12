package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Constructor;
import java.lang.reflect.Modifier;

import org.junit.jupiter.api.Test;
import java.util.List;

public class DeveloperTest {

    @Test
    public void testPrivateConstructor() throws Exception {
        // this hack is from https://www.timomeinen.de/2013/10/test-for-private-constructor-to-get-full-code-coverage/
        Constructor<Developer> constructor = Developer.class.getDeclaredConstructor();
        assertTrue(Modifier.isPrivate(constructor.getModifiers()),"Constructor is not private");

        constructor.setAccessible(true);
        constructor.newInstance();
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("Yue C.", Developer.getName());
    }

    @Test
    public void checkGithubId() {
        assertEquals("yuecao365", Developer.getGithubId());
    }

    @Test
    public void testGetTeamNumber() {
        Team team = Developer.getTeam();
        assertEquals("s25-15", team.getName());
    }

    @Test
    public void testGetTeamMembers() {
        Team team = Developer.getTeam();
        List<String> members = team.getMembers();

        assertTrue(members.contains("Yue C."));
        assertTrue(members.contains("Bryce"));
        assertTrue(members.contains("Lucas"));
        assertTrue(members.contains("Perry"));
        assertTrue(members.contains("David"));
        assertTrue(members.contains("Tyler"));
    }

    

}
