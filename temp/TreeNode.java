public class TreeNode<E>{
    private TreeNode<E> left,right;
    private E data;

    TreeNode(E data){
	this(data,null,null);
    }

    TreeNode(E data, TreeNode<E> left, TreeNode<E> right){
	setData(data);
	setLeft(left);
	setRight(right);
    }
    
    public void setData(E data){
	this.data=data;
    }

    public void setLeft(TreeNode<E> left){
	this.left=left;
    }

    public void setRight(TreeNode<E> right){
	this.right=right;
    }

    public E getData(){
	return data;
    }
}
