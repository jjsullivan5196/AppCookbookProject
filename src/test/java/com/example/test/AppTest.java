package com.example.test;

import java.util.ArrayList;
import java.util.Random;
import java.util.Collections;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;


public class AppTest {

    @Test
    public void groupsHaveThreePeople() throws Exception {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App app = new App(names);
        List<String> group = app.createGroup("a");
        assertEquals(group.size(), 3);
    }

    @Test
    public void givenUsernameIsInGroup() throws Exception {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App app = new App(names);
        String name = "a";
        List<String> group = app.createGroup(name);
        assertEquals(group.contains(name), true);
    }

    @Test
    public void groupsHaveConsistentMembership() throws Exception {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App app = new App(names);
        List<String> actualA = app.createGroup("a");
        List<String> actualB = app.createGroup("b");
        List<String> actualC = app.createGroup("c");
        List<String> expected = new ArrayList<String>();
        expected.add("a");
        expected.add("b");
        expected.add("c");
        assertEquals(actualA, expected);
        assertEquals(actualB, expected);
        assertEquals(actualC, expected);
    }

    @Test
    public void createSubgroups() {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App app = new App(names);
        ArrayList<ArrayList<String>> groups = app.createSubgroups();
        assertEquals(groups.size(), 2);
        assertEquals(groups.get(0).size(), 3);
    }

    @Test
    public void findGroup() {
        List<String> names = new ArrayList<String>();
        names.add("a");
        names.add("b");
        names.add("c");
        names.add("d");
        names.add("e");
        names.add("f");
        App app = new App(names);
        ArrayList<ArrayList<String>> groups = app.createSubgroups();
        String name = "a";
        ArrayList<String> group = app.findGroup(groups, name);
        assertEquals(group.contains(name), true);
    }


}
