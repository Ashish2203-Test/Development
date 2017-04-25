public class PrimeNumbers{

   
   private static boolean isPrime(int number){
   
   		for(int i=2; i<number; i++){
   		    if(number%i==0){
   		         return false;
   		    }
   		
   		}
   		
   		return true;			
   }
   
   
   public static void main(String[] args){
   
      for(int i=2; i<100; i++){
         if(isPrime(i)){
             System.out.print(i+", ");
         
         }
      
      }
      
      System.out.println();
   
   
   }


}