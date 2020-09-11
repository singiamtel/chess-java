package controller;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;

public class Game {
	private Piece [][] board = new Piece[8][8];
	private Boolean turn;
	private Move [] moveList;
	public Game(){
		// Empty constructor starts a new game 
		// White pieces
		board[0][0] = new Rook(true, 0);
		board[0][1] = new Knight(true,1);
		board[0][2] = new Bishop(true,2);
		board[0][3] = new Queen(true,3);
		board[0][4] = new King(true,4);
		board[0][5] = new Bishop(true,5);
		board[0][6] = new Knight(true,6);
		board[0][7] = new Rook(true,7);

		for(int i=0; i<8; ++i){
			board[1][i] = new Pawn(true,1+i);
		}
		// Black pieces
		for(int i=0; i<8; ++i){
			board[6][i] = new Pawn(false, 8*6 + i);
		}
		board[7][0] = new Rook(false, 8*7 );
		board[7][1] = new Knight(false, 8*7 + 1);
		board[7][2] = new Bishop(false, 8*7 + 2);
		board[7][3] = new Queen(false, 8*7 + 3);
		board[7][4] = new King(false, 8*7 + 4);
		board[7][5] = new Bishop(false, 8*7 + 5);
		board[7][6] = new Knight(false, 8*7 + 6);
		board[7][7] = new Rook(false, 8*7 + 7);
		// Empty spaces
		for(int i=2; i<6; ++i){
			for(int j=0; j<8; ++j){
				board[i][j] = null;
			}
		}
	}

	public Piece getPieceAtSquare(int square){
		return board[(square/8)][square%8] ;
	}
	// This function is only for debug purposes and should never execute
	public void printBoard(){
			for(int j=7; j>=0; j--){
				for(int k=0; k<8; ++k){
					System.out.print(this.board[j][k] + " ");
				}
				System.out.println("");
			}
	
	}
}
