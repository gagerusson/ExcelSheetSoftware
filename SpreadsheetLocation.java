package spreadsheet123;

//Update this file with your own code.

public class SpreadsheetLocation implements Location {
    private int row;
    private int col;
    private String cellName;
    
    public SpreadsheetLocation(String cellName) {
      this.cellName = cellName;    
    }
    
    @Override
    public int getRow() { 
      if (cellName.toUpperCase().startsWith("CLEAR")) {
         return Integer.parseInt(cellName.substring(6)) - 1;
      }
      else {  
         return Integer.parseInt(cellName.substring(1)) - 1;  
      }   
    }

    @Override
    public int getCol() {
      char firstChar = cellName.charAt(0);
      int colNumber = Character.toUpperCase(firstChar) - 'A';
      
      return colNumber;
    }
    

}
