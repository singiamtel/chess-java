package controller.command;

import java.util.ArrayList;

import controller.Controller;
import controller.Game;
import controller.Move;
import gui.Square;
import utilities.Pair;

public class SelectPiece extends Command{
	Pair<Integer, Integer> coor;
	public SelectPiece(Pair<Integer, Integer> coor) {
		super();
		this.coor = coor;
	}

	public void execute() {

		if(!context.isPieceSelected()) {
			Game game = context.getGame();
			if(game.getPieceAtSquare(coor) == null) return;
			ArrayList<Move> moves = game.getPieceAtSquare(coor).generateMoves(game);
			for (Move move : moves) {
				Square oldSquare = Controller.getController().getMainWindow().getBoard().getSquareAt(move.getTo());
				Square newSquare = new Square(oldSquare.isWhite(), oldSquare.getPiece(), true, move.isCheck(),move.isEating(), new Pair<Integer,Integer>(move.getTo().getFirst(),move.getTo().getSecond()));
				context.getMainWindow().getBoard().setSquareAt(move.getTo(), newSquare);
			}
			context.setLastPieceSelected(coor);
			context.setPieceSelected(true);
			context.getGame().makeMove(new Move(context.getLastPieceSelected(),coor));
		}else {
			if(context.getMainWindow().getBoard().getSquareAt(coor).canMoveHere()) {
				context.getGame().makeMove(new Move(context.getLastPieceSelected(),coor));
				context.getMainWindow().getBoard().makeMove(new Move(context.getLastPieceSelected(),coor));
				context.setPieceSelected(false);
				
			}
		}
	}

}
