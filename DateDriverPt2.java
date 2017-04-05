/*
Elijah Augustin
CSC 210
Lab 1 Part 2
*/
import javax.swing.JOptionPane;


class DateDriverPt2 {

      static int askUserForInput(String prompt) {
          int answer = 0;
          String question = null;
          
          question = JOptionPane.showInputDialog(prompt);
          answer = Integer.parseInt(question);
             
          return answer;
      }
      
      public static void main(String[] args) {
           int month = 0;
           int year = 0;
           int day = 0;
           Date anyDate = null;
            
           anyDate = new Date();
            
           year = askUserForInput("Enter a Year: ");
           month = askUserForInput("Enter a Month: ");
           day = askUserForInput("Enter a Day");
               
           JOptionPane.showMessageDialog(null, anyDate.determineJulianDate(year, month, day) + " days since Jan 1 1660.");
            
      }
        
}

class Date {

     private final static int EPOCH_YEAR = 1660;
     private final static int EPOCH_MONTH = 1;
     private final static int EPOCH_DAY = 1;
  
     public static boolean isLeapYear(int yearValue) {
     
        boolean leapYear = false;
        
        if (((yearValue % 4 == 0)&& (yearValue % 100 != 0)) || (yearValue % 400 == 0)){
            leapYear = true;
        }
        else {
            leapYear = false;
        }
            return leapYear;
     }
  
  
      public static int daysInAMonth(int year, int month) {
         	switch(month) {
         		case 1:  
               case 3:   
               case 5: 
               case 7:          		
         		case 8: 
               case 10:       
               case 12: return 31;         		        		
         		case 4:          		       		       		
         		case 6:               		         	
         		case 9:         	
         		case 11: return 30; 
               
               case 2:  if (isLeapYear(year)){
                           return 29;}
                        else {return 28;}       
         		default: return 0;
         
             }
            
      }
      
      
      public static int daysInAYear(int year) {
         return (isLeapYear(year) ? 366 : 365);
      }
      
      
      public static int determineJulianDate(int givenYear, int givenMonth, int givenDay) {
         int julianDate = 0;
         
         for (int year = EPOCH_YEAR; year < givenYear; year++) {
            julianDate += daysInAYear(year);
         }
         for (int month = EPOCH_MONTH; month < givenMonth; month++) {
            julianDate += daysInAMonth(givenYear, month);
         }
         
         return julianDate += givenDay;          
      }
         
}