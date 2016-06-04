package cn.edu.upc.yb.model;

import org.springframework.data.repository.CrudRepository;

/**
 * Created by yyljj on 2016/5/21.
 */
public interface UserDao extends CrudRepository<User,Integer>{
    public Iterable<User> findByIsdeletNotAndIsloserNotOrderByDateDesc(Boolean isdelet,Boolean isloser);
    public Iterable<User> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
}
