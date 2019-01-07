package com.cn;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

public class Test {

	private void combineWithExpressionLanguage() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/bean.xml", getClass());
		TestBean foo = applicationContext.getBean("foo", TestBean.class);
		TestBean bar = applicationContext.getBean("bar", TestBean.class);
		System.out.println(foo.getAge()+"---"+bar.getName());
	}

	private static void testXmlBeanFactory() {
		ClassPathResource classPathResource = new ClassPathResource("bean.xml");
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(classPathResource);
		TestBean foo = (TestBean) xmlBeanFactory.getBean("foo");
		System.out.println(foo.getAge());
	}

	public static void main(String[] args) {
//		new Test().combineWithExpressionLanguage();
		testXmlBeanFactory();
		System.out.println(Math.abs(-6));
	}
}
