import javax.swing.JOptionPane;

class Algorithm2 {

    public static void main(String[] args) {

        JOptionPane.showMessageDialog(null,isYearValid(1400));
        JOptionPane.showMessageDialog(null,isMonthValid(3));
        /*JOptionPane.showMessageDialog(null,isDayValid(1900, 8, 7))*/
    }

    public static boolean isYearValid(int year) {
      boolean answer;
      answer = (year >= 1660) ? true : false;
      return answer;
    }

    public static boolean isMonthValid(int month) {
      boolean answer;
      answer = (month > 1 && month <=12) ? true : false;
      return answer;
    }
/*
    public static boolean isDayValid(int year, int month, int day) {
      boolean answer;
      answer (day >= 1 && day <= daysInAMonth(year, month)) ? true : false;
      return answer;
    }
*/
}
