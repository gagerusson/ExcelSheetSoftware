package spreadsheet123;

public class PercentCell implements Cell {
   private double value;
   private String number;
   private String abbCellText;
   private String fullCellText;
   
   public PercentCell(String number) {
      value = getDoubleValue();
      this.number = number;
      abbCellText = number.substring(0, number.indexOf("."));
      abbCellText += "%";
      String test = abbCellText;

      for (int i = 0; i < 10 - test.length(); i++) {
         abbCellText += " ";
      }
   
      //full cell
      fullCellText = number.replace("%", "").trim();
      String tempNumber = fullCellText.replace(".", "").trim();
      if (number.indexOf(".") == 1) {
         fullCellText = "0.0" + tempNumber;
      }
      else {
         fullCellText = "0." + tempNumber;
      }
   }
   
   public double getDoubleValue() {
      return value;
   }
   
   public String abbreviatedCellText() {
      return abbCellText; //needs to end in %
   }
   
   public String fullCellText() {
      return fullCellText;
   }
   
   
}