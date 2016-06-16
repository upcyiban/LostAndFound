package cn.edu.upc.yb.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yyljj on 2016/5/21.
 */
public interface UserDao extends PagingAndSortingRepository<User,Integer> {
    public Iterable<User> findByIsdeletNotAndIsloserNotOrderByDateDesc(Boolean isdelet,Boolean isloser);
    public Iterable<User> findByIsdeletNotOrderByDateDesc(Boolean isdelet);
    public Page<User> findAll(Pageable pageable);
}
