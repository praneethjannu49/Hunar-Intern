class Node {
    int data;
    Node next;

    // Constructor
    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    // Method to add elements to the list
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    // Method to display the list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Method to delete the last occurrence of a specified item
    public void deleteLastOccurrence(int key) {
        Node current = head;
        Node lastOccurrence = null;
        Node lastOccurrencePrev = null;
        Node prev = null;

        // Traverse the list to find the last occurrence of the key
        while (current != null) {
            if (current.data == key) {
                lastOccurrence = current;
                lastOccurrencePrev = prev;
            }
            prev = current;
            current = current.next;
        }

        // If the key is not found, return
        if (lastOccurrence == null) {
            System.out.println("Item not found in the list.");
            return;
        }

        // If the last occurrence is the head node
        if (lastOccurrence == head) {
            head = head.next;
        } else {
            lastOccurrencePrev.next = lastOccurrence.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        
        // Add elements to the list
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(2);

        System.out.println("Original List:");
        list.display();

        // Delete last occurrence of 2
        list.deleteLastOccurrence(2);
        System.out.println("After deleting last occurrence of 2:");
        list.display();

        // Delete last occurrence of 3
        list.deleteLastOccurrence(3);
        System.out.println("After deleting last occurrence of 3:");
        list.display();

        // Delete last occurrence of 1 (head node)
        list.deleteLastOccurrence(1);
        System.out.println("After deleting last occurrence of 1:");
        list.display();

        // Try to delete an item that does not exist
        list.deleteLastOccurrence(5);
        System.out.println("After attempting to delete non-existent item 5:");
        list.display();
    }
}