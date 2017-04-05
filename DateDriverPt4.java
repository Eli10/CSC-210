/*
Elijah Augustin
CSC 210
Lab 1 Part 4
*/
import javax.swing.JOptionPane;
import javax.swing.JFrame;


class Date {

     private final static int EPOCH_YEAR = 1660;
     private final static int EPOCH_MONTH = 1;
     private final static int EPOCH_DAY = 1;
     private int month = 0;
     private int year = 0;
     private int day = 0;
     
     public Date(int givenDay, int givenMonth, int givenYear) {
      this.day = givenDay;
      this.month = givenMonth;
      this.year = givenYear;
     }

     
     /* Accessor Methods */
     public int getDay() {
      return day;
     }
     
     public int getMonth() {
      return month;
     }
     
     public int getYear() {
      return year;
     }
     
     /* Mutator Methods */
     public void setDay(int givenDay) {
      day = givenDay;
     }
     
     public void setMonth(int givenMonth) {
      month = givenMonth;
     }
     
     public void setYear(int givenYear) {
      year = givenYear;
     }
     
     /* Figure out if year is a leap year */
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
  
     /* Figure out days in a month */
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
      
      /* Figure out days in Year */
      public static int daysInAYear(int year) {
         return (isLeapYear(year) ? 366 : 365);
      }
      
      /* Determine Julian Date */    
      public static int determineJulianDate(int givenYear, int givenMonth, int givenDay) {
         int julianDate = 0;
         
         for (int year = EPOCH_YEAR; year < givenYear; year++) {
            julianDate += daysInAYear(year);
         }
         for (int month = EPOCH_MONTH; month < givenMonth; month++) {
            julianDate += daysInAMonth(givenYear, month);
         }
         
         return julianDate += givenDay - 1;          
      }
      
      /* Determines the current Year from Julian Date */ 
      public static int determineYearFromJulianDate(int days) {
         int year = EPOCH_YEAR;
         for(year = year; days > daysInAYear(year); year++) {
            days = days - daysInAYear(year);
         }
         
         return year;
                  
      }
      
      /* Determines the current Month from Julian Date */ 
      public static int determineMonthFromJulianDate(int days) {
         int month = EPOCH_MONTH;
         int year = EPOCH_YEAR;
         int daysInAMonth = daysInAMonth(year, month);
         
        
         for(year = year; days > daysInAYear(year); year++) {
            days = days - daysInAYear(year);
         }
                 
         for(month = month; days >= daysInAMonth; month++) {
            days = days - daysInAMonth;
         }        
         return month;
                  
      }
      
      /* Determines the current Day from Julian Date */ 
      public static int determineDayFromJulianDate(int days) {
         int day = EPOCH_DAY;
         int month = EPOCH_MONTH;
         int daysInAYear = daysInAYear(determineYearFromJulianDate(days));
         int daysInAMonth = daysInAMonth(determineYearFromJulianDate(days), determineMonthFromJulianDate(days));
         int year = EPOCH_YEAR;
        
         for(year = year; days > daysInAYear(year); year++) {
            days = days - daysInAYear(year);
         }
         System.out.println(days);
         for(month = month; days > daysInAMonth; month++) {
            days = days - daysInAMonth;
            System.out.println(days);
         } 
         day += days;
         return day;
                  
      }     
      
      
      boolean isStringValid(String prompt) {
         boolean answer = false;
         
            if ((prompt != null) && (prompt.length() > 0)) {
               answer = true;
            }
            else {
               answer = false;
            }
            return answer;
      }  
      
      
            
}


class DateDriverPt4 {

      static int askUserForInput(String prompt) {
          int answer = 0;
          String question = null;
          
          question = JOptionPane.showInputDialog(prompt);
          answer = Integer.parseInt(question);
             
          return answer;
      }
      
      public static void main(String[] args) {
           
           int julianDate;
           JFrame frame = new JFrame("JOptionPane showMessageDialog example");
           Date anyDate = null;
           anyDate = new Date(0,0,0);
  
           anyDate.setYear(askUserForInput("Enter a Year: "));
           anyDate.setMonth(askUserForInput("Enter a Month: "));
           anyDate.setDay(askUserForInput("Enter a Day"));
           
           julianDate = anyDate.determineJulianDate(anyDate.getYear(), anyDate.getMonth(), anyDate.getDay());
               
           JOptionPane.showMessageDialog(frame, julianDate + " days since January 1, 1660.");
           
              
   
           
           JOptionPane.showMessageDialog(frame, "Year : " + anyDate.determineYearFromJulianDate(julianDate));
           JOptionPane.showMessageDialog(frame, "Month : " + anyDate.determineMonthFromJulianDate(julianDate));
           JOptionPane.showMessageDialog(frame, "Day : " + anyDate.determineDayFromJulianDate(julianDate));
            
            
      }
        
}
