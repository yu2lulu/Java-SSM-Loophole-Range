package it.ssm.service.impl;

import it.ssm.dao.UserinfoDao;
import it.ssm.dao.articleDao;
import it.ssm.domain.Userinfo;
import it.ssm.domain.article;
import it.ssm.service.dom4jService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

@Service
public class dom4jServiceImpl implements dom4jService {
    @Override
    public article getArticleById(String id) {
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        articleDao bean = app.getBean(articleDao.class);

        article oneArticle = bean.getArticleById(id);

        return oneArticle;
    }
}
