package annotation.javaeyer;

import java.lang.reflect.Method;
import java.util.HashSet;
import java.util.Set;

public class TestAnnotation {
	/**
	 * author lighter 說明:具體關天Annotation的API的用法請參見javaDoc文檔
	 */
	public static void main(String[] args) throws Exception {
		String CLASS_NAME = "annotation.javaeyer.JavaEyer";
		Class test = Class.forName(CLASS_NAME);
		Method[] method = test.getMethods();
		boolean flag = test.isAnnotationPresent(Description.class);
		if (flag) {
			Description des = (Description) test.getAnnotation(Description.class);
			System.out.println("描述:" + des.value());
			System.out.println("-----------------");
		}

		// 把JavaEyer這一類有利用到@Name的全部方法保存到Set中去
		Set<Method> set = new HashSet<Method>();
		for (int i = 0; i < method.length; i++) {
			boolean otherFlag = method[i].isAnnotationPresent(Name.class);
			if (otherFlag)
				set.add(method[i]);
		}
		for (Method m : set) {
			Name name = m.getAnnotation(Name.class);
			System.out.println(name.originate());
			System.out.println("創建的社區:" + name.community());
		}
	}
}
