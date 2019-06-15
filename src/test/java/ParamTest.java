import com.mxz.mybatis.domain.Client;
import com.mxz.mybatis.mapper.ClientMapper;
import com.mxz.mybatis.util.MybatisUtil;
import com.mxz.mybatis.vo.ClientVO;
import org.apache.ibatis.session.SqlSession;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description: Mybatis的参数处理测试
 * @Auther: mengxiuze
 * @Date: 2019/6/14 09:58
 */
public class ParamTest {

    @Test
    void testGetByVO(){
        SqlSession session = MybatisUtil.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        ClientVO vo = new ClientVO("admin", "123456");
        Client client = clientMapper.getByVO(vo);
        session.close();
        System.out.println(client);
    }

    @Test
    void testGetByMap(){
        SqlSession session = MybatisUtil.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Map<String, Object> paramMap = new HashMap<String, Object>(){
            {
                this.put("username", "admin");
                this.put("password", "123456");
            }
        };
        Client client = clientMapper.getByMap(paramMap);
        session.close();
        System.out.println(client);
    }

    @Test
    void testGetByParam(){
        SqlSession session = MybatisUtil.getSession();
        ClientMapper clientMapper = session.getMapper(ClientMapper.class);
        Client client = clientMapper.getByParam("admin", "123456");
        session.close();
        System.out.println(client);
    }
}
