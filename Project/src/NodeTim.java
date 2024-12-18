class NodeTim {
    NodeTim left, right;
    String nama;
    int win, lose;
    ListPlayer headPlayer;

    NodeTim(String nama, ListPlayer player){
        this.nama = nama;
        headPlayer = player;
        left = null;
        right = null;
    }
}