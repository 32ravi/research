package Algorithms.recursion;

//Recursive Java program for level order traversal of Binary Tree

/*
 * http://www.geeksforgeeks.org/level-order-tree-traversal/
 * 
 *  Class containing left and right child of current 
Node_ and key value*/
class Node_
{
 int data;
 Node_ left, right;
 public Node_(int item)
 {
     data = item;
     left = right = null;
 }
}

class BinaryTree_LevelTraversal
{
 // Root of the Binary Tree
 Node_ root;

 public BinaryTree_LevelTraversal()
 {
     root = null;
 }

 /* function to print level order traversal of tree*/
 void printLevelOrder()
 {
     int h = height(root);
     int i;
     for (i=1; i<=h; i++)
         printGivenLevel(root, i);
 }

 /* Compute the "height" of a tree -- the number of
 Node_s along the longest path from the root Node_
 down to the farthest leaf Node_.*/
 int height(Node_ root)
 {
     if (root == null)
        return 0;
     else
     {
         /* compute  height of each subtree */
         int lheight = height(root.left);
         int rheight = height(root.right);
          
         /* use the larger one */
         if (lheight > rheight)
             return(lheight+1);
         else return(rheight+1); 
     }
 }

 /* Print Node_s at the given level */
 void printGivenLevel (Node_ root ,int level)
 {
     if (root == null)
         return;
     if (level == 1)
         System.out.print(root.data + " ");
     else if (level > 1)
     {
         printGivenLevel(root.left, level-1);
         printGivenLevel(root.right, level-1);
     }
 }
  
 /* Driver program to test above functions */
 public static void main(String args[])
 {
    BinaryTree_LevelTraversal tree = new BinaryTree_LevelTraversal();
    tree.root= new Node_(1);
    tree.root.left= new Node_(2);
    tree.root.right= new Node_(3);
    tree.root.left.left= new Node_(4);
    tree.root.left.right= new Node_(5);
     
    System.out.println("Level order traversal of binary tree is ");
    tree.printLevelOrder();
 }
}