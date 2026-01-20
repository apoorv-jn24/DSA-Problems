import java.util.*;
public class LL {
    private ListNode head;

    static class ListNode {
        int data;
        ListNode next;

        ListNode(int data) {
            this.data = data;
            this.next = null;
        }
    }
       public LL(int[] values) {
        for (int val : values) {
            insertAtEnd(val);
        }
    }

    public void insertAtEnd(int data) {
        ListNode newListNode = new ListNode(data);
        if (head == null) {
            head = newListNode;
            return; 
        } 
            ListNode temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newListNode;
        }
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
    
    public ListNode middleNode(ListNode head) {
        if(head == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    public void display(ListNode node) {
    System.out.print("[");
    while (node != null) {
        System.out.print(node.data);
        if (node.next != null) {
            System.out.print(", ");
        }
        node = node.next;
    }
    System.out.println("]");
}

    public static void main(String[] args) {
        int[] test = {1, 2, 3, 4, 5};
        LL list = new LL(test);

        System.out.print("Full list: ");
        list.display(list.head);

        ListNode middle = list.middleNode(list.head);
        System.out.print("From middle: ");
        System.out.println();
        list.display(middle);
        System.out.println("Has cycle: " + list.hasCycle(list.head));
    }
       
}