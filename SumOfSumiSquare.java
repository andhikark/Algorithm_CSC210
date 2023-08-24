//Putu Andhika restu Kurnia (65130500247)

public class SumOfSumiSquare{
    public static void main(String[] args){
        double answer = 0;
        long n;
        long start,end;
        double[][] timeArray = new double[5][4];
        int count = 0;
        for( n = 50,count = 0; n < 1000000; n *= 10,count++){
            
            start = System.currentTimeMillis();
            answer = sumOfSumIsquareUseFormula(n); 
            end = System.currentTimeMillis();
            System.out.println(answer + " for " + (end-start) + " milliseconds");
            timeArray[count][0] = end-start;
            
            start = System.currentTimeMillis();
            answer = sumOfSumIsquareReuse(n); // o(n)
            end = System.currentTimeMillis();
            System.out.println(answer + " (reuse of sum of i^2) for " + (end-start) + " milliseconds");
            timeArray[count][1] = end-start;
            
            start = System.currentTimeMillis();
            answer = sumOfSumIsquare(n); // 0(n^2)
            end = System.currentTimeMillis();
            System.out.println(answer + " for " + (end-start) + " milliseconds");
            timeArray[count][2] = end-start;
            
            start = System.currentTimeMillis();
            answer = sumOfSumIsquareByAddition(n); // 0(n^2)
            end = System.currentTimeMillis();
            System.out.println(answer + " for " + (end-start) + " milliseconds");
            timeArray[count][3] = end-start;
            
            System.out.println();
        }
        
        for(int i = 0; i < timeArray.length;i++){
            for(int j = 0; j < timeArray[0].length; j++){
                System.out.print(timeArray[i][j] + " ");
            }
            System.out.println("");
        }
        
        
    }
    
    
    public static double sumOfSumIsquare(long n){
        double sumOfSum = 0;
        for (int j = 1; j <= n ; j++ ){
            double sumIsquare = 0;
            for(double i = 1; i <= j ; i++){
                sumIsquare += i * i;
            }
            sumOfSum += sumIsquare;
        } 
        return sumOfSum;
    }
    
    public static double sumOfSumIsquareUseFormula(long n){
        double sumOfSum = 0;
        for(long j = 1; j <= n; j++){
            sumOfSum += (j*(j + 1)*(2*j+1))/6; 
        }
        return sumOfSum;
    }
    
    public static double sumOfSumIsquareByAddition(long n){
        double sumOfSum = 0;
        for (int j = 1; j <= n ; j++ ){
            double sumIsquare = 0;
            for(double i = 1; i <= j ; i++){
                double iSquare = 0;
                for(int k = 1; k <= i;k++){
                    iSquare += i;
                }
                
                sumIsquare += iSquare;
            }
            sumOfSum += sumIsquare;
        } 
        return sumOfSum;
    }
    
    public static double sumOfSumIsquareReuse(long n){
        double sumOfSum = 0;
        double sumIsquare = 0;
        for (double j = 1; j <= n ; j++ ){
            sumIsquare += j * j;
            sumOfSum += sumIsquare;
        } 
        return sumOfSum;
    }
}
