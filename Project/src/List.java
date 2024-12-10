public class List {
    NodeTim head = null;
    NodeTim tail = null;
    NodeTim next = null;
    

    public void addData (NodeTim add){
        if(head == null){
            head = add;
            tail = head;
        } else {
            tail.next = add;
            tail = add;
        }
    }















    

    // public void printList (){
    //     if(head == null){
    //         System.out.println("tidak ada data");
    //         return;
    //     }
        
    //     else {
    //         NodeTim temp = head;
    //         System.out.println("ID Team :" +temp.data+"Nama Team"+temp.data);
    //         temp = temp.next;
    //     }

    // }


}
