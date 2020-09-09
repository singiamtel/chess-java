public class PieceLogic {
	public static Boolean isValid(Game game, Move move){
		return false;
	}
	public static Boolean isCheck(Game game, Move move){
		return false;
	}
	public static Boolean isMate(Game game, Move move){
		if(!isCheck(game, move)) return false;

		return false;
	}
	public static Boolean isStaleMate(Game game, Move move){
		return false;
	}
}
