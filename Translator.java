public class Translator {
	public static int algebraicToLERF(String algebraic){
		// a = 0, h = 7, each rank += 8
		// TODO: clear up
		return (Character.toLowerCase((algebraic.charAt(0))) - 97) + 8 * (Integer.parseInt(algebraic.substring(1,2)) - 1);
	}
	public static String LERFtoAlgebraic(int LERF){
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
	// public static 
}