public class Maze{
    private char[][]m;

    public Maze(char[][]c){
	m=c;
    }
    public char[][]mazeSolve(char[][]maze){
	int x,y;
	char[][]copy=new char[maze.length][maze[0].length];
	for (int h=0;h<maze.length;h++){
	    for (int l=0;l<maze[0].length;l++){
		copy[h][l]=maze[h][l];
		if (maze[h][l]=='S'){
		    x=l;
		    y=h;
		    if (maze[h+1][l]!='X'){
			copy[h+1][l]='.';
		    }
		    if (maze[h][l+1]!='X'){
			copy[h][l+1]='.';
		    }
		    if (maze[h-1][l]!='X'){
			copy[h-1][l]='.';
		    }
		    if (maze[h][l-1]!='X'){
			copy[h][l-1]='.';
		    }
		}
	    }
	}
	m=copy;
	return copy;
    }

    public String toString(){
	String str="";
	for (int i=0;i<m.length;i++){
	    for (int j=0;j<m[0].length;j++){
		str+=""+m[i][j];
	    }
	    str+="\n";
	}
	return str;
    }
}
