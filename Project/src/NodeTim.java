class NodeTim {
    NodeTim next;
    String nama;
    ListPlayer headPlayer;

    NodeTim(String nama, ListPlayer player){
        this.nama = nama;
        headPlayer = player;
        this.next = null;
    }
}