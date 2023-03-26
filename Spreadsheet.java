package spreadsheet123;

// Update this file with your own code.

public class Spreadsheet implements Grid {
   private final int rows = 20;
   private final int cols = 12;
   private final int CELL_WIDTH = 10;
   private Cell[][] cells;
   
   //constructor
   public Spreadsheet() {   
      cells = new Cell[rows][cols];
      //create an empty spreadsheet
      for (int i = 0; i < cells.length; i++) {
         for (int j = 0; j < cells[i].length; j++) {
            cells[i][j] = new EmptyCell();
         }
      }
   }
   
   public String setCell(SpreadsheetLocation location, Cell cell) {
      cells[location.getRow()][location.getCol()] = cell;
      return getGridText();
     
   }
           
           
                 
  public String processCommand(String command) {
      command = command.trim();
      
      if (command.equals("")) { //empty command
         return command;
      }
      
      int firstSpace = command.indexOf(" ");
      String first; //<cell> name
      String leftOver; //whats left *= ...
    
      //determine if <cell> row is single or double digit
      if (command.indexOf(" ") != -1) { 
         first = command.substring(0, firstSpace).trim();
         if (firstSpace == 5) { //if command is clear <cell>
            leftOver = command.substring(firstSpace + 1).trim();
         }
         else {
            leftOver = command.substring(firstSpace + 2).trim();
         }
      }
      else {
         first = command;
         leftOver = "";
      }
      
      String spread;
      //if command is clear *make different location
      if (firstSpace == 5) {
         spread = leftOver;
      }
      else {
         spread = first;
      }      

      SpreadsheetLocation location = new SpreadsheetLocation(spread); //SpdsheetLocation obj 

      // <clear> || <clear> <cell>
      if (first.toUpperCase().startsWith("CLEAR")) {
         if (leftOver.equals("")) {
            clear();
            return getGridText();
         }
         else {
            return clearCell(location);
         }       
      }       
      
      //cell inspection
      if (leftOver.equals("")) {
           return cells[location.getRow()][location.getCol()].fullCellText();
      }
      else { //decide what cell it is
         return cellType(location, leftOver);
      }
           
   } //end processCommand
      
   public void clear() {
      for (int i = 0; i < cells.length; i++) {
         for (int j = 0; j < cells[i].length; j++) {
            cells[i][j] = new EmptyCell();
         }
      }
   }
   
   public String clearCell(SpreadsheetLocation location) {
      Cell Empty = new EmptyCell();
      setCell(location, Empty);
      return getGridText();
   }
   
   public String cellType(SpreadsheetLocation location, String command) {
      
      if (command.startsWith("(") && command.endsWith(")")) { //FormulaCell
         cells[location.getRow()][location.getCol()] = new FormulaCell(command);     
      }
      else if (command.endsWith("%")) { //PercentCell
         cells[location.getRow()][location.getCol()] = new PercentCell(command);
      }
      else if (command.startsWith("\"") && command.endsWith("\"")) { //TextCell
         cells[location.getRow()][location.getCol()] = new TextCell(command);
      }
      else {
         cells[location.getRow()][location.getCol()] = new ValueCell(command);
      }
            
      return getGridText();  
   }
   
   public int getRows() {
      return rows;	
	}

	public int getCols() {
      return cols;      
	}

	
	public Cell getCell(Location loc) {     
		
		return cells[loc.getRow()][loc.getCol()];
	}      
   
   public String createRow(String rowNum, String[] inputs) {
       String start;
       String border = "|";
       String row = "";
       if (rowNum.length() == 1) {
          start = rowNum + "  ";
       }
       else {
          start = rowNum + " ";
       }

       for (int i = 0; i < cols; i++) {
          row += inputs[i] + border;
       }       
       
       return start + border + row;
   }        

	public String getGridText() {
      String header = "   |A         |B         |C         |D         |E         |F         |G         |H         |I         |J         |K         |L         |\n";
      String grid = header;
      
      for (int row = 0; row < rows; row++) {
         String[] inputs = new String[cols];
         for (int col = 0; col < cols; col++) {
            //input for each cell *all empty cells atm* - fills up arr with 12 cells
            inputs[col] = cells[row][col].abbreviatedCellText();
         }
         grid += createRow(String.valueOf(row + 1), inputs) + "\n";
      }
      
      return grid;
      
   }

}     

