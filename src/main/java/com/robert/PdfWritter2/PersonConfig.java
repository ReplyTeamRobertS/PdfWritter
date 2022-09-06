//package com.robert.PdfWritter2;
//
//import org.springframework.beans.BeansException;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.ApplicationContextAware;
//import org.springframework.context.EnvironmentAware;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.core.env.Environment;
//import org.thymeleaf.TemplateEngine;
//import org.thymeleaf.spring5.SpringTemplateEngine;
//import org.thymeleaf.templateresolver.ITemplateResolver;
//import org.thymeleaf.templateresolver.StringTemplateResolver;
//
//@Configuration
////@PropertySource("classpath:mail/emailconfig.properties")
//public class PersonConfig implements ApplicationContextAware, EnvironmentAware {
//    @Override
//    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
//
//    }
//
//    @Override
//    public void setEnvironment(Environment environment) {
//
//    }
//
//    @Bean
//    public TemplateEngine personTemplateEngine() {
//        final SpringTemplateEngine templateEngine = new SpringTemplateEngine();
//
//        // Resolver for HTML editable emails (which will be treated as a String)
//        templateEngine.addTemplateResolver(stringTemplateResolver());
//
//        return templateEngine;
//    }
//
//    private ITemplateResolver stringTemplateResolver() {
//        final StringTemplateResolver templateResolver = new StringTemplateResolver();
//        templateResolver.setOrder(1);
//        // No resolvable pattern, will simply process as a String template everything not previously matched
//        templateResolver.setTemplateMode("HTML5");
//        templateResolver.setCacheable(false);
//        return templateResolver;
//    }
//
//
//
//}
