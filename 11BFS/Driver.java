public class Driver{
    public static void main(String[]args){
	
	Maze m=new Maze("data1.dat");
	//	System.out.println(m);
	if (m.solveBFS(true)){
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
	System.out.println(s);
    }
}
