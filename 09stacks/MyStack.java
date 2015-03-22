import java.util.*;
public class MyStack{
    private ArrayList<String> stax;
    
    public MyStack(){
	stax=new ArrayList<String>();
    }
    public String toString(){
	String list="[";
	for (String e:stax){
	    list+=e+" , ";
	}
	return list.substring(0,list.length()-2)+"]";
    }

    public boolean empty(){
	return stax.size()==0;
    }
    public String pop(){
	if (!empty()){
	    String popped=stax.get(stax.size()-1);
	    stax.remove(stax.size()-1);
	    return popped;
	}
	throw new EmptyStackException();
    }

    public String push(String pancake){
	stax.add(pancake);
	return pancake;
    }

    public String peek(){
	if (!empty()){
	    return stax.get(stax.size()-1);
	}
	throw new EmptyStackException();
    }
    
    
}
