import java.util.*;
import java.io.*;


public class KnightsTour{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;
    private int maxx,maxy;

    //terminal specific character to move the cursor
    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }
 
    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public String toString(){
	String ans = "\n";
	for (int i=0;i<board.length;i++){
	    for (int j=0;j<board[0].length;j++){
		ans+=board[i][j];
	    }
	    ans+="\n";
	}
	//build your knights tour here...
	return hide + go(0,0) + ans + "\n" + show;
    }

    public KnightsTour(){
	maxx=board[0].length;
	maxy=board.length;
    }

    public KnightsTour(int size){
				
    }

    
    public void solve(){
	return solve(0,0);
    }

    public void solve(int startx, int starty){

    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	System.out.println(this);
	wait(20);

	if (isFull()){
	    return true;
	}
	if (((x<maxx) && (x>-1)) || ((y<maxy) (y>-1)) && (board[y][x]==-1)){
	    board[y][x]=currentMoveNumber;
	    if (solve(x+1,y-2,currentMoveNumber+1)||
		solve(x-1,y-2,currentMoveNumber+1)||
		solve(x+2,y+1,currentMoveNumber+1)||
		solve(x+2,y-1,currentMoveNumber+1)||
		solve(x+1,y+2,currentMoveNumber+1)||
		solve(x-1,y+2,currentMoveNumber+1)||
		solve(x-2,y+1,currentMoveNumber+1)||
		solve(x-2,y-1,currentMoveNumber+1)||){
		return true;
	    }
	}
	return false;
    }

    public boolean isFull(){
	for (int i=0;i<maxy;i++){
	    for (int j=0;j<maxx;j++){
		if (board[i][j]==-1){
		    return false;
		}
	    }
	}
	return true;
    }


}