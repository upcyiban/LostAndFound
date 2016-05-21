package cn.edu.cup.yb.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by yyljj on 2016/5/21.
 */
public interface OfficialDao extends CrudRepository<Official,Integer>{
    public Iterable<Official> findAll(Sort sort);
}
