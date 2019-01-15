import com.cn.bean.MyBean;
import com.cn.bean.MyBeanConstruct;
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

	private Log logger = LogFactory.getLog(MyBeanTest.class);

	@Before
	public void before () {
		logger.info("----------bean的生命周期开始-----------");
	}

	@After
	public void after () {
		logger.info("----------bean的生命周期结束-----------");
	}

	@Test
	public void test () {
		MyBeanConstruct myBeanConstruct = new MyBeanConstruct();
		myBeanConstruct.test();
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("myBean.xml");
		MyBean myBean = applicationContext.getBean("myBean", MyBean.class);
		logger.info("08-->加载到的bean="+ myBean.toString());
		applicationContext.close();
	}
}
