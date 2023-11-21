import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        char kembali; 
        boolean isValidCredential = false;

        // Tabel Admin
        String[] fullNames = new String[15]; // nama lengkap nasabah baru
        int[] rekNasabahs = new int[15]; // nomor rekening nasabah baru
        int[] pinNasabahs = new int[15]; // PIN nasabah baru 
        int[] saldoNasabahs = new int[15]; // saldo nasabah baru

        fullNames[0] = "M. Arif Fahrudin";
        fullNames[1] = "Naafi Ridho Athallah";
        fullNames[2] = "Nova Diana Ramadhan";

        rekNasabahs[0] = 12345;
        rekNasabahs[1] = 67890;
        rekNasabahs[2] = 12114;

        pinNasabahs[0] = 1234;
        pinNasabahs[1] = 6789;
        pinNasabahs[2] = 1211;

        saldoNasabahs[0] = 5000000;
        saldoNasabahs[1] = 7500000;
        saldoNasabahs[2] = 10000000;

        int employeeCount = 3;
        
        // Nasabah
        int noRekNasabah, pinNasabah;
        int userID = 0;

    }
}
