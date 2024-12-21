public class Stack {
    NodePlayer top = null, bot = null;

    boolean isEmpty(){
        return top == null;
    }

    int size(){
        NodePlayer current = bot;
        int i = 0;
        while(current != null){
            i++;
            current = current.next;
        }
        return i;
    }

    void push(NodePlayer newNode){
        if(isEmpty()){
            top = bot = newNode;
        }else{
            top.next = newNode;
            top = newNode;
        }
    }

    NodePlayer pop(){
        NodePlayer temp = top;
        NodePlayer current = bot;
        while(current != top){
            current = current.next;
        }
        current.next = null;
        top = current;
        return temp;
    }

    void swap(NodePlayer player1, NodePlayer player2){
        String nama = player1.nama;
        String role = player1.role;
        int kill = player1.kill;
        int death = player1.death;
        int assist = player1.assist;

        player1.nama = player2.nama;
        player1.role = player2.role;
        player1.kill = player2.kill;
        player1.assist = player2.assist;
        player1.death = player2.death;

        player2.nama = nama;
        player2.role = role;
        player2.kill = kill;
        player2.assist = assist;
        player2.death = death;
    }

    void selectionSort(){
        if(top == null) return;
        NodePlayer current = bot;
        NodePlayer posisi = null;
        NodePlayer temp = null;
        while(current != null){
            temp = current;
            posisi = current.next;
            while(posisi != null){
                if((float)(temp.kill + temp.assist) / temp.death < (float)(posisi.kill + posisi.assist) / posisi.death){
                    temp = posisi;
                }
                posisi = posisi.next;
            }
            if(temp != current){
                swap(current, temp);
            }
            current = current.next;
        }
    }

    void printPlayer(){
        NodePlayer current = bot;
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
}
