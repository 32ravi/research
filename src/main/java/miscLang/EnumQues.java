package miscLang;

enum Enums
{
    A, B, C;
     
    {
        System.out.println(1);
    }
     
    static
    {
        System.out.println(2);
    }
     
    private Enums()
    {
        System.out.println(3);
    }
}
 
public class EnumQues
{
    public static void main(String[] args)
    {
        Enum en = Enums.C;
    }
}