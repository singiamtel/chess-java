package controller;

import pieces.Bishop;
import pieces.King;
import pieces.Knight;
import pieces.Pawn;
import pieces.Piece;
import pieces.Queen;
import pieces.Rook;
import utilities.Pair;

public class Game {
	private Piece [][] board = new Piece[8][8];
	private Boolean turn;
	private Move [] moveList;

	public Game(boolean empty){
	}
	public Game(){
		// Empty constructor starts a new game 
		// White pieces
		board[0][0] = new Rook(true, new Pair<Integer, Integer>(0,0));
		board[0][1] = new Knight(true,new Pair<Integer, Integer>(0,1));
		board[0][2] = new Bishop(true,new Pair<Integer, Integer>(0,2));
		board[0][3] = new Queen(true,new Pair<Integer, Integer>(0,3));
		board[0][4] = new King(true,new Pair<Integer, Integer>(0,4));
		board[0][5] = new Bishop(true,new Pair<Integer, Integer>(0,5));
		board[0][6] = new Knight(true,new Pair<Integer, Integer>(0,6));
		board[0][7] = new Rook(true,new Pair<Integer, Integer>(0,7));

		for(int i=0; i<8; ++i){
			board[1][i] = new Pawn(true,new Pair<Integer, Integer>(1,i));
		}
		// Black pieces
		for(int i=0; i<8; ++i){
			board[6][i] = new Pawn(false, new Pair<Integer, Integer>(6, i));
		}
		board[7][0] = new Rook(false,new Pair<Integer, Integer>(7,0));
		board[7][1] = new Knight(false,new Pair<Integer, Integer>(7,1));
		board[7][2] = new Bishop(false,new Pair<Integer, Integer>(7,2));
		board[7][3] = new Queen(false,new Pair<Integer, Integer>(7,3));
		board[7][4] = new King(false,new Pair<Integer, Integer>(7,4));
		board[7][5] = new Bishop(false,new Pair<Integer, Integer>(7,5));
		board[7][6] = new Knight(false,new Pair<Integer, Integer>(7,6));
		board[7][7] = new Rook(false,new Pair<Integer, Integer>(7,7));

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
	public Piece getPieceAtSquare(Pair<Integer, Integer> square){
		return board[square.getFirst()][square.getSecond()];
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