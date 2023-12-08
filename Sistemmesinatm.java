import java.util.Scanner;

public class Sistemmesinatm {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner nc = new Scanner(System.in);
        String lanjut, tambahNasabah, terus;
        int menu, noRekNasabah, pinNasabah;
        int banyakGaris = 90;
        int counter = 3;
        boolean login = false;
        int no = 0;
        int saldo = 0, jaumlahTransfer = 0;

        // array
        String[] arrayNama = new String[10];
        int[] arrayPin = new int[10];
        int[] arrayRekening = new int[10];
        int[] arraySaldo = new int[10];

        arrayNama[0] = "arief";
        arrayRekening[0] = 12345;
        arrayPin[0] = 12345;
        arraySaldo[0] = 3000000;

        arrayNama[1] = "naafi";
        arrayRekening[1] = 67890;
        arrayPin[1] = 67890;
        arraySaldo[1] = 4500000;

        arrayNama[2] = "nova";
        arrayRekening[2] = 111213;
        arrayPin[2] = 111213;
        arraySaldo[2] = 4000000;

        do {
            System.out.println("====================");
            System.out.println("   Selamat Datang   ");
            System.out.println("Menu:\n" + "1. Admin\n" + "2. Data nasabah\n" + "3. nasabah");
            System.out.println("====================");
            menu = sc.nextInt();
            if (menu == 1) {
                System.out.println("Admin");
                for (int i = 0; i <= banyakGaris; i++) {
                    System.out.print("-");
                }
                System.out.println("");
                System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", "no", "nama lengkap", "nomor Rekening",
                        "saldo", "pin");
                for (int i = 0; i <= banyakGaris; i++) {
                    System.out.print("-");
                }
                System.out.println("");
                for (int i = 0; i < counter; i++) {
                    System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", i + 1, arrayNama[i], arrayRekening[i],
                            arraySaldo[i], arraySaldo[i]);
                }
                System.out.println("apakah ingin menambahkan y/n");
                tambahNasabah = nc.nextLine();
                if (tambahNasabah.equalsIgnoreCase("y")) {
                    if (counter < arrayNama.length) {
                        System.out.println("");
                        System.out.println("tambah nasabah baru");
                        System.out.println("masukkan nama lengkap");
                        arrayNama[counter] = nc.nextLine();
                        System.out.println("masukkan nomor rekening");
                        arrayRekening[counter] = sc.nextInt();
                        System.out.println("masukkan pin");
                        arrayPin[counter] = sc.nextInt();
                        System.out.println("masukkan jumlah saldo");
                        arraySaldo[counter] = sc.nextInt();
                        counter++;
                    }

                }

            } else if (menu == 2) {
                for (int i = 0; i <= banyakGaris; i++) {
                    System.out.print("-");
                }
                System.out.println("");
                System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", "no", "nama lengkap", "nomor Rekening",
                        "saldo", "pin");
                for (int i = 0; i <= banyakGaris; i++) {
                    System.out.print("-");
                }
                System.out.println("");
                for (int i = 0; i < counter; i++) {
                    System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", i + 1, arrayNama[i], arrayRekening[i],
                            arraySaldo[i], arrayPin[i]);
                }

            } else if (menu == 3) {
                System.out.println("========================================");
                System.out.println("                  NASABAH               ");
                System.out.println("========================================");
                System.out.print("Masukkan Nomor Rekening Anda: ");
                noRekNasabah = sc.nextInt();
                System.out.print("Masukkan PIN ATM Anda: ");
                pinNasabah = sc.nextInt();
                for (int i = 0; i < arrayRekening.length; i++) {
                    if (noRekNasabah == arrayRekening[i] && pinNasabah == arrayPin[i]) {
                        login = true;
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

                        if (operator == 4) {
                            System.out.println("==========================");
                            System.out.println("          TRANSFER        ");
                            System.out.println("==========================");
                            System.out.println("Masukkan Jumlah Nominal yang Akan Ditransfer: ");
                            int transfer = sc.nextInt();
                            arraySaldo[i] = arraySaldo[i] - transfer;

                            System.out.println("\nPilih Bank Tujuan Transfer");
                            String[] Bank = { "Mandiri", "BRI", "BCA", "BNI", "CIMB Niaga" };
                            System.out.println("1. Mandiri");
                            System.out.println("2. BRI");
                            System.out.println("3. BCA");
                            System.out.println("4. BNI");
                            System.out.println("5. CIMB Niaga");
                            System.out.print("Masukkan Pilihan : ");
                            int bank = sc.nextInt();

                            System.out.println("\nMasukkan Nomor Rekening Tujuan: ");
                            sc.nextLine();
                            int noRek = sc.nextInt();
                            for (int j = 0; j < arrayRekening.length; j++) {
                                if (noRek == arrayRekening[j]) {
                                    arraySaldo[j] = arraySaldo[j] + transfer;
                                    System.out.println("\nTransaksi Anda Berhasil");
                                    System.out.println("BANK\t\t: " + Bank[bank-1]);
                                    System.out.println("Nomor Rekening\t: " + arrayRekening[j]);
                                    System.out.println("Atas Nama\t: " + arrayNama[j]);
                                    System.out.println("Jumlah Transfer\t: " + transfer);
                                    break;

                                }
                            }
                            
                            break;

                        }

                    }
                }
            }

            System.out.println("apakah akan melanjutkan transaksi y/n");
            lanjut = nc.nextLine();

        } while (lanjut.equalsIgnoreCase("y"));

    }
}