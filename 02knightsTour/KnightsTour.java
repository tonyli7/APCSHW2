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
    private int size;
    private boolean solution;

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
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		ans+=board[i][j]+" ";
	    }
	    ans+="\n";
	}
	//build your knights tour here...
	if (solution){
	    return hide + clear + go(0,0) + ans + "\n" + show;
	}
	return "no solution";
    }

   

    public KnightsTour(int size){
	this.size=size;
	board=new int[size][size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j]=0;
	    }
	}
    }

    
    public boolean solve(){
	if (size<5){
	    return false;
	}
	return solve(0,0);
    }

    public boolean solve(int startx, int starty){
	if (isFull()){
	    return true;
	}
	return solve(startx,starty,1);
    }


		
    public boolean solve(int x,int y,int currentMoveNumber){
	//	System.out.println(this);
	//	wait(20);

	if (isFull()){
	    solution=true;
	    return true;
	}
	if ((((x<size) && (x>-1)) && ((y<size) && (y>-1))) && (board[y][x]==0)){
	    board[y][x]=currentMoveNumber;
	    if (solve(x+1,y-2,currentMoveNumber+1)||
		solve(x-1,y-2,currentMoveNumber+1)||
		solve(x+2,y+1,currentMoveNumber+1)||
		solve(x+2,y-1,currentMoveNumber+1)||
		solve(x+1,y+2,currentMoveNumber+1)||
		solve(x-1,y+2,currentMoveNumber+1)||
		solve(x-2,y+1,currentMoveNumber+1)||
		solve(x-2,y-1,currentMoveNumber+1)){
		return true;
	    }
	    board[y][x]=0;
	}
	
	return false;
    }

    public boolean isFull(){
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		if (board[i][j]==0){
		    return false;
		}
	    }
	}
	return true;
    }

    public String name(){
	return "li.tony";
    }


}
