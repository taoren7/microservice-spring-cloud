package cn.allen.cloud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import cn.allen.cloud.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
