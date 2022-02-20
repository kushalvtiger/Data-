package kushal.practice.problems.algoexpert.easy;

import org.junit.Test;

import kushal.practice.problems.algoexpert.easy.LinkedList.LL;

public class LinkedListTest
{

    @Test
    public void testRemoveDuplicates() 
    {
      final LL ll1 = new LL(1);
      final LL ll2 = new LL(1);
      final LL ll3 = new LL(2);
      final LL ll4 = new LL(2);
      final LL ll5 = new LL(3);
      final LL ll6 = new LL(4);
      ll1.next = ll2;
      ll2.next = ll3;
      ll3.next = ll4;
      ll4.next = ll5;
      ll5.next = ll6;
      ll6.next = null;
      
      LinkedList.removeDuplicatesFromLinkedList(ll1);
    }

}
