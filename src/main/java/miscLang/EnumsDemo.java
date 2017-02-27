package miscLang;

/*
 * 
Enums in java are mainly used for grouping similar kind of constants as a one unit. 
constants means static and final. Enums are introduced in JDK 1.5 onward. 
Before that similar kind of constants are grouped by declaring them as static and final in one class.
 Below example shows how the constants will look without enums.

 
 class ConstantsWithoutEnums
{
    public static final String north = "NORTH";
    public static final String south = "SOUTH";
    public static final String east = "EAST";
    public static final String west = "WEST";
}
 
public class EnumQues
{
    public static void main(String[] args)
    {
        System.out.println(ConstantsWithoutEnums.north);
        System.out.println(ConstantsWithoutEnums.south);
        System.out.println(ConstantsWithoutEnums.east);
        System.out.println(ConstantsWithoutEnums.west);
    }
}
 */

/*
 * 
 * http://javaconceptoftheday.com/java-enums-tutorial-with-examples/
 * 
 1. RSN NOTE Duplicate ENUMS not allowed, compile error
 2. NOTE Every constant of enum is public, static and final by default.
     As every constant is static, they can be accessed directly using enum name.
  3. Enum constants are implicitly static and final and can not be changed once created.
 */
enum Directions
{
	NORTH, SOUTH, EAST, WEST //====NOTE=====>>> semicolon; not necessary, it is optional 
}

public class EnumsDemo
{
	public static void main(String[] args)
	{
		enumDemo();
	}

	public static void enumDemo(){
		Directions d1 = Directions.EAST;
		System.out.println(d1);

		Directions d2 = Directions.NORTH;
		System.out.println(d2);

		System.out.println(Directions.SOUTH);

		System.out.println(Directions.WEST);
	}
}



