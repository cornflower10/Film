import com.jiangpw.entity.film.Info;
import com.jiangpw.mapper.UserMapper;
import com.jiangpw.mapper.film.InfoMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class UserDaoTest {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private InfoMapper infoMapper;
    @Test
    public void testFindUserById() {
//        int id = 1;
//        User user = userMapper.selectByPrimaryKey(id);
//        System.out.println(user.getId() + ":" + user.getUsername());
        Info info = new Info();
        info.setTitle("xibushijie");
        infoMapper.insert(info);

    }
}
