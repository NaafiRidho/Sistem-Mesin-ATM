import java.util.Scanner;

public class sistemmesin_atm {
    public static void main(String[] args) {

        String namaBank;
        int[] arrayNomor = { 123, 456, 789 };
        int[] arrayPassword = { 123, 456, 789 };
        int nomorAtm, password;
        boolean login = false;
        char operator, konfirmasi;
        double saldo = 5000000, tarikUang, tabunganAkhir, transfer, pajak, nomorRekening;
        Scanner sc = new Scanner(System.in);

        // LOGIN USERNAME DAN PASSWORD
        System.out.println("========================================");
        System.out.println("         Selamat datang di ATM          ");
        System.out.println("========================================");
        System.out.println("masukkan user:");
        nomorAtm = sc.nextInt();
        System.out.println("masukkan password:");
        password = sc.nextInt();

        for (int i = 0; i < 3; i++) {
            if (nomorAtm == arrayNomor[i] && password == arrayPassword[i]) {
                login = true;
            }
        }
        if (login == true) {
            System.out.println("Berhasil login");
        } else {
            System.out.println("tidak Berhasil login");
        }
        while (login == true) {
            System.out.println("1. cek saldo");
            System.out.println("2.ambil uang");
            System.out.println("3. transfer");
            System.out.println("4. Ubah Pin");

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
                            break;

                    }

                    if (namaBank.equalsIgnoreCase("1")) {
                        pajak = 0;
                    } else {
                        pajak = 2500;
                    }

                    System.out.println("===========================");
                    System.out.println(" Masukkan Nomor rekening ");
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
