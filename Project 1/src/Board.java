import java.util.Scanner;

/**
 * @author Nihaal Manesia
 * @version 1.0
 * @since 9/5/2017
 */

public class Board {
	
	/**Used as the board which is displayed in the console*/
	char [][] board = new char[8][8];
	/**Used to insert a piece and first validate move before adding piece to actual board and printing to screen*/
	char [][] grid = new char[8][8];
	
	/**
	 * Initializes the board class which holds methods to interact
	 * with the board and to create the board using ASCII art.
	 */
	public Board() {
		for(int r = 0; r<grid.length; r++) {
			for(int c = 0; c<grid[r].length;c++) {
				grid[r][c] = ' ';
			}
		}
		grid[3][3] = 'W';
		grid[4][3] = 'B';
		grid[3][4] = 'B';
		grid	[4][4] = 'W';
		
		paintBoard();
	}
	
	/**
	 * Goes through the grid[][] and counts how many pieces are on the board in order to determine whether board is full or not
	 * @return true, if board is full, therefore ending the game
	 */
	private boolean gameOver(){
		boolean full = false;
		int total = 0;
		
		for(int r = 0; r<grid.length; r++) {
			for(int c = 0; c<grid[r].length;c++) {
				if((grid[r][c] == 'W') || (board[r][c] == 'B')) {
					total++;
				}
			}
		}
		if(total == 64) {
			full = true;
		}
		return full;
	}
	
	/**
	 * Counts the number of pieces on board for each player and prints out the current status of the game
	 * @param turn holds the char 'B' or 'W' in order to determine whose turn it is
	 */
	private void status(char turn) {
		int black = 0;
		int white = 0;
		
		for(int r = 0; r<grid.length; r++) {
			for(int c = 0; c<grid[r].length;c++) {
				if(grid[r][c] == 'B') {
					black++;
				}
				else if(grid[r][c] == 'W') {
					white++;
				}
			}
		}
		
		if(turn == 'B') {
			System.out.println("Black has " + black + " pieces. White has " + white + " pieces.");
		}
		else if(turn == 'W') {
			System.out.println("Black has " + black + " pieces. White has " + white + " pieces.");
		}
	}
	
	/**
	 * Used to end the game and determine the winner, based on who has more pieces on the board at the end
	 */
	private void endGame() {
		int white = 0;
		int black = 0;
		
		for(int r = 0; r<grid.length; r++) {
			for(int c = 0; c<grid[r].length;c++) {
				if(grid[r][c] == 'B') {
					black++;
				}
				else if(grid[r][c] == 'W') {
					white++;
				}
			}
		}
		
		if(white > black) {
			System.out.println("Game over. The winner is black!");
		}
		else if(black > white) {
			System.out.println("Game over. The winner is white!");
		}
		else {
			System.out.println("Game over. It's a tie game!");
		}
	}
	
	/**
	 * Method which uses all other methods to check if move is valid, takes in the row and column where player would like to place piece and continues play
	 */
	public void play() {
		Scanner console = new Scanner(System.in);
		char move = 'B';
		
		System.out.println("Black players turn");
		
		while(!gameOver()) {
			status(move);
			int row = 0;
			int col = 0;
			boolean valid = false;
			
			while(!valid) {
				System.out.println("Enter the row you would like to place your piece at: ");
				col = console.nextInt() - 1;
				System.out.println("Enter the column you would like to place your piece at: ");
				row = console.nextInt() - 1;
				valid = validMove(move,row,col);
			}
			
			turn(move, row, col);
			
			if(move == 'B') {
				move = 'W';
				System.out.println("White players turn");
			}
			else {
				move = 'B';
				System.out.println("Black players turn");
			}
		}
		console.close();
		endGame();
	}
	
	/**
	 * Checks to make sure the desired location for new piece is valid based on game rules.
	 * @param turn holds current turn based on char 'W' or 'B'
	 * @param r holds the row which player has attempted to place piece at
	 * @param c holds the column which player has attempted to place piece at
	 * @return whether or not the move is valid or not based on position entered
	 */
	private boolean validMove(char turn, int r, int c) {
		boolean valid = false;
		
		char oppositeColor = 'B';
		
		if(turn == 'B') {
			oppositeColor = 'W';
		}
		
		if(grid[r][c] == ' ') {
			if(r+1<8 && c+1<8 && grid[r+1][c+1]==oppositeColor) {
				valid = true;
			}
			else if(r+1<8 && grid[r+1][c]==oppositeColor) {
				valid = true;
			}
			else if(c+1<8 && grid[r][c+1]==oppositeColor) {
				valid = true;
			}
			else if(c-1>-1 && grid[r][c-1]==oppositeColor) {
				valid = true;
			}
			else if(r-1>-1 && c-1>-1 && grid[r-1][c-1]==oppositeColor) {
				valid = true;
			}
			else if(r-1>-1 && grid[r-1][c]==oppositeColor) {
				valid = true;
			}
			else if(r-1>-1 && c+1<8 && grid[r-1][c+1] == oppositeColor) {
				valid = true;
			}
			else if(r+1<8 && c-1>-1 && grid[r+1][c-1] == oppositeColor) {
				valid = true;
			}
		}
		if(valid == false) {
			System.out.println("Not a valid input. Try again:");
		}
		return valid;
	}
	
	/**
	 * Calls on direction() in order to turn the other players pieces based on current players move
	 * @param turn holds current turn based on char 'W' or 'B'
	 * @param row holds the row which player has attempted to place piece at
	 * @param col holds the column which player has attempted to place piece at
	 */
	private void turn(char turn, int row, int col) {
		grid[row][col] = turn;
		
		//above and below
		direction(row, col, turn, 0, -1);
		direction(row, col, turn, 0, 1);
		//right and left
		direction(row, col, turn, 1, 0);
		direction(row, col, turn, -1, 0);
		//diagonals
		direction(row, col, turn, 1, 1);
		direction(row, col, turn, -1, -1);
		direction(row, col, turn, 1, -1);
		direction(row, col, turn, -1, 1);
		
		paintBoard();
	}
	
	/**
	 * Takes the move presented by player and flips the other players pieces in every direction
	 * @param row holds row at which player is placing piece
	 * @param col holds column at which player is placing piece
	 * @param color holds which color the current player is 'W' or 'B'
	 * @param colDir 1 means forward, -1 means backwards, so up or down the column
	 * @param rowDir 1 means forward, -1 means backwards so left or right in the row
	 */
	private void direction(int row, int col, char color, int colDir, int rowDir) {
		int currentRow = row + rowDir;
		int currentCol = col + colDir;
		
		if(currentRow == 8 || currentCol == 8 || currentRow == 0 || currentCol == 0) {
			return;
		}
		
		while((grid[currentRow][currentCol] == 'B') || (grid[currentRow][currentCol] == 'W')) {
			if(grid[currentRow][currentCol] == color) {
				while(!(row == currentRow && col == currentCol)) {
					grid[currentRow][currentCol] = color;
					currentRow -= rowDir;
					currentCol -= colDir;
				}
				break;
			}
			else {
				currentRow += rowDir;
				currentCol += colDir;
			}
			if(currentRow < 0 || currentCol < 0 || currentRow == 8 || currentCol == 8) {
				break;
			}
		}
	}
	
	/**
	 * Moves the pieces from grid[][] to board[][] then prints the current state of the board to the console
	 */
	private void paintBoard() {
		
		for(int r = 0; r<grid.length; r++) {
			for(int c = 0; c<grid[r].length; c++) {
				board[r][c] = grid[r][c];
			}
		}
		
		System.out.println("   1 2 3 4 5 6 7 8\n"
				+ "  -----------------\n"
				+ "1 |" + board[0][0] + "|" + board[1][0] + "|" + board[2][0] + "|" + board[3][0] + "|" + board[4][0] + "|" + board[5][0] + "|" + board[6][0] + "|" + board[7][0] + "|\n"
				+ "  -----------------\n"
				+ "2 |" + board[0][1] + "|" + board[1][1] + "|" + board[2][1] + "|" + board[3][1] + "|" + board[4][1] + "|" + board[5][1] + "|" + board[6][1] + "|" + board[7][1] + "|\n"
						+ "  -----------------\n"
				+ "3 |" + board[0][2] + "|" + board[1][2] + "|" + board[2][2] + "|" + board[3][2] + "|" + board[4][2] + "|" + board[5][2] + "|" + board[6][2] + "|" + board[7][2] + "|\n"
						+ "  -----------------\n"
				+ "4 |" + board[0][3] + "|" + board[1][3] + "|" + board[2][3] + "|" + board[3][3] + "|" + board[4][3] + "|" + board[5][3] + "|" + board[6][3] + "|" + board[7][3] + "|\n"
						+ "  -----------------\n"
				+ "5 |" + board[0][4] + "|" + board[1][4] + "|" + board[2][4] + "|" + board[3][4] + "|" + board[4][4] + "|" + board[5][4] + "|" + board[6][4] + "|" + board[7][4] + "|\n"
						+ "  -----------------\n"
				+ "6 |" + board[0][5] + "|" + board[1][5] + "|" + board[2][5] + "|" + board[3][5] + "|" + board[4][5] + "|" + board[5][5] + "|" + board[6][5] + "|" + board[7][5] + "|\n"
						+ "  -----------------\n"
				+ "7 |" + board[0][6] + "|" + board[1][6] + "|" + board[2][6] + "|" + board[3][6] + "|" + board[4][6] + "|" + board[5][6] + "|" + board[6][6] + "|" + board[7][6] + "|\n"
						+ "  -----------------\n"
				+ "8 |" + board[0][7] + "|" + board[1][7] + "|" + board[2][7] + "|" + board[3][7] + "|" + board[4][7] + "|" + board[5][7] + "|" + board[6][7] + "|" + board[7][7] + "|\n"
				+ "  -----------------\n");
	}
}