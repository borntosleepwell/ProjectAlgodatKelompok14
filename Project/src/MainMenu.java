import java.util.Scanner;

public class MainMenu {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int pilihan = 0;

        while (pilihan != 6) {
            tampilkanHeader();
            System.out.println("====== Menu Utama ======");
            System.out.println("1. Tambahkan Tim");
            System.out.println("2. Hapus Tim");
            System.out.println("3. List Tim");
            System.out.println("4. Jadwal Pertandingan");
            System.out.println("5. Bracket List");
            System.out.println("6. Keluar");
            System.out.print("Masukkan Opsi : ");

            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    opsiPertama();
                    break;
                case 2:
                    opsiKedua();
                    break;
                case 3:
                    opsiKetiga();
                    break;
                case 4:
                    opsiKeempat();
                    break;
                case 5:
                    opsiKelima();
                    break;
                case 6:
                    System.out.println("Sampai Jumpa Lagi Pejuang!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }
        input.close();

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
        playerBTR.addPlayer("Super Kenn", "Jungler"); 
        playerBTR.addPlayer("MORENO", "MidLaner"); 
        playerBTR.addPlayer("KYY", "Roamer"); 
        playerBTR.addPlayer("Super Luke", "ExpLaner");
    }

    public static void tampilkanHeader() {

        System.out.println("  _________  ___  _________  ________  ________                  ");
        System.out.println(" |\\___   ___\\\\  \\|\\___   ___\\\\   __  \\|\\   ___  \\                ");
        System.out.println(" \\|___ \\  \\_\\ \\  \\|___ \\  \\_\\ \\  \\|\\  \\ \\  \\\\ \\  \\               ");
        System.out.println("      \\ \\  \\ \\ \\  \\   \\ \\  \\ \\ \\   __  \\ \\  \\\\ \\  \\              ");
        System.out.println("       \\ \\  \\ \\ \\  \\   \\ \\  \\ \\ \\  \\ \\  \\ \\  \\\\ \\  \\             ");
        System.out.println("        \\ \\__\\ \\ \\__\\   \\ \\__\\ \\ \\__\\ \\__\\ \\__\\\\ \\__\\           ");
        System.out.println("         \\|__|  \\|__|    \\|__|  \\|__|\\|__|\\|__| \\|__|           ");
        System.out.println("                                                                  ");
        System.out.println("            Sistem Manajemen Turnamen E-Sports                   ");
        System.out.println("                                                                  ");
    }

    public static void opsiPertama() {
        System.out.println("Anda memilih Opsi Pertama.");
    }
    public static void opsiKedua() {
        System.out.println("Anda memilih Opsi Kedua.");
    }
    public static void opsiKetiga() {
        System.out.println("Anda memilih Opsi Ketiga.");
    }
    public static void opsiKeempat() {
        System.out.println("Anda memilih Opsi Keempat.");
    }
    public static void opsiKelima() {
        System.out.println("Anda memilih Opsi Kelima");
    }
}
