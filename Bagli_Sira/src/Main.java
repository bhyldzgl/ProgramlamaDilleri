import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Stack {
    private int[] stack;
    private int top;
    private int boyut;

    public Stack(int boyut) {
        this.boyut = boyut;
        stack = new int[boyut];
        top = -1;
    }

    public void push(int item) {
        if (top == boyut - 1) {
            System.out.println("Yigit dolu! Eleman eklenemedi.");
            return;
        }
        stack[++top] = item;
    }

    public int pop() {
        if (isEmpty()) {
            System.out.println("Yigit bos Eleman cikarilamaz.");
            return -1;
        }
        return stack[top--];
    }

    public boolean isEmpty() {
        return (top == -1);
    }

    public int size() {
        return top + 1;
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Dosya Adini Girin: ");
        String dosyaAdi = scanner.nextLine();
        File dosya = new File(dosyaAdi);

        Stack sayilarStack = new Stack(100);
        Stack indexlerStack = new Stack(100);

        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(dosya));
            String satir;
            while ((satir = bufferedReader.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                sayilarStack.push(sayi);
                indexlerStack.push(sayilarStack.size() - 1);
            }
            bufferedReader.close();
        } catch (IOException e) {
            System.err.println("Dosya Okuma Hatasi: " + e.getMessage());
            scanner.close(); 
            return;
        }

        int[] sayilar = new int[sayilarStack.size()];
        int[] indexler = new int[indexlerStack.size()];

        for (int i = sayilarStack.size() - 1; i >= 0; i--) {
            sayilar[i] = sayilarStack.pop();
            indexler[i] = indexlerStack.pop();
        }

        
        int[] siraliSayilar = sayilar.clone();
        int[] siraliIndexler = indexler.clone();

        
        for (int i = 1; i < siraliSayilar.length; i++) {
            int key = siraliSayilar[i];
            int keyIndex = siraliIndexler[i];
            int j = i - 1;

            while (j >= 0 && siraliSayilar[j] > key) {
                siraliSayilar[j + 1] = siraliSayilar[j];
                siraliIndexler[j + 1] = siraliIndexler[j];
                j--;
            }
            siraliSayilar[j + 1] = key;
            siraliIndexler[j + 1] = keyIndex;
        }

        System.out.println("Baslangictaki Hali:\t Sirali Hali:");
        for (int i = 0; i < sayilar.length; i++) {
            System.out.println(sayilar[i] + "\t" + indexler[i] + "\t\t" + siraliSayilar[i] + "\t" + siraliIndexler[i]);
        }
        
        scanner.close(); 
    }
}