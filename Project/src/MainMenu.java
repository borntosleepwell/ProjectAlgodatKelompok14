import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        ListPlayer playerRRQ = new ListPlayer();
        playerRRQ.addPlayer("Skylar", "GoldLaner"); 
        playerRRQ.addPlayer("Sutsujin", "Jungler"); 
        playerRRQ.addPlayer("Rinz", "MidLaner"); 
        playerRRQ.addPlayer("idok", "Roamer"); 
        playerRRQ.addPlayer("Dyrennn", "ExpLaner");

        ListPlayer playerEvos = new ListPlayer();
        playerEvos.addPlayer("Natco", "GoldLaner"); 
        playerEvos.addPlayer("Anavel", "Jungler"); 
        playerEvos.addPlayer("clawkun", "MidLaner"); 
        playerEvos.addPlayer("DreamS", "Roamer"); 
        playerEvos.addPlayer("Saykots", "ExpLaner");

        ListPlayer playerBTR = new ListPlayer();
        playerBTR.addPlayer("EMANN", "GoldLaner"); 
        playerBTR.addPlayer("SuperKenn", "Jungler"); 
        playerBTR.addPlayer("MORENO", "MidLaner"); 
        playerBTR.addPlayer("KYY", "Roamer"); 
        playerBTR.addPlayer("SuperLuke", "ExpLaner");

        ListPlayer playerTLID = new ListPlayer();
        playerTLID.addPlayer("AeronShiki", "GoldLaner");
        playerTLID.addPlayer("Faviannn", "Jungler"); 
        playerTLID.addPlayer("Yehezkiel", "MidLaner"); 
        playerTLID.addPlayer("Widy", "Roamer"); 
        playerTLID.addPlayer("Aran", "ExpLaner");

        NodeTim rrq = new NodeTim("RRQ", playerRRQ);
        NodeTim evos = new NodeTim("EVOS", playerEvos);
        NodeTim btr = new NodeTim("BTR", playerBTR);
        NodeTim tlid = new NodeTim("TLID", playerTLID);
        NodeTim juara = new NodeTim("Champion", null);
        NodeTim grandFinal1 = new NodeTim("Final", null);
        NodeTim grandFinal2 = new NodeTim("Final", null);

        TreeTim tree = new TreeTim();
        tree.root = juara;

        tree.root.left = grandFinal1;
        tree.root.right = grandFinal2;
        tree.root.left.parent = tree.root;
        tree.root.right.parent = tree.root;

        tree.root.left.left = rrq;
        tree.root.left.right = evos;
        tree.root.left.left.parent = tree.root.left;
        tree.root.left.right.parent = tree.root.left;

        tree.root.right.left = btr;
        tree.root.right.right = tlid;
        tree.root.right.left.parent = tree.root.right;
        tree.root.right.right.parent = tree.root.right;

        while(true){
            header();
            int input = scanner.nextInt();
            System.out.print("\033[H\033[2J");  
            System.out.flush();
            if(input == 1){
                tree.levelOrder();
                System.out.print(">>>");
                String kembali = scanner.next();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }else if(input == 2){
                tree.matchDay();
                System.out.print(">>>");
                String kembali = scanner.next();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }else if(input == 3){
                tree.levelOrderTim();
                System.out.print(">>>");
                String kembali = scanner.next();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }else if(input == 4){
                while(true){
                    System.out.println("Ingin Melihat Player Tim Apa?");
                    tree.levelOrderTim2();
                    System.out.println();
                    System.out.println("Masukan Angka Selain (1-4) Untuk Kembali");
                    System.out.print(">>>");
                    input = scanner.nextInt();
                    System.out.print("\033[H\033[2J");  
                    System.out.flush();
                    if(input == 1){
                        tree.levelOrderPlayer("RRQ");
                        System.out.print(">>>");
                        String kembali = scanner.next();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                    }else if(input == 2){
                        tree.levelOrderPlayer("EVOS");
                        System.out.print(">>>");
                        String kembali = scanner.next();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                    }else if(input == 3){
                        tree.levelOrderPlayer("BTR");
                        System.out.print(">>>");
                        String kembali = scanner.next();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                    }else if(input == 4){
                        tree.levelOrderPlayer("TLID");
                        System.out.print(">>>");
                        String kembali = scanner.next();
                        System.out.print("\033[H\033[2J");  
                        System.out.flush();
                    }else{
                        break;
                    }
                }
            }else if(input == 5){
                tree.bestPlayer();
                System.out.print(">>>");
                String kembali = scanner.next();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }else if(input == 6){
                System.out.print("Cari Nama Player : ");
                String nama = scanner.next();
                System.out.println();
                tree.search(nama);
                String kembali = scanner.next();
                System.out.print("\033[H\033[2J");  
                System.out.flush();
            }
            else{
                System.out.println("===============================================");
                System.out.println("= Terimakasih Telah Menggunakan, Sampai Jumpa =");
                System.out.println("===============================================");
                break;
            }
        }
    }

    public static void header() {
        String header = """
              _________  ___  _________  ________  ________                  
             |\\___   ___\\\\  \\|\\___   ___\\\\   __  \\|\\   ___  \\                
             \\|___ \\  \\_\\ \\  \\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\\\ \\  \\               
                  \\ \\  \\ \\ \\  \\   \\ \\  \\ \\ \\   __  \\ \\  \\\\ \\  \\              
                   \\ \\  \\ \\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\\\ \\  \\             
                    \\ \\__\\ \\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\ \\__\\\\ \\__\\           
                     \\|__|  \\|__|    \\|__|  \\|__|\\|__|\\|__| \\|__|           
                                                                              
                        Sistem Manajemen Turnamen E-Sports                                                                             
                """;
        System.out.println(header);
        System.out.println("=====================================================================================");
        System.out.println("1. Show Bracket");
        System.out.println("2. Start The Match");
        System.out.println("3. Team's Score");
        System.out.println("4. Player Of The Team");
        System.out.println("5. Best Player");
        System.out.println("6. Search Player");
        System.out.println("7. EXIT");
        System.out.print(">>>");
    }
}
