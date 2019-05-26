import com.mxz.mybatis.domain.User;
import com.mxz.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.Map;

/**
 * @Description: 别名配置测试类
 * @Auther: mengxiuze
 * @Date: 2019/5/26 16:50
 */
public class AliasTest {

    /**
     * @description: 测试实体类User的别名
     * @auther: mengxiuze
     * @date: 2019/5/26 16:58
     */
    @Test
    void testDomainAlias(){
        SqlSession session = MybatisUtil.getSession();
        User user = session.selectOne("com.mxz.mybatis.mapper.UserMapper.testAlias", 2L);
        System.out.println(user);
        session.close();
    }

    /**
     * @description: 测试系统自带Integer的别名(查询表数据的总数)
     * @auther: mengxiuze
     * @date: 2019/5/26 16:59
     */
    @Test
    void testSysIntAlias(){
        SqlSession session = MybatisUtil.getSession();
        int rows = session.selectOne("com.mxz.mybatis.mapper.UserMapper.queryForCount");
        System.out.println(rows);
        session.close();
    }

    /**
     * @description: 只查询部分字段，用Map来封装（更简单的方法，使用selectMap()）
     * @auther: mengxiuze
     * @date: 2019/5/26 17:04
     */
    @Test
    void testMap(){
        SqlSession session = MybatisUtil.getSession();
        Map<String, Object> map1 = session.selectOne("com.mxz.mybatis.mapper.UserMapper.testMap1", 3L);
        System.out.println(map1);
        // 区别：没有查询的字段会以null打印
        User map2 = session.selectOne("com.mxz.mybatis.mapper.UserMapper.testMap2", 3L);
        System.out.println(map2);
        session.close();
    }
}
