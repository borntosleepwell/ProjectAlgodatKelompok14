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

    void printPlayer(){
        NodePlayer current = head;
        while(current != null){
            System.out.println(current.nama + ", Role : " + current.role);
            System.out.println("------------------------------------------");
            System.out.println(current.kill + "/" + current.death + "/" + current.assist);
            if(current.death == 0){
                System.out.println("KDA : 0");
            }else{
                System.out.println("KDA : " + (float)(current.kill + current.assist) / current.death);
            }
            System.out.println();
            current = current.next;
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

    void linearSearch(String namaPlayer){
        NodePlayer current = head;
        boolean isFound = false;
        while(current != null){
            if(current.nama.equals(namaPlayer)){
                isFound = true;
                break;
            }
            current = current.next;
        }
        if(isFound == false){
            System.out.println("Player dengan Nama '" + namaPlayer + "' Tidak Ditemukan");
            System.out.println("==================================================");
        }else{
            System.out.println(current.nama + ", Role : " + current.role);
            System.out.println("------------------------------------------");
            System.out.println(current.kill + "/" + current.death + "/" + current.assist);
            if(current.death == 0){
                System.out.println("KDA : 0");
            }else{
                System.out.println("KDA : " + (float)(current.kill + current.assist) / current.death);
            }
            System.out.println("==================================================");
        }
    }
}
