import com.cn.bean.MyBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author huoxianwei
 * @date 2019/1/10 20:41
 */
public class MyBeanTest {

	private static final Log logger = LogFactory.getLog(MyBeanTest.class);

	@Before
	public void before () {
		System.out.println("----------bean的生命周期开始-----------");
	}

	@After
	public void after () {
		System.out.println("----------bean的生命周期结束-----------");
	}

	@Test
	public void test () {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myBean.xml");
		MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
		logger.info("加载到bean="+ myBean.toString());
		applicationContext.close();
	}
}
