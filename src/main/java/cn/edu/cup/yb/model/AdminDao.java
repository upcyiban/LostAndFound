package cn.edu.cup.yb.model;

import org.springframework.data.repository.CrudRepository;

import java.util.Collection;

/**
 * Created by 77dfeba on 2016/5/21.
 */
public interface AdminDao extends CrudRepository<Admin,Integer>{
    public Collection<Admin> findByUsernameAndPassword(String username,String password);
}
