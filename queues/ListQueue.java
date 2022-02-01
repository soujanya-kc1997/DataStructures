package gitrepo.DataStructures.queues;


public class ListQueue<T> implements Queue<T> {
    private int size;
    private static class ListNode<T>{
        T data;
        ListNode prev,next;
        ListNode(T x,ListNode prev,ListNode next){
            data = x;
            this.prev = prev;
            this.next = next;
        }
    }

    private ListNode<T> head=null,tail=null;

    private boolean isEmpty(){
        if(tail == null) {
            return true;
        }
        return false;
    }
    public void enqueue(T x){
        if(isEmpty()){
            head = tail = new ListNode<T>(x, null, null);
        }else{
            ListNode newNode = new ListNode<>(x,tail,null);
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public T dequeue(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        T data = head.data;
        if(head == tail) {
            head.data  = null;
            head = tail = null;
        }else{
            ListNode<T> temp = head;
            head = head.next;
            head.prev = null;
            temp = null;
        }
        size--;
        return data;
    }

    public int size(){
        return size;
    }

    public T peek(){
        if(isEmpty()){
            throw new RuntimeException("Queue is empty");
        }
        return head.data;
    }

    public static void main(String args[]){
        ListQueue<Integer> list = new ListQueue();
        list.enqueue(4);
        list.enqueue(5);
        System.out.println(list.dequeue());
        list.enqueue(7);
        list.enqueue(8);
        System.out.println(list.peek());
        list.enqueue(9);
        System.out.println(list.dequeue());
        System.out.println(list.peek());
        System.out.println(list.size());
    }
}
