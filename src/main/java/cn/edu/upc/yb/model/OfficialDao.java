package cn.edu.upc.yb.model;

import com.sun.corba.se.spi.oa.ObjectAdapterFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.Iterator;

/**
 * Created by yyljj on 2016/5/21.
 */
public interface OfficialDao extends CrudRepository<Official,Integer>,PagingAndSortingRepository<Official,Integer> {
    public Iterable<Official> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
    public Page<Official> findAll(Pageable pageable);
    public Page<Official> findByIsdeletNotOrderByDateDesc(Boolean isdelet,Pageable pageable);
}
