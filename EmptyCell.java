package spreadsheet123;

public class EmptyCell implements Cell {
    String abbreviatedCellText;
    String fullCellText;
   

    public EmptyCell() {
      abbreviatedCellText = "          ";
      fullCellText = "";
    }
    
    public String abbreviatedCellText() {
      return abbreviatedCellText;
    }
    
    public String fullCellText() {
      return fullCellText;
    }  
   
}