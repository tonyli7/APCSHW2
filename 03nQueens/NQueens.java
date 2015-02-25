public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private char[][]board;
    private int[]qPos;
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
		ans=""+ans+board[i][j]+" ";
	    }
	    ans=ans+"\n";
	}

	if (solution){
	    return hide + clear + go(0,0) + ans + "\n" + show;
	}
	return "no solution";
    }

    public NQueens(int size){
	this.size=size;
	board=new char[size][size];
	qPos=new int [size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j]='_';
	    }
	}
	for (int i=0;i<size;i++){
	    qPos[i]=-size-size;
	}
 
    }

    public boolean solve(){
	if (size<4){
	    return false;
	}
	return solve(0);
    }

    public boolean solve(int startx){
	if ((startx==size) || (startx<0)){
	    return false;
	}
	return solve(startx,0);
    }

    public boolean solve(int startx, int starty){


	if (startx==size){
	    solution=true;
	    return true;
	}
	if ((startx<size) && (startx>-1) &&//if within x range
	    (starty<size) && (starty>-1) &&//if within y range 
	    (board[starty][startx]=='_') &&//if empty
	    (noThreat(startx,starty))){//if not threatened

	    board[starty][startx]='Q';
	    qPos[startx]=starty;
	    for (int i=0;i<size;i++){
		if(solve(startx+1,i)){
		    return true;
		  
		}
	
	
	    }
	    board[starty][startx]='_';
	    qPos[startx]=-size-size;
	    if (solve(startx,starty+1)){
		return true;
	    }
	}
	return false;
    }
   
    public boolean noThreat(int x, int y){
	for (int i=0;i<size;i++){
	    if ((abs(i-x) == abs(qPos[i]-y)) || (qPos[i]==y)){
		return false;
	    }
	}
	return true;
    }

    public int abs(int n){
	if (n>=0){
	    return n;
	}
	return n*-1;
    }

    public String name(){
	return "li.tony";
    }

   
}
