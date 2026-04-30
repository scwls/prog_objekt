import java.util.AbstractList;
import java.util.NoSuchElementException;

public class CustomList<T>  {
    Node<T> head = null;
    Node<T> tail = null;


    public void addLast(T value){
        Node current = new Node(value, null);
        if(head==null){
            head=current;
        }else{
            tail.next=current;
        }
        tail=current;
    }
    public T getLast(){
        if(tail==null){
            throw new NoSuchElementException("Lista jest pusta");
        }
        return tail.value;
    }

    public void addFirst(T value){
        Node current = new Node(value, null);
        if(head==null){
            tail=current;
        }else{
            current.next=head;
        }
        head=current;
    }

    public T getFirst(){
        if(head==null){
            throw new NoSuchElementException("Lista jest pusta");
        }
        return head.value;
    }

    public T removeFirst(){
        if(head==null){
            throw new NoSuchElementException("Lista jest pusta");
        }
        Node<T> current = head;
        head=head.next;
        if(head==null){
            tail=null;
        }
        return current.value;
    }

    public T removeLast(){
        if(tail==null){
            throw new NoSuchElementException("Lista jest pusta");
        }
        T valueToReturn = tail.value;
        if(head == tail){
            head=null;
            tail=null;;
        }else{
            Node<T> current=head;
            while(current.next!=tail){
                current=current.next;
            }
            current.next = null;
            tail = current;
        }
        return valueToReturn;
    }
}
