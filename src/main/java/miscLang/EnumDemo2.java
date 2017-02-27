package miscLang;

import javax.swing.plaf.synth.SynthSeparatorUI;

/*
 enum Company {
	EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25);
	private int rankingValue;

	private Company(int rankingValue) {
		this.value = rankingValue;
	}
}
*/

public class EnumDemo2 {
	
	//====NOTE=====>>> You can specify values of enum constants at the creation time. 
	//MyEnum.values() returns an array of MyEnum’s values.
	public enum Company {
		
		EBAY(30), PAYPAL(10), GOOGLE(15), YAHOO(20), ATT(25); //You need semicolon when enum has parameters or method other than constatnts
		
		private int rankingValue;
 
		private Company(int value) {
			this.rankingValue = value;
		}
	}
 
	

	public static void main(String[] args) {
	
		for(Company cName:Company.values()){
			System.out.println("Company Name=" + cName + " Ranking=" + cName.rankingValue );
		}
		
		//====NOTE=====>>> Every enum in java extends java.lang.Enum class. 
		System.out.println("Ordinal of GOOGLE=" + Company.GOOGLE.ordinal());
		
		//====NOTE=====>>> Enums can be declared inside a class. 
		      //If declared inside a class, they are static by default and can be accessed directly by Class name.
		System.out.println("Enums are static -"+ EnumDemo2.Company.EBAY);
		
		
	}

}
