package com.geekbrains;

import com.geekbrains.participants.Participant;

public class Team {
    private String teamName;
    private Participant[] participants;

    public Team(String teamName, Participant[] participants) {
        this.teamName = teamName;
        this.participants = participants;
    }

    public Participant[] getParticipants() {
        return participants;
    }

    public void showResults(){
        for( Participant p : participants){
           if (p.isActive()) System.out.println(p.getName() + " successfully finished distance");
        }
    }
    public void showTeam(){
        System.out.println("Team participants:");
        for( Participant p : participants){
            System.out.println(p.getName());
        }
    }
}
