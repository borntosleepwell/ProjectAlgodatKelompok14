class NodeTim {
    NodeTim left, right, parent;
    String nama;
    int win, lose;
    boolean play;
    ListPlayer headPlayer;

    NodeTim(String nama, ListPlayer player){
        this.nama = nama;
        headPlayer = player;
        play = true;
        left = null;
        right = null;
    }
}