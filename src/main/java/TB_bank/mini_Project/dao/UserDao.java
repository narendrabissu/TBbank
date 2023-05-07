package TB_bank.mini_Project.dao;
import TB_bank.mini_Project.POJO.User1;
import org.apache.catalina.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


@Repository
@EnableJpaRepositories
public interface UserDao extends JpaRepository<User1,Integer> {

User1 findByEmailId(@Param("email") String email);
User1 findByEmail(String email);
}
