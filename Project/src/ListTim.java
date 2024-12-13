public class ListTim {
    NodeTim head = null, tail = null;
    
    public void addTim (String nama, ListPlayer player){
       NodeTim newNode = new NodeTim(nama, player);
       if(head == null){
        head = tail = newNode;
       }else{
        tail.next = newNode;
        tail = newNode;
       }
    }
    
}
