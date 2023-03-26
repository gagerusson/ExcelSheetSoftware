package spreadsheet123;

public class RealCell implements Cell {
   private String input;
   private double doubleVal;
   private String fillStr;
   private String fullCellText;
   
   public RealCell(String input) {
      this.input = Double.toString(getDoubleValue());
      doubleVal = Double.parseDouble(input);
      fillStr = fullCellText = input;
      boolean hasDecimal = true;
      
      if (input.indexOf(".") == -1) {
         hasDecimal = false;
      }
      
      if (hasDecimal == false) {
         if (input.length() < 10) {
            fillStr += ".0";
            int test = fillStr.length();
            for (int i = 0; i < 10 - test; i++) {
                  fillStr += " ";
            }
         }
         else if (input.length() > 10 ) {
            fillStr = input.substring(0, 8);
            fillStr += ".0";
         }
      }
      else { //has decimal
         if (input.length() < 10) {
            for (int i = 0; i < 10 - input.length(); i++) {
                  fillStr += " ";
            }
         }
         else if (input.length() > 10 ) {
            fillStr = input.substring(0, 10);
         }
      }
   }
   
   public double getDoubleValue() {
      return doubleVal;
   }
   
   public String abbreviatedCellText() {
      return fillStr;
   }
   
   public String fullCellText() {
      return fullCellText;
   }

}