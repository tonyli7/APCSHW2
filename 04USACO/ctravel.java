import java.util.*;
public class ctravel{
    public static int rows,cols,sec;
    public static char grid[][];
    public static void main(String[]args){
	try{
	    //	File file = new File("ctravel.in");
	    //	Scanner sc = new Scanner(file);
	    String input = "4 5 6\n...*.\n...*.\n.....\n.....\n1 3 1 5";
	    Scanner sc = new Scanner(input);
	    String line1 = sc.nextLine();

	    rows = Integer.parseInt(line1.substring(0, line1.indexOf(" ")));
	    cols = Integer.parseInt(line1.substring(line1.indexOf(" ") + 1, line1.indexOf(" ", line1.indexOf(" ") + 1)));
	    sec=Integer.parseInt(line1.substring(line1.lastIndexOf(" ") + 1));
	
	    grid=new char[rows][cols];

	    for (int y=0;y<rows;y++){
		String l=sc.nextLine();
		for (int x=0;y<cols;x++){
		    grid[y][x]=l.charAt(x);
		}
	    }

	    String lastline = sc.nextLine();

	    int r1 = Integer.parseInt(lastline.substring(0, lastline.indexOf(" "))) - 1;
	    int c1 = Integer.parseInt(lastline.substring(lastline.indexOf(" ") + 1, lastline.indexOf(" ", lastline.indexOf(" ") + 1))) - 1;
	    int r2 = Integer.parseInt(lastline.substring(lastline.indexOf(" ", lastline.indexOf(" ") + 1) + 1, lastline.lastIndexOf(" "))) - 1;
	    int c2 = Integer.parseInt(lastline.substring(lastline.lastIndexOf(" ") + 1)) - 1;
	  
	    ctravel.solve(r1, c1, r2, c2, sec);
	    
	    System.out.println(ways);
	}catch (Exception e){
	    System.out.println("oops");
	}
    }
    static int ways=0;
    public static boolean solve(int x1, int y1, int x2, int y2, int s){
	if ((x1==x2) && (y1==y2) && (s==sec)){
	    ways++;
	    return true;
	}
	if ((x1>=0) && (x1<cols) &&
	    (y1>=0) && (y1<rows) &&
	    (grid[y1][x1]!='*') &&
	    (s<sec)){
		
	    solve(x1+1,y1,x2,y2,s+1);
	    solve(x1-1,y1,x2,y2,s+1);
	    solve(x1,y1+1,x2,y2,s+1);
	    solve(x1,y1-1,x2,y2,s+1);
	    return false;
	}
	return false;
    }
	
}

