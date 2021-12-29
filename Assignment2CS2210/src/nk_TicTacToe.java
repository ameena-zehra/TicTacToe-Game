
public class nk_TicTacToe {
	
	private char[][] gameBoard;
	private int board_size;
	private int inline;
	
	/**
	* Constructor
	* initializes the gameBoard instance variable using the board_size input
	* enters a nested for loop to store a ' ' in every cell of the array
	* @param int board_size specified the size of the board 
	* @param int inline is the number of symbols needed to win the game
	* @param int max_levels is the maximum number of game tree that will be explored by the program
	*/
	public nk_TicTacToe(int board_size, int inline, int max_levels) {
		gameBoard = new char[board_size][board_size];
		this.board_size = board_size;
		this.inline = inline;
		for (int i=0; i<board_size; i++) {
			for (int j=0;j<board_size;j++ ) {
				gameBoard[i][j]=' ';
			}
		}
	}
	
	/**
	* Public createDictionary
	* @return returns an empty dictionary with a size that is a prime number between 6,000 to 8,000
	*/
	public Dictionary createDictionary() {
		Dictionary dict= new Dictionary(7057);
		return dict;
	}
	
	/**
	* Public repeatedConfig
	* represents the content of the gameBoard as a string as described above
	* then it checks whether the string representing the game board is in the configurations dictionary
	* if it is it returns its associated score or the value of -1
	* @param Dictionary configurations where the gameBoardString is checked in
	* @return returns either the associated score of the gameBoard or -1
	*/
	public int repeatedConfig(Dictionary configurations) {
		String gameBoardString = "";
		for (int i=0; i<board_size; i++) {
			for (int j=0;j<board_size;j++ ) {
				gameBoardString+=gameBoard[i][j];
			}
		}
		return configurations.get(gameBoardString);
	}
	
	/**
	* Public insertConfig
	* first represents the content of the gameBoard as a string
	* creates a Record object using the string and score
	* then it inserts the Record object in the configurations dictionary
	* @param Dictionary configurations where the gameBoardString is stored
	* @param int score of the gameBoardString
	*/
	public void insertConfig(Dictionary configurations, int score) {
		String gameBoardString = "";
		for (int i=0; i<board_size; i++) {
			for (int j=0;j<board_size;j++ ) {
				gameBoardString+=gameBoard[i][j];
			}
		}
		Record gameBoardrecord = new Record(gameBoardString, score);
		configurations.insert(gameBoardrecord);
		
	}
	
	/**
	* Public storePlay
	* Stores a symbol in gameBoard[row][col]
	* then it inserts the Record object in the configurations dictionary
	* @param int row number where the symbol is to be stored
	* @param int column number where the symbol is to be stored
	* @param char symbol to be stored
	*/
	public void storePlay(int row, int col, char symbol) {
		gameBoard[row][col]=symbol;
		
	}
	
	/**
	* Public squareisEmpty
	* @param int row number of the cell that is to be checked
	* @param int column number of the cell that is to be checked
	* @return boolean of true or false depending on if the cell stores a ' '
	*/
	public boolean squareIsEmpty(int row, int col) {
		if (gameBoard[row][col]==' ') {
			return true;
		}
		return false;
	}
	
	/**
	* Public wins
	* uses 4 helper variables to decipher if the symbol given has won the tac-tac toe game
	* @param char symbol to be checked
	* @return boolean of true or false depending on if the symbol has won tic tac toe
	*/
	public boolean wins(char symbol) {
		boolean horizontalwin = horizontalWin(symbol);
		if (horizontalwin==true) {
			return horizontalwin;
		}
		boolean verticalwin = verticalWin(symbol);
		if (verticalwin==true) {
			return verticalwin;
		}
		
		boolean diagonalRightwin = diagonalRightWin(symbol);
		if (diagonalRightwin==true) {
			return diagonalRightwin;
		}
		boolean diagonalLeftwin = diagonalLeftWin(symbol);
		if (diagonalLeftwin==true) {
			return diagonalLeftwin;
		}
		return false;
	}
	
	/**
	* Private helper method
	* used by wins to see if the symbol has the required inline characters to win a horizontal victory
	* @param char symbol to be checked
	* @return boolean of true or false depending on if the symbol has won tic tac toe horizontally
	*/
	private boolean horizontalWin(char symbol){
		int count;
		for (int i=0; i<board_size; i++) {
			count = 0;
			for (int j=0;j<board_size;j++ ) {
				if (gameBoard[i][j]==symbol) {
					count++;
					if (count >=inline) {
						return true;
					}
				}
				if ((gameBoard[i][j]!=symbol)&&(count>=1)) {
					count=0;
				}
			}
		}
		return false;
		
	}
	
	/**
	* Private helper method
	* used by wins to see if the symbol has the required inline characters to win a vertical victory
	* @param char symbol to be checked
	* @return boolean of true or false depending on if the symbol has won tic tac toe vertically
	*/
	private boolean verticalWin(char symbol) {
		int count;
		for (int j=0; j<board_size; j++) {
			count = 0;
			for (int i=0;i<board_size;i++ ) {
				if (gameBoard[i][j]==symbol) {
					count++;
					if (count >=inline) {
						return true;
					}
				}
				if ((gameBoard[i][j]!=symbol)&&(count>=1)) {
					count=0;
				}
			}
		}
		return false;
	}
	
	/**
	* Private helper method
	* used by wins to see if the symbol has the required inline characters to win a diagonal victory with a row pointing to the right
	* @param char symbol to be checked
	* @return boolean of true or false depending on if the symbol has won tic tac toe diagonally
	*/
	private boolean diagonalRightWin(char symbol) {

		for (int i=0; i<board_size; i++) {
			for (int j=0;j<board_size;j++ ) {
				if ((inline<=(board_size-i))&&(inline<=(board_size-j))){
					int count = 0;
					while((count<=inline)&&(i+count<board_size)&&(j+count<board_size) ){
						if (gameBoard[i+count][j+count]!=symbol ){
							break;
						}
						count++;	
					}
					if (count==inline) {
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	
	/**
	* Private helper method
	* used by wins to see if the symbol has the required inline characters to win a diagonal victory with a row pointing to the left
	* @param char symbol to be checked
	* @return boolean of true or false depending on if the symbol has won tic tac toe diagonally
	*/
	private boolean diagonalLeftWin(char symbol) {
		for (int i=0; i<board_size; i++) {
			for (int j=0;j<board_size;j++ ) {
				if ((inline<=(board_size-i))&&(inline<=(j+1))){
					int count = 0;
					while((count<=inline)&&(i+count<board_size)&&(j-count>=0)) {
						if (gameBoard[i+count][j-count]!=symbol ){
							break;
						}
						count++;	
					}
					if (count ==inline) {
						return true;
					}
					
				}
			}
		}
		return false;
	}
	
	/**
	* Public isDraw method
	* @return a boolean value of true or false if the gameBoard has not empty positions left and no player has won the game
	*/
	public boolean isDraw() {
		if ((wins('O')== true)||(wins('X')== true)) {
			return false;
		}
		for (int i=0; i<board_size; i++) {
			for (int j=0;j<board_size;j++ ) {
				if (squareIsEmpty(i,j)==true) {
					return false;
				}
			}
		}
		return true;
		
	}
	
	/**
	* Public isDraw method
	* @return 3 if the computer has won, 0 is the human has won, 2 if the game is a draw and 1 if the game is still undecided
	*/
	public int evalBoard() {
		
		if (wins('O')== true) {
			return 3;
		}
		if (wins('X')== true) {
			return 0;
		}
		if (isDraw()== true) {
			return 2;
		}
		return 1;
	}
}
