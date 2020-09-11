package utilities;

import java.util.ArrayList;

import controller.Game;
import controller.Move;
import pieces.Piece;

public class Raycast {
	public static ArrayList<Move> awd(Game game, Piece piece, Direction dir){
		ArrayList<Move> moveArray = new ArrayList<Move>();
		int LERF = piece.getPositionLERF();
		int x = LERF / 8;
		int y = LERF % 8;

		switch(dir){
			case EAST:
				raycast(moveArray, game, piece, x, y, 0, 1);			
				break;
			case NORTH:
				raycast(moveArray, game, piece, x, y, 1, 0);			
				break;
			case NORTHEAST:
				raycast(moveArray, game, piece, x, y, 1, 1);			
				break;
			case NORTHWEST:
				raycast(moveArray, game, piece, x, y, 1, -1);			
				break;
			case SOUTH:
				raycast(moveArray, game, piece, x, y, -1, 0);			
				break;
			case SOUTHEAST:
				raycast(moveArray, game, piece, x, y, -1, 1);			
				break;
			case SOUTHWEST:
				raycast(moveArray, game, piece, x, y, -1, -1);			
				break;
			case WEST:
				raycast(moveArray, game, piece, x, y, 0, -1);			
				break;
		}
		return moveArray;
	}
	private static void raycast(ArrayList<Move> moveArray, Game game, Piece piece, int x, int y, int addX, int addY){
		x+=addX;
		y+=addY;
		if(x<=0 || y<=0) return;
		if(x>=8 || y>=8) return;
		// mueve
		if(game.getPieceAtSquare(8*x + y) == null){
			moveArray.add(new Move(x,y, null, false));
			raycast(moveArray, game, piece, x, y, addX, addY);
		}
		else if(game.getPieceAtSquare(8*x + y).isWhite() != piece.isWhite()){
			moveArray.add(new Move(x,y, null, false));
		}
	}
}
