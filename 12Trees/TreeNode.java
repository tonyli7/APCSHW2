public class TreeNode<E>{
    private TreeNode<E> prev;
    private E data;

    public TreeNode(){
	this(null,null);
    }

    public TreeNode(E element, TreeNode<E> prev){
	this.prev=prev;
	data=element;
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