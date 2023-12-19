import java.util.Scanner;

public class sistemATM {
    static boolean isLogin = false;
    static boolean isValidCredential = false;
    static boolean found = false;
    static int customerCount = 3;
    static int userID = 0;
    static int pencarian = 0;

    // nasabah
    static int[] rekNasabahs = new int[15]; // nomor rekening nasabah baru
    static int[] pinNasabahs = new int[15]; // PIN nasabah baru
    static String[] fullNames = new String[15]; // nama lengkap nasabah baru
    static int[] saldoNasabahs = new int[15]; // saldo nasabah baru

    public static void login(String[] usernames, String[] passwords, int pilih) {
        Scanner sc = new Scanner(System.in);

        if (pilih == 1) {
            System.out.println("+------------------------------------+");
            System.out.print("Masukkan Username : ");
            String inputUsername = sc.next();
            System.out.print("Masukkan Password : ");
            String inputPassword = sc.next();
            System.out.println("+------------------------------------+");

            for (int i = 0; i < usernames.length; i++) {
                if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i])) {
                    isLogin = true;
                    break;
                }
            }

            while (!isLogin) {
                System.out.println("\033[H\033[2J");
                System.out.flush();

                System.out.println("------------------------------");
                System.out.println("\tLogin Gagal !");
                System.out.println("------------------------------");

                // login ulang
                System.out.println();
                System.out.println("+------------------------------------+");
                System.out.print("Masukkan Username : ");
                inputUsername = sc.next();
                System.out.print("Masukkan Password : ");
                inputPassword = sc.next();
                System.out.println("+------------------------------------+");

                for (int i = 0; i < usernames.length; i++) {
                    if (inputUsername.equals(usernames[i]) && inputPassword.equals(passwords[i])) {
                        isLogin = true;
                        userID = i;
                        break;
                    }
                }
            }

            System.out.println("\033[H\033[2J");
            System.out.flush();

        }
        if (pilih == 2) {
            System.out.print("\033[H\033[2J");
            System.out.flush();

            System.out.println("------------------------------------------");
            System.out.println("|                NASABAH                 |");
            System.out.println("------------------------------------------");
            System.out.print("Masukkan Nomor Rekening : ");
            int noRekNasabah = sc.nextInt();
            System.out.print("Masukkan PIN ATM        : ");
            int pinNasabah = sc.nextInt();
            for (int i = 0; i < customerCount; i++) {
                if (noRekNasabah == rekNasabahs[i] && pinNasabah == pinNasabahs[i]) {
                    isValidCredential = true;
                    userID = i;
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // admin
        String[] usernames = { "admin1", "admin2", "admin3" };
        String[] passwords = { "passadmin1", "passadmin2", "passadmin3" };

        fullNames[0] = "M. Arif Fahrudin";
        fullNames[1] = "Naafi Ridho Athallah";
        fullNames[2] = "Nova Diana Ramadhan";

        rekNasabahs[0] = 23417601;
        rekNasabahs[1] = 23417600;
        rekNasabahs[2] = 23417604;

        pinNasabahs[0] = 760192;
        pinNasabahs[1] = 760085;
        pinNasabahs[2] = 760104;

        saldoNasabahs[0] = 1250000;
        saldoNasabahs[1] = 750000;
        saldoNasabahs[2] = 1000000;

        // array mutasi
        int jumlah = 0;
        String[][] jenisFitur = new String[15][10];
        int[][] nominalMutasi = new int[15][10];
        char[][] charMutasi = new char[15][10];
        int[] kolomMutasi = new int[10];

        char kembali = 'n';
        char kembali2 = 'n';

        int pinKonfirmasi = 'n';
        int pilih = 0, pilih1 = 0, pilih2, pilih3;
        int pilihAdmin = 0;

        // Login
        do {
            System.out.print("\033[H\033[2J");
            System.out.flush();

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
                System.out.print("\033[H\033[2J");
                System.out.flush();

                System.out.println("-------------------------------------");
                System.out.println("|       SELAMAT DATANG DI ATM       |");
                System.out.println("-------------------------------------");
                System.out.println("1. Admin");
                System.out.println("2. Nasabah");
                System.out.println("3. Keluar");
                System.out.print("--> ");
            }

            System.out.println("\033[H\033[2J");
            System.out.flush();

            switch (pilih) {
                // ADMIN
                case 1:
                    login(usernames, passwords, pilih);
                    break;

                // NASABAH
                case 2:
                    login(usernames, passwords, pilih);

                    if (isValidCredential) {
                        do {
                            System.out.println("\033[H\033[2J");
                            System.out.flush();

                            System.out.println("+-------------------------------------------+");
                            System.out.println("     Selamat Datang, " + fullNames[userID] + "!");
                            System.out.println("+-------------------------------------------+");
                            System.out.println();
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
                            System.out.println("||  7. Kembali Menu Utama  ||");
                            System.out.println("||=========================||");
                            System.out.print("--> ");

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
                                    tarik -= 1;

                                    while (nominal[tarik] > saldoNasabahs[userID]) {
                                        System.out.println();
                                        System.out.println("------------------------------");
                                        System.out.println("Maaf, saldo Anda tidak cukup");
                                        System.out.println("------------------------------");
                                        System.out.println();
                                        System.out.print("Pilih jumlah Penarikan Tunai yang Anda inginkan : ");
                                        tarik = sc.nextInt();
                                        tarik -= 1;
                                    }

                                    saldoNasabahs[userID] = saldoNasabahs[userID] - nominal[tarik];

                                    // print struk
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("            TARIK TUNAI             ");
                                    System.out.println();
                                    System.out.println("NAMA          : " + fullNames[userID]);
                                    System.out.println("NO. REKENING  : " + rekNasabahs[userID]);
                                    System.out.println("NOMINAL       : Rp." + nominal[tarik]);
                                    System.out.println("SALDO         : Rp." + saldoNasabahs[userID]);
                                    System.out.println();
                                    System.out.println("----------TRANSAKSI SUKSES----------");

                                    // mutasi
                                    jenisFitur[userID][kolomMutasi[userID]] = "Penarikan Tunai";
                                    charMutasi[userID][kolomMutasi[userID]] = '-';
                                    nominalMutasi[userID][kolomMutasi[userID]] = nominal[tarik];
                                    kolomMutasi[userID] += 1;
                                    break;

                                case 2:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println(" ");
                                    System.out.println("          SETOR TUNAI          ");
                                    System.out.println("+-----------------------------+");
                                    int setor;
                                    do {
                                        System.out.print(
                                                "Masukkan nominal uang yang Anda Setorkan (kelipatan Rp50.000) : ");
                                        setor = sc.nextInt();
                                        sc.nextLine();

                                    } while (setor % 50000 != 0);
                                    if (setor > 0) {
                                        saldoNasabahs[userID] += setor;

                                        // print struk
                                        System.out.println("\033[H\033[2J");
                                        System.out.flush();

                                        System.out.println("          SETORAN TUNAI          ");
                                        System.out.println(" ");
                                        System.out.println("NO. REKENING    : " + rekNasabahs[userID]);
                                        System.out.println("NAMA            : " + fullNames[userID]);
                                        System.out.println("RINCIAN         : Rp." + setor);
                                        System.out.println("SALDO           : Rp." + saldoNasabahs[userID]);
                                        System.out.println(" ");
                                        System.out.println("----------SETORAN TUNAI BERHASIL----------");

                                        // mutasi
                                        jenisFitur[userID][kolomMutasi[userID]] = "Setor Tunai";
                                        nominalMutasi[userID][kolomMutasi[userID]] = setor;
                                        kolomMutasi[userID] += 1;
                                    }
                                    break;

                                case 3:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();

                                    // print struk
                                    System.out.println("               CEK SALDO               ");
                                    System.out.println();
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

                                    // mutasi
                                    saldoNasabahs[userID] = saldoNasabahs[userID] - transfer;
                                    jenisFitur[userID][kolomMutasi[userID]] = "Transfer";
                                    charMutasi[userID][kolomMutasi[userID]] = '-';
                                    nominalMutasi[userID][kolomMutasi[userID]] = transfer;
                                    kolomMutasi[userID] += 1;

                                    for (int i = 0; i < rekNasabahs.length; i++) {
                                        if (noRek == rekNasabahs[i]) {
                                            saldoNasabahs[i] = saldoNasabahs[i] + transfer;
                                            System.out.println("\033[H\033[2J");
                                            System.out.flush();

                                            System.out.println("               TRANSFER               ");
                                            System.out.println();
                                            System.out.println("BANK TUJUAN   : " + bank);
                                            System.out.println("NAMA PENGIRIM : " + fullNames[userID]);
                                            System.out.println("NO. REKENING  : " + rekNasabahs[userID]);
                                            System.out.println("KETERANGAN    : Transfer");
                                            System.out.println("--------------------------------------");
                                            System.out.println("NAMA PENERIMA : " + fullNames[i]);
                                            System.out.println("REK TUJUAN    : " + rekNasabahs[i]);
                                            System.out.println("JUMLAH        : Rp." + transfer);
                                            System.out.println();
                                            System.out.println("-----------TRANSFER BERHASIL----------");
                                            int tfMutasi = i;

                                            // mutasi
                                            jenisFitur[tfMutasi][kolomMutasi[tfMutasi]] = "Transfer";
                                            charMutasi[tfMutasi][kolomMutasi[tfMutasi]] = '+';
                                            nominalMutasi[tfMutasi][kolomMutasi[tfMutasi]] = transfer;
                                            kolomMutasi[tfMutasi] += 1;
                                        }
                                    }
                                    break;

                                case 5:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("            UBAH PIN            ");
                                    System.out.println("+------------------------------+");
                                    System.out.print("Masukkan PIN ATM Lama : ");
                                    int pinLama = sc.nextInt();

                                    while (pinLama != pinNasabahs[userID]) {
                                        System.out.println();
                                        System.out.println("-------------------------------------------");
                                        System.out.println("  PIN yang Anda masukkan salah! Coba lagi  ");
                                        System.out.println("-------------------------------------------");
                                        System.out.print("Masukkan PIN ATM Lama : ");
                                        pinLama = sc.nextInt();
                                    }

                                    // masukkan pin baru
                                    int pinBaru;
                                    do {
                                        System.out.print("Masukkan PIN ATM baru (6 digit) : ");
                                        pinBaru = sc.nextInt();
                                        sc.nextLine();

                                        if (pinLama == pinBaru) {
                                            System.out.println();
                                            System.out.println("-------------------------------------------");
                                            System.out.println("PIN lama dan PIN baru tidak boleh sama");
                                            System.out.println("-------------------------------------------");
                                            continue;
                                        }

                                        if (pinBaru < 100000 || pinBaru > 999999) {
                                            System.out.println("--------------------------");
                                            System.out.println("  PIN Baru harus 6 digit  ");
                                            System.out.println("--------------------------");
                                            continue;
                                        }

                                        // konfirmasi pin baru
                                        int konfirmPin;
                                        do {
                                            System.out.print("Konfirmasi PIN baru : ");
                                            konfirmPin = sc.nextInt();
                                            if (konfirmPin != pinBaru) {
                                                System.out.println();
                                                System.out.println(
                                                        "----------------------------------------------------");
                                                System.out.println(
                                                        "Maaf, PIN yang Anda masukkan tidak sesuai. Coba lagi");
                                                System.out.println(
                                                        "----------------------------------------------------");
                                            }
                                        } while (konfirmPin != pinBaru);

                                    } while (pinBaru == pinLama || pinBaru < 100000 || pinBaru > 999999);

                                    // print struk
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();

                                    pinNasabahs[userID] = pinBaru;
                                    System.out.println("               UBAH PIN               ");
                                    System.out.println();
                                    System.out.println("NAMA            : " + fullNames[userID]);
                                    System.out.println("NO. REKENING    : " + rekNasabahs[userID]);
                                    System.out.println("-------------------------------------------");
                                    System.out.println("PENGGANTIAN PIN BERHASIL !");
                                    System.out.println("PIN ATM berhasil diganti menjadi " + pinBaru);
                                    System.out.println("-------------------------------------------");
                                    break;

                                case 6:
                                    System.out.println("\033[H\033[2J");
                                    System.out.flush();
                                    System.out.println();
                                    System.out.println("               MUTASI REKENING               ");
                                    System.out.println();
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
                                            System.out.printf("%-5d | %-20s | %-1s%-20s%n", j + 1, jenisFitur[i][j],
                                                    charMutasi[i][j],
                                                    nominalMutasi[i][j]);
                                        }
                                    }
                                    break;

                                case 7:
                                    System.out.println("");
                                    break;
                            }
                            if (pilih2 == 7) {
                                isValidCredential = false;
                                break;
                            } else {
                                System.out.println();
                                System.out.print("Apakah Anda ingin melakukan transaksi lagi? (y/n) : ");
                                kembali2 = sc.next().charAt(0);

                                if (kembali2 == 'y') {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();
                                    
                                    System.out.print("Masukkan PIN ATM : ");
                                    pinKonfirmasi = sc.nextInt();

                                    while (pinKonfirmasi != pinNasabahs[userID]) {
                                        System.out.println("----------------------------------------------------");
                                        System.out.println("  PIN yang Anda masukkan salah. Silahkan coba lagi  ");
                                        System.out.println("----------------------------------------------------");
                                        System.out.println();
                                        System.out.print("Masukkan PIN ATM : ");
                                        pinKonfirmasi = sc.nextInt();
                                    }
                                }
                                if (kembali2 == 'n') {
                                    isValidCredential = false;
                                }
                            }
                        } while (pinKonfirmasi == pinNasabahs[userID] && isValidCredential);
                    }
            }
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // ADMIN
            if (isLogin) {
                    do {
                        System.out.print("\033[H\033[2J");
                        System.out.flush();

                        System.out.println("1. Data Nasabah");
                        System.out.println("2. Tambah Nasabah");
                        System.out.println("3. Pencarian Nasabah");
                        System.out.println("4. Kembali");
                        System.out.print("--> ");
                        pilih1 = sc.nextInt();

                        switch (pilih1) {
                            // data nasabah
                            case 1:
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.println(
                                        "                                    DATA NASABAH                                ");
                                System.out.println();
                                headerTabel();
                                tabel();
                                break;

                            // tambah nasabah
                            case 2:
                                if (customerCount < fullNames.length) {
                                    sc.nextLine(); // membersihkan new line

                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("          TAMBAH NASABAH BARU          ");
                                    System.out.println("+-------------------------------------+");
                                    System.out.print("Nama Lengkap   : ");
                                    fullNames[customerCount] = sc.nextLine();
                                    System.out.print("Nomor Rekening : ");
                                    rekNasabahs[customerCount] = sc.nextInt();
                                    System.out.print("PIN            : ");
                                    pinNasabahs[customerCount] = sc.nextInt();
                                    System.out.print("Saldo          : ");
                                    saldoNasabahs[customerCount] = sc.nextInt();

                                    customerCount++;
                                    System.out.println();
                                    System.out.println("-----------------------------------------");
                                    System.out.println("   Nasabah baru berhasil ditambahkan !   ");
                                    System.out.println("-----------------------------------------");

                                } else {
                                    System.out.println();
                                    System.out.println("Batas maksimum nasabah baru telah tercapai");
                                }
                                break;

                            case 3:
                                System.out.println("\033[H\033[2J");
                                System.out.flush();

                                sc.nextLine(); // membersihkan newline

                                System.out.print("Masukkan nama nasabah yang dicari : ");
                                String search = sc.nextLine();
                                for (int i = 0; i < customerCount; i++) {
                                    if (fullNames[i].toLowerCase().contains(search.toLowerCase())) {
                                        pencarian = i;
                                        found = true;
                                    }
                                }
                                System.out.print("\033[H\033[2J");
                                System.out.flush();

                                System.out.print("Data nasabah dengan nama yang dicari : ");
                                System.out.println();
                                headerTabel();
                                tabel();

                                if (!found) {
                                    System.out.print("\033[H\033[2J");
                                    System.out.flush();

                                    System.out.println("------------------------");
                                    System.out.println("  Data tidak ditemukan  ");
                                    System.out.println("------------------------");
                                }
                                found = false;
                                break;

                            case 4:
                                System.out.println("");
                                break;

                            default:
                                System.out.println("Pilihan tidak valid. Silahkan memilih lagi");
                                break;
                        }
                        if (pilih1 == 4) {
                            isLogin = false;
                            break;
                        } else {
                            System.out.println();
                            System.out.print("Apakah Anda ingin kembali ke menu utama? (y/n) : ");
                            kembali = sc.next().charAt(0);
                            if (kembali == 'n' || kembali == 'N') {
                                isLogin = false;
                            }
                        }
                    } while (kembali == 'y' || kembali == 'Y');
                }

        } while (pilih != 3);
    }

    static void headerTabel() {
        System.out.println(
                "--------------------------------------------------------------------------------------");
        System.out.printf("%-3s | %-25s | %-20s | %-15s | %-10s%n",
                "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");

    }

    static void tabel() {
        if (found) {
            for (int i = pencarian; i <= pencarian; i++) {
                System.out.println(
                        "--------------------------------------------------------------------------------------");
                System.out.printf("%-3d | %-25s | %-20s | %-15s | %-10s%n",
                        i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
            }
        }
        if (!found) {
            System.out.println(
                    "--------------------------------------------------------------------------------------");
            for (int i = 0; i < customerCount; i++) {
                System.out.printf("%-3d | %-25s | %-20s | %-15s | %-10s%n",
                        i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
            }
        }
    }
}
