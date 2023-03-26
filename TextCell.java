package spreadsheet123;

public class TextCell implements Cell {
   private String abbCellText;
   private String fullCellText;
   
   
   public TextCell(String input) {
      this.fullCellText = input;
      
      //String noQuotes = input.substring(1, input.length() - 1);
      String noQuotes = input.replace("\"", "");
      String fillStr = noQuotes;
      
      if (noQuotes.length() > 10) {
         this.abbCellText = noQuotes.substring(0, 10);
      }
      else if (noQuotes.length() < 10) {
         for (int i = 0; i < 10 - noQuotes.length(); i++) {
            fillStr += " ";
         }
         this.abbCellText = fillStr;
      }
      else {
         this.abbCellText = noQuotes;
      }
   }
   
   public String abbreviatedCellText() {
      return abbCellText;
   }
   
   public String fullCellText() {
      return fullCellText;
   }
   
}
