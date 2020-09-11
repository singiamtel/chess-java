package controller;

public class PieceLogic {
	public static Boolean isValid(Game game, Move move){
		game.getPieceAtSquare(move.getFrom()).isValidMove();
		/*
		switch(game.getPieceAtSquare(move.getFrom())){

			case BLACK_BISHOP:
			case WHITE_BISHOP:
				return (isValidBishopMove(game, move));
			case BLACK_KING:
			case WHITE_KING:
				return (isValidKingMove(game, move));
			case BLACK_KNIGHT:
			case WHITE_KNIGHT:
				return (isValidKnightMove(game, move));
			case BLACK_PAWN:
			case WHITE_PAWN:
				return (isValidPawnMove(game, move));
			case BLACK_QUEEN:
			case WHITE_QUEEN:
				return (isValidQueenMove(game, move));
			case BLACK_ROOK:
			case WHITE_ROOK:
				return (isValidRookMove(game, move));
			case EMPTY:
				// TODO: Exception?
				return false;
		}
		*/
		return false;
	}
	private static Boolean isValidKnightMove(Game game, Move move){
		return true;
	}
	private static Boolean isValidKingMove(Game game, Move move){
		return true;
	}
	private static Boolean isValidBishopMove(Game game, Move move){
		return true;
	}
	private static Boolean isValidRookMove(Game game, Move move){
		return true;
	}
	private static Boolean isValidPawnMove(Game game, Move move){
		return true;
	}
	private static Boolean isValidQueenMove(Game game, Move move){
		return true;
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
