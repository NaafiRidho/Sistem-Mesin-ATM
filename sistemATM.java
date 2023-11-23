import java.util.Scanner;

public class sistemATM {
    public static void main(String[] args) {
        Scanner sc = new Scanner (System.in);
        
          // admin
          String[] username = new String[10];
          String[] password = new String[10];
          
          // nasabah
          String[] fullNames = new String[15]; // nama lengkap nasabah baru
          int[] rekNasabahs = new int[15]; // nomor rekening nasabah baru
          int[] pinNasabahs = new int[15]; // PIN nasabah baru 
          int[] saldoNasabahs = new int[15]; // saldo nasabah baru
  
          // username admin
          username[0] = "";
          username[1] = "admin1";
          username[2] = "admin2";
          username[3] = "admin3";
  
          // password admin
          password[0] = "";
          password[1] = "passadmin1";
          password[2] = "passadmin2";
          password[3] = "passadmin3";
  
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
  
          int employeeCount = 3;
          boolean isValidCredential = false;
  
          String inputUsername, inputPassword;
          int pilih = 0, pilih1, pilih2, pilih3;
  
          int noRekNasabah, pinNasabah;
          int adminID = 0;
          int userID = 0;
  
          // login
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
                      System.out.print("Masukkan username Anda: ");
                      inputUsername = sc.nextLine();
                      System.out.print("Masukkan password Anda: ");
                      inputPassword = sc.nextLine();
  
                      for (int i = 0; i < username.length; i++) {
                          if (inputUsername.equals(username[i]) && inputPassword.equals(password[i])) {
                              isValidCredential = true;
                              adminID = i;
                              break;
                          }    
                      }
  
                      while (!isValidCredential) {
                          System.out.println("\033[H\033[2J");
                          System.out.flush();
  
                          System.out.println("Maaf, username dan password Anda salah");
                          System.out.println(" ");
                          
                          // masukkan ulang username & password
                          System.out.print("Masukkan username Anda: ");
                          inputUsername = sc.nextLine();
                          System.out.print("Masukkan password Anda: ");
                          inputPassword = sc.nextLine();
  
                          for (int i = 0; i < username.length; i++) {
                              if (inputUsername.equals(username[i]) && inputPassword.equals(password[i])) {
                                  isValidCredential = true;
                                  adminID = i;
                                  break; 
                              }
                          }
                      }
                      
                      System.out.println("\033[H\033[2J");
                      System.out.flush();
                      break;
  
                  // NASABAH
                  case 2:
                      System.out.println("\033[H\033[2J");
                      System.out.flush();
  
                      System.out.println("================    NASABAH    ================");
                      System.out.print("Masukkan nomor rekening Anda: ");
                      noRekNasabah = sc.nextInt();
                      System.out.print("Masukkan PIN ATM Anda: ");
                      pinNasabah = sc.nextInt();
                      for (int i = 0; i < employeeCount; i++) {
                          if (noRekNasabah == rekNasabahs[i] && pinNasabah == pinNasabahs[i]) {
                              isValidCredential = true;
                              userID = i;
                              break;
                          }
                      }
  
                      while (!isValidCredential) {
                          System.out.println("\033[H\033[2J");
                          System.out.flush();
  
                          System.out.println("Maaf, nomor rekening dan PIN Anda salah");
                          System.out.println(" ");
  
                          // masukkan ulang no rek dan pin 
                          System.out.println("================    NASABAH    ================");
                          System.out.print("Masukkan nomor rekening Anda: ");
                          noRekNasabah = sc.nextInt();
                          System.out.print("Masukkan PIN ATM Anda: ");
                          pinNasabah = sc.nextInt();
                          for (int i = 0; i < employeeCount; i++) {
                              if (noRekNasabah == rekNasabahs[i] && pinNasabah == pinNasabahs[i]) {
                                  isValidCredential = true;
                                  userID = i;
                                  break;
                              }
                          }
                          
                      }
  
                      if (isValidCredential) {
                          System.out.println(" ");
                          System.out.println("Hai" + " " + fullNames[userID] + "!");
                          System.out.println("Silahkan pilih jenis transaksi yang Anda inginkan");
                          System.out.println(" ");
                          System.out.println("          JENIS TRANSAKSI           ");
                          System.out.println("+----------------------------------+");
                          System.out.println("1. Penarikan Tunai");
                          System.out.println("2. Setor Tunai");
                          System.out.println("3. Cek Saldo");
                          System.out.println("4. Transfer");
                          System.out.println("5. Ubah PIN");
                          System.out.println("6. Mutasi Rekening");
                          System.out.println("--> ");
                          pilih3 = sc.nextInt();
  
                          switch (pilih3) {
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
  
                              case 2 :
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
  
                              
                          
                              default:
                                  break;
                          }
                      }
              }
          } while (pilih !=3);
  

    }
}
