package kushal.practice.problems.leetcode.explore.learn;

import java.util.HashSet;
import java.util.Set;

/**
 * Main Class for Cycle Linked List.
 * 
 * @author Kushalvtiger
 */
class CycleLinkedList
{
    /**
     * SC: O(1) TC: O(n)
     *
     * Determine weather the list has a cycle.
     * 
     * @param Head of the list.
     * 
     * @return <code>true</code> if list has cycle, <code>false</code> otherwise.
     */
    static boolean hasCycle(ListNode head)
    {
        if (head == null)
        {
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast)
        {
            if (fast == null || fast.next == null)
            {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    /**
     * SC: O(n) TC: O(n)
     * 
     * Determine weather the list has a cycle approach 2.
     * 
     * @param Head of the list.
     * 
     * @return <code>true</code> if list has cycle, <code>false</code> otherwise.
     */
    static boolean hasCycle2(ListNode head)
    {
        if (head == null)
        {
            return false;
        }
        Set<ListNode> hashSet = new HashSet<ListNode>();
        ListNode node = head;
        while (node.next != null)
        {
            node = node.next;
            if (hashSet.contains(node))
            {
                return true;
            }
            hashSet.add(node);
        }
        return false;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Determine intersection in the list if it has a cycle approach 2.
     * 
     * @param Head of the list.
     * 
     * @return intersect node.
     */
    static ListNode detectCycle(ListNode head)
    {
        ListNode tortoise = head;
        ListNode hare = head;

        // A fast pointer will either loop around a cycle and meet the slow
        // pointer or reach the `null` at the end of a non-cyclic list.
        while (hare != null && hare.next != null)
        {
            tortoise = tortoise.next;
            hare = hare.next.next;
            if (tortoise == hare)
            {
                return tortoise;
            }
        }
        return null;
    }

    /**
     * SC: O(n) TC: O(n)
     * 
     * Determine intersection in the list if it has a cycle approach 2.
     * 
     * @param Head of the list.
     * 
     * @return intersect node.
     */
    public ListNode detectCycle2(ListNode head)
    {
        if (head == null)
        {
            return null;
        }
        Set<ListNode> hashSet = new HashSet<ListNode>();
        ListNode node = head.next;
        hashSet.add(head);
        while (node != null)
        {
            if (hashSet.contains(node))
            {
                return node;
            }
            hashSet.add(node);
            node = node.next;
        }
        return null;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Determine intersection in the list if it has a cycle approach 2.
     * 
     * @param Head of the list.
     * 
     * @return intersect node.
     */
    static ListNode getIntersect(ListNode head)
    {
        if (head == null)
        {
            return null;
        }

        // If there is a cycle, the fast/slow pointers will intersect at some
        // node. Otherwise, there is no cycle, so we cannot find an entrance to
        // a cycle.
        ListNode intersect = detectCycle(head);
        if (intersect == null)
        {
            return null;
        }

        // To find the entrance to the cycle, we have two pointers traverse at
        // the same speed -- one from the front of the list, and the other from
        // the point of intersection.
        ListNode ptr1 = head;
        ListNode ptr2 = intersect;
        while (ptr1 != ptr2)
        {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        return ptr1;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Gets Intersection node at which the intersection of two singly linked lists begins.
     * 
     * @param headA Head of the listA.
     * @param headB Head of the listB.
     * @return intersect node.
     */
    static ListNode getIntersectionNode(ListNode headA, ListNode headB)
    {
        if (headA == null || headB == null)
        {
            return null;
        }

        SingleLinkedList listA = new SingleLinkedList(headA);
        SingleLinkedList listB = new SingleLinkedList(headB);

        int lengthA = listA.getLength();
        int lengthB = listB.getLength();

        int diff = lengthA - lengthB;
        ListNode newHeadA = headA;
        ListNode newHeadB = headB;
        if (diff < 0)
        {
            newHeadB = listB.getNode(diff * -1);
        }
        if (diff > 0)
        {
            newHeadA = listA.getNode(diff);
        }

        while (newHeadB != newHeadA)
        {
            newHeadA = newHeadA.next;
            newHeadB = newHeadB.next;
        }

        if (newHeadA == null || newHeadB == null)
        {
            return null;
        }

        return newHeadA;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Removes the n-th node from the end of list and return its head. 
     * 
     * @param Head of the list.
     * 
     * @return Node that was removed.
     */
    static ListNode removeNthFromEnd(ListNode head, int n)
    {
        if (head == null)
        {
            return null;
        }
        ListNode endnode = head;
        ListNode rmNode = head;
        int rmIndex = n;
        while (endnode.next != null)
        {
            endnode = endnode.next;
            rmIndex--;
            if (rmIndex < 0)
            {
                rmNode = rmNode.next;
            }
        }
        if (rmNode.next != null || rmNode.next.next != null)
        {
            rmNode.next = rmNode.next.next;
        }

        return head;
    }
}
