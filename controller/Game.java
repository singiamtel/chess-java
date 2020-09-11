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
	Game(){
		// Empty constructor starts a new game whites
		board[0][0] = new Rook();
		board[0][1] = new Knight();
		board[0][2] = new Bishop();
		board[0][3] = new Queen();
		board[0][4] = new King();
		board[0][5] = new Bishop();
		board[0][6] = new Knight();
		board[0][7] = new Rook();

		for(int i=0; i<8; ++i){
			board[1][i] = new Pawn();
		}
		for(int i=0; i<8; ++i){
			board[7][i] = new Pawn();
		}
		for(int i=2; i<7; ++i){
			for(int j=0; j<8; ++j){
				board[i][j] = null;
			}
		}
		//blacks
		board[7][0] = new Rook();
		board[7][1] = new Knight();
		board[7][2] = new Bishop();
		board[7][3] = new Queen();
		board[7][4] = new King();
		board[7][5] = new Bishop();
		board[7][6] = new Knight();
		board[7][7] = new Rook();
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
