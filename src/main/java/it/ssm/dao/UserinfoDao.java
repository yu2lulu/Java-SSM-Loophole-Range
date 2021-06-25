package it.ssm.dao;

import it.ssm.domain.Userinfo;

import java.util.List;

public interface UserinfoDao {

    public List<Userinfo> getUsers();

    public Userinfo getUserById(String id);
}
