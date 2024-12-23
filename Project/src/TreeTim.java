import java.util.Random;
public class TreeTim {
    NodeTim root = null;
    Random random = new Random();

    boolean isEmpty(){
        return root == null;
    }

    void levelOrder() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        
        System.out.println("Tournament Bracket:");
        System.out.println("==================");
        
        System.out.println("└── " + root.nama);
        
        if (root.left != null && root.right != null) {
            // First Final Bracket
            System.out.println("    ├── " + (root.left.nama != null ? root.left.nama : "Final"));
            System.out.println("    │   ├── " + (root.left.left != null ? root.left.left.nama : "[Team]"));
            System.out.println("    │   └── " + (root.left.right != null ? root.left.right.nama : "[Team]"));
            
            System.out.println("    └── " + (root.right.nama != null ? root.right.nama : "Final"));
            System.out.println("        ├── " + (root.right.left != null ? root.right.left.nama : "[Team]"));
            System.out.println("        └── " + (root.right.right != null ? root.right.right.nama : "[Team]"));
        } else {
            System.out.println("No teams in the tournament.");
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

    void levelOrderPlayer(String namaTim){
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if(current.nama == namaTim && current.headPlayer != null){
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
                // String done = """
                //     __  __       _______ _____ _    _   _____   ____  _   _ ______   _ 
                //    |  \\/  |   /\\|__   __/ ____| |  | | |  __ \\ / __ \\| \\ | |  ____| | |
                //    | \\  / |  /  \\  | | | |    | |__| | | |  | | |  | |  \\| | |__    | |
                //    | |\\/| | / /\\ \\ | | | |    |  __  | | |  | | |  | | . ` |  __|   | |
                //    | |  | |/ ____ \\| | | |____| |  | | | |__| | |__| | |\\  | |____  |_|
                //    |_|  |_/_/    \\_\\_|  \\_____|_|  |_| |_____/ \\____/|_| \\_|______| (_)
                                                                                       
                                                                                       
                //   """;
        System.out.println(header);        
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);

        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if(current == null){
                continue;
            }
            if(current.headPlayer == null && current.nama != "Champion" && current.nama !="Final"){
                NodeTim selanjutnya = queue.dequeue();
                if (selanjutnya == null){
                    return;
                }
                if (root == null) {
                    System.out.println("Tree is empty.");
                    return;
                }
                Queue antrian = new Queue();
                antrian.enqueue(root);
                NodeTim final1 = null, final2 = null;
                while (!antrian.isEmpty()) {
                    NodeTim posisi = antrian.dequeue();
                    if(posisi.nama.equals(current.nama) && posisi.headPlayer != null){
                        NodeTim tempParent = current.parent;
                        final1 = posisi;
                        final1.parent = tempParent;
                    }
                    if (posisi.left != null) {
                        antrian.enqueue(posisi.left);
                    }
                    if (posisi.right != null) {
                        antrian.enqueue(posisi.right);
                    }
                }
                antrian.enqueue(root);
                while (!antrian.isEmpty()) {
                    NodeTim posisi = antrian.dequeue();
                    if(posisi.nama.equals(selanjutnya.nama) && posisi.headPlayer != null){
                        NodeTim tempParent = selanjutnya.parent;
                        final2 = posisi;
                        final2.parent = tempParent;
                    }
                    if (posisi.left != null) {
                        antrian.enqueue(posisi.left);
                    }
                    if (posisi.right != null) {
                        antrian.enqueue(posisi.right);
                    }
                }
                final1.headPlayer.updateKDA();
                final2.headPlayer.updateKDA();
                int nilai = random.nextInt(2);
                if(nilai == 0){
                    final1.lose += 1;
                    final2.win += 1;
                }else{
                    final1.win += 1;
                    final2.lose += 1;
                }
                if(final1.lose > 0){
                    final1.play = false;
                    swap(final2.parent, final2);
                    final2.play = false;
                }else{
                    final2.play = false;
                    swap(final1.parent, final1);
                    final1.play = false;
                }
            }
            if (current.headPlayer != null) {
                // System.out.println(header);
                current.headPlayer.updateKDA();
                int nilai = random.nextInt(2);
                NodeTim selanjutnya = queue.dequeue(); 
                selanjutnya.headPlayer.updateKDA();
                if(nilai == 0){
                    current.lose += 1;
                    selanjutnya.win += 1;
                }else{
                    current.win += 1;
                    selanjutnya.lose += 1;
                }
                if(current.lose > 0){
                    current.play = false;
                    swap(selanjutnya.parent, selanjutnya);
                    selanjutnya.play = false;
                }else{
                    selanjutnya.play = false;
                    swap(current.parent, current);
                    current.play = false;
                }
            }
            if (current.left != null && current.left.play) {
                queue.enqueue(current.left);
            }
            if (current.right != null && current.right.play) {
                queue.enqueue(current.right);
            }
        }
    }
    
    void swap(NodeTim parentNode, NodeTim node){
        parentNode.nama = node.nama;
        parentNode.win = node.win;
        parentNode.lose = node.lose;
        parentNode.play = node.play;
    }

    void search(String namaPlayer){
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
                current.headPlayer.linearSearch(namaPlayer);
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
    void bestPlayer(){
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }
        Queue queue = new Queue();
        queue.enqueue(root);
        Stack stack = new Stack();
        while (!queue.isEmpty()) {
            NodeTim current = queue.dequeue();
            if(current.headPlayer != null){
                NodePlayer posisi = current.headPlayer.head;
                while(posisi != null){
                    NodePlayer temp = new NodePlayer(posisi.nama, posisi.role);
                    temp.kill = posisi.kill;
                    temp.assist = posisi.assist;
                    temp.death = posisi.death;
                    stack.push(temp);
                    posisi = posisi.next;
                }
            }
            if (current.left != null) {
                queue.enqueue(current.left);
            }
            if (current.right != null) {
                queue.enqueue(current.right);
            }
        }
        stack.selectionSort();
        stack.printPlayer();
        
    }
}
