public class BSTree<E>{
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode<E> root;

    public BTree() {
	root = null;
    }

  
    public void add( E d ) { 
	if (root==null){
	    root=new TreeNode<E>(d);
	}else{
	    add(root,new TreeNode<E>(d,root));
	}
    }

    public void add(TreeNode<E> curr, TreeNode<E> branch){
	
    }

    //VCC
    public void preOrder( TreeNode<E> curr ) {
	if (curr==null){
	    System.out.print("");
	}else{
	    System.out.print(curr.getData());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}

    }


    //CVC
    public void inOrder( TreeNode<E> curr ) {
	if (curr==null){
	    System.out.print("");
	}else{
	    inOrder(curr.getLeft());
	    System.out.print(curr.getData());
	    inOrder(curr.getRight());
	}
    }

    //CCV
    public void postOrder( TreeNode<E> curr ) {
	if (curr==null){
	    System.out.print("");
	}else{
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.print(curr.getData());
	   
	}
    }
}
