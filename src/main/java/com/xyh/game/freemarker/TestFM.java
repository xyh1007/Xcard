package com.xyh.game.freemarker;

import com.xyh.game.freemarker.base.TemplateExtUtil;
import freemarker.core.Environment;
import freemarker.ext.servlet.FreemarkerServlet;
import freemarker.ext.servlet.HttpRequestHashModel;
import freemarker.template.TemplateDirectiveBody;
import freemarker.template.TemplateDirectiveModel;
import freemarker.template.TemplateException;
import freemarker.template.TemplateModel;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class TestFM implements TemplateDirectiveModel {
    @Override
    public void execute(Environment environment, Map map, TemplateModel[] templateModels, TemplateDirectiveBody templateDirectiveBody) throws TemplateException, IOException {
        try {
            HttpRequestHashModel hashModel = (HttpRequestHashModel) environment.getDataModel()
                    .get(FreemarkerServlet.KEY_REQUEST);
            HttpServletRequest request = hashModel.getRequest();
            String html = this.getTest(request,map);
            environment.getOut().write(html);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private String getTest(HttpServletRequest request, @SuppressWarnings("rawtypes") Map map) {
        Map<String, Object> fMap = new HashMap<String, Object>();
        return TemplateExtUtil.output(fMap, "/common/javafm/test.ftl");
    }
}
