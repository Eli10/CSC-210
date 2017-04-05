/*Elijah Augustin
Homework 1
CSC 210*/


class findMininmum {


   public static void main(String[] args) {
   
      int[] numArr = {4,76,32,3,901,9,16,891,89891023,9999};
      
      System.out.println(findMinimum(numArr));
      
            
   }
   
   
   public static int findMinimum(int array[]) {
      
         
         int smallestNum = 1000000000;
         
         if (array == null) {
            System.out.println("Array is null.");
            System.out.println(smallestNum = 0);
            System.exit(0);
         }
         
         if(array.length >= 11) {
            System.out.println("Array is larger than 10 elements.");
            System.out.println(smallestNum = 0);
            System.exit(0);
         }
         
         if(array.length < 1) {
            System.out.println("Array is smaller than 1 elements.");
            System.out.println(smallestNum = 0);
            System.exit(0);
         }
         
         for(int elementCounter = 0; elementCounter < array.length; elementCounter++) {
            if(array[elementCounter] <= 0) {
               System.out.println("An element in your arrray is smaller than or equal to zero.");
               System.out.println(smallestNum = 0);
               System.exit(0);
            }
         }
                 
         
         for(int counter = 0; counter < array.length; counter++) {
                         
            if(array[counter] < smallestNum) {
               smallestNum = array[counter];   
            }           
            
         }
         
         return smallestNum;
      
      }
}
