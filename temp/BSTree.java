public class BSTree{
    public static final int PRE_ORDER = 0;
    public static final int IN_ORDER = 1;
    public static final int POST_ORDER = 2;

    private TreeNode root;

    public BSTree() {
	root = null;
    }

  
    public void add( int d ) { 
	if (root==null){
	    root=new TreeNode(d);
	}else{
	    add(root,new TreeNode(d));
	}
    }

    public void add(TreeNode curr, TreeNode branch){
	if (isBigger(branch, curr) && !curr.hasRight()){
	    curr.setRight(branch);
	}else if (!isBigger(branch, curr) && !curr.hasLeft()){
	    curr.setLeft(branch);
	}else{
	    if (isBigger(branch,curr)){
		add(curr.getRight(), branch);
	    }else{
		add(curr.getLeft(), branch);
	    }
	}
    }

    public boolean isBigger(TreeNode branch, TreeNode curr){
	return branch.getData()>curr.getData();
    }


     public void traverse( int mode) {
	if ( mode == PRE_ORDER )
	    preOrder( root );
	else if ( mode == IN_ORDER )
	    inOrder( root );
	else
	    postOrder( root );
	System.out.println();
    }

    //VCC
    public void preOrder( TreeNode curr ) {
	if (curr==null){
	    System.out.print("");
	}else{
	    System.out.print(curr.getData());
	    preOrder(curr.getLeft());
	    preOrder(curr.getRight());
	}

    }


    //CVC
    public void inOrder( TreeNode curr ) {
	if (curr==null){
	    System.out.print("");
	}else{
	    inOrder(curr.getLeft());
	    System.out.print(curr.getData());
	    inOrder(curr.getRight());
	}
    }

    //CCV
    public void postOrder( TreeNode curr ) {
	if (curr==null){
	    System.out.print("");
	}else{
	    postOrder(curr.getLeft());
	    postOrder(curr.getRight());
	    System.out.print(curr.getData());
	   
	}
    }

    public static void main( String[] args ) {

	BSTree t = new BSTree();

	for ( int i=0; i < 7; i++ ) {
	   
	    t.add( i );
	   
	}
	
	//	System.out.println( "Pre-order: ");
	//	t.traverse( PRE_ORDER );

	System.out.println( "In-order: ");
	t.traverse( IN_ORDER );
		
	System.out.println( "Post-order: ");
	//	t.traverse( POST_ORDER );
	//	System.out.println( "Height: " + t.getHeight() );
	
	//	System.out.println( t );
    }
}
