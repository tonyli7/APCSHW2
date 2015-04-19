import java.util.*;
import java.io.*;

public class Maze{
    private char[][]maze;
   
    private int maxx,maxy;
    private int startx,starty;
    private MyDEQ<Cors> frontier;
    private ArrayList<Integer> solutions;
    //Terminal keycodes to clear the terminal, or hide/show the cursor
    private String clear =  "\033[2J";
    private String hide =  "\033[?25l";
    private String show =  "\033[?25h";

    public Maze(String filename){
	startx = -1;
	starty = -1;
	//read the whole maze into a single string first
	String ans = "";
	try{
	    Scanner in = new Scanner(new File(filename));

	    //keep reading next line
	    while(in.hasNext()){
		String line = in.nextLine();
		if(maxy == 0){
		    //calculate width of the maze
		    maxx = line.length();
		}
		//every new line add 1 to the height of the maze
		maxy++;
		ans += line;
	    }
	}
	catch(Exception e){
	    System.out.println("File: " + filename + " could not be opened.");
	    e.printStackTrace();
	    System.exit(0);
	}

	//copy from the single string to a 2D array
	maze = new char[maxx][maxy];
	for(int i = 0; i < ans.length(); i++){
	    char c = ans.charAt(i);
	    maze[i % maxx][i / maxx] = c;
	    if(c == 'S'){
		startx = i % maxx;
		starty = i / maxx;
	    }
	}

	frontier=new MyDEQ<Cors>();
	solutions=new ArrayList<Integer>(2);
    }

    public void wait(int millis){
	try {
	    Thread.sleep(millis);
	}
	catch (InterruptedException e) {
	}
    }

    public void clearTerminal(){
	System.out.println(clear);
    }

    private String color(int foreground,int background){
	return ("\033[0;" + foreground + ";" + background + "m");
    }

    private String go(int x,int y){
	return ("\033[" + x + ";" + y + "H");
    }

    public String toString(){
	String ans = "Solving a maze that is " + maxx + " by " + maxy + "\n";
	for(int i = 0; i < maxx * maxy; i++){
	    if(i % maxx == 0 && i != 0){
		ans += "\n";
	    }
	    char c =  maze[i % maxx][i / maxx];
	    if(c == '#'){
		ans += color(38,47)+c;
	    }else{
		ans += color(32,40)+c;
	    }
	}
	return hide + go(0,0) + ans + "\n" + show + color(37,40);
    }

    public String toString(boolean animate){
	if (animate){
	    return toString();
	}
	return "NO!";
    }

    public boolean solve(boolean animate,int method){
	frontier.addFirst(new Cors(startx,starty));
	
	while(frontier.size()!=0){
	    
	    if (animate){
		wait(20);
		clearTerminal();
		System.out.println(this.toString(true));
	    }

	   
	    System.out.println(frontier);
	    Cors removed;
	    removed=frontier.remove(method);
	    int currX=removed.getX();
	    int currY=removed.getY();
	    int next[][]={
		{currX+1,currY},
		{currX-1,currY},
		{currX,currY+1},
		{currX,currY-1}
	    };

	    for (int[] cor: next){
		if (maze[cor[0]][cor[1]]=='E'){
		    Cors yay=new Cors(cor[0],cor[1]);
		    yay.setPrev(removed);
		    solutions.add(yay.getX());
		    solutions.add(yay.getY());
		    yay=yay.getPrev();
		    while (yay!=null){
			maze[yay.getX()][yay.getY()]='X';
			solutions.add(yay.getX());
			solutions.add(yay.getY());
			yay=yay.getPrev();
		    }
		    return true;
		}
		if (maze[cor[0]][cor[1]]==' '){
		    frontier.customAdd(new Cors(cor[0],cor[1]),method,1);
		    frontier.getLast().setPrev(removed);
		    maze[currX][currY]='.';
		}
	    }
	   
	}
	return false;
    }

    public boolean solveBFS(boolean animate){
	return solve(animate,0);

    }

    public boolean solveDFS(boolean animate){
	return solve(animate,1);

    }
    
    //public solveBest(boolean animate){}
    //public solveAStar(boolean animate{}

    public int[] solutionCoordinates(){
	int[] set=new int[solutions.size()];
	int n=0;
	for (int i=solutions.size()-1;i>=0;i--){
	    set[n]=solutions.get(i);
	    n++;
	}
	return set;
    }
    
    
   
   

    public boolean solveBFS(){
	return solveBFS(false);
    }

    public boolean solveDFS(){
	return solveDFS(false);
    }

   
    
    public String name(){
	return "li.tony";
    }

}
