package InnerClasses;

public class IMPInnerClassShadow {

	public int x = 0;

	class FirstLevel {

		public int x = 1;

		void methodInFirstLevel(int x) {
			System.out.println("x = " + x);
			System.out.println("this.x = " + this.x);
			System.out.println("ShadowTest.this.x = " + IMPInnerClassShadow.this.x);
		}
	}

	public static void main(String... args) {
		IMPInnerClassShadow st = new IMPInnerClassShadow();
		IMPInnerClassShadow.FirstLevel fl = st.new FirstLevel();
		fl.methodInFirstLevel(23);
	}
}