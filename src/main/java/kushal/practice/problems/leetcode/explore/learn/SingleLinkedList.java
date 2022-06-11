package kushal.practice.problems.leetcode.explore.learn;

/**
 * Main Class for Single Linked List.
 * 
 * @author Kushalvtiger
 */
class SingleLinkedList
{
    private ListNode head;

    /**
     * Initialize your data structure here.
     * 
     * @param head Head of the linked List.
     */
    public SingleLinkedList(final ListNode head)
    {
        this.head = head;
    }

    /** 
     * SC: O(1) TC: O(n)
     * 
     * Helper function to return the index-th node in the linked list. 
     * 
     * @param index Index of the node.
     * @param val Value of the node.
     */
    public ListNode getNode(int index)
    {
        ListNode cur = this.head;
        for (int i = 0; i < index && cur != null; ++i)
        {
            cur = cur.next;
        }
        return cur;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Helper function to return the last node in the linked list. 
     * 
     * @return tail {@link ListNode}
     */
    public ListNode getTail()
    {
        ListNode cur = this.head;
        while (cur != null && cur.next != null)
        {
            cur = cur.next;
        }
        return cur;
    }
    
    /**
     * SC: O(1) TC: O(n)
     * 
     * Helper function to return the length of the linked list. 
     * 
     * @return length of the Linked List.
     */
    public int getLength()
    {
        ListNode cur = this.head;
        int index = 0;
        while (cur != null && cur.next != null)
        {
            cur = cur.next;
            index ++;
        }
        return index;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Get the value of the index-th node in the linked list. If the index is invalid, return -1. 
     * 
     * @param index Index of the node.
     * 
     * @return {@link ListNode} at given index. 
     */
    public int get(int index)
    {
        ListNode cur = getNode(index);
        return cur == null ? -1 : cur.val;
    }

    /**
     * SC: O(1) TC: O(1)
     * 
     * Add a node of value val before the first element of the linked list. After the insertion, the new node will be the first node of the linked
     * list. 
     * 
     * @param val Value to be added at the head of the node.
     */
    public void addAtHead(int val)
    {
        ListNode cur = new ListNode(val);
        cur.next = this.head;
        this.head = cur;
        return;
    }

    /** 
     * SC: O(1) TC: O(n)
     * 
     * Append a node of value val to the last element of the linked list. 
     */
    public void addAtTail(int val)
    {
        if (this.head == null)
        {
            addAtHead(val);
            return;
        }
        ListNode prev = getTail();
        ListNode cur = new ListNode(val);
        prev.next = cur;
    }

    /**
     * SC: O(1) TC: O(n)
     * 
     * Add a node of value val before the index-th node in the linked list. If index equals to the length of linked list, the node will be appended to
     * the end of linked list. If index is greater than the length, the node will not be inserted. 
     * 
     * @param index Index where node needs to be inserted.
     * 
     * @param val Value of the node.
     */
    public void addAtIndex(int index, int val)
    {
        if (index == 0)
        {
            addAtHead(val);
            return;
        }
        ListNode prev = getNode(index - 1);
        if (prev == null)
        {
            return;
        }
        ListNode next = prev.next;
        ListNode cur = new ListNode(val);
        cur.next = next;
        prev.next = cur;
    }

    /**
     * SC: O(1) TC: O(n) 
     * 
     * Delete the index-th node in the linked list, if the index is valid. 
     * 
     * @param index Index where node needs to be deleted.
     */
    public void deleteAtIndex(int index)
    {
        ListNode cur = getNode(index);
        if (cur == null)
        {
            return;
        }
        ListNode prev = getNode(index - 1);
        ListNode next = cur.next;
        if (prev != null)
        {
            prev.next = next;
        }
        else
        {
            // modify head when deleting the first node.
            this.head = next;
        }
    }
}
