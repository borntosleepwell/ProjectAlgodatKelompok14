public class Queue {
    NodeQueue front = null, back = null;

    boolean isEmpty(){
        return front == null;
    }

    int size(){
        NodeQueue current = front;
        int i = 0;
        while(current != null){
            i++;
            current = current.next;
        }
        return i;
    }

    void enqueue(NodeTim treeNode){
        NodeQueue newNode = new NodeQueue(treeNode);
        if(isEmpty()){
            front = back = newNode;
        }else{
            back.next = newNode;
            back = newNode;
        }
    }

    NodeTim dequeue(){
        NodeTim temp = front.treeNode;
        front = front.next;
        return temp;
    }
}