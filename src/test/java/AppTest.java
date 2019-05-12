import com.mxz.mybatis.domain.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;


import java.io.InputStream;
import java.util.List;

/**
 * @Description: 应用测试类
 * @Auther: mengxiuze
 * @Date: 2019/5/11 10:13
 */
public class AppTest {

    /**
     * @description: 查询id为1的用户信息
     * @auther: mengxiuze
     * @date: 2019/5/11 10:15
     */
    @Test
    void testGet() throws Exception {
        // 从classpath 路径去加载mybatis 全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SQLSessionFactory对象，好比是DataSource
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SQLSession对象，好比是Connection
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 具体操作（增删改查）
        User user = sqlSession.selectOne("com.mxz.mybatis.mapper.UserMapper.get", 1L);
        // 关闭会话连接
        sqlSession.close();
        System.out.println(user);
    }

    /**
     * @description: 查询所有用户
     * @auther: mengxiuze
     * @date: 2019/5/12 11:33
     */
    @Test
    void testListAll() throws Exception {
        // 从classpath 路径去加载mybatis 全局配置文件
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
        // 创建SQLSessionFactory对象，好比是DataSource
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        // 创建SQLSession对象，好比是Connection
        SqlSession sqlSession = sqlSessionFactory.openSession();
        // 具体操作（增删改查）
        List<User> userList = sqlSession.selectList("com.mxz.mybatis.mapper.UserMapper.ListAll");
        // 关闭会话连接
        sqlSession.close();
        for (User user : userList){
            System.out.println(user);
        }
    }
}
