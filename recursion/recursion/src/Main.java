public class Main {

    
    public static int ikiliAramaTekrarlı(int[] list, int düşük, int yüksek, int hedef, int[] öncesiYığın,
            int[] sonrasıYığın, int endeks) {
        if (düşük <= yüksek) {
            int orta = (düşük + yüksek) / 2;

            
            öncesiYığın[endeks] = düşük;
            sonrasıYığın[endeks] = yüksek;

            if (list[orta] == hedef) {
               
                öncesiYığın[endeks + 1] = orta;
                sonrasıYığın[endeks + 1] = orta;
                return orta;
            } else if (list[orta] < hedef) {
                
                return ikiliAramaTekrarlı(list, orta + 1, yüksek, hedef, öncesiYığın, sonrasıYığın, endeks + 1);
            } else {
               
                return ikiliAramaTekrarlı(list, düşük, orta - 1, hedef, öncesiYığın, sonrasıYığın, endeks + 1);
            }
        }
       
        return -1;
    }

   
    public static void geriDön(int[] öncesiYığın, int[] sonrasıYığın, int endeks) {
        
        for (int i = 0; i < endeks; i++) {
            int tersEndeks = endeks - i - 1;
            System.out.println("Cagridan once " + öncesiYığın[i] + " -> Cagridan sonra: " + sonrasıYığın[i] +
                    "\t\tGeriye donus: Cagridan once: " + öncesiYığın[tersEndeks] + " -> Cagridan sonra: " +
                    sonrasıYığın[tersEndeks]);
        }
    }

    public static void main(String[] args) {
        int[] dizi = { 2, 3, 4, 10, 40, 50, 60, 70, 80, 90, 100 };
        int hedef = 10;
        int[] öncesiYığın = new int[dizi.length + 1];
        int[] sonrasıYığın = new int[dizi.length + 1];

        
        int sonuçEndeks = ikiliAramaTekrarlı(dizi, 0, dizi.length - 1, hedef, öncesiYığın, sonrasıYığın, 0);

       
        if (sonuçEndeks != -1 && sonuçEndeks < dizi.length) {
            System.out.println("Hedef dizide indeks: " + sonuçEndeks);
        } else {
            System.out.println("Hedef dizi içinde bulunamadı.");
        }

        
        geriDön(öncesiYığın, sonrasıYığın, sonuçEndeks);
    }
}
