public class Main {

    public static int minimumDeger(int[] dizi, int baslangic, int son, int[] ilk, int[] sonra, int indeks) {

        if (baslangic == son) {
            return dizi[baslangic];
        }

        int orta = (baslangic + son) / 2;

        int solMin = minimumDeger(dizi, baslangic, orta, ilk, sonra, 2 * indeks + 1);
        int sagMin = minimumDeger(dizi, orta + 1, son, ilk, sonra, 2 * indeks + 2);

        ilk[indeks] = baslangic;
        sonra[indeks] = son;

        return Math.min(solMin, sagMin);
    }


    public static void main(String[] args) {

        int[] dizi = { 9, 2, 14, 5, 10, 11, 21, 4, 17, 12, 16, 22, 28 };

        int[] IlkYigit = new int[dizi.length * 2];
        int[] IkinciYigit = new int[dizi.length * 2];

        int min = minimumDeger(dizi, 0, dizi.length - 1, IlkYigit, IkinciYigit, 0);

        System.out.println("\n");

        for (int i = 0; i < IlkYigit.length; i++) {
            if (IlkYigit[i] != 0 || IkinciYigit[i] != 0) {
                System.out.println("Sol: " + IlkYigit[i] + " - Sag: " + IkinciYigit[i]);
            }
        }

        System.out.println("\nDizinin minimum degeri : " + min + "\n");
    }
}
