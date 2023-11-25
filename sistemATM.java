import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);

        String[] usernames = { "admin1", "admin2", "admin3"};
        String[] passwords = {"passadmin1","passadmin2","passadmin3"};
        String[] roles = { "admin", "admin", "admin", "nasabah"};

        // nasabah
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

        char kembali;

        String inputUsername, inputPassword, search;
        
        boolean isValidCredential = false;
        
        int customerCount = 3;
        int pilih = 0, pilih1, pilih2, pilih3;
        int noRekNasabah, pinNasabah;
        int userID = 0;

        // LOGIN
        do {
            System.out.println("====================================");
            System.out.println("        SELAMAT DATANG DI ATM       ");
            System.out.println("====================================");
            System.out.println("1. Admin");
            System.out.println("2. Nasabah");
            System.out.println("3. Keluar");
            System.out.print("--> ");
            pilih = sc.nextInt();
            sc.nextLine(); // membersihkan new line

            while (pilih > 3) {
            System.out.println("====================================");
            System.out.println("        SELAMAT DATANG DI ATM       ");
            System.out.println("====================================");
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
                    inputUsername = sc.nextLine();
                    System.out.print("Masukkan password Anda: ");
                    inputPassword = sc.nextLine();
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

                        System.out.println("Maaf, username dan password Anda salah");
                        System.out.println(" ");
                        
                        // masukkan ulang username & password
                        System.out.println("+------------------------------------+");
                        System.out.print("Masukkan username Anda: ");
                        inputUsername = sc.nextLine();
                        System.out.print("Masukkan password Anda: ");
                        inputPassword = sc.nextLine();
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
                }

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
                                    System.out.println(
                                                "---------------------------------------------------------------------------------------------------------------");
                                    System.out.printf("%-5s | %-25s | %-20s | %-20s | %-10s%n", 
                                    "No", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
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
                                        pinNasabahs[customerCount] = sc.nextInt();
                                        System.out.print("Saldo          : ");
                                        saldoNasabahs[customerCount] = sc.nextInt();

                                        customerCount++;

                                    } else {
                                        System.out.println("Batas maksimum nasabah baru telah tercapai");
                                    }
                                    break;

                                case 3 :
                                    sc.nextLine(); // membersihkan newline
                                    boolean found = false;
                                    System.out.print("Masukkan nama nasabah yang dicari: ");
                                    System.out.println();
                                    search = sc.nextLine();
                                    for (int i = 0; i < customerCount; i++) {
                                        if (fullNames[i].toLowerCase().contains(search.toLowerCase())) {

                                            System.out.println("Data nasabah dengan nama yang dicari: ");
                                            System.out.println();
                                            System.out.println(
                                                        "---------------------------------------------------------------------------------------------------------------");
                                            System.out.printf("%-10s | %-25s | %-20s | %-20s | %-10s%n", 
                                            "Urutan", "Nama Lengkap", "Nomor Rekening", "Saldo", "PIN");
                                                    System.out.println(
                                                        "---------------------------------------------------------------------------------------------------------------");
                                            System.out.printf("%-10d | %-25s | %-20s | %-20s | %-10s%n",
                                                    i + 1, fullNames[i], rekNasabahs[i], saldoNasabahs[i], pinNasabahs[i]);
                                            found = true;
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("Data tidak ditemukan");
                                    }
                                    break;
                                
                                case 4 :
                                    System.out.println("");
                                    System.exit(0);
                                default:
                                    System.out.println("Pilihan tidak valid. Silahkan memilih lagi");
                                    break;
                            }
                            System.out.println();
                            System.out.println("Apakah Anda ingin kembali ke menu? (y/n)");
                            kembali = sc.next().charAt(0);
                        } while (kembali == 'y' || kembali =='Y');
                        break;

                    } else if (role.equals("nasabah")) {
                        // NASABAH
                        do {
                            System.out.println("Masukkan nomor rekening Anda: ");
                            noRekNasabah = sc.nextInt();
                            System.out.println("Masukkan PIN ATM Anda: ");
                            pinNasabah = sc.nextInt();
                            for (int i = 0; i < customerCount; i++) {
                                if (noRekNasabah == rekNasabahs[i] && pinNasabah == pinNasabahs[i]) {
                                    isValidCredential = true;
                                    userID = i;
                                }
                            }

                            if (isValidCredential) {
                                System.out.println("+------------------------------------------+");
                                System.out.println("Selamat Datang, " + fullNames[userID]);
                                System.out.println("+------------------------------------------+");
                                System.out.println();
                                System.out.println("Silahkan pilih jenis transaksi yang Anda inginkan");
                                System.out.println("||=========================||");
                                System.out.println("||     JENIS TRANSAKSI     ||");
                                System.out.println("||_________________________||");
                                System.out.println("||                         ||");
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
                                        System.out.println(" ");
                                        System.out.println("             SETOR TUNAI            ");
                                        System.out.println("+----------------------------------+");
                                        System.out.print("Masukkan nominal uang yang Anda Setorkan : ");
                                        int setor = sc.nextInt();
                                        saldoNasabahs[userID] = saldoNasabahs[userID] + setor;
                                        System.out.println(" ");
                                        System.out.println("           SETORAN TUNAI            ");
                                        System.out.println(" ");
                                        System.out.println("NO. REKENING    : " + rekNasabahs[userID]);
                                        System.out.println("NAMA            : " + fullNames[userID]);
                                        System.out.println("RINCIAN         : Rp." + setor);
                                        System.out.println("SALDO           : Rp." + saldoNasabahs[userID]);
                                        System.out.println(" ");
                                        System.out.println("----------SETORAN TUNAI BERHASIL----------");
                                        break;

                                    case 3 :
                                        System.out.println(" ");
                                        System.out.println("              CEK SALDO             ");
                                        System.out.println("+----------------------------------+");
                                        System.out.println("NAMA            : " + fullNames[userID]);
                                        System.out.println("NO. REKENING    : " + rekNasabahs[userID]);
                                        System.out.println("SALDO           : Rp." + saldoNasabahs[userID]);
                                        break;
                                    case 4 :    
                                        System.out.println(" ");
                                        System.out.println("               TRANSFER             ");
                                        System.out.println("+----------------------------------+");
                                        System.out.println("Masukkan Bank Tujuan Transfer: ");
                                        String bank = sc.nextLine();
                                        System.out.print("Masukkan Nomor Rekening Tujuan: ");
                                        sc.nextLine(); // membersihkan newline
                                        int noRek = sc.nextInt();
                                        System.out.print("Masukkan jumlah nominal yang akan ditransfer : ");
                                        int transfer = sc.nextInt();
                                        saldoNasabahs[userID] = saldoNasabahs[userID] - transfer;
                                        
                                        for (int i = 0; i < rekNasabahs.length; i++) {
                                            if (noRek == rekNasabahs[i]) {
                                                saldoNasabahs[i] = saldoNasabahs[i] + transfer;
                                                System.out.println(" ");
                                                System.out.println("KE BANK         : " + bank);
                                                System.out.println("NAMA PENGIRIM   : " + fullNames[userID]);
                                                System.out.println("NAMA PENERIMA   : " + fullNames[i]);
                                                System.out.println("REK TUJUAN      : " + rekNasabahs[i]);
                                                System.out.println("JUMLAH          : Rp." + transfer);
                                                System.out.println(" ");
                                                System.out.println("----------TRANSFER BERHASIL----------");
                                                System.out.println(" ");
                                                System.out.println("           SIMPAN RESI INI         ");
                                                System.out.println("        SEBAGAI BUKTI YANG SAH      ");
                                            }
                                        }
                                        break;
                                    case 5 :
                                                System.out.println(" ");
                                                System.out.println("              UBAH PIN             ");
                                                System.out.println("+----------------------------------+");
                                                System.out.print("Masukkan PIN Lama : ");
                                                int pinLama = sc.nextInt();
                                                System.out.print("Masukkan Pin Baru : ");
                                                int pinBaru=sc.nextInt();
                                                System.out.print("Konfirmasi Pin    : ");
                                                int konfirmasi=sc.nextInt();
                                                System.out.println(" ");
                                                System.out.println("----------UBAH PIN BERHASIL----------");
                                                if(pinBaru==konfirmasi){
                                                pinNasabahs[userID]=pinBaru;
                                                }
                                                else{
                                                System.out.println("Maaf, Pin yang Anda masukkan tidak sesuai");
                                                }
                                                break;

                                    default:
                                        break;
                                }
                                        }
                        } while (isValidCredential);
                    }
                }
            } while (pilih !=3);

    }
}
