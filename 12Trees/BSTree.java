import java.io.*;
import java.util.*;

public class BSTree <T extends Comparable> {
    
    private BSTreeNode<T> root;

    public BSTree() {
	root = null;
    }

    public boolean isEmpty() {
	return root == null;
    }
    public boolean isLeaf( BSTreeNode<T> t ) {
	return (t.getLeft() == null && t.getRight() == null);
    }

    /*======== public void add() ==========
      Inputs:   T c  
      Returns: 

      Wrapper for the recursive add method
      ====================*/
    public void add( T c ) {
	root = add( root, new BSTreeNode<T>(c) );
    }

    /*======== public BSTreeNode<T> add() ==========
      Inputs:  BSTreeNode<T> curr
               BSTreeNode<T> t 
      Returns: 

      Add t to the correct place in the tree rooted at curr.
      ====================*/
    private BSTreeNode<T> add(BSTreeNode<T> curr, BSTreeNode<T> t) {
	if (curr==null){
	    return t;
	}else if (curr.compareTo(t.getData())>0){
	    curr.setLeft(add(curr.getLeft(),t));
	   
	}else if (curr.compareTo(t.getData())<0){
	    curr.setRight(add(curr.getRight(),t));
	 
	}
	return curr;
    }

    /*======== public void remove() ==========
      Inputs:   T c  
      Returns: 
      
      Wrapper for the recursive remove method
      ====================*/
    public void remove( T c ) {
	root = remove( root, c );
    }

    /*======== public BSTreeNode<T> remove() ==========
      Inputs:   BSTreeNode<T> curr
		T c
      Returns: 

      Should remove the value c from the tree rooted at
      curr, if it exists.
      ====================*/
    private BSTreeNode<T> remove( BSTreeNode<T> curr, T c ) {
	if (curr==null){
	    return curr;
	}
	if (curr.isLeaf() && curr.compareTo(c)==0){
	    return null;
	}
	if (curr.compareTo(c)>0){//go left
	    curr.setLeft(remove(curr.getLeft(),c));
	}else if (curr.compareTo(c)<0){//go right
	    curr.setRight(remove(curr.getRight(),c));
	}else{
	    //when it's equal store the data of the closest element to the current
	    curr.setData(getClosest(curr.getRight()).getData());
	    curr.setRight(remove(curr.getRight(),curr.getData()));
	}
	return curr;
    }
    private BSTreeNode<T> getClosest(BSTreeNode<T> curr){//gets closest from the right side
	if (curr==null){
	    return null;
	}
	if (!curr.hasLeft()){
	    return curr;
	}
	return getClosest(curr.getLeft());
    }

   
    public void test(){
	System.out.println(getClosest(root));
    }


    /*======== public void inOrder()) ==========
      Inputs:   
      Returns: 

      Wrapper for the recursive inOrder method
      ====================*/
    public void inOrder() {
	inOrderHelper( root );
	System.out.println();
    }

    /*======== public void inOrderHelper() ==========
      Inputs:   BSTreeNode<T> t  
      Returns: 
      
      Performs an in-order traversal for the tree with 
      root t.
      ====================*/
    public void inOrderHelper( BSTreeNode<T> t ) {
	if (t == null) {
	    return;
	}
	inOrderHelper( t.getLeft() );
	System.out.print( t.getData() + " ");
	inOrderHelper( t.getRight() );
    }

    public int getHeight(){
	return getHeight(root);
    }

    private int getHeight(BSTreeNode<T> r){
	if(r == null){
	    return 0;
	}else{
	    //System.out.println("recursion height");
	    return 1 + Math.max(getHeight(r.getLeft()),
				getHeight(r.getRight()));
	}
    }

    //Stolen toString()+toString() helpers from Dennis Yatunin
    private int maxLength() {
	// returns the minimum number of characters required
	// to print the data from any node in the tree
	if (root == null)
	    return 0;
	return maxLength(root);
    }

    private int maxLength(BSTreeNode<T> curr) {
	int max = curr.toString().length();
	int temp;
	if (curr.getLeft() != null) {
	    temp = maxLength(curr.getLeft());
	    if (temp > max)
		max = temp;
	}
	if (curr.getRight() != null) {
	    temp = maxLength(curr.getRight());
	    if (temp > max)
		max = temp;
	}
	return max;
    }

    private String spaces(double n) {
	// returns a String of n spaces
	String result = "";
	for (int i = 0; i < n; i++)
	    result += " ";
	return result;
    }

    /*
      getLevel will produce a String for each level of the tree.
      The resulting Strings will look like this:

      ._______________________________
      ._______________._______________
      ._______._______._______._______
      .___.___.___.___.___.___.___.___
      ._._._._._._._._._._._._._._._._

      toString will combine those Strings and provide an output that
      will look like this:

      _______________.
      _______._______________.
      ___._______._______._______.
      _.___.___.___.___.___.___.___.
      ._._._._._._._._._._._._._._._.
      In these diagrams, each dot represents wordLength characters,
      each underscore represents wordLength spaces, and, for any nodes
      that are null, the dots will be "replaced" by underscores.
    */

    private String getLevel(BSTreeNode<T> curr, int currLevel, int targetLevel, int height, int wordLength) {
	if (currLevel == 1){
	    return curr.toString() + 

		spaces(wordLength - curr.toString().length()) +
		spaces(wordLength * 

		       Math.pow(2, height - targetLevel + 1) - 

		       wordLength);
	}
	String result = "";
	if (curr.getLeft() != null){
	    result += getLevel(curr.getLeft(), currLevel - 1, targetLevel, height, wordLength);
	}else{
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	if (curr.getRight() != null){
	    result += getLevel(curr.getRight(), currLevel - 1, targetLevel, height, wordLength);
	}else{ 
	    result += spaces(wordLength * Math.pow(2, height - targetLevel + currLevel - 1));
	}
	return result;
    }
		
    public String toString() {
	if (root == null)
	    return "";
	String result = "";
	int height = getHeight();
	int wordLength = maxLength();
	// add the every level of the tree except the last one
	for (int level = 1; level < height; level++){
	    // remove extra spaces from the end of each level's String to prevent lines from
	    // getting unnecessarily long and add spaces to the front of each level's String
	    // to keep everything centered
	    result += spaces(wordLength * Math.pow(2, height - level) - wordLength) +
		getLevel(root, level, level, height, wordLength).replaceFirst("\\s+$", "") +
		"\n";
	}
	// now add the last level (level = height)
	result += getLevel(root, height, height, height, wordLength).replaceFirst("\\s+$", "");
				
	return result;
    }
   
    public static void main( String[] args ) {
	BSTree<Integer> t = new BSTree<Integer>();
	BSTree<Integer> x = new BSTree<Integer>();

	for ( int i=7; i < 20; i+=7 ) {
	    t.add( i );
	}

	for ( int i=2; i < 10; i+=2){
	    t.add( i );
	    x.add(i);
	}
	t.add(1);
	//	t.remove(2);
	System.out.println(t);
	x.remove(4);
	System.out.println(x);
	t.test();
	x.inOrder();
    }

    public String name(){
	System.out.println("li.tony");
    }
}
