
package ttt;

import java.util.Scanner;


public class TTT {

 
    public static void main(String[] args) {
  Scanner sc = new Scanner(System.in);
        boolean doyouwanttoplay = true;
        while(doyouwanttoplay){
            System.out.println("WELCOME TO TIC TAC TOE");
            System.out.println();
            System.out.println("Choose the single character that will represent you on the board");
            char playertoken = sc.next().charAt(0);
            System.out.println("Choose the single character that will represent your opponent on board");
            char opponenttoken = sc.next().charAt(0);
            TTTlogic game = new TTTlogic(playertoken, opponenttoken);
            Aiplayer ai = new Aiplayer();
            
            System.out.println("Now we can start the game");
            TTTlogic.printIndexBoard();
            System.out.println();
            
            while(game.gameOver().equals("notOver")){
                if(game.currentmarker == game.usermarker){
                    System.out.println("Its ur turn..!! Enter a spot for your token");
                    int spot = sc.nextInt();
                    while(!game.playturn(spot)){
                        System.out.println("Try Again..!!" + spot + "was invalid spot");
                        spot = sc.nextInt();
                    }
                    System.out.println("You picked " + spot + "!");
                }else{
                    System.out.println("It's my turn..!!");
                    int AiSpot = ai.pickspot(game);
                    game.playturn(AiSpot);
                    System.out.println("I picked" + AiSpot + "!");
                    
                }
                System.out.println();
                game.printboard();
            }
            System.out.println(game.gameOver());
            System.out.println();
            System.out.println("Do you want to play again? Enter Y if you do."
            + "Enter anything else if you want to quit");
            char response = sc.next().charAt(0);
            doyouwanttoplay = (response == 'Y');
            System.out.println();
            System.out.println();
        }
    }
    
}
