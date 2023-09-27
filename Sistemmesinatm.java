import java.util.Scanner;

public class Sistemmesinatm{
    public static void main (String[]args){

        Scanner sc = new Scanner(System.in);
        char kartuAtm;
        double tabunganAwal, pin, penarikanUang, penambahanUang, tabunganAkhir;
        
        System.out.println("Masukkan kartu");
        String tmp = sc.nextLine();
        kartuAtm = tmp.charAt(0);
        System.out.println("Masukkan pin");
        pin = sc.nextDouble();
        System.out.println("masukkan tabungan awal");
        tabunganAwal = sc.nextDouble();
        System.out.println("penarikan uang");
        penarikanUang = sc.nextDouble();
        System.out.println("penambahan uang");
        penambahanUang = sc.nextDouble();
        
        tabunganAkhir = tabunganAwal- penarikanUang+ penambahanUang;
        System.out.print(tabunganAkhir); 
    
    
    }
}