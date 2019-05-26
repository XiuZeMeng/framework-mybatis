import com.mxz.mybatis.domain.User;
import com.mxz.mybatis.util.MybatisUtil;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

/**
 * @Description: 修改、删除、新增测试类
 * @Auther: mengxiuze
 * @Date: 2019/5/26 11:51
 */
public class UpdateTest {

    /**
     * @description: 修改测试
     * @auther: mengxiuze
     * @date: 2019/5/26 16:00
     */
    @Test
    void testUpdate(){
        SqlSession session = MybatisUtil.getSession();

        User userUpdate = new User();
        userUpdate.setId(2L);
        userUpdate.setName("用户2-afterUpdate");
        userUpdate.setSalary(new BigDecimal(10000));
        session.update("com.mxz.mybatis.mapper.UserMapper.update", userUpdate);

        // 提交事务
        session.commit();
        session.close();
    }

    /**
     * @description: 修改删除
     * @auther: mengxiuze
     * @date: 2019/5/26 16:10
     */
    @Test
    void testDelete(){
        SqlSession session = MybatisUtil.getSession();
        session.delete("com.mxz.mybatis.mapper.UserMapper.delete", 1L);
        session.commit();
        session.close();
    }

    @Test
    void testSave(){
        SqlSession session = MybatisUtil.getSession();
        User u = new User();
        u.setName("用户-新增");
        u.setSalary(new BigDecimal(100));
        System.out.println(u);
        session.insert("com.mxz.mybatis.mapper.UserMapper.save", u);
        session.commit();
        session.close();
        System.out.println(u);
    }
}
