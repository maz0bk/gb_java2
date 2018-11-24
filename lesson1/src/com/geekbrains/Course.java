package com.geekbrains;

import com.geekbrains.obstacles.Obstacle;
import com.geekbrains.participants.Participant;

public class Course {
    private Obstacle course[];

    public Course(Obstacle[] course) {
        this.course = course;
    }
    public void doIt(Team team){
        for (Participant p : team.getParticipants()){
            for(Obstacle o : course) {
                o.doIt(p);
                if(!p.isActive()) {
                    break;
                }
            }
        }
    }
}
