package gitrepo.DataStructures.queues;

import java.util.Scanner;

/*Here, we will learn operations on queues.

Given N integers, the task is to insert those elements in the queue. Also, given M integers, task is to find the frequency of each number in the Queue.

Example:

Input:
8
1 2 3 4 5 2 3 1
5
1 3 2 9 10

Output:
2
2
2
-1
-1

Explanation:
After inserting 1, 2, 3, 4, 5, 2, 3, 1 into the queue,
frequency of 1 is 2, 3 is 2, 2 is 2, 9 is -1 and 10 is
-1 (since, 9 and 10 is not there in the queue).
Your Task:
Your task is to complete the functions insert() and findFrequency() which inserts the element into the queue and find the count of occurences of element in the queue respectively.

Constraints:
1 <= N <= 103
1 <= M <= 103
1 <= Elements of Queue <= 106*/
public class OperationsOnQueue<T>{
    private int queueSize = 0;
    private static class ListNode<T>{
        T data;
        ListNode prev,next;
        ListNode(T data,ListNode prev,ListNode next){
            this.data = data;
            this.prev = prev;
            this.next = next;
        }
    }
    ListNode tail,head;
    public boolean isEmpty(){
        if(tail == null){
            return true;
        }
        return false;
    }
    public  void enqueue(T data){
        if(isEmpty()){
            head = tail = new ListNode(data,null,null);
        }else{
            ListNode newNode = new ListNode(data,tail,null);
            tail.next = newNode;
            tail = newNode;
        }
        queueSize++;
    }
    public int findFrequency(T element){
        int count = 0;
        ListNode tempIterator = head;
        for(int i=0;i<queueSize;i++){
            if(tempIterator.data == element){
                count++;
            }
            tempIterator = tempIterator.next;
        }

        return count;
    }

    public static void main (String args[]){
        Scanner sc = new Scanner(System.in);
        OperationsOnQueue oq = new OperationsOnQueue();
        int n = sc.nextInt();
        int a[] = new int[n];
        for(int i=0;i<n;i++) {
            oq.enqueue(sc.nextInt());
        }

        int k = sc.nextInt();
        for(int i=0;i<k;i++){
            System.out.println(oq.findFrequency(sc.nextInt()));
        }

    }
}
