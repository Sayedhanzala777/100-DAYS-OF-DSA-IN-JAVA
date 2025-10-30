class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Task 2: Append node at end
    public void append(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = newNode;
    }

    // Task 3: Prepend node at beginning
    public void prepend(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
    }

    // Task 4: Delete node by value
    public void delete(int data) {
        if (head == null) return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node curr = head;
        while (curr.next != null && curr.next.data != data) {
            curr = curr.next;
        }

        if (curr.next != null) {
            curr.next = curr.next.next;
        }
    }

    // Task 5: Search node by value
    public boolean find(int data) {
        Node curr = head;
        while (curr != null) {
            if (curr.data == data) return true;
            curr = curr.next;
        }
        return false;
    }

    // Task 6: Print all elements
    public void printList() {
        Node curr = head;
        while (curr != null) {
            System.out.print(curr.data + " -> ");
            curr = curr.next;
        }
        System.out.println("null");
    }

    // Task 7: Reverse the linked list
    public void reverse() {
        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    // Task 8: Get middle node
    public Node getMiddle() {
        if (head == null) return null;
        Node slow = head;
        Node fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}

public class Day12 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        // Append elements
        list.append(10);
        list.append(20);
        list.append(30);
        list.append(40);
        list.append(50);

        System.out.println("Initial Linked List:");
        list.printList();

        // Prepend element
        list.prepend(5);
        System.out.println("After Prepending 5:");
        list.printList();

        // Delete element
        list.delete(30);
        System.out.println("After Deleting 30:");
        list.printList();

        // Find element
        System.out.println("Find 20? " + list.find(20));
        System.out.println("Find 100? " + list.find(100));

        // Reverse list
        list.reverse();
        System.out.println("After Reversing:");
        list.printList();

        // Get middle element
        Node middle = list.getMiddle();
        if (middle != null)
            System.out.println("Middle Element: " + middle.data);
    }
}
