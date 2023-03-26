package spreadsheet123;

public class ValueCell implements Cell {
   private double value;
   private String input;
   private String fillStr;
   private String fullCellText;
   private boolean hasDecimal;
   
   
   public ValueCell(String input) {
      //super(input);
      hasDecimal = true;
      this.input = input;
      //value = super.getDoubleValue();
      value = Double.parseDouble(input);
      fullCellText = fillStr = input;
      
      if (input.indexOf(".") == -1) {
         hasDecimal = false;
      }
      
      String test = fillStr.trim();
      if (test.endsWith("000")) {
         fillStr = test.substring(0, test.length() - 3);
         input = fillStr;
      }
      else if (test.endsWith(".00")) {
         fillStr = test.substring(0, test.length() - 1);
         input = fillStr;
      }
      
      if (hasDecimal == false) {
         if (input.length() < 10) {
            fillStr += ".0";
            int testLength = fillStr.length();
            for (int i = 0; i < 10 - testLength; i++) {
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
   
   } //close constructor
   
//    public double getDoubleValue() {
//       return value;
//    }
   
   public String abbreviatedCellText() {
      return fillStr;
   }
   
   public String fullCellText() {
      return fullCellText;
   }
   
   
}