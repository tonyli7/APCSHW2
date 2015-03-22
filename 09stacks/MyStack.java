import java.util.*;
public class MyStack<T>{
  
    MyLinkedList<T> stax;

    public MyStack(){
	stax=new MyLinkedList<T>();
    }

  

    public boolean empty(){
	if (stax.size()==0){
	    return true;
	}
	return false;
    }

    public T push(T pancake){
	stax.add(pancake);
	return pancake;
    }

    public T peek(){
	return stax.getEnd();
    }

    public String toString(){
	return stax.toString();
    }

   
}
