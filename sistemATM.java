import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        
        char kembali;

         // Data Login Nasabah
         int[]arrayRek = {12345, 67890, 12114, 12164};
         int[]arrayPIN = {1234, 5678, 1216, 1204};
         boolean login = false;
 
         // Tabel Admin
         String[] fullNameb = new String[10]; // Nama Lengkap Nasabah Baru
         int[] RekNasabahb = new int[10]; // Nomor Rekening Nasabah Baru
         int[] saldoNasabahb = new int[10]; // Saldo Nasabah Baru
         int[] pinNasabahb = new int[10]; // PIN Nasabah Baru
         
         fullNameb[0] = "M. Arif Fahrudin";
         fullNameb[1] = "Naafi Ridho Athallah";
         fullNameb[2] = "Nova Diana Ramadhan";
 
         RekNasabahb[0] = 12345;
         RekNasabahb[1] = 67890;
         RekNasabahb[2] = 12114;

         saldoNasabahb[0] = 500000;
         saldoNasabahb[1] = 750000;
         saldoNasabahb[2] = 1000000;

         pinNasabahb[0] = 1234;
         pinNasabahb[1] = 5678;
         pinNasabahb[2] = 1216;

        int employeeCount = 3;

        // LOGIN
        do {
            System.out.println("====================================");
            System.out.println("        SELAMAT DATANG DI ATM"       );
            System.out.println("====================================");
            System.out.print("MENU\n"
                    + "1. Admin\n"
                    + "2. Data Nasabah\n"
                    + "3. Nasabah\n"
                    + "Masukkan Pilihan : ");
                    int pilihan = sc.nextInt();

                    switch (pilihan) {
                        case 1:
                            // data nasabah
                            System.out.println("                                        ADMIN                                                           ");
                            System.out.println(" ");
                            System.out.println(
                                        "---------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", 
                            "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                    System.out.println(
                                        "---------------------------------------------------------------------------------------------------------------");
                           for (int i = 0; i < employeeCount; i++) {
                            System.out.printf("%-5d | %-25s | %-20s | %-20s | %-10s%n",
                                    i + 1, fullNameb[i], RekNasabahb[i], saldoNasabahb[i], pinNasabahb[i]);
                                
                            }
                            // tambah nasabah baru
                            System.out.println(" ");
                            System.out.println("Apakah Ingin Menambah Nasabah Baru? (y/n): ");
                            String choice = sc.next();
                            // sc.next();
                            if (choice.equalsIgnoreCase("y")) {
                                if (employeeCount < fullNameb.length) {
                                    sc.nextLine(); // Membersihkan newline
                                    System.out.println(" ");
                                    System.out.println("     TAMBAH NASABAH BARU"    );
                                    System.out.println("+--------------------------+");
                                    System.out.print("Nama Lengkap   : ");
                                    fullNameb[employeeCount] = sc.nextLine();
                                    System.out.print("Nomor Rekening : ");
                                    RekNasabahb[employeeCount] = sc.nextInt();
                                    System.out.print("Saldo          : ");
                                    saldoNasabahb[employeeCount] = sc.nextInt();
                                    System.out.print("PIN            : ");
                                    pinNasabahb[employeeCount] = sc.nextInt();
                                    employeeCount++; 
                                } 
                                else {
                                    System.out.println("Batas maksimum nasabah baru telah tercapai");
                                } 
                            } 
                            break;

                        case 2:
                           // menampilkan data nasabah
                            System.out.println("========================================        ADMIN       ========================================");
                            System.out.println(" ");
                            System.out.println(
                                        "------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", 
                            "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                    System.out.println(
                                        "------------------------------------------------------------------------------------------------------------");
                           for (int i = 0; i < employeeCount; i++) {
                            System.out.printf("%-5d | %-25s | %-20s | %-20s | %-10s%n",
                                    i + 1, fullNameb[i], RekNasabahb[i], saldoNasabahb[i], pinNasabahb[i]);
                           }
                            break;

                        case 3:
                           // login nasabah
                            System.out.println("========================================");
                            System.out.println("                  NASABAH               ");
                            System.out.println("========================================");
                            System.out.print("Masukkan Nomor Rekening Anda: ");
                            int noRekNasabah = sc.nextInt();
                            System.out.print("Masukkan PIN ATM Anda: ");
                            int pinNasabah = sc.nextInt(); 
                                for (int i = 0; i < 3; i++) {
                                    if (noRekNasabah == arrayRek[i] && pinNasabah == arrayPIN[i]) {
                                        login = true;
                                    }
                                }
                                if (login == true) {
                                    System.out.println(" ");
                                    System.out.println("   PILIH JENIS TRANSAKSI");   
                                    System.out.println("---------------------------");
                                    System.out.print("\n"
                                            + "1. Penarikan Tunai\n"
                                            + "2. Setor Tunai\n"
                                            + "3. Cek Saldo\n"
                                            + "4. Transfer\n"
                                            + "5. Ubah Pin\n"
                                            + "6. Mutasi Rekening\n"
                                            + "Masukkan Pilihan : ");
                                            int operator = sc.nextInt();
                                        switch (operator) {
                                            case 1:
                                                System.out.println(" ");
                                                System.out.println("==========================");
                                                System.out.println("      PENARIKAN TUNAI     ");
                                                System.out.println("=========================="); 
                                                int [] nominal = {100000, 200000, 300000, 500000, 1000000, 1500000};
                                                System.out.println("1. 100.000 \t 4. 500.000 ");
                                                System.out.println("2. 200.000 \t 5. 1.000.000");
                                                System.out.println("3. 300.000 \t 6. 1.500.000");
                                                System.out.print("Pilih Jumlah Penarikan Tunai yang Anda Inginkan: ");
                                                int tarik = sc.nextInt();
                                                saldoNasabahb[employeeCount-1] = saldoNasabahb[employeeCount-1] - nominal[tarik-1];
                                                System.out.println(" ");
                                                System.out.println("        Transaksi Anda Berhasil     ");
                                                System.out.println("------------------------------------");
                                                System.out.println("Anda Melakukan Tarik Tunai Sebesar Rp. " + nominal[tarik-1]);
                                                System.out.println("Saldo Anda Tersisa Rp. " + saldoNasabahb[employeeCount-1]);
                                                System.out.println("------------------------------------");
                                                break;
                                            case 2:
                                                // SETOR TUNAI
                                                System.out.println("==========================");
                                                System.out.println("        SETOR TUNAI       ");
                                                System.out.println("==========================");
                                                System.out.println("Saldo Anda adalah Rp." + saldoNasabahb[employeeCount-1]);
                                                System.out.print("Masukkan nominal uang yang Anda setorkan : ");
                                                int setor = sc.nextInt();
                                                saldoNasabahb[employeeCount-1] = saldoNasabahb[employeeCount-1] + setor;
                                                System.out.println(" ");
                                                System.out.println("    Transaksi Anda Berhasil"   );
                                                System.out.println("--------------------------------");
                                                System.out.println("Anda melakukan setor tunai sebesar Rp." + setor);
                                                System.out.println("Jumlah saldo Anda adalah Rp." + saldoNasabahb[employeeCount-1]);
                                                System.out.println("--------------------------------");
                                                break;
                                            case 3:
                                                // CEK SALDO
                                                System.out.println("==========================");
                                                System.out.println("         CEK SALDO        ");
                                                System.out.println("==========================");
                                                System.out.println("Nama Nasabah\t: " + fullNameb[employeeCount-1]);
                                                System.out.println("Nomor Rekening\t: " + RekNasabahb[employeeCount-1]);
                                                System.out.println("Saldo     \t: Rp." + saldoNasabahb[employeeCount-1]);
                                                System.out.println(" ");
                                                break;
                                            case 4:
                                                // TRANSFER
                                                System.out.println("==========================");
                                                System.out.println("          TRANSFER        ");
                                                System.out.println("==========================");
                                                System.out.println("Masukkan Jumlah Nominal yang Akan Ditransfer: ");
                                                int transfer = sc.nextInt();

                                                System.out.println("\nPilih Bank Tujuan Transfer");
                                                String [] Bank = {"Mandiri", "BRI", "BCA", "BNI", "CIMB Niaga"};
                                                System.out.println("1. Mandiri");
                                                System.out.println("2. BRI");
                                                System.out.println("3. BCA");
                                                System.out.println("4. BNI");
                                                System.out.println("5. CIMB Niaga");
                                                System.out.print("Masukkan Pilihan : ");
                                                int bank = sc.nextInt();

                                                System.out.println("\nMasukkan Nomor Rekening Tujuan: ");
                                                sc.nextLine();
                                                String noRek = sc.nextLine();
                                                saldoNasabahb[employeeCount-1] = saldoNasabahb[employeeCount-1] + transfer;
                                                System.out.println("\nTransaksi Anda Berhasil");
                                                System.out.println("BANK\t\t: " + Bank[bank-1]);
                                                System.out.println("Nomor Rekening\t: " + RekNasabahb[employeeCount-1]);
                                                System.out.println("Atas Nama\t: " + fullNameb[employeeCount-1]);
                                                System.out.println("Jumlah Transfer\t: " + transfer);

                                                case 5 :
                                                

                                                break;
                                            default:
                                                break;
                                        }
                                        
                                } else {
                                    System.out.println("Maaf, Nomor Rekening dan PIN Anda Salah");
                                }
                                break;
                        }
                        System.out.println(" ");
                        System.out.println("Apakah ingin kembali ke menu utama? (y/n)");
                        kembali = sc.next().charAt(0);
            } while (kembali == 'y' || kembali == 'Y');


    }
}
