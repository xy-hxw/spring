package com.cn;


import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.Resource;

/**
 * @author huoxianwei
 * @date 2019/1/8 15:21
 * IOC容器加载配置文件
 */
public class Test {

	/**
	 * spring-context包下加载xml文件
	 */
	private static void combineWithExpressionLanguage() {
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("/bean.xml", Test.class);
		TestBean foo = applicationContext.getBean("foo", TestBean.class);
		TestBean bar = applicationContext.getBean("bar", TestBean.class);
		System.out.println(foo.getAge()+"---"+bar.getName());
	}

	/**
	 * spring-core包下加载配置文件
	 */
	private static void testXmlBeanFactory() {
		// 资源文件加载  类加载器初始化
		ClassPathResource classPathResource = new ClassPathResource("bean.xml");
		// 控制反转，由IOC对文件解析，注册BeanDefinition
		XmlBeanFactory xmlBeanFactory = new XmlBeanFactory(new ClassPathResource("bean.xml"));
		// 第一次取值时，进行依赖注入
		TestBean foo = (TestBean) xmlBeanFactory.getBean("foo");
		System.out.println(foo.getAge());
	}

	/**
	 * 调用的ClassPathResource获取配置文件和类加载器
	 */
	private static void testDefaultResourceLoader () {
		Resource resource = new DefaultResourceLoader().getResource("/bean.xml");
		System.out.println(resource);
	}

	public static void main(String[] args) {
		combineWithExpressionLanguage();
		testXmlBeanFactory();
		testDefaultResourceLoader();
	}
}
