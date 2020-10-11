package controller;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JPanel;

import controller.Move.promotions;
import pieces.*;
import utilities.Pair;
import utilities.Raycast;

public class Game {
	private Piece [][] board = new Piece[8][8];
	private boolean whitePlays;
	private Move.promotions promotion;
	private Pair enPassant;
	
	private boolean whiteKingRook;
	private boolean whiteQueenRook;
	private boolean blackKingRook;
	private boolean blackQueenrook;


	// Test game
	public Game(boolean empty){
		board[3][3] = new Knight(true,new Pair(3,3));
		board[0][0] = new King(true,new Pair(0,0));
		board[1][2] = new King(false,new Pair(1,2));
		board[4][2] = new Pawn(false,new Pair(4,2));
	}

	private Piece[][] cloneBoard(){
		Piece [][] newBoard = new Piece[8][8];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if(board[i][j] != null) {
					newBoard[i][j] = board[i][j].clonePiece();
				}
				else newBoard[i][j] = board[i][j];
			}
		}
		return newBoard;
	}
	public Game(Game game){

		this.board = game.cloneBoard();

		this.whitePlays = game.whitePlays;
	}
	public Game(){
		// Empty constructor starts a new game 
		// White pieces
		board[0][0] = new Rook(true, new Pair(0,0));
		board[0][1] = new Knight(true,new Pair(0,1));
		board[0][2] = new Bishop(true,new Pair(0,2));
		board[0][3] = new Queen(true,new Pair(0,3));
		board[0][4] = new King(true,new Pair(0,4));
		board[0][5] = new Bishop(true,new Pair(0,5));
		board[0][6] = new Knight(true,new Pair(0,6));
		board[0][7] = new Rook(true,new Pair(0,7));

		for(int i=0; i<8; ++i){
			board[1][i] = new Pawn(true,new Pair(1,i));
		}
		// Black pieces
		for(int i=0; i<8; ++i){
			board[6][i] = new Pawn(false, new Pair(6, i));
		}
		board[7][0] = new Rook(false,new Pair(7,0));
		board[7][1] = new Knight(false,new Pair(7,1));
		board[7][2] = new Bishop(false,new Pair(7,2));
		board[7][3] = new Queen(false,new Pair(7,3));
		board[7][4] = new King(false,new Pair(7,4));
		board[7][5] = new Bishop(false,new Pair(7,5));
		board[7][6] = new Knight(false,new Pair(7,6));
		board[7][7] = new Rook(false,new Pair(7,7));
		
		whiteKingRook = true;
		whiteQueenRook = true;
		blackKingRook = true;
		blackQueenrook = true;

		// Empty spaces
		for(int i=2; i<6; ++i){
			for(int j=0; j<8; ++j){
				board[i][j] = null;
			}
		}
		this.whitePlays = true;
	}

	public boolean whitePlays() {
		return this.whitePlays;
	}

	public void setWhitePlays(boolean whitePlays) {
		this.whitePlays = whitePlays;
	}

	public Piece getPieceAtSquare(int square){
		int x = square/8;
		int y = square%8;
		return board[x][y];
	}
	public Piece getPieceAtSquare(Pair square){
		return board[square.getFirst()][square.getSecond()];
	}

	// This function is only for debug purposes and should never execute
	public void printBoard(){
			for(int j=7; j>=0; j--){
				for(int k=0; k<8; ++k){
					if(this.board[j][k] != null) System.out.print(this.board[j][k].getClass().getName() + " ");
					else System.out.print("null ");
				}
				System.out.println("");
			}
	
	}


	public boolean isLocationOnCheck(boolean isWhite, Pair location){
		Piece king = new King(isWhite, location);
		// Rooks, bishops and queens
		if(Raycast.kingRaycast(this, king)){
			return true;
		}
		// Knights
		for (Pair move : Knight.moves) {
			Pair attempt = king.getPosition().addPair(move);
			if(Move.isOutOfBounds(attempt)){
				continue;
			}
			if(getPieceAtSquare(attempt) instanceof Knight && getPieceAtSquare(attempt).isWhite() != isWhite){
				return true;
			}

		}
		// Pawns
		Pair firstPos = king.getPosition().addPair(new Pair(king.isWhite()? 1 : -1, 1));
		if (!firstPos.isOutOfBounds()) {
			Piece first = getPieceAtSquare(firstPos);
			if (first != null && first.isWhite() != king.isWhite() && first instanceof Pawn) {
				return true;
			}
		}
		Pair secondPos = king.getPosition().addPair(new Pair(king.isWhite()? 1 : -1, -1));
		if (!secondPos.isOutOfBounds()) {
			Piece second = getPieceAtSquare(secondPos);
			if (second != null && second.isWhite() != king.isWhite() && second instanceof Pawn) {
				return true;
			}
		}

		// Other kings
		for(Pair i : King.moves){
			Pair sqr = king.getPosition().addPair(i);
			if(sqr.isOutOfBounds()) continue;
			if(getPieceAtSquare(sqr) instanceof King) {
				if(getPieceAtSquare(sqr).isWhite() != this.whitePlays) {
					return true;
				}
			}
		}

		return false;
	}

	
	public boolean isKingOnCheck(boolean isWhite){
		Piece king = findKing(isWhite);
		// Rooks, bishops and queens
		if(Raycast.kingRaycast(this, king)){
			return true;
		}
		// Knights
		for (Pair move : Knight.moves) {
			Pair attempt = king.getPosition().addPair(move);
			if(Move.isOutOfBounds(attempt)){
				continue;
			}
			if(getPieceAtSquare(attempt) instanceof Knight && getPieceAtSquare(attempt).isWhite() != isWhite){
				return true;
			}

		}
		// Pawns
		Pair firstPos = king.getPosition().addPair(new Pair(king.isWhite()? 1 : -1, 1));
		if (!firstPos.isOutOfBounds()) {
			Piece first = getPieceAtSquare(firstPos);
			if (first != null && first.isWhite() != king.isWhite() && first instanceof Pawn) {
				return true;
			}
		}
		Pair secondPos = king.getPosition().addPair(new Pair(king.isWhite()? 1 : -1, -1));
		if (!secondPos.isOutOfBounds()) {
			Piece second = getPieceAtSquare(secondPos);
			if (second != null && second.isWhite() != king.isWhite() && second instanceof Pawn) {
				return true;
			}
		}

		// Other kings
		for(Pair i : King.moves){
			Pair sqr = king.getPosition().addPair(i);
			if(sqr.isOutOfBounds()) continue;
			if(getPieceAtSquare(sqr) instanceof King) return true;
		}

		return false;
	}

	private Piece findKing(boolean isWhite) {
		for (int i = 0; i < 8; ++i) {
			for (int j = 0; j < 8; j++) {
				Piece tmp = this.getPieceAtSquare(new Pair(i, j));
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
				Piece attempt = this.getPieceAtSquare(new Pair(i,j));
				if(attempt != null && attempt.isWhite() == isWhite){
					ArrayList<Move> tmp = attempt.generateMoves(this, true);
					if(tmp != null) list.addAll(tmp);
				}
			}
		}
		return list;
	}
	public void setPromotion(Move.promotions promotion) {
		this.promotion = promotion;
	}

	public void makeMove(Move move, boolean fake) {


		if(!fake && getPieceAtSquare(new Pair(move.getFrom().getFirst(),move.getFrom().getSecond())) instanceof Pawn &&
				(this.whitePlays ? move.getTo().getFirst() == 7 : move.getTo().getFirst() == 0)) {
			Move.promotions chosenPromotion = choosePromotion();
			promotion = chosenPromotion;
			this.board[move.getTo().getFirst()][move.getTo().getSecond()] = makePromotion(chosenPromotion,this.whitePlays,move.getTo());
		}
		if(move.getPromotion() != null) {
			this.board[move.getTo().getFirst()][move.getTo().getSecond()] = makePromotion(move.getPromotion(),this.whitePlays,move.getTo());
			promotion = null;
		}else{
			if(promotion == null) {
			this.board[move.getTo().getFirst()][move.getTo().getSecond()] = this.board[move.getFrom().getFirst()][move
                    .getFrom().getSecond()].clonePiece();
			}
		}
		if(board[move.getFrom().getFirst()][move.getFrom().getSecond()] instanceof Pawn && Math.abs(move.getFrom().getFirst() - move.getTo().getFirst()) == 2) {
			if(whitePlays) {
				enPassant = new Pair(move.getTo().getFirst() -1, move.getTo().getSecond());
			}else {
				enPassant = new Pair(move.getTo().getFirst() +1, move.getTo().getSecond());
			}
		}
		
		this.board[move.getFrom().getFirst()][move.getFrom().getSecond()] = null;

		this.board[move.getTo().getFirst()][move.getTo().getSecond()]
				.setPosition(new Pair(move.getTo().getFirst(), move.getTo().getSecond()));
		if(move.getEnPassant() != null) {
			if(move.getEnPassant().getFirst() < 0) {
				this.board[move.getEnPassant().getFirst()-1][move.getEnPassant().getSecond()] = null;
			}
		}
		
		this.whitePlays = !this.whitePlays;

	}
	public static Piece makePromotion(promotions promotion, boolean isWhite, Pair pos) {
		switch (promotion) {
		case QUEEN:
			return new Queen(isWhite, pos);
		case KNIGHT:
			return new Knight(isWhite, pos);
		case ROOK:
			return new Rook(isWhite, pos);
		case BISHOP:
			return new Bishop(isWhite, pos);
		default:
			return new Queen(isWhite,pos);
		}
	}

	public promotions getPromotion() {
		return this.promotion;
	}
		
	public boolean validateMove(Move move) {
		Game check = new Game(this);
		check.makeMove(move,true);
		if (check.isKingOnCheck(whitePlays)) {
			return false;
		}
		return true;
	}

	public ArrayList<Move> purgeMoves(ArrayList<Move> moves){
		for (int i = 0; i < moves.size(); i++) {
			if(!validateMove(moves.get(i))){
				moves.remove(i);
				i--;
			}
		}
		return moves;
	}

	public boolean isStaleMate(){
		if(isKingOnCheck(this.whitePlays)) return false;
		ArrayList<Move> legalMoves = new ArrayList<Move>(this.generateAllColourMoves(this.whitePlays));
		purgeMoves(legalMoves);

		if(legalMoves.isEmpty()) return true;
		return false;
	}

	public boolean isMate(){
		if(!isKingOnCheck(this.whitePlays)) {
			return false;
		}
		ArrayList<Move> legalMoves = new ArrayList<Move>(this.generateAllColourMoves(this.whitePlays));

		purgeMoves(legalMoves);

		if(legalMoves.isEmpty()) return true;
		return false;
	}
	
	public Piece [][] getBoard(){
		return board;
	}
	
	public boolean isWhiteKingRook() {
		return whiteKingRook;
	}

	public void setWhiteKingRook(boolean whiteKingRook) {
		this.whiteKingRook = whiteKingRook;
	}

	public boolean isWhiteQueenRook() {
		return whiteQueenRook;
	}

	public void setWhiteQueenRook(boolean whiteQueenRook) {
		this.whiteQueenRook = whiteQueenRook;
	}

	public boolean isBlackKingRook() {
		return blackKingRook;
	}

	public void setBlackKingRook(boolean blackKingRook) {
		this.blackKingRook = blackKingRook;
	}

	public boolean isBlackQueenrook() {
		return blackQueenrook;
	}

	public void setBlackQueenrook(boolean blackQueenrook) {
		this.blackQueenrook = blackQueenrook;
	}

	public Pair getEnPassant() {
		return enPassant;
	}

	public void setEnPassant(Pair enPassant) {
		this.enPassant = enPassant;
	}

	
	public Move.promotions choosePromotion() {
		Object[] options = {"Queen","Rook","Knight","Bishop"};
		int n = JOptionPane.showOptionDialog(new JPanel(),
		    "Choose promotion recipient",
		    "Promotion",
		    JOptionPane.YES_NO_CANCEL_OPTION,
		    JOptionPane.QUESTION_MESSAGE,
		    null,
		    options,
		    options[2]);
		switch (n) {
		case 0:
			return Move.promotions.QUEEN;
		case 1:
			return Move.promotions.ROOK;
		case 2:
			return Move.promotions.KNIGHT;
		case 3:
			return Move.promotions.BISHOP;
		default:
			return Move.promotions.QUEEN;
		}
	}

	public boolean isMoveEating(Move move) {
		if(getPieceAtSquare(move.getTo()) == null){
			return false;
		}
		if (getPieceAtSquare(move.getFrom()).isWhite() != getPieceAtSquare(move.getTo()).isWhite()) {
			return true;
		}
		else {
			return false;
		}
	}

	public void update(){
		// this.updateEnPassant();
		if(isMate()){
			System.out.println("GAME OVER");
			// TODO: handle checkmate
		}
		else if(isStaleMate()){
			System.out.println("STALEMATE");
		}
		// stalemate
		// checks if game is over
		// this function should run every ply
	}
}