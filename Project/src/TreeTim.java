import java.util.Random;

public class TreeTim {
    NodeTim root = null;
    Random random = new Random();

    boolean isEmpty(){
        return root == null;
    }
    void levelOrderPlayer(String namaTim){
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if(current.nama == namaTim){
                System.out.println(current.nama);
                System.out.println("==========================================");
                current.headPlayer.printPlayer();
                System.out.println();
            }
            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }
     void levelOrderTim(){
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if(current.headPlayer != null){
                System.out.println(current.nama);
                System.out.println("Win : " + current.win + " Lose : " + current.lose);
                System.out.println();
            }
            if (current.left != null) {
                queue.enqueue(current.left);
            }

            if (current.right != null) {
                queue.enqueue(current.right);
            }
}
}
    void matchDay(){
        String header = """
                  __  __           _            _         ____                                 
                |  \\/  |         | |          | |       |  _ \\                                
                | \\  / |   __ _  | |_    ___  | |__     | |_) |   ___    __ _   _   _   _ __  
                | |\\/| |  / _` | | __|  / __| | '_ \\    |  _ <   / _ \\  / _` | | | | | | '_ \\ 
                | |  | | | (_| | | |_  | (__  | | | |   | |_) | |  __/ | (_| | | |_| | | | | |
                |_|  |_|  \\__,_|  \\__|  \\___| |_| |_|   |____/   \\___|  \\__, |  \\__,_| |_| |_|
                                                                        __/ |                
                                                                       |___/                 
                """;
        System.out.println(header);
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if (current.headPlayer != null) {
                current.headPlayer.updateKDA();
                current.win += random.nextInt(2);
                current.lose += random.nextInt(2);
            }
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }
}
