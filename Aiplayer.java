/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ttt;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Shubham Pathak
 */
public class Aiplayer {
    
     public int pickspot(TTTlogic game){
        ArrayList<Integer> choices = new ArrayList<>();
        for(int i=0;i<9;i++){
            if(game.board[i] == '-'){
                choices.add(i+1);
            }
        }
        Random rand = new Random();
        int choice = choices.get(Math.abs(rand.nextInt() % choices.size()));
        return choice;
    }
}
