public class TreeNode{
    private TreeNode left,right;
    private int data;

    TreeNode(int data){
	this(data,null,null);
    }

    TreeNode(int data, TreeNode left, TreeNode right){
	setData(data);
	setLeft(left);
	setRight(right);
    }
    
    public void setData(int data){
	this.data=data;
    }

    public void setLeft(TreeNode left){
	this.left=left;
    }

    public void setRight(TreeNode right){
	this.right=right;
    }

    public int getData(){
	return data;
    }

    public TreeNode getLeft(){
	return left;
    }

    public TreeNode getRight(){
	return right;
    }

    public boolean hasLeft(){
	return left!=null;
    } 

    public boolean hasRight(){
	return right!=null;
    }
    
    public boolean isLeaf(){
	return !hasLeft() && !hasRight();
    }

    
}
