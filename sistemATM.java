import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
        String nama, username, noRek, jenisBayar, pinLama, pinBaru, pinKonfirmasi;
        int rekening, pin, tarik, setor, transfer,bank, ubahPin, nomorAtm;
        char operator, konfirmasi;
        int saldo = 50000000;
        boolean login = false;

        String[] fullNames = new String[10]; // Nama Lengkap Nasabah Baru
        int[] noRekNasabah = new int[10]; // Nomor Rekening
        double[] saldoNasabah = new double[10]; // Saldo Nasabah
        int[] pinNasabah = new int[10]; // PIN Nasabah
        

        fullNames[0] = "M. Arif Fahrudin";
        fullNames[1] = "Naafi Ridho Athallah";
        fullNames[2] = "Nova Diana Ramadhan";

        noRekNasabah[0] = 12345;
        noRekNasabah[1] = 67890;
        noRekNasabah[2] = 12114;

        saldoNasabah[0] = 50.0000;
        saldoNasabah[1] = 70.0000;
        saldoNasabah[2] = 100.000;

        pinNasabah[0] = 1234;
        pinNasabah[1] = 5678;
        pinNasabah[2] = 1216;

        int employeeCount = 3;

        // LOGIN USERNAME DAN PASSWORD
        do {
        System.out.println("========================================");
        System.out.println("         SELAMAT DATANG DI ATM          ");
        System.out.println("========================================");
        System.out.println("Pilih Login\n"
                    + "1. Admin\n"
                    + "2. Nasabah\n"
                    + "Masukkan Pilihan : ");
                    int choice = sc.nextInt();

                    switch (choice) {
                        case 1:
                            System.out.println("========================================");
                            System.out.println("                  ADMIN                 ");
                            System.out.println("========================================");
                            System.out.println(" ");
                            System.out.println(
                                        "---------------------------------------------------------------------------------------------------------------");
                            System.out.printf("%-10s | %-20s | %-20s | %-20s | %-20s%n", 
                            "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                    System.out.println(
                                        "---------------------------------------------------------------------------------------------------------------");
                        for (int i = 0; i < employeeCount; i++) {
                            System.out.printf("%-10d | %-20s | %-20s | %-20s | %-20s%n",
                                    i + 1, fullNames[i], noRekNasabah[i], saldoNasabah[i], pinNasabah[i]);
                        }
                            break;
                        case 2:
                        
                    
                        default:
                            break;
                    }
                                
                    System.out.print("Masukkan Nama Anda\t : ");
                    nama = sc.nextLine();
                    System.out.print("Masukkan Rekening Anda \t : ");
                    rekening = sc.nextInt();
                    System.out.print("Masukkan PIN Anda \t : ");
                    pin = sc.nextInt();

                    if (rekening == 12345678 && pin == 123) {
                    } else {
                        System.out.println("Maaf Username dan Pin Anda Salah");
                    }
            }
            
                    // PILIH TRANSAKSI
                    while (rekening == 12345678 && pin == 123); {
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
                        operator = sc.next().charAt(0);

                        // TARIK TUNAI
                        switch (operator) {
                            case '1' :
                                System.out.println(" ");
                                System.out.println("==========================");
                                System.out.println("      PENARIKAN TUNAI     ");
                                System.out.println("==========================");
                                int [] nominal = {100000, 200000, 300000, 500000, 1000000, 1500000};
                                System.out.println("1. 100.000 \t 4. 500.000 ");
                                System.out.println("2. 200.000 \t 5. 1.000.000");
                                System.out.println("3. 300.000 \t 6. 1.500.000");
                                System.out.println("Pilih Jumlah Penarikan Tunai yang Anda Inginkan: ");
                                tarik = sc.nextInt();
                                saldo = saldo - nominal[tarik-1];
                                System.out.println("    Transaksi Anda Berhasil"   );
                                System.out.println("------------------------------------");
                                System.out.println("Anda Melakukan Tarik Tunai Sebesar " + tarik);
                                System.out.println("Saldo Anda Tersisa Rp." + saldo);
                                System.out.println("------------------------------------");
                                break;

                            case '2':
                            // SETOR TUNAI
                                System.out.println("==========================");
                                System.out.println("        SETOR TUNAI       ");
                                System.out.println("==========================");
                                System.out.println("Saldo Anda adalah Rp." + saldo);
                                System.out.print("Masukkan nominal uang yang Anda setorkan : ");
                                setor = sc.nextInt();
                                saldo = saldo + setor;
                                System.out.println(" ");
                                System.out.println("    Transaksi Anda Berhasil"   );
                                System.out.println("--------------------------------");
                                System.out.println("Anda melakukan setor tunai sebesar Rp." + setor);
                                System.out.println("Jumlah saldo Anda adalah Rp." + saldo);
                                System.out.println("--------------------------------");
                                break;
                            
                            case '3':
                            // CEK SALDO
                                System.out.println("==========================");
                                System.out.println("         CEK SALDO        ");
                                System.out.println("==========================");
                                System.out.println("Nama Nasabah\t: " + nama);
                                System.out.println("Nomor Rekening\t: " + rekening);
                                System.out.println("Saldo     \t: Rp." + saldo);
                                System.out.println(" ");
                                break;

                            case '4':
                            // TRANSFER
                                System.out.println("==========================");
                                System.out.println("          TRANSFER        ");
                                System.out.println("==========================");
                                System.out.println("Masukkan Jumlah Nominal yang Akan Ditransfer: ");
                                transfer = sc.nextInt();

                                System.out.println("\nPilih Bank Tujuan Transfer");
                                String [] Bank = {"Mandiri", "BRI", "BCA", "BNI", "CIMB Niaga"};
                                System.out.println("1. Mandiri");
                                System.out.println("2. BRI");
                                System.out.println("3. BCA");
                                System.out.println("4. BNI");
                                System.out.println("5. CIMB Niaga");
                                System.out.print("Masukkan Pilihan : ");
                                bank = sc.nextInt();

                                System.out.println("\nMasukkan Nomor Rekening Tujuan: ");
                                sc.nextLine();
                                noRek = sc.nextLine();
                                saldo = saldo - transfer;
                                System.out.println("\nTransaksi Anda Berhasil");
                                System.out.println("BANK\t\t: " + Bank[bank-1]);
                                System.out.println("Nomor Rekening\t: " + noRek);
                                System.out.println("Jumlah Transfer\t: " + transfer);
                                break;
                            
                            case '5':
                            // UBAH PIN
                            System.out.println("==========================");
                            System.out.println("         UBAH PIN         ");
                            System.out.println("==========================");

                            System.out.println("Masukkan PIN lama: ");
                            pinLama = sc.nextLine();
                            System.out.println("Masukkan PIN baru: ");
                            pinBaru = sc.nextLine();
                            System.out.println("Konfirmasi PIN baru: ");
                            pinKonfirmasi = sc.nextLine();
                            
                            if (!pinBaru.equals(pinKonfirmasi)) {
                                System.out.println("PIN baru tidak sama dengan konfirmasi pin baru");
                            }
                            System.out.println("PIN berhasil diubah");
                        }
                        System.out.println("Apakah Anda Ingin Melakukan Transaksi Kembali (Y/T)? ");
                        konfirmasi = sc.next().charAt(0);
                        if (konfirmasi == 't' || konfirmasi == 'T') {
                            System.out.println("Terima kasih");
                    }
                }

    }
}
