package gui;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class GameController {
	private Game game;
	private MainWindow mainWindow;
	private boolean isPieceSelected;
	private Pair pieceSelected;
	private Pair enPassant;



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
	public void checkIfSync(){
		//TODO: exception
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
		ArrayList<Move> moves = game.getPieceAtSquare(on).generateMoves(game);
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
		if (isPieceSelected) {
			if (!squareAt.canMoveHere()) {
				clearMoveMarks();
			} else {
				// MAKEMOVE
				// System.out.println(new Move(pieceSelected, on).getFrom().toString() + " "
						// + new Move(pieceSelected, on).getTo().toString());
				game.makeMove(new Move(pieceSelected, on,game.getPromotion()),false);
				mainWindow.getBoard().makeMove(new Move(pieceSelected, on));
				this.update();
				return;
			}
		}
		if (!isPieceSelected && squareAt.getPiece() != null && squareAt.getPiece().isWhite() == game.whitePlays()) {
			generateMoveMarks(on);
		}
	}

	public Pair getEnPassant() {
		return enPassant;
	}

	public void setEnPassant(Pair enPassant) {
		this.enPassant = enPassant;
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