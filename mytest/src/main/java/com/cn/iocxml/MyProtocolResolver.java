package com.cn.iocxml;

import com.cn.constants.Constants;
import org.springframework.core.io.DefaultResourceLoader;
import org.springframework.core.io.ProtocolResolver;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.lang.Nullable;
import org.springframework.util.StringUtils;

/**
 * @author huoxianwei
 * @date 2019/1/8 15:12
 * 添加自定义的xml解析器
 */
public class MyProtocolResolver implements ProtocolResolver {

	@Override
	public Resource resolve(@Nullable String location, @Nullable  ResourceLoader resourceLoader) {
		if (!StringUtils.isEmpty(location) && location.startsWith(Constants.XML_PREFIX) && null != resourceLoader) {
			return resourceLoader.getResource(location.replace(Constants.XML_PREFIX, ""));
		}
		return null;
	}

	public static void main(String[] args) {
		DefaultResourceLoader defaultResourceLoader = new DefaultResourceLoader();
		defaultResourceLoader.addProtocolResolver(new MyProtocolResolver());
		Resource resource = defaultResourceLoader.getResource("my/beans.xml");
		System.out.println("配置文件路径为="+resource.getFilename());
	}
}
