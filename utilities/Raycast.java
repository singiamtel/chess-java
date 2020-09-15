package utilities;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import pieces.Piece;

public class Raycast {
	public static ArrayList<Move> raycast(Game game, Piece piece, Direction dir){
		ArrayList<Move> moveArray = new ArrayList<Move>();
		Pair<Integer, Integer> position = piece.getPosition();
		int x = position.getFirst();
		int y = position.getSecond();

		switch(dir){
			case EAST:
				recursiveRaycast(moveArray, game, piece, x, y, 0, 1, x, y);			
				break;
			case NORTH:
				recursiveRaycast(moveArray, game, piece, x, y, 1, 0, x, y);			
				break;
			case NORTHEAST:
				recursiveRaycast(moveArray, game, piece, x, y, 1, 1, x, y);			
				break;
			case NORTHWEST:
				recursiveRaycast(moveArray, game, piece, x, y, 1, -1, x, y);			
				break;
			case SOUTH:
				recursiveRaycast(moveArray, game, piece, x, y, -1, 0, x, y);			
				break;
			case SOUTHEAST:
				recursiveRaycast(moveArray, game, piece, x, y, -1, 1, x, y);			
				break;
			case SOUTHWEST:
				recursiveRaycast(moveArray, game, piece, x, y, -1, -1, x, y);			
				break;
			case WEST:
				recursiveRaycast(moveArray, game, piece, x, y, 0, -1, x, y);			
				break;
		}
		return moveArray;
	}
	private static void recursiveRaycast(ArrayList<Move> moveArray, Game game, Piece piece, int x, int y, int addX, int addY, int originalX, int originalY){
		x+=addX;
		y+=addY;
		if(x<=0 || y<=0) return;
		if(x>=8 || y>=8) return;
		if(game.getPieceAtSquare(8*x + y) == null){
			moveArray.add(new Move(8*originalX + originalY , 8*x + y, null, false, false));
			recursiveRaycast(moveArray, game, piece, x, y, addX, addY ,originalX, originalY);
		}
		else if(game.getPieceAtSquare(8*x + y).isWhite() != piece.isWhite()){
			moveArray.add(new Move(8*originalX + originalY , 8*x + y, null, false, true));
		}
	}
}