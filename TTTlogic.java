
package ttt;

public class TTTlogic {
    protected char[] board;
    protected char usermarker;
    protected char aiMarker;
    protected char currentmarker;
    protected char winner;
    
    public TTTlogic(char playerToken, char aiMarker){
        this.usermarker = playerToken;
        this.aiMarker = aiMarker;
        this.winner = '-';
        this.board = setboard();
        this.currentmarker = usermarker;
    }
    public static char[] setboard(){
        char[] board = new char[9];
        for(int i=0; i<board.length;i++){
            board[i]='-';
        }
        return board;
    }
    public boolean playturn(int spot){
        boolean isvalid = withinRange(spot)&& !isSpotTaken(spot);
        if(isvalid){
            board[spot-1] = currentmarker;
            currentmarker = (currentmarker == usermarker) ? aiMarker : usermarker;
        }
        return isvalid;
    }
    public boolean withinRange(int number){
        return number>0 && number<board.length+1 ;
    }
    public boolean isSpotTaken(int number){
        return board[number - 1] != '-';
    }
    
    public void printboard(){
        System.out.println();
        for(int i =0; i<board.length;i++){
            if(i%3==0 && i!=0){
                System.out.println();
                System.out.println("--------------");
            }
            System.out.println(" | " + board[i]);
        }
        System.out.println();
    }
    public static void printIndexBoard(){
        System.out.println();
        for(int i =0; i<9;i++){
            if(i%3==0 && i!=0){
                System.out.println();
                System.out.println("--------------");
            }
            System.out.println(" | " + (i+1));
        }
        System.out.println();
    }
    
    public boolean isthereAwinner(){
        boolean diagonalsandmiddle = (rightdi() || leftdi() || secondcol() ||  middlerow()) && board[4]!='-';
        boolean topandfirst = (firstcol() || toprow()) && board[0] != '-';              
        boolean bottomandthird = (bottomrow() || thirdcol()) && board[8] !='-';
        if(diagonalsandmiddle){
            this.winner = board[4];
        }else if(topandfirst){
            this.winner = board[0];
        }else if(bottomandthird){
            this.winner = board[8];
        }
        return diagonalsandmiddle || topandfirst ||bottomandthird;
        
    }
    public boolean toprow(){
        return board[0]==board[1] && board[1]==board[2];
    }
    public boolean middlerow(){
        return board[3]==board[4] && board[4]==board[5];
    }
    public boolean bottomrow(){
        return board[6]==board[7] && board[7]==board[8];
    }
    public boolean firstcol(){
        return board[0]==board[3] && board[3]==board[6];
    }
    public boolean secondcol(){
        return board[1]==board[4] && board[4]==board[7];
    }
    public boolean thirdcol(){
        return board[2]==board[5] && board[5]==board[8];
    }
    public boolean rightdi(){
        return board[0]==board[4] && board[4]==board[8];
    }
    public boolean leftdi(){
        return board[2]==board[4] && board[4]==board[6];
    }
    
    public boolean istheboardfilled(){
        for(int i=0; i<board.length; i++){
            if(board[i] == '-'){
                return false;
            }
        }
        return true;            
    }
     
    public String gameOver(){
        boolean didsomeonewin = isthereAwinner();
        if(didsomeonewin){
            return "We have a winner and the winner is " + this.winner + "'s";
        }else if(istheboardfilled()){
            return "Draw, GAME OVER...!!!";
        }else{
            return "notOver";
        }
    }

}
