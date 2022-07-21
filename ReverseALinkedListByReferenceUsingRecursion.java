import java.util.*;
class Node<T>
{
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
        if(temp == null)
        {
            System.out.println("LL is empty");
        }
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    Node<T> reverse(Node<T> currentNode, Node<T> previousNode)
    {
        if(currentNode == null)
        {
            return previousNode;
        }
        Node<T> ahead = currentNode.next;
        currentNode.next = previousNode;
        return reverse(ahead, currentNode);
    }
    void reverseCall()
    {
        start = reverse(start, null);
        Node<T> temp = start;
        if(temp == null)
        {
            System.out.println("LL is empty");
        }
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
public class ReverseALinkedList {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            LinkedListOperations<Integer> opr = new LinkedListOperations<>();
            while (true) {
                System.out.println("1. Add node at the end");
                System.out.println("2. Print the Linked List");
                System.out.println("3. Reverse A Linked List");
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
                    case 2: opr.print();
                    break;
                    case 3: opr.reverseCall();
                    break;
                    case 10: return;
                }
            }
        }
        }
    }
