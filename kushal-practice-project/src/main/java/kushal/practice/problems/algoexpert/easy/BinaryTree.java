package kushal.practice.problems.algoexpert.easy;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree
{
    public static class BT
    {
        public int value;

        public BT left;

        public BT right;

        public BT(int value)
        {
            this.value = value;
        }
    }

    /** O(logn) time worst is 0(n) for one side leaning tree | O(1) space*/
    public static int findClosestValueInBst(BT tree, int target)
    {
        int closest = tree.value;
        while(tree != null)
        {
            if( Math.abs(target - closest) > Math.abs(tree.value - target))
            {
                closest = tree.value;
            }
            if( target < tree.value)
            {
                tree = tree.left;
            }
            if( target > tree.value)
            {
                tree = tree.right;
            }
            else
            {
                break;
            }
        }
        return closest;
    }

    /** O(n) time | O(n) space*/
    public static List<Integer> branchSums(BT root) 
    {
        final List<Integer> branchSums = new ArrayList<Integer>();
        branchSums(root, 0, branchSums);
        return branchSums;
    }

    private static void branchSums(BT node, int sum, List<Integer> branchSums)
    {
        if(node == null)
        {
            return;
        }
        
        sum = sum + node.value;
        if(node.left == null && node.right == null)
        {
            branchSums.add(sum);
        }
        branchSums(node.left, sum, branchSums);
        branchSums(node.right, sum, branchSums);
    }
    
    /**O(n) Time and O(h) Space */
    public static int nodeDepths(BT root)
    {
        final List<Level> depthTree = new ArrayList();
        depthTree.add(new Level(root,0));
        int sum = 0;
        while(depthTree.size()>0)
        {
            Level top = depthTree.remove(depthTree.size() - 1);
            BT currentNode = top.node;
            if(currentNode!=null)
            {
                sum = sum + top.depth;
                depthTree.add(new Level(currentNode.left, top.depth + 1));
                depthTree.add(new Level(currentNode.right, top.depth + 1));
            }
            
        }
            
        return sum;
    }
    
    
    static class Level
    {
        int depth; 
        BT node;
        public Level(BT node, int depth)
        {
            this.depth = depth; 
            this.node = node;
        }
    }
    
}
