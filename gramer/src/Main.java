
import java.util.Scanner;

public class Main {
   
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cumlenizi Giriniz : ");
        String cumle = scanner.nextLine();
        scanner.close();
        
       if(kontrolGrammer(cumle)){
           System.out.println("EVET");
       }else{
           System.out.println("HAYIR");
       }
        
    }
    
    public static boolean kontrolGrammer(String cumle){
        
        // diziye tanımla
        String[] subjects = new String[9];

        subjects[0] = "Ben";
        subjects[1] = "Sen";
        subjects[2] = "Hasan";
        subjects[3] = "Nurşah";
        subjects[4] = "Elif";
        subjects[5] = "Abdulrezzak";
        subjects[6] = "Şehribanu";
        subjects[7] = "Zeynelabidin";
        subjects[8] = "Naki";
        
        String objects[] = new String[18];
        
        objects[0] = "Bahçe";
        objects[1] = "Okul";
        objects[2] = "Park";
        objects[3] = "Sınıf";
        objects[4] = "Yarın";
        objects[5] = "Pazartesi";
        objects[6] = "Salı";
        objects[7] = "Çarşamba";
        objects[8] = "Perşembe";
        objects[9] = "Cuma";
        objects[10] = "Cumartesi";
        objects[11] = "Pazar";
        objects[12] = "Merkez";
        objects[13] = "Ev";
        objects[14] = "Kitap";
        objects[15] = "Defter";
        objects[16] = "Güneş";
        objects[17] = "Beydağı";
        
        String[] verbs = new String[6];
        
        verbs[0] = "Gitmek";
        verbs[1] = "Gelmek";
        verbs[2] = "Okumak";
        verbs[3] = "Yazmak";
        verbs[4] = "Yürümek";
        verbs[5] = "Görmek";
        
        // Cümleyi parçalara ayırıyoruz 
        
        String[] kelimeler = cumle.split("\\s+");
        
        //Cümlede özne nesne ve yüklem kontrolü
        
        String geciciSubject = kelimeler[0];
        String geciciObject = kelimeler[1];
        String geciciVerb = kelimeler[2];
        
        
        if(kelimeler.length != 3){
            return false;
        }
        
        int controlSubject = 0;
        int controlObject = 0;
        int controlVerb = 0;
        
        for(int i = 0 ; i < 9 ; i++){
            if(geciciSubject.equals(subjects[i])){
                controlSubject++;
            }
        }
        
        for(int i = 0 ; i < 18 ; i++){
            if(geciciObject.equals(objects[i])){
                controlObject++;
            }
        }
        
        for(int i = 0 ; i < 6 ; i++){
            if(geciciVerb.equals(verbs[i])){
                controlVerb++;
            }
        }
        
        if( controlSubject == 1  && controlObject == 1 && controlVerb == 1){
            return true;
        }
        
        return false;
           
    }
    
}