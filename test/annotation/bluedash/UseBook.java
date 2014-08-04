package annotation.bluedash;

import java.lang.annotation.Annotation;

/* http://bluedash.net/spaces/Web%E5%BC%80%E5%8F%91%E6%95%99%E7%A8%8B2%EF%BC%8DJava%20Annotation */

public class UseBook {

	public static void main(String[] args) {
		Book b = new Book();
		b.setBookname("J2EE Tutorial");
		for (Annotation anno : b.getClass().getAnnotations()) {
			System.out.println(anno.annotationType().toString());
			
			if (anno.annotationType().equals(Copyright.class)) {
				Copyright c = (Copyright) anno;
				System.out.println("The Copyright of [" + b.getBookname() + "] Copyright: " + c.value());
			}
		}
	}
}
