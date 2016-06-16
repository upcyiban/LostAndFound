package cn.edu.upc.yb.model;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by yyljj on 16-6-16.
 */
public interface UserDaoPage extends PagingAndSortingRepository<User,Integer>{
    public Page<User> findAll(Pageable pageable);
}
