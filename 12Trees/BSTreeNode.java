import java.io.*;
import java.util.*;

public class BSTreeNode<T extends Comparable> {

    private int count;
    private T data;
    private BSTreeNode<T> left;
    private BSTreeNode<T> right;

    public BSTreeNode( T d ) {
 
	data = d;
	left = right = null;
	count=1;
    }
    
    //accessors
    public T getData() {
	return data;
    }
    public BSTreeNode<T> getLeft() {
	return left;
    }
    public BSTreeNode<T> getRight() {
	return right;
    }

    //mutators
    public void setData( T d ) {
	data = d;
    }
    public void setLeft( BSTreeNode<T> l ) {
	left = l;
    }
    public void setRight( BSTreeNode<T> r ) {
	right = r;
    }

    public void addCount(){
	count++;
    }

    public int compareTo(T other){
	return this.getData().compareTo(other);
    }
    
    public boolean hasLeft(){
	return left!=null;
    }

    public boolean hasOnlyLeft(){
	return hasLeft() && !hasRight();
    }

    public boolean hasOnlyRight(){
	return !hasLeft() && hasRight();
    }

    public boolean hasRight(){
	return right!=null;
    }

    public boolean isLeaf(){
	return !hasLeft() && !hasRight();
    }

    public boolean hasTwo(){
	return hasLeft() && hasRight();
    }

    public String toString(){
	return ""+getData();
    }

}


