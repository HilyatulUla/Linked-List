public class Linkedlist {
    private Node head;
    private int size;

    public Linkedlist() {
        this.head = null;
        this.size = 0;
    }

    public void setHead(Node head) {
        this.head = head;
        this.incSize();
    }

    public int getSize() {
        return this.size;
    }

    public void incSize() {
        this.size++;
    }

    public void decSize() {
        this.size--;
    }

    public Node getHead() {
        return this.head;
    }

    public void sortingbyBubble() {
        if (size > 1) {
            boolean wasChanged;

            do {
                Node current = head;
                Node previous = null;
                Node next = head.getNext();
                wasChanged = false;

                while (next != null) {
                    if (current.getData().getNama().toLowerCase().compareTo(next.getData().getNama().toLowerCase()) > 0) {
                        wasChanged = true;

                        if (previous != null) {
                            Node sig = next.getNext();

                            previous.setNext(next);
                            next.setNext(current);
                            current.setNext(sig);
                        } else {
                            Node sig = next.getNext();

                            head = next;
                            next.setNext(current);
                            current.setNext(sig);
                        }

                        previous = next;
                        next = current.getNext();
                    } else {
                        previous = current;
                        current = next;
                        next = next.getNext();
                    }
                }
            } while (wasChanged);
        }
    
    }

    public void searchContainsEditor(String penulis){
        Node current = this.getHead();

        while(current != null){
            if(current.getData().getNama().contains(penulis)){
                System.out.println(current.getData().getNama() + " ditemukan dengan total artikel yang di edit adalah " + current.getData().getArtikel() + ".");
            }
            if(current.getNext() == null){
                break;
            }
            current = current.getNext();
        }
    }

    public Node cari(String penulis) {
        Node current = this.getHead();

        while (current != null) {
            if (current.getData().getNama().equalsIgnoreCase(penulis))
                return current;
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
        return null;
    }

    public String fetchData(String penulis) {
        Node isFound = this.cari(penulis);

        if (isFound != null) {
            return "Data " + isFound.getData().getNama()+ 
            " ditemukan dengan "+isFound.getData().getArtikel()
            + " artikel.";
        } else {
            return "Nama " + penulis + " tidak ditemukan.";
        }
    }

    public void fetchAllData(String penulis){
        Node isFound = this.cari(penulis);
        if(isFound != null){
            System.out.println(isFound.getData().getNama() + " mengedit " + isFound.getData().getArtikel() + " artikel.");
            isFound.getData().getJudul();
        }else{
            System.out.println("Data " + penulis + " tidak ditemukan.");
        }
    }

    public void add(String penulis) {
        Node isFound = this.cari(penulis);

        if (isFound == null) {
            this.setHead(new Node(new Data(penulis),
            this.getHead()));
        } else {
            isFound.getData().addArtikel();
        }
    }

    public void display() {
        Node current = this.getHead();
        while (current != null) {
            System.out.println(current.getData().getNama()
            + " -------> " + current.getData().getArtikel() 
            + " artikel");
            if (current.getNext() == null)
                break;
            current = current.getNext();
        }
    }
}
