package com.company;

import java.lang.reflect.Array;

/**
 * Created by imusiievych on 5/5/15.
 */
public class Competition
{
    String[] players = {"David", "Dan", "Ann", "Inna", "Vlad"};


    public void makeCompetiotion(String[] some_pl){
        int playersnumber =some_pl.length;

        int counter = 0;

        while(counter<playersnumber){

            String thePlayer = some_pl[counter];
            counter++;
            if(thePlayer.equals("Inna")){
                continue;
            }

            System.out.println("This player is on the list: " + thePlayer);

        }
    }

    public static void main(String[] args){

        Competition comp1 = new Competition();


        comp1.makeCompetiotion(comp1.players);

    }

}
