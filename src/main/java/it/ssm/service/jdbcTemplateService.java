package it.ssm.service;

import it.ssm.domain.Userinfo;

public interface jdbcTemplateService {
    public Userinfo getUserinfoOne(String id);

    public Userinfo getUserinfoOneSafe(String id);
}
