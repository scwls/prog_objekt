import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class CustomList<T> extends AbstractList<T> {
    Node<T> head = null;
    Node<T> tail = null;

    @Override
    public T get(int i) {
        if(i==0) {
            if(head==null){
                return null;
            }else{
            return head.value;
            }
        }else{
            Node<T> current = head;
            for(int j=0; j<i; j++){
                if(current.next == null){
                    return null;
                }else{
                    current=current.next;
                }
            }
            return current.value;
        }
    }
    @Override
    public int size() {
        if(head==null) {
            return 0;
        }else{
            Node<T> current = head;
            int i = 1;
            while(current.next!=null){
                current=current.next;
                i+=1;
            }
            return i;
        }
    }

    @Override
    public boolean add(T t) {
        addLast(t);
        return true;
    }

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

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            private Node<T> current = head;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                T result = current.value;
                current=current.next;
                return result;
            }
        };
    }
}
