package spreadsheet123;

public class FormulaCell implements Cell {
   private String abbCellText;
   private String fullCellText;
   private double dub;
   
   public FormulaCell(String formula) {
      this.dub = 0.0;
      fullCellText = formula;
      
      if (fullCellText.length() > 10) {
         abbCellText = formula.substring(0, 10);
      }
      else if (fullCellText.length() < 10) {
         for (int i = 0; i < 10 - fullCellText.length(); i++) {
            abbCellText += " ";
         }
      }
   }
   
   public double getDoubleValue() {
      return dub;
   }
   
   public String abbreviatedCellText() {
      return abbCellText;
   }
   
   public String fullCellText() {
      return fullCellText;
   }
   
   
}