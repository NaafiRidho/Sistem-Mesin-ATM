import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        char kembali; 

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

        // menu login
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
                        System.out.println("                                             ADMIN                                                      ");
                        System.out.println(" ");
                        System.out.println(
                                    "---------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", 
                        "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                System.out.println(
                                    "---------------------------------------------------------------------------------------------------------------");
                       for (int i = 0; i < employeeCount; i++) {
                        System.out.printf("%-5d | %-25s | %-20s | %-20s | %-10s%n",
                                i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
                        }
                        // tambah nasabah baru
                        System.out.println(" ");
                        System.out.println("Apakah Anda ingin menambah nasabah baru? (y/n): ");
                        String choice = sc.next();

                        if (choice.equalsIgnoreCase("y")) {
                            if (employeeCount < fullNames.length) {
                                sc.nextLine(); // membersihkan new line
                                System.out.println("        TAMBAH NASABAH BARU        ");
                                System.out.println("+---------------------------------+");
                                System.out.print("Nama Lengkap   : ");
                                fullNames[employeeCount] = sc.nextLine();
                                System.out.print("Nomor Rekening : ");
                                rekNasabahs[employeeCount] = sc.nextInt();
                                System.out.print("PIN            : ");
                                pinNasabahs[employeeCount] = sc.nextInt();
                                System.out.print("Saldo          : ");
                                saldoNasabahs[employeeCount] = sc.nextInt();

                                employeeCount++;
                            } else {
                                System.out.println("Batas maksimum nasabah baru telah tercapai");
                            }
                        }
                        break;

                    case 2 :
                    // menampilkan data nasabah
                        System.out.println("                                        DATA NASABAH                                                    ");
                        System.out.println(" ");
                        System.out.println(
                                    "---------------------------------------------------------------------------------------------------------------");
                        System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", 
                        "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                System.out.println(
                                    "---------------------------------------------------------------------------------------------------------------");
                       for (int i = 0; i < employeeCount; i++) {
                        System.out.printf("%-5d | %-25s | %-20s | %-20s | %-10s%n",
                                i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
                        }
                        break;

                    case 3 :
                    // login nasabah
                    System.out.println("=======================     NASABAH     =======================");
                    System.out.print("Masukkan Nomor Rekening Anda : ");
                    noRekNasabah = sc.nextInt();
                    System.out.print("Masukkan PIN ATM Anda : ");
                    pinNasabah = sc.nextInt();
                    boolean isValidCredential = false;

                    for (int i = 0; i < employeeCount; i++) {
                        if (noRekNasabah == rekNasabahs[i] && pinNasabah == pinNasabahs[i]) {
                            isValidCredential = true;
                            userID = i;
                        }
                    }

                    if (isValidCredential) {
                        System.out.println(" ");
                        System.out.println("Hai" + " " + fullNames[userID] + "!" + "\n" + "Selamat Datang di ATM");
                        System.out.println(" ");
                        System.out.println("Silahkan pilih jenis transaksi yang Anda inginkan");
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
                                // TARIK TUNAI
                                    System.out.println(" ");
                                    System.out.println("            PENARIKAN TUNAI         ");
                                    System.out.println("+----------------------------------+");
                                    int [] nominal = {100000, 200000, 300000, 500000, 1000000, 1500000};
                                    System.out.println("1. 100.000 \t 4. 500.000 ");
                                    System.out.println("2. 200.000 \t 5. 1.000.000");
                                    System.out.println("3. 300.000 \t 6. 1.500.000");
                                    System.out.print("Pilih jumlah Penarikan Tunai yang Anda inginkan : ");
                                    int tarik = sc.nextInt();
                                    saldoNasabahs[userID] = saldoNasabahs[userID] - nominal[tarik-1];
                                    System.out.println(" ");
                                    System.out.println("            TARIK TUNAI             ");
                                    System.out.println(" ");
                                    System.out.println("JUMLAH  : Rp." + nominal[tarik-1]);
                                    System.out.println("SALDO   : Rp." + saldoNasabahs[userID]);
                                    System.out.println(" ");
                                    System.out.println("----------TRANSAKSI SUKSES----------");
                                    break;
                                case 2:
                                // SETOR TUNAI
                                    System.out.println("==========================");
                                    System.out.println("        SETOR TUNAI       ");
                                    System.out.println("==========================");
                                    System.out.println("Saldo Anda adalah Rp." + saldoNasabahs[userID]);
                                    System.out.print("Masukkan nominal uang yang Anda setorkan : ");
                                    int setor = sc.nextInt();
                                    saldoNasabahs[userID] = saldoNasabahs[userID] + setor;
                                    System.out.println(" ");
                                    System.out.println("    Transaksi Anda Berhasil"   );
                                    System.out.println("--------------------------------");
                                    System.out.println("Anda melakukan setor tunai sebesar Rp." + setor);
                                    System.out.println("Jumlah saldo Anda adalah Rp." + saldoNasabahs[userID]);
                                    System.out.println("--------------------------------");
                                    break;
                                case 3:
                                    // CEK SALDO
                                    System.out.println("==========================");
                                    System.out.println("         CEK SALDO        ");
                                    System.out.println("==========================");
                                    System.out.println("Nama Nasabah\t: " + fullNames[userID]);
                                    System.out.println("Nomor Rekening\t: " + rekNasabahs[userID]);
                                    System.out.println("Saldo     \t: Rp." + saldoNasabahs[userID]);
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
                                    saldoNasabahs[userID] = saldoNasabahs[employeeCount-1] + transfer;
                                    System.out.println("\nTransaksi Anda Berhasil");
                                    System.out.println("BANK\t\t: " + Bank[bank-1]);
                                    System.out.println("Nomor Rekening\t: " + rekNasabahs[userID]);
                                    System.out.println("Atas Nama\t: " + fullNames[userID]);
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
