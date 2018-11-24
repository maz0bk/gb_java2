package com.geekbrains;

import com.geekbrains.participants.*;
import com.geekbrains.obstacles.*;

public class MainClass {
    public static void main(String[] args) {
        Course course = new Course(new Obstacle[]{new Cross(200), new Water(20), new Wall(2), new Cross(500)});
        Team team = new Team("First",new Participant[]{new Human("Billy"), new Cat("Barsik"), new Dog("Bobik"), new Cat("Murka")});
        course.doIt(team);
        team.showResults();
    }
}
