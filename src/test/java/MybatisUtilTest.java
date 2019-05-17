import com.mxz.mybatis.domain.User;
import com.mxz.mybatis.util.MybatisUtil;
import lombok.Cleanup;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Description: mybatisUtil工具类测试
 * @Auther: mengxiuze
 * @Date: 2019/5/17 10:10
 */
public class MybatisUtilTest {

    @Test
    void mybatisUtilTest() {
        @Cleanup
        SqlSession sqlSession = MybatisUtil.getSession();
        User user = sqlSession.selectOne("com.mxz.mybatis.mapper.UserMapper.get", 1L);
        System.out.println(user);
    }
}
