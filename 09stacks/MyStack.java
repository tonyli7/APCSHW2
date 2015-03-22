import java.util.*;
public class MyStack<T>{
    LNode<T> end;
    int size;
    MyLinkedList<T> stax;

    public MyStack(){
	this(0);
    }

    public MyStack(int size){
	this.size=size;
	end=0;
    }

    public boolean empty(){
	if (size==0){
	    return true;
	}
	return false;
    }

    public T push(T pancake){
	stax.add(pancake);
	return pancake;
    }

   
}
