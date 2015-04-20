public class Driver{
    public static void main(String[]args){
	/*
	MyDEQ<String>d=new MyDEQ<String>();
	d.add("first",2);
	d.add("third",3);
	d.add("second",1);
	System.out.println(d.priorityList());
	System.out.println(d);
	System.out.println(d.removeSmallest());
	System.out.println(d.priorityList());
	System.out.println(d);
	System.out.println(d.removeSmallest());
	System.out.println(d.priorityList());
	System.out.println(d);
	//	System.out.println(d.removeSmallest());
	*/
	Maze m=new Maze("data1.dat");

	//	System.out.println(m);
	if (m.solveBest(true)){
	    System.out.println(m);
	}
	String s="[ ";
	for (int i=0;i<m.solutionCoordinates().length;i++){
	    if (i%2==0){
		s+="( ";
		s+=m.solutionCoordinates()[i]+",";
	    }else{

		s+=m.solutionCoordinates()[i];
		if (i%2==1){
		    s+=" ),";
		}
	    }
	}
	System.out.println(s+" ]");
	
    }
}
