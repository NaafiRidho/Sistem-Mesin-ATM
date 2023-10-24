import java.util.Scanner;

public class sistemmesin_atm {
    public static void main(String[] args) {
        String user, namaBank;
        char operator, konfirmasi;
        double password, saldo = 5000000, tarikUang, tabunganAkhir, transfer, pajak, nomorRekening;
        Scanner sc = new Scanner(System.in);

        // LOGIN USERNAME DAN PASSWORD
        System.out.println("========================================");
        System.out.println("         Selamat datang di ATM          ");
        System.out.println("========================================");
        System.out.println("masukkan user:");
        user = sc.nextLine();
        System.out.println("masukkan password:");
        password = sc.nextDouble();
        if (user.equalsIgnoreCase("naafi") && password == 123) {

        } else {
            System.out.println("Username dan password salah");
        }

        while(user.equalsIgnoreCase("naafi") && password == 123) {
            System.out.println("1. cek saldo");
            System.out.println("2.ambil uang");
            System.out.println("3. transfer");

            // case
            System.out.println("masukkan (1 2 3 4:)");
            operator = sc.next().charAt(0);

            switch (operator) {
                case '1':
                    System.out.println("===========================");
                    System.out.println("       cek saldo anda      ");
                    System.out.println("      saldo anda" + saldo);
                    break;

                case '2':
                    System.out.println("===========================");
                    System.out.println("     total ambil uang      ");
                    tarikUang = sc.nextDouble();
                    tabunganAkhir = saldo - tarikUang;
                    System.out.println("tabungan akhir anda:" + tabunganAkhir);
                    break;

                case '3':
                    System.out.println("Pilih bank 1,2,3");
                    namaBank = sc.nextLine();
                    namaBank = sc.nextLine();
                    switch (namaBank) {
                        case "1":
                            System.out.println("mandiri");
                            break;
                        case "2":
                            System.out.println("bca");
                            break;
                        case "3":
                            System.out.println("bri");

                    }

                    if (namaBank.equalsIgnoreCase("1")) {
                        pajak = 0;
                    } else {
                        pajak = 2500;
                    }

                    System.out.println("===========================");
                    System.out.println("  Masukkan Nomor rekening  ");
                    nomorRekening = sc.nextDouble();
                    System.out.println("Masukkan total transfer : ");
                    transfer = sc.nextDouble();
                    tabunganAkhir = saldo - transfer - pajak;
                    System.out.println("Tabungan Akhir Anda : " + tabunganAkhir);
                    break;
            }
            System.out.println("Apakah ingin kembali ke menu awal (Y/T)? ");
            konfirmasi = sc.next().charAt(0);
            if (konfirmasi == 't' || konfirmasi == 'T') {
                System.out.println("Terima kasih");
                break;
            }

        } 

        

    }

}
