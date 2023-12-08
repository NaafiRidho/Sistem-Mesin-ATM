import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] usernames = { "admin1", "admin2", "admin3" };
        String[] passwords = { "passadmin1", "passadmin2", "passadmin3" };
        String[] roles = { "admin", "admin", "admin" };

        // nasabah
        String[] fullNames = new String[15]; // nama lengkap nasabah baru
        int[] rekNasabahs = new int[15]; // nomor rekening nasabah baru
        String[] pinNasabahs = new String[15]; // PIN nasabah baru
        int[] saldoNasabahs = new int[15]; // saldo nasabah baru

        fullNames[0] = "M. Arif Fahrudin";
        fullNames[1] = "Naafi Ridho Athallah";
        fullNames[2] = "Nova Diana Ramadhan";

        rekNasabahs[0] = 23417601;
        rekNasabahs[1] = 23417600;
        rekNasabahs[2] = 23417604;

        pinNasabahs[0] = "760192";
        pinNasabahs[1] = "760085";
        pinNasabahs[2] = "760104";

        saldoNasabahs[0] = 500000;
        saldoNasabahs[1] = 7500000;
        saldoNasabahs[2] = 10000000;

        char kembali = 'n';
        char kembali2 = 'n';

        String inputUsername, inputPassword, search;

        boolean isValidCredential = false;

        int customerCount = 3;
        int pilih = 0, pilih1 = 0, pilih2 = 0, pilih3;
        int pilihAdmin = 0;
        int noRekNasabah; 
        String pinNasabah;
        int userID = 0;

        // array mutasi
        int jumlah = 0;
        String[][] jenisFitur = new String[customerCount][10];
        int[][] nominalMutasi = new int[customerCount][10];
        int[] kolomMutasi = new int[customerCount];

        // Login
        do {
            System.out.println("-------------------------------------");
            System.out.println("|       SELAMAT DATANG DI ATM       |");
            System.out.println("-------------------------------------");
            System.out.println("1. Admin");
            System.out.println("2. Nasabah");
            System.out.println("3. Keluar");
            System.out.print("--> ");
            pilih = sc.nextInt();
            sc.nextLine(); // membersihkan new line

            while (pilih > 3) {
                System.out.println("-------------------------------------");
                System.out.println("|       SELAMAT DATANG DI ATM       |");
                System.out.println("-------------------------------------");
                System.out.println("1. Admin");
                System.out.println("2. Nasabah");
                System.out.println("3. Keluar");
                System.out.print("--> ");
                pilih = sc.nextInt();
                sc.nextLine(); // membersihkan new line
            }

            System.out.println("\033[H\033[2J");
            System.out.flush();

            switch (pilih) {
                // ADMIN
                case 1:
                    System.out.println("+------------------------------------+");
                    System.out.print("Masukkan username Anda: ");
                    inputUsername = sc.next();
                    System.out.print("Masukkan password Anda: ");
                    inputPassword = sc.next();
                    System.out.println("+------------------------------------+");

                    for (int i = 0; i < usernames.length; i++) {
                        if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i])) {
                            isValidCredential = true;
                            userID = i;
                            break;
                        }
                    }

                    while (!isValidCredential) {
                        System.out.println("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("------------------------------");
                        System.out.println("\tLogin Gagal !");
                        System.out.println("------------------------------");

                        // login ulang
                        System.out.println();
                        System.out.println("+------------------------------------+");
                        System.out.print("Masukkan username Anda: ");
                        inputUsername = sc.next();
                        System.out.print("Masukkan password Anda: ");
                        inputPassword = sc.next();
                        System.out.println("+------------------------------------+");

                        for (int i = 0; i < usernames.length; i++) {
                            if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i])) {
                                isValidCredential = true;
                                userID = i;
                                break;
                            }
                        }
                    }

                    System.out.println("\033[H\033[2J");
                    System.out.flush();
                    break;

                // NASABAH
                case 2:
                    System.out.print("\033[H\033[2J");
                    System.out.flush();

                    System.out.println("--------------------------------");
                    System.out.println("|           NASABAH            |");
                    System.out.println("--------------------------------");

                    System.out.print("Masukkan nomor rekening Anda: ");
                    noRekNasabah = sc.nextInt();
                    System.out.print("Masukkan PIN ATM Anda: ");
                    pinNasabah = sc.nextLine();
                     pinNasabah = sc.nextLine();
                    for (int i = 0; i < customerCount; i++) {
                        if (noRekNasabah == rekNasabahs[i] && pinNasabah.equals(pinNasabahs[i])) {
                            isValidCredential = true;
                            userID = i;
                        }
                    }

                    if (isValidCredential) {
                        do {
                            System.out.println("\033[H\033[2J");
                            System.out.flush();
                            System.out.println("+------------------------------------------+");
                            System.out.println("Selamat Datang, " + fullNames[userID]);
                            System.out.println("+------------------------------------------+");
                            System.out.println("Silahkan pilih jenis transaksi yang Anda inginkan");
                            System.out.println();
                            System.out.println("||=========================||");
                            System.out.println("||     JENIS TRANSAKSI     ||");
                            System.out.println("||_________________________||");
                            System.out.println("||  1. Penarikan Tunai     ||");
                            System.out.println("||  2. Setor Tunai         ||");
                            System.out.println("||  3. Cek Saldo           ||");
                            System.out.println("||  4. Transfer            ||");
                            System.out.println("||  5. Ubah PIN            ||");
                            System.out.println("||  6. Mutasi Rekening     ||");
                            System.out.println("||=========================||");
                            pilih2 = sc.nextInt();

                            switch (pilih2) {
                                case 1:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println();
                                    System.out.println("            PENARIKAN TUNAI         ");
                                    System.out.println("+----------------------------------+");
                                    int[] nominal = { 100000, 200000, 300000, 500000, 1000000, 1500000 };
                                    System.out.println("1. 100.000 \t 4. 500.000 ");
                                    System.out.println("2. 200.000 \t 5. 1.000.000");
                                    System.out.println("3. 300.000 \t 6. 1.500.000");
                                    System.out.print("Pilih jumlah Penarikan Tunai yang Anda inginkan : ");
                                    int tarik = sc.nextInt();
                                    saldoNasabahs[userID] = saldoNasabahs[userID] - nominal[tarik - 1];
                                    System.out.println();
                                    System.out.println("            TARIK TUNAI             ");
                                    System.out.println();
                                    System.out.println("NAMA          : " + fullNames[userID]);
                                    System.out.println("NO. REKENING  : " + rekNasabahs[userID]);
                                    System.out.println("NOMINAL       : Rp." + nominal[tarik - 1]);
                                    if (nominal[tarik] > saldoNasabahs[userID]) {
                                        System.out.println("Maaf Saldo anda tidak cukup");
                                        
                                    } else {
                                        
                                    
                                    System.out.println("SALDO         : Rp." + saldoNasabahs[userID]);
                                    System.out.println();
                                    System.out.println("----------TRANSAKSI SUKSES----------");
                                    jenisFitur[userID][kolomMutasi[userID]] = "Penarikan Tunai";
                                    nominalMutasi[userID][kolomMutasi[userID]] = nominal[tarik - 1];
                                    kolomMutasi[userID] += 1;
                                    break;
                                } break;

                                case 2:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println(" ");
                                    System.out.println("             SETOR TUNAI            ");
                                    System.out.println("+----------------------------------+");
                                    System.out.print("Masukkan nominal uang yang Anda Setorkan : ");
                                    int setor = sc.nextInt();
                                    sc.nextLine();
                                    if (setor % 50000 == 0) {
                                        if (setor > 0) {
                                            saldoNasabahs[userID] += setor;
                                            System.out.println();
                                            System.out.println("           SETORAN TUNAI            ");
                                            System.out.println(" ");
                                            System.out.println("NO. REKENING    : " + rekNasabahs[userID]);
                                            System.out.println("NAMA            : " + fullNames[userID]);
                                            System.out.println("RINCIAN         : Rp." + setor);
                                            System.out.println("SALDO           : Rp." + saldoNasabahs[userID]);
                                            System.out.println(" ");
                                            System.out.println("----------SETORAN TUNAI BERHASIL----------");
                                            jenisFitur[userID][kolomMutasi[userID]] = "Setor Tunai";
                                            nominalMutasi[userID][kolomMutasi[userID]] = setor;
                                            kolomMutasi[userID] += 1;
                                        } else {
                                            System.out.println("-----------------------------------------------------");
                                            System.out.println("Penyetoran tunai harus kelipatan Rp50.000");
                                        }
                                    }
                                    break;

                                case 3:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println();
                                    System.out.println("              CEK SALDO             ");
                                    System.out.println("+----------------------------------+");
                                    System.out.println("NAMA            : " + fullNames[userID]);
                                    System.out.println("NO. REKENING    : " + rekNasabahs[userID]);
                                    System.out.println("SALDO           : Rp." + saldoNasabahs[userID]);
                                    break;

                                case 4:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println("               TRANSFER             ");
                                    System.out.println("+----------------------------------+");
                                    System.out.print("Masukkan Bank Tujuan Transfer: ");
                                    String bank = sc.next();
                                    sc.nextLine();
                                    System.out.print("Masukkan Nomor Rekening Tujuan: ");
                                    int noRek = sc.nextInt();
                                    System.out.print("Masukkan jumlah nominal yang akan ditransfer : ");
                                    int transfer = sc.nextInt();
                                    saldoNasabahs[userID] = saldoNasabahs[userID] - transfer;

                                    for (int i = 0; i < rekNasabahs.length; i++) {
                                        if (noRek == rekNasabahs[i]) {
                                            saldoNasabahs[i] = saldoNasabahs[i] + transfer;
                                            System.out.println();
                                            System.out.println("                  TRANSFER                  ");
                                            System.out.println();
                                            System.out.println("BANK TUJUAN   : " + bank);
                                            System.out.println("NAMA PENGIRIM : " + fullNames[userID]);
                                            System.out.println("NO. REKENING  : " + rekNasabahs[userID]);
                                            System.out.println("KETERANGAN    : Transfer");
                                            System.out.println("---------------------------------------------");
                                            System.out.println("NAMA PENERIMA : " + fullNames[i]);
                                            System.out.println("REK TUJUAN    : " + rekNasabahs[i]);
                                            System.out.println("JUMLAH        : Rp." + transfer);
                                            System.out.println();
                                            System.out.println("--------------TRANSFER BERHASIL--------------");
                                            jenisFitur[userID][kolomMutasi[userID]] = "Transfer";
                                            nominalMutasi[userID][kolomMutasi[userID]] = transfer;
                                            kolomMutasi[userID] = +1;
                                        }
                                    }
                                    break;

                                case 5:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println();
                                    System.out.println("              UBAH PIN             ");
                                    System.out.println("+----------------------------------+");
                                    System.out.print("Masukkan PIN ATM Lama : ");
                                    int pinLama = sc.nextInt();
                                    System.out.print("Masukkan PIN ATM Baru : ");
                                    String pinBaru = sc.nextLine();
                                    sc.nextLine();
                                    if (pinBaru.length()!=pinNasabahs[userID].length()) {
                                        System.out.println("PIN baru harus 6 digit");
                                    } else if (pinBaru == pinNasabahs[userID]) {
                                        System.out.println("PIN lama dan PIN baru tidak boleh sama");
                                    }
                                    System.out.print("Konfirmasi Pin        : ");
                                    String konfirmasi = sc.nextLine();
                                    if (pinBaru == konfirmasi) {
                                        pinNasabahs[userID] = pinBaru;
                                    } else {
                                        System.out.println("Maaf, PIN yang Anda masukkan tidak sesuai");
                                    }
                                    System.out.println("---------------------------------------------");
                                    System.out.println("PENGGANTIAN PIN BERHASIL !");
                                    System.out.println("PIN ATM berhasil diganti menjadi " + pinBaru);
                                    System.out.println("---------------------------------------------");
                                    break;

                                case 6:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println();
                                    System.out.println("            MUTASI REKENING             ");
                                    System.out.println("+--------------------------------------+");
                                    for (int i = 0; i < 50; i++) {
                                        System.out.print("-");
                                    }
                                    System.out.println();
                                    System.out.printf("%-5s | %-20s | %-20s%n", "no", "jenis Transaksi",
                                            "nominal transaksi");
                                    for (int i = 0; i < 50; i++) {
                                        System.out.print("-");
                                    }
                                    System.out.println();
                                    for (int i = userID; i <= userID; i++) {

                                        for (int j = 0; j < kolomMutasi[i]; j++) {
                                            System.out.printf("%-5d | %-20s | %-20s%n", j + 1, jenisFitur[i][j],
                                                    nominalMutasi[i][j]);
                                        }

                                    }
                                    break;
                                case 7:
                                    System.out.println("");
                                    break;

                            }
                            if (pilih2 == 7) {
                                break;
                            } else {
                                System.out.println();
                                System.out.println("Apakah Anda ingin kembali ke menu utama? (y/n)");
                                kembali2 = sc.next().charAt(0);
                            }
                        } while (kembali2 == 'y' || kembali2 == 'Y');
                    }
                    // KELUAR
                case 3:
                    return;
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // ADMIN
            if (userID != -1) {
                String role = roles[userID];
                if (role.equals("admin")) {
                    do {
                        System.out.println("1. Data Nasabah");
                        System.out.println("2. Tambah Nasabah");
                        System.out.println("3. Pencarian Nasabah");
                        System.out.println("4. Keluar");
                        System.out.print("--> ");
                        pilih1 = sc.nextInt();

                        switch (pilih1) {
                            // data nasabah
                            case 1:
                                System.out.println("Data Nasabah ");
                                headerTabel();
                                // System.out.println(
                                // "---------------------------------------------------------------------------------------------------------------");
                                // System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n",
                                // "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                System.out.println(
                                        "---------------------------------------------------------------------------------------------------------------");
                                for (int i = 0; i < customerCount; i++) {
                                    System.out.printf("%-5d | %-25s | %-20s | %-20s | %-10s%n",
                                            i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
                                }
                                break;

                            // tambah nasabah
                            case 2:
                                if (customerCount < fullNames.length) {
                                    sc.nextLine(); // membersihkan new line
                                    System.out.println("        TAMBAH NASABAH BARU        ");
                                    System.out.println("+---------------------------------+");
                                    System.out.print("Nama Lengkap   : ");
                                    fullNames[customerCount] = sc.nextLine();
                                    System.out.print("Nomor Rekening : ");
                                    rekNasabahs[customerCount] = sc.nextInt();
                                    System.out.print("PIN            : ");
                                    pinNasabahs[customerCount] = sc.nextLine();
                                    System.out.print("Saldo          : ");
                                    saldoNasabahs[customerCount] = sc.nextInt();

                                    customerCount++;

                                } else {
                                    System.out.println("Batas maksimum nasabah baru telah tercapai");
                                }
                                break;

                            case 3:
                                sc.nextLine(); // membersihkan newline
                                boolean found = false;
                                System.out.print("Masukkan nama nasabah yang dicari: ");
                                System.out.println();
                                search = sc.nextLine();
                                for (int i = 0; i < customerCount; i++) {
                                    if (fullNames[i].toLowerCase().contains(search.toLowerCase())) {

                                        System.out.println("Data nasabah dengan nama yang dicari: ");
                                        System.out.println();
                                        headerTabel();
                                        System.out.println(
                                                "---------------------------------------------------------------------------------------------------------------");
                                        System.out.printf("%-5d | %-25s | %-20s | %-20s | %-10s%n",
                                                i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
                                        found = true;
                                    }
                                }
                                if (!found) {
                                    System.out.println("Data tidak ditemukan");
                                }
                                break;

                            case 4:
                                System.out.println("");
                                break;

                            default:
                                System.out.println("Pilihan tidak valid. Silahkan memilih lagi");
                                break;
                        }
                        if (pilih1 == 4) {
                            break;
                        } else {
                            System.out.println();
                            System.out.println("Apakah Anda ingin kembali ke menu utama? (y/n)");
                            kembali = sc.next().charAt(0);
                        }
                    } while (kembali == 'y' || kembali == 'Y');
                }
            }
            System.out.println();

        } while (pilih != 3 || pilih1 == 4 || pilih2 == 7);

    }

    static void headerTabel() {
        System.out.println(
                "---------------------------------------------------------------------------------------------------------------");
        System.out.printf("%-10s | %-25s | %-20s | %-20s | %-10s%n",
                "Urutan", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");

    }
}
