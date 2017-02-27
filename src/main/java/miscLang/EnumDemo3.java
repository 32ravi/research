package miscLang;


enum ENUM_NAME{
	FIRST(1,"ek"),SECOND(2,"do"),THIRD(3,"teen"),
	
	FOURTH(4,"FOUR"){   //====NOTE=====>>> ENUMS can override mehotds
		@Override
		String enumMethods() {
			return "CHAR-CHAR from override method";
		}
	};
	
	int i; //====NOTE=====>>> ENUMS can have field
	String description;
	
	ENUM_NAME(int a, String str){//====NOTE=====>>> ENUMS can have constructor, YOU can't make constructor PUBLIC
		                                //ENUM constructors are private by default.
		i = a;
		description = str;
	}
	
	
	String enumMethods(){ //ENUMS can have methods.
		return description;
	}
}

public class EnumDemo3 {
	public static void main(String[] args) {
		
		System.out.println("arithmetic value:" + ENUM_NAME.FIRST.i  + " hindi name: " + ENUM_NAME.FIRST.enumMethods());
		
		System.out.println("From method 4..." + ENUM_NAME.FOURTH.enumMethods());
	}
}
