public class Driver{
    public static void main(String[]args){
	Maze m=new Maze("data1.dat");
	if (m.solveBFS(true)){
	    System.out.println(m);
	}
    }
}