package beans;

/**
 * Created by doliu on 6/12/14.
 */
public class ListNode {
	public int val;
	public ListNode next;
	// for the problem of copying list with random pointer
	public ListNode random;
	public ListNode() { val = Integer.MIN_VALUE; next = null; }
	public ListNode(int x) { val = x; next = null; }
}
