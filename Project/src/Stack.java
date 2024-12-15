public class Stack {
    NodePlayer top = null, bot = null;

    boolean isEmpty(){
        return top == null;
    }

    int size(){
        int i = 0;
        NodePlayer current = bot;
        while(current != null){
            i++;
            current = current.next;
        }
        return i;
    }

    void push(NodePlayer newNode){
        if(top == null){
            top = bot = newNode;
        }else{
            top.next = newNode;
            top = newNode;
        }
    }

    NodePlayer pop(){
        NodePlayer current = bot;
        NodePlayer temp = null;
        while(current != top){
            temp = current;
            current = current.next;
        }
        temp.next = null;
        top = temp;
        return current;
    }
}
