package by.pvt.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
public class EmailSenderHelper implements BeanNameAware, ApplicationContextAware,
        InitializingBean, DisposableBean
{

    @Value(value = "My Email Handler")
    private String name;

    /*@Bean
    @Scope(scopeName = "prototype")
    public EmailSenderHelper getInstance() {
        return new EmailSenderHelper();
    }*/

    public String getName() {
        return name;
    }

    @Override
    public void setBeanName(String s) {
        System.out.println("setBeanName: " + s);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println(applicationContext);
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("Bean destroy");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("afterPropertiesSet");
    }
}
