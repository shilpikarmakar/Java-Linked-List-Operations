import java.util.Scanner;

class Node<T>{
    T data;
    Node<T> next;
    Node(T data)
    {
        this.data = data;
        next = null;
    }
}
class LinkedListOperations<T>
{
    Node<T> start;
    void addAtEnd(Node<T> node)
    {
        if(start == null)
        {
            start = node;
        }
        else
        {
            Node<T> temp = start;
            while(temp.next != null)
            {
                temp = temp.next;
            }
            temp.next = node;
        }
    }
    void print()
    {
        Node<T> temp = start;
        while(temp != null)
        {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    void addAtBeg(Node<T> node)
    {
        if(start == null)
        {
            start = node;
        }
        else
        {
            node.next = start;
            start = node;
        }
    }
    void addAtMiddle(Node<T> node, int pos)
    {
        if(pos == 0)
        {
            addAtBeg(node);
            return;
        }
        Node<T> temp = start;
        int i = 1;
        while(i < pos)
        {
            temp = temp.next;
            i++;
        }
        node.next = temp.next;
        temp.next = node;
    }
    void deleteAtBeg()
    {
        if(start == null)
        {
            System.out.println("Linked List is empty");
            return;
        }
        if(start.next == null)
        {
            start = null;
            return;
        }
        Node<T> temp = start;
        start = start.next;
        temp.next = null;
        temp = null;
    }
    void deleteFromEnd()
    {
        if(start == null)
        {
            System.out.println("Linked List is empty");
            return;
        }
        if(start.next == null)
        {
            start = null;
            return;
        }
        Node<T> temp = start;
        Node<T> temp2 = start;
        while(temp != null)
        {
            temp2 = temp;
            temp = temp.next;
        }
        temp2.next = null;
        temp = null;
    }
    void deleteFromMiddle(int pos)
    {
        if(start == null)
        {
            System.out.println("Linked List is empty");
            return;
        }
        if(start.next == null)
        {
            start = null;
            return;
        }
        Node<T> temp = start;
        Node<T> temp2 = start;
        for(int i=1; i<pos-1; i++)
        {
            temp = temp.next;
            temp2 = temp;
        }
        temp2 = temp2.next;
        temp.next = temp.next.next;
        temp2.next = null;
    }
}
public class LinkedListCRUDOperations {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedListOperations<Integer> opr = new LinkedListOperations<>();
            while (true) {
                System.out.println("1. Add node at the end");
                System.out.println("2. Print the Linked List");
                System.out.println("3. Add node at the beginning of linked list");
                System.out.println("4. Add position wise in the linked list");
                System.out.println("5. Delete the beginning node");
                System.out.println("6. Delete the end node");
                System.out.println("7. Delete from the given position");
                System.out.println("10. Exit");
                System.out.println("Enter the choice");
                int choice = sc.nextInt();
                int data;
                Node<Integer> node;
                switch(choice)
                {
                    case 1: System.out.println("Enter the data for node");
                    data = sc.nextInt();
                    node = new Node<>(data);
                    opr.addAtEnd(node);
                    break;
                    case 3: System.out.println("Enter the data for node");
                    data = sc.nextInt();
                    node = new Node<>(data);
                    opr.addAtBeg(node);
                    break;
                    case 4: System.out.println("Enter the data for node");
                    data = sc.nextInt();
                    System.out.println("Enter the position: ");
                    int pos = sc.nextInt();
                    node = new Node<>(data);
                    opr.addAtMiddle(node, pos);
                    break;
                    case 5: opr.deleteAtBeg();
                    break;
                    case 6: opr.deleteFromEnd();
                    break;
                    case 7: System.out.println("Enter the position: ");
                    int pos1 = sc.nextInt();
                    opr.deleteFromMiddle(pos1);
                    break;
                    case 2: opr.print();
                    break;
                    case 10: return;
                }
            }
        }
    }
}
