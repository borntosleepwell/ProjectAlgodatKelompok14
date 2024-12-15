class NodePlayer {
    NodePlayer next;
    String nama;
    String role;
    int kill;
    int death;
    int assist;

    // Constructor
    NodePlayer(String nama, String role) {
        this.nama = nama;
        this.role = role;
        this.next = null;
        this.kill = generateKill(nama, role);
        this.death = generateDeath(nama);
        this.assist = generateAssist(this.kill, this.death);
    }
    // Kill didapat dari panjang nama dan role dikali lalu di moduluskan
    private int generateKill(String nama, String role) {
        int totalLength = nama.length() * role.length();
        return (totalLength % 10) + 1; 
    }

    // Nilai dari Death didapat dari jumlah ascii nama
    private int generateDeath(String nama) {
        int asciiSum = 0;
        for (int i = 0; i < nama.length(); i++) {
            asciiSum += nama.charAt(i);
        }
        return (asciiSum % 10) + 1;
    }

    //nilai assist didapat dari kill dan death
    private int generateAssist(int kill, int death) {
        int assist = (kill * death) % 10;
        return assist == 0 ? 1 : assist;
    }

    // K/D/A didapat dari match yang telah dimainkan
    public void updateKDA(int matchesPlayed, boolean isWin) {
        // Update kill
        int updatedKill = this.kill + matchesPlayed;
        while (updatedKill > 10) {
            updatedKill -= 10;
        }
        this.kill = (updatedKill == 0) ? 1 : updatedKill;

        // Update death
        if (isWin) {
            this.death = (this.death > 1) ? this.death - 1 : 1;
        } else {
            int updatedDeath = this.death + matchesPlayed;
            while (updatedDeath > 10) {
                updatedDeath -= 10;
            }
            this.death = (updatedDeath == 0) ? 1 : updatedDeath;
        }

        // Update assist: berdasarkan kill dan death
        this.assist = generateAssist(this.kill, this.death);
    }
    // Print player data
    public void printPlayerData() {
        System.out.println("Nama: " + nama);
        System.out.println("Role: " + role);
        System.out.println("Kill: " + kill);
        System.out.println("Death: " + death);
        System.out.println("Assist: " + assist);
    }

    // Sorting by Insertion
    public static NodePlayer sortPlayers(NodePlayer head) {
        if (head == null || head.next == null) return head;

        NodePlayer sorted = null;

        while (head != null) {
            NodePlayer current = head;
            head = head.next;

            if (sorted == null || getTotalKDA(current) >= getTotalKDA(sorted)) {
                current.next = sorted;
                sorted = current;
            } else {
                NodePlayer temp = sorted;
                while (temp.next != null && getTotalKDA(current) < getTotalKDA(temp.next)) {
                    temp = temp.next;
                }
                current.next = temp.next;
                temp.next = current;
            }
        }

        return sorted;
    }

    // Rumus menghitung K/D/A
    private static int getTotalKDA(NodePlayer player) {
        return player.kill + player.assist - player.death;
    }
}
