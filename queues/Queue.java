package gitrepo.DataStructures.queues;

public interface Queue<T>{
   public void enqueue(T element);
   public T dequeue();
   public T peek();
   public int size();
}






