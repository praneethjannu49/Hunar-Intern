class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    private Node head;

    // Method to add a node to the end of the list
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

    // Method to display the linked list
    public void display() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " -> ");
            current = current.next;
        }
        System.out.println("null");
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

        // If the key was found, delete the last occurrence
        if (lastOccurrence != null) {
            if (lastOccurrencePrev != null) {
                lastOccurrencePrev.next = lastOccurrence.next;
            } else {
                head = lastOccurrence.next;
            }
        }
    }
}

public class LinkedListMain {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(2);
        list.add(4);

        System.out.println("Original list:");
        list.display();

        list.deleteLastOccurrence(2);

        System.out.println("List after deleting the last occurrence of 2:");
        list.display();
    }
}
