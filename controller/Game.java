package controller;

import java.util.ArrayList;

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
	private Boolean whitePlays;
	private Pawn enPassant;

	public Game(boolean empty){
		board[3][3] = new Knight(true,new Pair<Integer, Integer>(3,3));
		board[0][0] = new King(true,new Pair<Integer, Integer>(0,0));
		board[1][2] = new King(false,new Pair<Integer, Integer>(1,2));
		board[4][2] = new Pawn(false,new Pair<Integer, Integer>(4,2));
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
		this.whitePlays = true;
	}

	public Piece getPieceAtSquare(int square){
		int x = square/8;
		int y = square%8;
		return board[x][y];
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
	public boolean isKingOnCheck(boolean isWhite){
		ArrayList<Move> enemyMoves = new ArrayList<Move>(this.generateAllColourMoves(!isWhite));
		Piece king = findKing(isWhite);
		for (int i = 0; i < enemyMoves.size(); i++) {
			if(enemyMoves.get(i).getTo().equals(king.getPosition())){
				return true;
			}
		}
		return false;
	}
	private Piece findKing(boolean isWhite){
		for(int i=0; i<8; ++i){
			for (int j = 0; j < 8; j++) {
				Piece tmp = this.getPieceAtSquare(new Pair<Integer, Integer>(i, j));
				if(tmp != null){
					if(tmp instanceof King && tmp.isWhite() == isWhite){
						return tmp;
					}
				}
			}
		}
		// TODO: no king exception
		return null;
	}
	public ArrayList<Move> generateAllColourMoves(boolean isWhite){
		ArrayList<Move> list = new ArrayList<Move>();
		for(int i = 0; i<8; ++i){
			for(int j = 0; j<8; ++j){
				Piece attempt = this.getPieceAtSquare(new Pair<Integer, Integer>(i,j));
				if(attempt != null && attempt.isWhite() == isWhite){
					ArrayList<Move> tmp = attempt.generateMoves(this);
					if(tmp != null) list.addAll(tmp);
				}
			}
		}
		return list;
	}

}
