import java.util.Random;

public class ListPlayer {
    NodePlayer head = null, tail = null;
    Random random = new Random();

    void addPlayer(String nama, String role){
        NodePlayer newNode = new NodePlayer(nama, role);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
    
    void updateKDA(){
        NodePlayer current = head;
        while(current != null){
            current.kill += random.nextInt(10)+1;
            current.death += random.nextInt(4)+1;
            current.assist += random.nextInt(10)+1;
            current = current.next;
        }
    }
}
