public class Translator {
	public static int algebraicToLERF(String algebraic){
		// a = 0, h = 7, each rank += 8
		return (Character.toLowerCase((algebraic.charAt(0))) - 97) + 8 * (Integer.parseInt(algebraic.substring(1,2)) - 1);
	}
}