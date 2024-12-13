public class ListPlayer {
    NodePlayer head = null, tail = null;

    void addPlayer(String nama, String role){
        NodePlayer newNode = new NodePlayer(nama, role);
        if(head == null){
            head = tail = newNode;
        }else{
            tail.next = newNode;
            tail = newNode;
        }
    }
}
