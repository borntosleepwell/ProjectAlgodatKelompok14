public class Queue {
    NodePlayer front = null, back = null;

    boolean isEmpty(){
        return front == null;
    }

    int size(){
        NodePlayer current = front;
        int i = 0;
        while(current != null){
            i++;
            current = current.next;
        }
        return i;
    }

    void enqueue(NodePlayer newNode){
        if(front == null){
            front = back = newNode;
        }else{
            back.next = newNode;
            back = newNode;
        }
    }

    NodePlayer dequeue(){
        NodePlayer temp = front;
        front = front.next;
        return temp;
    }
}
