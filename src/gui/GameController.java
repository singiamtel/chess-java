package gui;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import controller.Move.Castle;
import pieces.King;
import pieces.Pawn;
import utilities.Pair;

public class GameController {
	private Game game;
	private MainWindow mainWindow;
	private boolean isPieceSelected;
	private Pair pieceSelected;

	private static GameController gc;

	public static GameController getCurrent(){
		return gc;
	}

	public static void setCurrent(GameController gameController){
		gc = gameController;
	}

	public static GameController createGame(){
		GameController gc = new GameController();
		setCurrent(gc);
		return getCurrent();
	}

	public GameController(){
		this.game = new Game();
		this.mainWindow = new MainWindow(this.game);
		this.isPieceSelected = false;
		this.pieceSelected = null;
	}

	private void update(){
		clearMoveMarks();
		game.update();
	}

	private void clearMoveMarks(){
		mainWindow.getBoard().clearMoveMarks();
		this.isPieceSelected = false;
	}

	private void generateMoveMarks(Pair on){
		this.isPieceSelected = true;
		this.pieceSelected = on;
		ArrayList<Move> moves = game.getPieceAtSquare(on).generateMoves(game, true);
		moves = game.purgeMoves(moves);
		for (Move move : moves) {
			Square newSquare = new Square(mainWindow.getBoard().getSquareAt(move.getTo()).isWhite(),
					mainWindow.getBoard().getSquareAt(move.getTo()).getPiece(), true, move.isCheck(),
					move.isEating(), new Pair(move.getTo().getFirst(), move.getTo().getSecond()));
			mainWindow.getBoard().setSquareAt(move.getTo(), newSquare);
		}
	}

	public void handleClick(Pair on) {
		Square squareAt = mainWindow.getBoard().getSquareAt(on);
		Move castle = null;
		if (isPieceSelected) {
			if (!squareAt.canMoveHere()) {
				// Clicking on an invalid square will clear the move marks
				pieceSelected = null;
				clearMoveMarks();
				return;
			}else if(on.equals(pieceSelected)){
				// Clicking on the same piece will clear the move marks too
				clearMoveMarks();
				pieceSelected = null;
				return;
			} else {
				// We make the move
				if(game.getPieceAtSquare(pieceSelected) instanceof King && Math.abs(pieceSelected.getSecond() - on.getSecond()) == 2) {
					// Move was castling
					if(on.equals(new Pair(0,6))){
						castle = new Move(Castle.WHITEKING);
					}else if(on.equals(new Pair(0,2))){
						castle = new Move(Castle.WHITEQUEEN);
					}else if(on.equals(new Pair(7,6))){
						castle = new Move(Castle.BLACKKING);
					}else if(on.equals(new Pair(7,2))){
						castle = new Move(Castle.BLACKQUEEN);
					}else{
						castle = new Move(Castle.BLACKQUEEN);
					};
					game.makeMove(castle,false);
					
				}else if(game.getPieceAtSquare(pieceSelected) instanceof Pawn && Math.abs(pieceSelected.getFirst() - on.getFirst()) == 2){
					// Move was a double-step pawn
					game.makeMove(new Move(pieceSelected, on,game.getPromotion()),false);
				}
				else if(game.getEnPassant() != null && game.getEnPassant().equals(on)) {
					// Move was eating other pawn en passant
					game.makeMove(new Move(pieceSelected,on,game.getEnPassant(),true),false);
				}
				else {
					// Regular move
					game.makeMove(new Move(pieceSelected, on,game.getPromotion()),false);
				}
				
				if(game.getEnPassant() != null && game.getEnPassant().equals(on)) {
					// Makes en passant move on board, removing eaten pawn
					mainWindow.getBoard().makeMove(new Move(pieceSelected, on,game.getEnPassant(),true));
				}else if(castle != null){
					// Makes castling move on board, moving rook too
					mainWindow.getBoard().makeMove(castle);
				}else {
					// Makes regular move on board
					mainWindow.getBoard().makeMove(new Move(pieceSelected, on, game.getPromotion()));
				}

				this.update();
				return;
			}
		}
		if (!isPieceSelected && squareAt.getPiece() != null && squareAt.getPiece().isWhite() == game.whitePlays()) {
			generateMoveMarks(on);
		}
	}

	public Game getGame() {
		return game;
	}
}