public class NodePlayer {
    NodePlayer next;
    String nama, role;
    int kill, death, assist;

    NodePlayer(String nama, String role){
        this.nama = nama;
        this.role = role;
        next = null;
    }
}
