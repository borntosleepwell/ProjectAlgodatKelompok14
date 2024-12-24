public class Queue {
    NodeQueue front = null, back = null;

    boolean isEmpty(){
        return front == null;
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
        if(front == null){
            System.out.println("============================\nTIDAK ADA PERTANDINGAN LAGI!\n============================");
            return null;
        }
        NodeTim temp = front.treeNode;
        front = front.next;
        return temp;
    }
}