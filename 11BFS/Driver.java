public class Driver{
    public static void main(String[]args){
	/*
	Maze m=new Maze("data1.dat");
	//	System.out.println(m);
	if (m.solveBFS(true)){
	    System.out.println(m);
	}
	*/
	MyDEQ<Integer>d=new MyDEQ<Integer>();
	d.addFirst(1);
	d.addFirst(2);
	System.out.println(d);
    }
}
