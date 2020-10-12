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

	public boolean makeMove(Pair from, Pair to){
		Move move = new Move(from, to);
		if(game.validateMove(move)){
			game.makeMove(move,false);
			mainWindow.getBoard().makeMove(move);
			// change turn
			return true;
		}
		return false;
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
			// Square oldSquare = mainWindow.getBoard().getSquareAt(move.getFrom());
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
				pieceSelected = null;
				clearMoveMarks();
				return;
			}else if(on.equals(pieceSelected)){
				clearMoveMarks();
				pieceSelected = null;
				return;
			} else {
				// MAKEMOVE
				if(game.getPieceAtSquare(pieceSelected) instanceof King && Math.abs(pieceSelected.getSecond() - on.getSecond()) == 2) {
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
					game.makeMove(new Move(pieceSelected, on,game.getPromotion()),false);
				}
				else if(game.getEnPassant() != null && game.getEnPassant().equals(on)) {
					game.makeMove(new Move(pieceSelected,on,game.getEnPassant(),true),false);
				}
				else game.makeMove(new Move(pieceSelected, on,game.getPromotion()),false);
				
				if(game.getEnPassant() != null && game.getEnPassant().equals(on)) {
					mainWindow.getBoard().makeMove(new Move(pieceSelected, on,game.getEnPassant(),true));
				}else if(castle != null){
					mainWindow.getBoard().makeMove(castle);
				}else {
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

/*
	if(!context.isPieceSelected()) {
		

	}else {
		if(context.getMainWindow().getBoard().getSquareAt(coor).canMoveHere()) {
			context.getGame().makeMove(new Move(context.getLastPieceSelected(),coor));
			context.getMainWindow().getBoard().makeMove(new Move(context.getLastPieceSelected(),coor));
			context.setPieceSelected(false);
			
		}
*/