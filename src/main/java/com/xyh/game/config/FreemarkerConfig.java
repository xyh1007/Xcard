package com.xyh.game.config;

import com.xyh.game.freemarker.TestFM;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class FreemarkerConfig {

    @Autowired
    private freemarker.template.Configuration configuration;

    @Autowired
    private TestFM testFM;


    @PostConstruct
    public void setSharedVariable() {
        configuration.setSharedVariable("test", testFM);
    }

}
