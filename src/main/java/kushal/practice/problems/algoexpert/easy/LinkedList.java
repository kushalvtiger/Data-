package kushal.practice.problems.algoexpert.easy;

public class LinkedList
{

    public static class LL
    {
        public int value;

        public LL next;

        public LL(int value)
        {
            this.value = value;
            this.next = null;
        }
    }

    public static LL removeDuplicatesFromLinkedList(LL linkedList)
    {
        if (linkedList == null)
        {
            return linkedList;
        }
        LL currentNode = linkedList;
        while (currentNode != null)
        {
            LL nextNode = currentNode.next;
            while (nextNode != null && nextNode.value == currentNode.value)
            {
                nextNode = nextNode.next;
            }
            currentNode = nextNode;
        }
        return linkedList;
    }
}
