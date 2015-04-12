public class Cors{
    private int x,y;
    private Cors prev;

    public Cors(int xcor,int ycor){
	x=xcor;
	y=ycor;
    }

    public int getX(){
	return x;
    }

    public int getY(){
	return y;
    }

    public void setPrev(Cors c){
	prev=c;
    }

    public Cors getPrev(){
	return prev;
    }
    public String toString(){
	return "( "+x+" , "+y+" )";
    }
}
