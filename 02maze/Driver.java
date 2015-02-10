public class Driver{
    public static void main(String[]args){
	
	char[][]zz={{'X','X','X','X'},
		    {'X','S',' ',' '},
		    {'X','X','X',' '},
		    {' ',' ',' ',' '}};

	Maze m=new Maze(zz);
	System.out.println(m.mazeSolve(zz));
	System.out.println(m);
    }
}
