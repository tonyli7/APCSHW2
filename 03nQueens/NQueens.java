public class NQueens{
    //constants for the class
    //terminal specific character to clear screen , or hide/show cursor
    final static String clear =  "\033[2J";
    final static String hide =  "\033[?25l";
    final static String show =  "\033[?25h";

    //instance variable
    private int[][]board;
    private int[][]qPos;
    private int[]badRows;
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
	
	//	if (solution){
	return hide + clear + go(0,0) + ans + "\n" + show;
	    //	}
	    //	return "no solution";
    }

    public NQueens(int size){
	this.size=size;
	board=new int[size][size];
	qPos=new int [size][2];
	badRows=new int[size];
	for (int i=0;i<size;i++){
	    for (int j=0;j<size;j++){
		board[i][j]=0;
	    }
	}
	for (int i=0;i<size;i++){
	    qPos[i][0]=-5;
	    qPos[i][1]=-100;
	}
	for (int i=0;i<size;i++){
	    badRows[i]=-5;
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
	System.out.println(this);
	wait(20);

	if (startx==size){
	    solution=true;
	    return true;
	}
	for (int i=0;i<size;i++){
	    if ((startx<size) && (startx>-1) &&//if within x range
		(starty<size) && (starty>-1) &&//if within y range 
		(board[starty][startx]==0) &&//if empty
		(badRows[starty]!=starty) &&//if not in same row
		(safeD(startx,starty))){//if not in diagonal with other queens
		
		board[i][startx]=8;
		qPos[i][0]=startx;
		qPos[i][1]=starty;
		badRows[i]=starty;
		if(solve(startx+1,starty)){
		    return true;
		}
		solve(startx+1,starty);
	    }
	}
	return false;
    }
    /*
    public void fill(int x, int y){
	for (int i=0;i<size;i++){
	    if (board[i][x]!=8){
		board[i][x]=1;
	    }
	}
	for (int j=0;j<size;j++){
	    if (board[y][j]!=8){
		board[y][j]=1;
	    }
	}
	int n=x+1;
	int m=y+1;
	while ((n<size) && (m<size)){
	    board[m][n]=1;
	    n++;
	    m++;
	}
	int h=x+1;
	int k=y-1;
	while ((h<size) && (k>0)){
	    board[k][h]=1;
	    h++;
	    k--;
	}
    }

    public void clear(int x, int y){
	for (int i=0;i<size;i++){
	    board[i][x]=0;
	}
	for (int j=0;j<size;j++){
	    board[y][j]=0;   
	}
	int n=x+1;
	int m=y+1;
	while ((n<size) && (m<size)){
	    board[m][n]=0;
	    n++;
	    m++;
	}
	int h=x+1;
	int k=y-1;
	while ((h<size) && (k>0)){
	    board[k][h]=0;
	    h++;
	    k--;
	}
    }
    */
    public boolean safeD(int x, int y){
	for (int i=0;i<size;i++){
	    if (abs(qPos[i][0]-x) == abs(qPos[i][1]-y)){
		return false;
	    }
	}
	return true;
    }

    public int abs(int n){
	return n*n/n;
    }

   
}
