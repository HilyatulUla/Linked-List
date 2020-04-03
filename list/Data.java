public class Data {
    private String nama;
    private int jmlhArtikel;
    private Linkedlist judul = new Linkedlist();

    public Data(String nama) {
        this.nama = nama;
        this.jmlhArtikel = 1;
    }

    public String getNama() {
        return nama;
    }

    public int getArtikel() {
        return this.jmlhArtikel;
    }

    public void addArtikel() {
        this.jmlhArtikel++;
    }

    public void addJudul(String artikel){
        judul.add(artikel);
    }

    public void getJudul() {
        Node current = judul.getHead();
        int i = 1;
        while(current != null){
            System.out.println(i+". "+current.getData().getNama());
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
            i++;
        }
    }
}