package _5_linked_list;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA =
 * 2, skipB = 3 Output: Reference of the node with value = 8
 * 
 * @author terry00
 *
 */

public class _12_intersect_two_linked_list {
	// 1. Method 1: use intersection method
	// headA: [0, 4, 1, 3, 8]
	// headB: [5, 1, 4, 1, 3, 8]
	// headA: [0, 4, 1, 3, 8, 5, 1, 4, 1, 3, 8]
	// headB: [5, 1, 4, 1, 3, 8, 0, 4, 1, 3, 8]
	// you will find [4, 1, 3, 8]
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if (headA == null || headB == null) {
			return null;
		}
		ListNode currA = headA;
		ListNode currB = headB;
		while (currA != currB) {
			if (currA == null) {
				currA = headB;
			} else {
				currA = currA.next;
			}

			if (currB == null) {
				currB = headA;
			} else {
				currB = currB.next;
			}
		}
		return currA;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
