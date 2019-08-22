package cn.com.dxk.management.repository;

import cn.com.dxk.management.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 〈用户-持久层〉
 *
 * @author Dingxk
 * @create 2019/8/15
 * @since 1.0.0
 */
@Repository
public interface UserRepository extends JpaRepository<User,Integer> {

    List<User> findByIphone(String iphone);

    List<User> findByNickName(String nickName);

    @Query("select u from User as u where iphone = ?1 or nickName = ?1")
    List<User> findByIphoneOrNickName(String IphoneOrNickName);

    Page<User> findAll(Pageable pageable);

    int deleteByUserId(String userId);

}
