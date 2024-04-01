import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

class Stack {
    private int[] stack;
    private int top;
    private int size;

    public Stack(int size) {
        this.size = size;
        stack = new int[size];
        top = -1;
    }

    public void push(int item) {
        if (top == size - 1) {
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
            int index = 0;
            while ((satir = bufferedReader.readLine()) != null) {
                int sayi = Integer.parseInt(satir);
                sayilarStack.push(sayi);
                indexlerStack.push(index++);
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

        System.out.println("Baslangictaki Hali:");
        for (int i = 0; i < sayilar.length; i++) {
            System.out.println(sayilar[i] + " " + indexler[i]);
        }

        // Sıralama işlemi
        for (int i = 0; i < sayilar.length - 1; i++) {
            for (int j = 0; j < sayilar.length - i - 1; j++) {
                if (sayilar[j] > sayilar[j + 1]) {
                    // Sayıları swap et
                    int temp = sayilar[j];
                    sayilar[j] = sayilar[j + 1];
                    sayilar[j + 1] = temp;
                }
            }
        }

        System.out.println("\nSirali Hali:");
        for (int i = 0; i < sayilar.length; i++) {
            System.out.println(sayilar[i] + " " + indexler[i]);
        }

        scanner.close();
    }
}