package it.ssm.service.impl;

import it.ssm.domain.Userinfo;
import it.ssm.service.jdbcTemplateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class jdbcTemplateServiceImpl implements jdbcTemplateService {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    //漏洞代码实例
    @Override
    public Userinfo getUserinfoOne(String id) {
        String sql = "select * from Userinfo where id = " + id;
        Userinfo userinfo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Userinfo>(Userinfo.class));
        return userinfo;
    }

    //安全的代码实例
    @Override
    public Userinfo getUserinfoOneSafe(String id) {
        String sql = "select * from Userinfo where id = ?";
        Userinfo userinfo = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<Userinfo>(Userinfo.class),id);
        return userinfo;
    }
}
