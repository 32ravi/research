package reflection.annotation;

import javax.tools.*;
import javax.lang.model.*;

public class CompilerAPI {

	public static void main(String[] args) {
		
		System.out.println(System.getProperty("java.home"));
		final JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();        
		for( final SourceVersion version: compiler.getSourceVersions() ) {
		    System.out.println( version );
		}
	}
}
