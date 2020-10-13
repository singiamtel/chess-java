package pieces;

import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;

import controller.Game;
import controller.Move;
import controller.Move.Castle;
import utilities.Pair;

public class King extends Piece {
	public static final ArrayList<Pair> moves = new ArrayList<Pair>(List.of(
			new Pair( 1,  0), 
			new Pair( 1,  1), 
			new Pair( 0,  1),
			new Pair(-1,  1), 
			new Pair(-1,  0), 
			new Pair(-1, -1),
			new Pair( 0, -1), 
			new Pair( 1, -1)));

	public King(Boolean isWhite, Pair position) {
		this.isWhite = isWhite;
		this.position = position;
	}
	public Piece clonePiece(){
		Piece ret = new King(this.isWhite, new Pair(this.position));
		return ret;
	}

	public ArrayList<Move> generateMoves(Game game, boolean fake) {
		ArrayList<Move> generatedMoves = new ArrayList<Move>();
		addRookMoves(game, generatedMoves);
		for (Pair move : moves) {
			Pair attempt = this.position.addPair(move);
			if(Move.isOutOfBounds(attempt)){
				continue;
			}
			if (!this.validateMove(game, new Move(new Pair(this.position.getFirst(), this.position.getSecond()), new Pair(attempt.getFirst(), attempt.getSecond())))) {
				continue;
			} else {
				if (game.isMoveEating(new Move(this.position, attempt))) {
					generatedMoves.add(new Move(this.position, attempt, null, false, true));
				} else {
					generatedMoves.add(new Move(this.position, attempt, null, false, false));
				}
			}
		}
		return generatedMoves;
	}
	
	public void addRookMoves(Game game, ArrayList<Move> moves) {
		Piece [][] board = game.getBoard();
		if(this.isWhite && !game.isKingOnCheck(this.isWhite)) {
			if(game.isWhiteKingRook()){
				if(board[0][5] == null && board[0][6] == null) {
					if(!game.isLocationOnCheck(this.isWhite, new Pair(0,5)) &&
							!game.isLocationOnCheck(this.isWhite, new Pair(0,6))){
						moves.add(new Move(Castle.WHITEKING));
					}
				}
			} 
			if(game.isWhiteQueenRook()) {
				if(board[0][1] == null && board[0][2] == null && board[0][3] == null) {
					if(!game.isLocationOnCheck(this.isWhite, new Pair(0,1)) &&
							!game.isLocationOnCheck(this.isWhite, new Pair(0,2)) &&
								!game.isLocationOnCheck(this.isWhite, new Pair(0,3))){
						moves.add(new Move(Castle.WHITEQUEEN));
					}
				}
			}
		}else if(!this.isWhite && !game.isKingOnCheck(isWhite)){
			if(game.isBlackKingRook()) {
				if(board[7][5] == null && board[7][6] == null) {
					if(!game.isLocationOnCheck(this.isWhite, new Pair(7,5)) &&
							!game.isLocationOnCheck(this.isWhite, new Pair(7,6))){
						moves.add(new Move(Castle.BLACKKING));
					}
				}
			}
			if(game.isBlackQueenrook()) {
				if(board[7][1] == null && board[7][2] == null && board[7][3] == null) {
					if(!game.isLocationOnCheck(this.isWhite, new Pair(7,1)) &&
							!game.isLocationOnCheck(this.isWhite, new Pair(7,2)) &&
								!game.isLocationOnCheck(this.isWhite, new Pair(7,3))){
						moves.add(new Move(Castle.BLACKQUEEN));
					}
				}
			}
		}
	}

	public ImageIcon getImage() {
		if (isWhite) {
			return new ImageIcon("img/white_king.png");
		} else {
			return new ImageIcon("img/black_king.png");
		}
	}
}