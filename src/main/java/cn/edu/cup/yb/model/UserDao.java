package cn.edu.cup.yb.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by yyljj on 2016/5/21.
 */
public interface UserDao extends CrudRepository<User,Integer>{
    public Collection<User> findByUsernameAndPassword(String username,String Password);
}
