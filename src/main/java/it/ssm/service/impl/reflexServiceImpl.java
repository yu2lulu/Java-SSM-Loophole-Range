package it.ssm.service.impl;

import it.ssm.dao.reflexDao;
import it.ssm.domain.article;
import it.ssm.service.reflexService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

@Service
public class reflexServiceImpl implements reflexService {
    @Override
    public article getArticleBytitle(String title) {
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(ContextLoader.getCurrentWebApplicationContext().getServletContext());

        reflexDao beanDao = app.getBean(reflexDao.class);
        article OneArticle = null;
        OneArticle = beanDao.getArticleBytitle(title);

        return OneArticle;
    }
}
