package Game;
import java.util.Scanner;

public class Mon {

  
    public static void main(String[] args) {
        
        Scanner input = new Scanner(System.in);
        int Tingkatan, templet, mulai, Random;

        //memulai permainan
        do {
            System.out.println("\n============================");
            System.out.println("Katak Melompat Di atas Batu");
            System.out.println("============================");
            //pemilihan Tingkatan
            do {
                printMenuKesulitan();
                System.out.print("Masukan pilihan Kesulitan: ");
                Tingkatan = input.nextInt();
            } while (Tingkatan > 3 || Tingkatan < 1);

            switch (Tingkatan) {
                case 1:
                    System.out.println("jumlah batu 25");
                    templet = 25;
                    break;
                case 2:
                    System.out.println("jumlah batu 100");
                    templet = 100;
                    break;
                default:
                    System.out.println("jumlah batu 225");
                    templet = 225;
                    break;
            }

            //menyusun memakai sqrt
            int x = (int) Math.sqrt(templet);
            int posisi[][] = PanjangTempat(x);

            printField(posisi, x);

            int Score = 0;
            int JmlTebak = 20;
            int depan, belakang;

            
            while (JmlTebak != 0) {
                System.out.println("Katak melompat!!,Temukan dia di batu sekarang!!");
                
                depan = (int) ((int) 1 + Math.random() * (x - 1));
                belakang = (int) ((int) 1 + Math.random() * (x - 1));
                System.out.print("Masukan tebakanmu dengan rentang 1-" + templet + ": ");
                Random = input.nextInt();//untuk menebak katak

               

                if (Random < 1 || Random > templet) {
                    System.out.println("tebakan mu melampaui batu, silahkan menebak ulang");
                } else {
                    JmlTebak--;
                    System.out.println("tebakan kamu " + Random + " dan katak melompat ke " + posisi[depan][belakang]);
                    if (Random == posisi[depan][belakang]) {
                        System.out.println("Selamat tebakanmu benar (+10)");
                        Score += 10;
                    } else {
                        System.out.println(" tebakanmu salah, silahkan mencoba kembali");
                    }
                }
            }

            //proses penilaian dan pesan hasil
            penilaian(Score);

            // main lagi atau tidak
            System.out.println("Ingin main lagi? 1 untuk lanjut, yang lain untuk berhenti");
            Score = 0;
            JmlTebak = 20;
            mulai = input.nextInt();
        } while (mulai == 1);
        System.out.println("Permainan Selesai");
    }

  
    private static void printField(int[][] posisi, int x) {
        for (int i = 0; i < x; i++) {
            for (int a = 0; a < x; a++) {
                System.out.print(posisi[i][a] + "\t");
            }
            System.out.println();
        }
    }
    private static int[][] PanjangTempat(int x) {
        int posisi[][] = new int[x][x];
        for (int i = 1; i <= x; i++) {
            for (int a = 1; a <= x; a++) {
                posisi[i - 1][a - 1] = x * (i - 1) + a;
            }
        }
        return posisi;
    }

    private static void penilaian(int Score) {
        if (Score < 50) {
            System.out.println("Bad~");
            System.out.println("Anda memperoleh score " + Score + "\tSangat buruk,Berlatih lagi ");
        } else if (Score >= 50 && Score <= 100) {
            System.out.println("Good~");
            System.out.println("Anda memperoleh score " + Score + "\tTidak memalukan~");
        } else {
            System.out.println("Excelent~");
            System.out.println("Anda memperoleh score" + Score + "\tKamu hebat, Calon Pemenang~");
        }
    }
    private static void printMenuKesulitan() {
        System.out.println("Pilihlah tingkatan kesulitan:");
        System.out.println("1. Easy");
        System.out.println("2. intermediate");
        System.out.println("3. difficult");
    }
}