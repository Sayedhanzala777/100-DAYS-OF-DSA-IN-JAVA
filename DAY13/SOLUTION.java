// Day - 13 : Stack

// Activity 1 : Implementing Stack
// Task1 > Create a Stack class with methods push(), pop(), peek(), and isEmpty().
// Task2 > Demonstrate stack operations by pushing and popping elements.

class Stack {
    private int arr[];
    private int top;
    private int capacity;

    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    public void push(int x) {
        if (isFull()) {
            System.out.println("Stack Overflow");
            return;
        }
        arr[++top] = x;
        System.out.println("Inserted: " + x);
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Stack Underflow");
            return -1;
        }
        System.out.println("Removed: " + arr[top]);
        return arr[top--];
    }

    public int peek() {
        if (!isEmpty()) return arr[top];
        else {
            System.out.println("Stack is Empty");
            return -1;
        }
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

public class Day13_Stack {
    public static void main(String[] args) {

        // Activity 1 - Demonstration
        Stack stack = new Stack(5);
        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("Top element: " + stack.peek());
        stack.pop();
        stack.pop();
        System.out.println("Is stack empty? " + stack.isEmpty());

        // Activity 2 : Stack Using Array is same as above (since implemented using array)
        // Handling overflow/underflow already included.

        // Activity 3 : Stack Using Linked List
        LinkedListStack linkedStack = new LinkedListStack();
        linkedStack.push(100);
        linkedStack.push(200);
        linkedStack.push(300);
        System.out.println("Peek (LinkedList Stack): " + linkedStack.peek());
        linkedStack.pop();
        linkedStack.pop();

        // Activity 4 : Applications
        System.out.println("Reversed string: " + reverseString("Hello"));
        System.out.println("Balanced ( {[]} ): " + isBalanced("{[]}"));
        System.out.println("Balanced ( {[}] ): " + isBalanced("{[}]"));

        // Activity 5 : Browser Back Button Simulation
        BrowserHistory browser = new BrowserHistory();
        browser.visit("google.com");
        browser.visit("youtube.com");
        browser.visit("github.com");
        browser.goBack();
        browser.goBack();
        browser.goBack();
    }

    // ---------------- STACK USING LINKED LIST ----------------
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    static class LinkedListStack {
        private Node top;

        public void push(int data) {
            Node newNode = new Node(data);
            newNode.next = top;
            top = newNode;
            System.out.println("Pushed (LL Stack): " + data);
        }

        public int pop() {
            if (top == null) {
                System.out.println("Stack Underflow (Linked List)");
                return -1;
            }
            int val = top.data;
            top = top.next;
            System.out.println("Popped (LL Stack): " + val);
            return val;
        }

        public int peek() {
            if (top == null) {
                System.out.println("Stack is empty (Linked List)");
                return -1;
            }
            return top.data;
        }
    }

    // ---------------- STACK APPLICATIONS ----------------
    static String reverseString(String str) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char c : str.toCharArray()) stack.push(c);
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) reversed.append(stack.pop());
        return reversed.toString();
    }

    static boolean isBalanced(String exp) {
        java.util.Stack<Character> stack = new java.util.Stack<>();
        for (char ch : exp.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[')
                stack.push(ch);
            else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '['))
                    return false;
            }
        }
        return stack.isEmpty();
    }

    // ---------------- REAL WORLD EXAMPLE: BROWSER BACK ----------------
    static class BrowserHistory {
        java.util.Stack<String> history = new java.util.Stack<>();

        void visit(String url) {
            history.push(url);
            System.out.println("Visited: " + url);
        }

        void goBack() {
            if (history.isEmpty()) {
                System.out.println("No more history!");
            } else {
                String url = history.pop();
                System.out.println("Going back from: " + url);
                if (!history.isEmpty())
                    System.out.println("Current: " + history.peek());
                else
                    System.out.println("At start page.");
            }
        }
    }
}
