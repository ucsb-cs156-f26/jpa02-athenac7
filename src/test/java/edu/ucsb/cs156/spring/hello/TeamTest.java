package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
    public void toString_returns_correct_string() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
    }
    @Test
    public void equals_same_object() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_different_class() {
        assertFalse(team.equals("Not a Team object"));
    }

    @Test
    public void equals_same_name_and_members() {
        Team t2 = new Team("test-team");
        assertTrue(team.equals(t2));
    }

    @Test
    public void equals_different_name_same_members() {
        Team t2 = new Team("different-name");
        assertFalse(team.equals(t2));
    }

    @Test
    public void equals_same_name_different_members() {
        Team t2 = new Team("test-team");
        t2.addMember("Alice");
        assertFalse(team.equals(t2));
    }

    @Test
    public void equals_different_name_different_members() {
        Team t2 = new Team("different-name");
        t2.addMember("Alice");
        assertFalse(team.equals(t2));
    }
    @Test
    public void hashCode_returns_exact_value() {
        Team t1 = new Team();
        t1.setName("foo");
        t1.addMember("bar");

        int expectedResult = 130294; 
        assertEquals(expectedResult, t1.hashCode());
    }
    // TODO: Add additional tests as needed to get to 100% jacoco line coverage, and
    // 100% mutation coverage (all mutants timed out or killed)

}
