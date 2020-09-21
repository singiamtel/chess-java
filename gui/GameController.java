package gui;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class GameController {
	private Game game;
	private MainWindow mainWindow;
	private boolean isPieceSelected;
	private Pair<Integer, Integer> pieceSelected;


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
	public boolean makeMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to){
		Move move = new Move(from, to);
		if(game.validateMove(move)){
			game.makeMove(move);
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

	private void generateMoveMarks(Pair<Integer, Integer> on){
		this.isPieceSelected = true;
		this.pieceSelected = on;
		ArrayList<Move> moves = game.getPieceAtSquare(on).generateMoves(game);
		for (Move move : moves) {
			Square oldSquare = mainWindow.getBoard().getSquareAt(move.getFrom());
			Square newSquare = new Square(mainWindow.getBoard().getSquareAt(move.getTo()).isWhite(),
					mainWindow.getBoard().getSquareAt(move.getTo()).getPiece(), true, move.isCheck(),
					move.isEating(), new Pair<Integer, Integer>(move.getTo().getFirst(), move.getTo().getSecond()));
			mainWindow.getBoard().setSquareAt(move.getTo(), newSquare);
		}
	}

	public void handleClick(Pair<Integer, Integer> on) {
		Square squareAt = mainWindow.getBoard().getSquareAt(on);
		if (game.getPieceAtSquare(on) != null) {
			System.out.println("game piece: " + game.getPieceAtSquare(on).getPosition());
		}
		if(squareAt.getPiece() != null){
			System.out.println("board piece: " + squareAt.getPiece().getPosition());
		}
		if (isPieceSelected) {
			if (!squareAt.canMoveHere()) {
				clearMoveMarks();
			} else {
				// MAKEMOVE
				System.out.println(new Move(pieceSelected, on).getFrom().toString() + " "
						+ new Move(pieceSelected, on).getTo().toString());
				game.makeMove(new Move(pieceSelected, on));
				mainWindow.getBoard().makeMove(new Move(pieceSelected, on));
				this.clearMoveMarks();
				return;
			}
		}
		if (!isPieceSelected && squareAt.getPiece() != null) {
			generateMoveMarks(on);
		}
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