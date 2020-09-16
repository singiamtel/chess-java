package pieces;

import java.util.ArrayList;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import utilities.Pair;

public class Pawn extends Piece {

	public Pawn(Boolean isWhite, Pair<Integer, Integer> position){
		this.isWhite = isWhite;
		this.position= position;
	}

	public ArrayList<Move> generateMoves(Game game){
		ArrayList<Move> moves = new ArrayList<Move>();
		Piece piece;
		if(isWhite()){
			//movimiento de uno
			// attempt to move one square
			piece = game.getPieceAtSquare(new Pair<Integer, Integer>(position.getFirst(), position.getSecond() + 1));
			if(piece != null){
				// moves.add(new Move(position.getFirst()*8 + position.getSecond(), piece.getPosition().getFirst()*8 + piece.getPosition().getSecond()));

				if(position.getFirst() == 1){
				}
			}
			if(position.getSecond() == 1){
				//movimiento de dos

			}
				//comprobar si come

		}
		else {
			if(position.getSecond() == 6){
				
			}
		}
		return null;
	}
	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_pawn.png");
		} else {
			return new ImageIcon("img/black_pawn.png");
		}
	}
}
