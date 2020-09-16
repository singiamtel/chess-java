package utilities;

import controller.Game;
import controller.Move;
import controller.PieceLogic;
import pieces.King;

public class Translator {
	public static int coordinateToLERF(String algebraic){
		// a = 0, h = 7, each rank += 8
		// TODO: clear up
		return (Character.toLowerCase((algebraic.charAt(0))) - 97) + 8 * (Integer.parseInt(algebraic.substring(1,2)) - 1);
	}
	public static String LERFtoCoordinate(int LERF){
		int number = LERF / 8 + 1;
		int letterCode = LERF % 8;
		char letter;
		System.out.println(letterCode + " " + number);
		switch(letterCode){
			case 0:
				letter = 'a';
				break;
			case 1:
				letter = 'b';
				break;
			case 2:
				letter = 'c';
				break;
			case 3:
				letter = 'd';
				break;
			case 4:
				letter = 'e';
				break;
			case 5:
				letter = 'f';
				break;
			case 6:
				letter = 'g';
				break;
			case 7:
				letter = 'h';
				break;
			default:
				// TODO: throw exception and remove next line
				letter = 'z';
				break;
		}
		return (Character.toString(letter) + Integer.toString(number));
	}
	public static String LERFtoAlgebraic(Move move, Game game){
		String ret = "";
		if(game.getPieceAtSquare(move.getFrom()) instanceof King //check color
		|| game.getPieceAtSquare(move.getFrom()) instanceof King ){
			
			// if((move.getFrom()-move.getTo()) == 2){
			// 	ret = "O-O";
			// }
			// else{
			// 	ret = "O-O-O";
			// }

		}

		if(move.getPromotion() != null){
			ret += "=";
			
			switch(move.getPromotion().toString()){
				case "WHITE_QUEEN":
				case "BLACK_QUEEN":
					ret += "Q";
					break;
				case "WHITE_BISHOP":
				case "BLACK_BISHOP":
					ret += "B";
					break;
				case "WHITE_ROOK":
				case "BLACK_ROOK":
					ret += "R";
					break;
				case "WHITE_KNIGHT":
				case "BLACK_KNIGHT":
					ret += "N";
					break;
				default:
					// TODO: throw exception
					break;

			}
		}
		if(PieceLogic.isMate(game, move)){
			ret += "#";
		}
		// TODO: fix when king check function is done
		// else if(PieceLogic.isCheck(game, move)){
		// 	ret += "+";
		// }

		return "return";
	}
}

/*

20 26
e3 c4 

rxc4

Enroque O-O !!
Come x
Jaque + !!
Mate # !!
Promocion =Q !!
Distinción de que pieza come kexc5

ka8xe6+
exa8=Q+

*/
