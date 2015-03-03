import java.util.*;
public class ctravel{
    public static int rows,cols,sec;
    public static char grid[][];
    public static boolean solution;
    static int ways=0;
    public static void main(String[]args){
	
	//	try{
	    //	File file = new File("ctravel.in");
	    //	Scanner sc = new Scanner(file);
	    String input = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	    Scanner sc = new Scanner(input);
	    String line1 = sc.nextLine();

	    rows = Integer.parseInt(line1.substring(0, line1.indexOf(" ")));
	    cols = Integer.parseInt(line1.substring(line1.indexOf(" ") + 1, line1.indexOf(" ", line1.indexOf(" ") + 1)));
	    sec=Integer.parseInt(line1.substring(line1.lastIndexOf(" ") + 1));
	
	    grid=new char[rows][cols];
	    String g="";
	    for (int y=0;y<rows;y++){
		String l=sc.nextLine();
		for (int x=0;x<cols;x++){
		    grid[y][x]=l.charAt(x);
		    g+=""+grid[y][x];
		}
		g+="\n";
	    }

	    String lastline = sc.nextLine();

	    int r1 = Integer.parseInt(lastline.substring(0, lastline.indexOf(" "))) - 1;
	    int c1 = Integer.parseInt(lastline.substring(lastline.indexOf(" ") + 1, lastline.indexOf(" ", lastline.indexOf(" ") + 1))) - 1;
	    int r2 = Integer.parseInt(lastline.substring(lastline.indexOf(" ", lastline.indexOf(" ") + 1) + 1, lastline.lastIndexOf(" "))) - 1;
	    int c2 = Integer.parseInt(lastline.substring(lastline.lastIndexOf(" ") + 1)) - 1;
	    solution=false;
	    ctravel.solve(1, 3, 1, 5, 0);
	    System.out.println(g);
	    System.out.print(r1);
	    System.out.println(c1);
	    if (solution){
		System.out.println(ways);
	    }else{
		System.out.println("gg");
	    }
	    //	}catch (Exception e){
	    //	    System.out.println("oops");
	    //	}
    }
   
    public static boolean solve(int y1, int x1, int y2, int x2, int s){
	if ((x1<0) && (x1>=cols) &&
	    (y1<0) && (y1>=rows) &&
	    (grid[y1][x1]=='*') &&
	    (s>sec)){
	    return false;
	}
	if ((x1==x2) && (y1==y2) && (s==sec)){
	    ways++;
	    solution=true;
	    return true;
	}
	if(
	solve(y1+1,x1,y2,x2,s+1)||
	solve(y1-1,x1,y2,x2,s+1)||
	solve(y1,x1+1,y2,x2,s+1)||
	solve(y1,x1-1,y2,x2,s+1)){
	return true;
	}
	return false;
    }
	
}

