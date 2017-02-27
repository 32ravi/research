package IO.allocation;

import java.lang.reflect.Field;


import java.nio.ByteBuffer;
import sun.misc.Unsafe;

/*
 http://stackoverflow.com/questions/34469568/buffer-vs-unsafe-outside-jvm
 I have a requirement to use a space in the available RAM which the GC has no control on. 
 I read a few articles on  the same which gave me the introduction on two approaches.
   They are specified in the following code.
 */
public class A_IMP_DirectMemoryTest{

	public static void main(String[] args) {

		//Approach 1
		ByteBuffer directByteBuffer = ByteBuffer.allocateDirect(8);
		directByteBuffer.putDouble(1.0);
		directByteBuffer.flip();
		System.out.println(directByteBuffer.getDouble());

		//Approach 2
		Unsafe unsafe = getUnsafe();
		long pointer = unsafe.allocateMemory(16);
		unsafe.putDouble(pointer, 2.0);
		unsafe.putDouble(pointer+8, 3.0);
		//unsafe.putDouble(pointer+16, 4.0);

		System.out.println(unsafe.getDouble(pointer));
		System.out.println(unsafe.getDouble(pointer+8));
		System.out.println(unsafe.getDouble(pointer+16));  ///You are going beyond allocated memory, so will get junk
	}

	public static Unsafe getUnsafe() {
		try {
			Field f = Unsafe.class.getDeclaredField("theUnsafe");
			f.setAccessible(true);
			return (Unsafe) f.get(null);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

}
