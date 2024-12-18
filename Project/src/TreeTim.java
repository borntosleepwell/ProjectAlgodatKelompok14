import java.util.Random;

public class TreeTim {
    NodeTim root = null;
    Random random = new Random();

    boolean isEmpty(){
        return root == null;
    }

    void levelOrder(){
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            System.out.println(current.nama);
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
    }

    void levelOrderTim2(){
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        int i = 1;
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if(current.headPlayer != null){
                System.out.println(i + ". " + current.nama);
                i++;
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
