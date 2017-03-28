package reflection;

import java.lang.reflect.*;
import java.lang.reflect.TypeVariable;
import java.util.Arrays;

public class ReflectionDemo {
	public static void main(String[] args) throws ClassNotFoundException {

		demoTypeParams();
		demoImplementedInterfaces();
		demoAnnotations();
		
		createNativeArray("int", 1);
		
		Class superclass = Class.forName("java.util.HashMap").getSuperclass();
		System.out.println("Superclass of hashMap:" + superclass.toString());
	}

	public static void demoTypeParams() throws ClassNotFoundException{
		//Get Type parameters (generics)
		TypeVariable<?>[] typeParameters = Class.forName("java.util.HashMap").getTypeParameters();
		for(TypeVariable<?> t : typeParameters){
			System.out.print(t.getName()+",");
		}
		System.out.println( " ");

	}

	public static void demoImplementedInterfaces() throws ClassNotFoundException{
		System.out.println("demo interfaces....");
		Type[] interfaces = Class.forName("java.util.HashMap").getGenericInterfaces();
		//prints "[java.util.Map<K, V>, interface java.lang.Cloneable, interface java.io.Serializable]"
		System.out.println(Arrays.toString(interfaces));
		//prints "[interface java.util.Map, interface java.lang.Cloneable, interface java.io.Serializable]"
		System.out.println(Arrays.toString(Class.forName("java.util.HashMap").getInterfaces()));		
	}
	
	public static void demoAnnotations() throws ClassNotFoundException{
		java.lang.annotation.Annotation[] annotations = Class.forName("java.util.HashMap").getAnnotations();
		//prints [@java.lang.Deprecated()]
		System.out.println(Arrays.toString(annotations));
	}
	
	public static Object createNativeArray(String typeName, int...dim) throws ClassNotFoundException  {
        Class<?> clazz = null;
        if ("int".equals(typeName)) {
            clazz = Integer.TYPE;
        } else if ("boolean".equals(typeName)) {
            clazz = Boolean.TYPE;
        } else if ("double".equals(typeName)) {
            clazz = Double.class;
            //All other native types: short, long, float ......
        }else {
            throw new ClassNotFoundException(typeName);
        }
        
        return Array.newInstance(clazz, dim);
    }
}

