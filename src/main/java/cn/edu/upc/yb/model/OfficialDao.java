package cn.edu.upc.yb.model;

import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.Iterator;

/**
 * Created by yyljj on 2016/5/21.
 */
public interface OfficialDao extends CrudRepository<Official,Integer>{
    public Iterable<Official> findAll(Sort sort);
    public Iterable<Official> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
}
