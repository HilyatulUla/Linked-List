import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Linkedlist ll = new Linkedlist();
        Scanner inp = new Scanner(System.in);

        try {
            File file = new File("../TugasLab/namafile.txt");
            Scanner read = new Scanner(file);

            while (read.hasNextLine()) {
                String data = read.nextLine();
                String[] splitter = data.split(":");
                ll.add(splitter[0]);

                if(ll.cari(splitter[0]) != null){
                    ll.cari(splitter[0]).getData().addJudul(splitter[1]);
                }
            }
            read.close();
        } catch (Exception e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // Output dari Program
        ll.sortingbyBubble();
        while (true) {
            System.out.print("\n--------LinkedList Program--------\n\n 1. Lihat semua data penulis\n 2. Cari nama penulis\n 3. Cari artikel \nMasukkan Pilihan : ");
            int pilihan = Integer.parseInt(inp.nextLine());
            
            if (pilihan == 1) {
                ll.display();
                System.out.println("");
            } 
            else if (pilihan == 2) {
                System.out.print("Masukkan nama penulis : ");
                String penulis = inp.nextLine();
                System.out.println("     ");
                ll.searchContainsEditor(penulis);
            }
            else if (pilihan == 3) {
                System.out.print("Input nama editor : ");
                String penulis = inp.nextLine();
                System.out.println("");
                ll.fetchAllData(penulis); 
            }
            else {
                System.out.println("Pilihan tidak sesuai\n");
            }

            while(true){
                System.out.print("Lanjutkan? \n\n1. Ya\n2. Tidak \nPilihan anda : ");
                int choise = Integer.parseInt(inp.nextLine());
                if (choise == 1){
                    choise = pilihan;
                    break;
                }
                else if (choise == 2) {
                    System.exit(1);
                }
            }
        }
    }
}