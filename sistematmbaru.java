import java.util.Scanner;

public class sistematmbaru {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Scanner nc = new Scanner(System.in);
        int nomorRekening, pin, saldo, j = 0;
        String role, menu, next, lanjut;
        boolean login = false;

        int[] arrayRekening = new int[10];
        int[] arrayPin = new int[10];
        int[] arraySaldo = new int[10];
        String[]namaNasabah= new String[10];

        do {
            System.out.println("Pilih Role Admin/Nasabah: ");
            role = sc.nextLine();

            if (role.equalsIgnoreCase("admin")) {

                do {

                    System.out.print("Masukkan nomor Rekening : ");
                    arrayRekening[j] = sc.nextInt();
                    System.out.println("Masukkan pin atm :");
                    arrayPin[j] = sc.nextInt();
                    System.out.println("Masukkan saldo atm :");
                    arraySaldo[j] = sc.nextInt();
                    j++;
                    System.out.println("apakah akan melanjutkan input nasabah y/t?");
                    next = nc.nextLine();

                } while (next.equalsIgnoreCase("y"));
                for (int i = 0; i < j; i++) {
                    System.out.println("data nasabah ke- " + (i + 1));
                    System.out.print("Nomor rekening: ");
                    System.out.println(arrayRekening[i]);
                    System.out.print("Pin Bank :");
                    System.out.println(arrayPin[i]);
                    System.out.print("Saldo bank: ");
                    System.out.println(arraySaldo[i]);
                }
            }

            if (role.equalsIgnoreCase("nasabah")) {

                System.out.println("====================");
                System.out.println("Masukkan nomor rekening");
                nomorRekening = sc.nextInt();
                System.out.println("Masukkan Pin ATM ");
                pin = sc.nextInt();
                System.out.println("====================");

                for (int i = 0; i < arrayRekening.length; i++) {
                    if (nomorRekening == arrayRekening[i] && pin == arrayPin[i]) {
                        login = true;
                        if (login == true) {
                            do{

                            System.out.println("===============");
                            System.out.println("Pilih Menu");
                            System.out.println("1. Cek saldo");
                            System.out.println("2. setor tunai");
                            System.out.println("3. tatik  tunai");
                            System.out.println("4. transfer");
                            System.out.println("5. ubah pin");
                            System.out.println("pilih angka 1,2,3,4,5");
                            menu = nc.nextLine();

                            switch (menu) {
                                case "1":
                                    System.out.println("====================");
                                    System.out.println("saldo atm anda :" + arraySaldo[i]);
                                    System.out.println("====================");
                                    break;

                            } 
                            System.out.println("apakah ingin lanjut");
                            lanjut=sc.nextLine();
                        }
                        while(lanjut.equalsIgnoreCase("y"));
                            
                        }
                    }

                }

            }
            System.out.println("apakah akan lanjut y/t");
            lanjut = nc.nextLine();
        } while (lanjut.equalsIgnoreCase("y"));
    }
}