package it.ssm.service.impl;

import it.ssm.dao.UserinfoDao;
import it.ssm.domain.Userinfo;
import it.ssm.service.myBatisService;
import org.springframework.stereotype.Service;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContext;

@Service
public class myBatisServiceImpl implements myBatisService {
    @Override
    public Userinfo getUserById(String id) {
        ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        WebApplicationContext app = WebApplicationContextUtils.getWebApplicationContext(servletContext);
        UserinfoDao Userinfobean = app.getBean(UserinfoDao.class);

        Userinfo user = Userinfobean.getUserById(id);

        return user;
    }
}
