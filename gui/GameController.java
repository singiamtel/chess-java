package gui;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import pieces.Pawn;
import utilities.Pair;

public class GameController {
	private Game game;
	private Board board;
	private boolean isPieceSelected;
	private Pair<Integer, Integer> lastPieceSelected;



	public GameController() {
		this.game = new Game();
		board = new Board(game);
		this.isPieceSelected = false;
	}

	public void checkIfSync() {
		// TODO: exception
	}

	public boolean makeMove(Pair<Integer, Integer> from, Pair<Integer, Integer> to) {
		if (game.validateMove(new Move(from, to))) {
			game.makeMove(new Move(from, to));
			board.makeMove(new Move(from, to));
			// change turn
			return true;
		}
		return false;
	}

	public Game getGame() {
		return this.game;
	}

	public void clickOnSquare(Pair<Integer, Integer> position) {
		if (isPieceSelected) {
			isPieceSelected = !isPieceSelected;
			System.out.println("piece IS selected");
		} else {
			System.out.println("piece WAS NOT selected, selecting...");
			if (game.getPieceAtSquare(position) == null) {
				return;
			}
			addPosibleMoves(position);
			lastPieceSelected  = position;
			isPieceSelected = !isPieceSelected;
		}
	}
	
	private void addPosibleMoves(Pair<Integer, Integer> position) {
		ArrayList<Move> moves = game.getPieceAtSquare(position).generateMoves(game);
		for (Move move : moves) {
			Square oldSquare = board.getSquareAt(move.getTo());
			Square newSquare = new Square(oldSquare.isWhite(), oldSquare.getPiece(), true, move.isCheck(),move.isEating(), new Pair<Integer,Integer>(move.getTo().getFirst(),move.getTo().getSecond()));
			board.setSquareAt(move.getTo(), newSquare);
		}
	}
}
