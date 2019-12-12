package com.xyh.game.freemarker.base;

import freemarker.template.Configuration;
import freemarker.template.Template;

import java.io.StringWriter;
import java.util.Map;

public class TemplateExtUtil {
    private static Configuration cfg = (Configuration)SpringBeanFactory.getBean("freeMarkerConfiguration");

    public TemplateExtUtil() {
    }

    public static Template input(String filename) {
        Template tmp = null;

        try {
            tmp = cfg.getTemplate(filename);
        } catch (Exception var3) {
            System.out.println("error input:" + filename);
            var3.printStackTrace();
        }

        return tmp;
    }

    public static String output(Map<String, Object> map, String input) {
        Template template = input(input);
        if (template == null) {
            return null;
        } else {
            try {
                StringWriter write = new StringWriter();
                template.process(map, write);
                return write.toString();
            } catch (Exception var4) {
                var4.printStackTrace();
                return null;
            }
        }
    }
}
