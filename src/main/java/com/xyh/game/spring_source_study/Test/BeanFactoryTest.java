package com.xyh.game.spring_source_study.Test;

import com.sun.tools.internal.jxc.ConfigReader;
import com.xyh.game.XcardApplication;
import com.xyh.game.spring_source_study.bean.MyTestBean;

import org.apache.el.util.ReflectionUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;
import org.springframework.test.context.junit4.SpringRunner;

/*@RunWith(SpringRunner.class)
@SpringBootTest(classes = {XcardApplication.class},webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)*/
public class BeanFactoryTest {
    @Test
    public void testSimpleLoad(){
/*        ApplicationContext ac = new ClassPathXmlApplicationContext("classpath:/springxml/beanTest.xml");
        MyTestBean mtc = (MyTestBean) ac.getBean("myb");
        Assert.assertEquals("test",mtc.getStr());*/

        BeanFactory bf = new XmlBeanFactory(new ClassPathResource("/springxml/beanTest.xml"));
        MyTestBean mtc2 = (MyTestBean) bf.getBean("myb");
        //Assert.assertEquals("test",mtc2.getStr());
        throw new IllegalArgumentException("s-error");
        //App？;
    }

}
