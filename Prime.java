//Andhika Restu 65130500247

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Prime{
    public static void main(String[] args) {
        System.out.println("Start time: " + currentTime());
        primeList(300000);
        System.out.println("Finish time: " + currentTime());

        System.out.println("Start time: " + currentTime());
        seiveOfEratosthenes(300000);
        System.out.println("Finish time: " + currentTime());


    }

    public static String seiveOfEratosthenes(int n){
        String result = "";
        int[] a = new int[n + 1];
        for(int i = 0; i < n+1; i++){
            a[i] = i;   // a = [2,3,4,5]
        }

        for(int p = 2; p < Math.floor(Math.sqrt(n)); p++){
            if(a[p] != 0){ //p is prime
                int j = p * p;
                while(j <= n){
                    a[j] = 0;
                    j += p;
                }
            }
        }

        for(int i = 2; i < n + 1; i++){
            if(a[i] != 0){
                result += a[i] + ", ";
            }
        }
        
        return result;
    }

    public static String currentTime(){
        Calendar now = new GregorianCalendar();
        int hour = now.get(Calendar.HOUR);
        int minute = now.get(Calendar.MINUTE);
        int second = now.get(Calendar.SECOND);
        int millisecond = now.get(Calendar.MILLISECOND);
        int ampm = now.get(Calendar.AM_PM);
        return (hour+(ampm>0?"PM":"AM")+":"+minute+":"+second + ":" + millisecond);
    }
    public static String primeList(int n){
        //brute force
        String result="";
        for(int i = 2; i <= n; i++){
            int j;
            for(j = 2; j < i; j++){
                if(i % j == 0){
                    break;
                }
            }
            if(j == i){
                result += j + ", ";
            }
        }
        result = result.substring(0, result.length() - 2);
        return result;
    }
}