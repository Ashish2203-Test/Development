package org.aziz;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

/**
 * Created by admin on 9/25/16.
 */
public class InitHelloWorld implements BeanPostProcessor{


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("Before initialization: "+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("After initialization: "+beanName);
        return bean;
    }
}
