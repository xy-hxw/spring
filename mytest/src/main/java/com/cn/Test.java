package com.cn;


import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
	public void combineWithExpressionLanguage() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/bean.xml", getClass());
		TestBean foo = applicationContext.getBean("foo", TestBean.class);
		TestBean bar = applicationContext.getBean("bar", TestBean.class);
		System.out.println(foo.getAge()+"---"+bar.getName());
	}

	public static void main(String[] args) {
		System.out.println(11);
		new Test().combineWithExpressionLanguage();
	}
}
