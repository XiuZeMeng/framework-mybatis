import com.mxz.mybatis.domain.User;
import com.mxz.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

/**
 * @Description: 配置resultMap测试类
 * @Auther: mengxiuze
 * @Date: 2019/6/7 10:17
 */
public class ResultMapTest {

    /**
     * @description: 测试表字段名和对象属性名称不匹配的情况
     * @auther: mengxiuze
     * @date: 2019/6/7 10:20
     */
    @Test
    void testSelectOne(){
        SqlSession session = MybatisUtil.getSession();
        User user = session.selectOne("com.mxz.mybatis.mapper.UserNewMapper.testSelectOne", 1L);
        System.out.println(user);
        session.close();
    }

    /**
     * @description: 测试使用别名解决名称不匹配问题
     * @auther: mengxiuze
     * @date: 2019/6/7 10:31
     */
    @Test
    void testUseAlias(){
        SqlSession session = MybatisUtil.getSession();
        User user = session.selectOne("com.mxz.mybatis.mapper.UserNewMapper.testUseAlias", 1L);
        System.out.println(user);
        session.close();
    }

    /**
     * @description: 测试使用ResultMap解决名称不匹配问题
     * @auther: mengxiuze
     * @date: 2019/6/7 10:37
     */
    @Test
    void testUseResultMap(){
        SqlSession session = MybatisUtil.getSession();
        User user = session.selectOne("com.mxz.mybatis.mapper.UserNewMapper.testUseResultMap", 1L);
        System.out.println(user);
        session.close();
    }
}
