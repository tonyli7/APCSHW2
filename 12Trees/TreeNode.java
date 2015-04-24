import java.util.*;
public class TreeNode<E>{
    private TreeNode<E> prev;
    private ArrayList<TreeNode<E>> next;
    private E data;

    public TreeNode(E element){
	this(element,null);
    }

    public TreeNode(E element, TreeNode<E> prev){
	this.prev=prev;
	data=element;
	next=new ArrayList<TreeNode<E>>(2);
    }

    public boolean addData(E data){
	if (next.size()==0){
	    return false;
	}
	Random rand=new Random();
	int rng=rand.nextInt(1);
	next.set(rng, new TreeNode<E>(data, this));
	return true;
    }

    public TreeNode<E> getRandChild(){
	Random rand=new Random();
	return next.get(rand.nextInt(1));
    }

    public void setData(E data){
	this.data=data;
    }

    public E getData(){
	return data;
    }

    public TreeNode<E> getPrev(){
	return prev;
    }
}
