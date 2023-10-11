package LargeIntegerMultiplication;

public class LargeIntegerMultiplication {
   public static void main(String [] args){
    String number1 = "1234";
    String number2 = "5678";
    String answer = "";
    // System.out.println(number1.substring(0, number1.length()/2) + " " + number1.substring(number1.length()/2));
    answer = multiplyLarge(number1, number2);
    System.out.println(answer);
    }

    public static String multiplyLarge(String a, String b) {
        if(a.length() == 1 && b.length() == 1){
            return (Long.parseLong(a) * Long.parseLong(b))+"";
        }else if (a.length() == 1){
            a = "0" + a;
        }else if(b.length() == 1){
            b = "0" + b;
        }

        int maxLength = Math.max(a.length(),b.length()); //determine which one is larger
        int totalLength = 2;

        for(; totalLength < maxLength; totalLength *= 2); // total length will be 2^i

        for(int i = a.length(); i < totalLength; i++){ a ="0" + a; }

        for(int i = b.length(); i < totalLength; i++){ b ="0" + b; }
        String a1,a0, b1,b0; // a = a1a0  b = b1b0
        a1 = a.substring (0,a.length()/2);
        a0 = a.substring(a.length()/2);
        b1 = b.substring (0,b.length()/2);
        b0 = b.substring(b.length()/2);
        // System.out.println(a1 + " " + a0 + " " + b1 + " " + b0);

        String c, c0, c11, c1,c2;
        c2 = multiplyLarge(a1, b1);
        c0 = multiplyLarge(a0, b0);
        c11 = multiplyLarge((Long.parseLong(a1) + Long.parseLong(a0)) + "",
            (Long.parseLong(b1) + Long.parseLong(b0))+"");
        
        c1 = (Long.parseLong(c11) - Long.parseLong(c2) - Long.parseLong(c0)) + "";
        c = (Long.parseLong(concat0AtBack(c2, a.length())) + Long.parseLong(concat0AtBack(c1, a.length()/2)) + Long.parseLong(c0))+"";
        return c;
    }

    public static String concat0AtBack(String num, int num_zero){
        for(int i = 0; i < num_zero;i++){
            num += 0;
        }
        return num;
    }
}

