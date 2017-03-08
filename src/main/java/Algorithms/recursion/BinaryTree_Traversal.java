package Algorithms.recursion;

//Java program for different tree traversals

/* Class containing left and right child of current
Nodex and key value*/
class Nodex
{
 int key;
 Nodex left, right;

 public Nodex(int item)
 {
     key = item;
     left = right = null;
 }
}

class BinaryTree_Traversal
{
 // Root of Binary Tree
 Nodex root;

 BinaryTree_Traversal()
 {
     root = null;
 }

 /* Given a binary tree, print its Nodexs according to the
   "bottom-up" postorder traversal. */
 void printPostorder(Nodex Nodex)
 {
     if (Nodex == null)
         return;

     // first recur on left subtree
     printPostorder(Nodex.left);

     // then recur on right subtree
     printPostorder(Nodex.right);

     // now deal with the Nodex
     System.out.print(Nodex.key + " ");
 }

 /* Given a binary tree, print its Nodexs in inorder*/
 void printInorder(Nodex Nodex)
 {
     if (Nodex == null)
         return;

     /* first recur on left child */
     printInorder(Nodex.left);

     /* then print the data of Nodex */
     System.out.print(Nodex.key + " ");

     /* now recur on right child */
     printInorder(Nodex.right);
 }

 /* Given a binary tree, print its Nodexs in preorder*/
 void printPreorder(Nodex Nodex)
 {
     if (Nodex == null)
         return;

     /* first print data of Nodex */
     System.out.print(Nodex.key + " ");

     /* then recur on left sutree */
     printPreorder(Nodex.left);

     /* now recur on right subtree */
     printPreorder(Nodex.right);
 }

 // Wrappers over above recursive functions
 void printPostorder()  {     printPostorder(root);  }
 void printInorder()    {     printInorder(root);   }
 void printPreorder()   {     printPreorder(root);  }

 // Driver method
 public static void main(String[] args)
 {
     BinaryTree_Traversal tree = new BinaryTree_Traversal();
     tree.root = new Nodex(1);
     tree.root.left = new Nodex(2);
     tree.root.right = new Nodex(3);
     tree.root.left.left = new Nodex(4);
     tree.root.left.right = new Nodex(5);

     System.out.println("Preorder traversal of binary tree is ");
     tree.printPreorder();

     System.out.println("\nInorder traversal of binary tree is ");
     tree.printInorder();

     System.out.println("\nPostorder traversal of binary tree is ");
     tree.printPostorder();
 }
}