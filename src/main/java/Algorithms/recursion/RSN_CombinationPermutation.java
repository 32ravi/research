package Algorithms.recursion;

/*
 * print all combination and permutatino of "abcd".
 * 
 * 
 */
public class RSN_CombinationPermutation {

	private static int permuCount=0;
	private static int comboCount=0;
	public static void main(String[] args) {
		combo("","abcd");
		System.out.println("-----------------------");
		permu("","abcd");
	}

	private static void combo(String prefix, String str) {

		if(str == null || str.length() == 0)
			return;

		System.out.println(prefix+ str.charAt(0)+ "     " + comboCount++);
		combo(prefix+str.charAt(0), str.substring(1));
		combo(prefix, str.substring(1));
	}

	private static void permu(String prefix, String str) {

		if(str == null || str.length() == 0)
			return;

		System.out.println(prefix+ str.charAt(0) + "     "+ permuCount++);
		if(!prefix.equals("")){
			System.out.println( str.charAt(0) + prefix+ "     "+ permuCount++);
		}
		permu(prefix+str.charAt(0), str.substring(1));
		permu(prefix, str.substring(1));
	}
}
