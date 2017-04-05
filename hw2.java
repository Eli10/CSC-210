import javax.swing.JOptionPane;

public class hw2
{
   public static void main(String[] args)
   {
      int month = 0;
      int year = 0;
      
  
      month = askUserForInput("What year is it?");
      year = askUserForInput("Can you please type in the month number?");
         
      JOptionPane.showMessageDialog(null, DaysInAMonth(month, year) + " days in the month" );
      
   }
   
   
      public static int askUserForInput(String prompt){
         int answer = 0;
         String question = null;
    
         question = JOptionPane.showInputDialog(prompt);
         answer = Integer.parseInt(question);
         
         return answer;
      }
      
   
      public static int DaysInAMonth(int year, int month) 
      {
         	switch(month) {
         		case 1:  return 31;
         		case 2:  if (isLeapYear(year)){
                           return 29;}
                        else {return 28;}
                        
         		case 3:  return 31;        		
         		case 4:  return 30;        		
         		case 5: return 31;        		
         		case 6: return 30;         
         		case 7: return 31;         		
         		case 8: return 31;         	
         		case 9: return 30;        	
         		case 10: return 31;      
         		case 11: return 30;        
         		case 12: return 31;
         		default: return 0;
         
             }
            
         }
         
         public static boolean isLeapYear(int yearValue){
            boolean LeapYear = false;
            if (((yearValue % 4 == 0)&& (yearValue % 100 != 0)) || (yearValue % 400 == 0)){
               LeapYear = true;
            }
            else {
               LeapYear = false;
            }
            return LeapYear;
         }



}






