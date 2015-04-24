import java.util.*;
public class TreeNode<E>{
    private TreeNode<E> prev;
    private TreeNode<E> left, right;
    private E data;

    public TreeNode(E element){
	this(element,null);
    }

    public TreeNode(E element, TreeNode<E> prev){
	this.prev=prev;
	data=element;
	left=null;
	right=null;
    }

  

    public TreeNode<E> getRandChild(){
	Random rand=new Random();
	int rng=rand.nextInt(1);
	if (rng==0){
	    return left;
	}
	return right;
    }

    public void setData(E data){
	this.data=data;
    }

    public void setLeft(TreeNode<E> t){
	left=t;
    }

    public void setRight(TreeNode<E> t){
	right=t;
    }

    public E getData(){
	return data;
    }

    public TreeNode<E> getPrev(){
	return prev;
    }

    public TreeNode<E> getLeft(){
	return left;
    }

    public TreeNode<E> getRight(){
	return right;
    }
}
