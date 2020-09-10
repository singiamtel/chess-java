public class Game {
	private Pieces [][] board = new Pieces[8][8];
	private Boolean turn;
	private Moves [] moveList;
	Game(){
		// Empty constructor starts a new game
		board[0][0] = Pieces.WHITE_ROOK;
		board[0][1] = Pieces.WHITE_KNIGHT;
		board[0][2] = Pieces.WHITE_BISHOP;
		board[0][3] = Pieces.WHITE_QUEEN;
		board[0][4] = Pieces.WHITE_KING;
		board[0][5] = Pieces.WHITE_BISHOP;
		board[0][6] = Pieces.WHITE_KNIGHT;
		board[0][7] = Pieces.WHITE_ROOK;

		for(int i=0; i<8; ++i){
			board[1][i] = Pieces.WHITE_PAWN;
		}
		for(int i=0; i<8; ++i){
			board[7][i] = Pieces.BLACK_PAWN;
		}
		for(int i=2; i<7; ++i){
			for(int j=0; j<8; ++j){
				board[i][j] = Pieces.EMPTY;
			}
		}

		board[7][0] = Pieces.BLACK_ROOK;
		board[7][1] = Pieces.BLACK_KNIGHT;
		board[7][2] = Pieces.BLACK_BISHOP;
		board[7][3] = Pieces.BLACK_QUEEN;
		board[7][4] = Pieces.BLACK_KING;
		board[7][5] = Pieces.BLACK_BISHOP;
		board[7][6] = Pieces.BLACK_KNIGHT;
		board[7][7] = Pieces.BLACK_ROOK;
	}

	public Pieces getPieceAtSquare(int square){
		return board[(square/8)][square%8] ;
	}
	// This function is only for debug purposes and should never execute
	public void printBoard(){
			for(int j=7; j>=0; j--){
				for(int k=0; k<8; ++k){
					System.out.print(this.board[j][k] + " ");
				}
				System.out.println("");
			}
	
	}
}
