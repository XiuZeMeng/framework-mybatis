import com.mxz.mybatis.domain.Employee;
import com.mxz.mybatis.mapper.EmployeeMapper;
import com.mxz.mybatis.query.EmployeeQueryObject;
import com.mxz.mybatis.query.PageResult;
import com.mxz.mybatis.service.IEmployeeService;
import com.mxz.mybatis.service.impl.EmployeeServiceImpl;
import com.mxz.mybatis.util.MybatisUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description: 员工信息类，mybatis的动态SQL-if和choose测试
 * @Auther: mengxiuze
 * @Date: 2019/6/22 10:29
 */
public class EmployeeTest {

    /**
     * @description: 查询工资大于等于1000的员工
     * @auther: mengxiuze
     * @date: 2019/6/22 10:35
     */
    @Test
    void test1() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        BigDecimal minSalary = new BigDecimal(1000);
        List<Employee> employeeList = employeeMapper.selectByMinSally(minSalary);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /**
     * @description: 查询工资范围在1000到2000之间的员工
     * @auther: mengxiuze
     * @date: 2019/6/22 10:35
     */
    @Test
    void test2() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        BigDecimal minSalary = new BigDecimal(1000);
        BigDecimal maxSalary = new BigDecimal(2000);
        List<Employee> employeeList = employeeMapper.selectByMinMaxSally(minSalary, maxSalary);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /**
     * @description: 查询指定部门员工信息
     * @auther: mengxiuze
     * @date: 2019/6/22 11:08
     */
    @Test
    void test3() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.selectByDeptId(10);
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    /**
     * @description: 使用SQL的foreach元素批量删除
     * @auther: mengxiuze
     * @date: 2019/6/23 10:10
     */
    @Test
    void test4() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
//        employeeMapper.batchDelete(new int[]{7,8,9});
        employeeMapper.batchDelete(Arrays.asList(7, 8, 9));
    }

    /**
     * @description: 使用SQL的foreach元素批量添加
     * @auther: mengxiuze
     * @date: 2019/6/23 10:19
     */
    @Test
    void test5() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = new ArrayList<Employee>();
        Employee em1 = new Employee();
        em1.setName("批量添加员工1");
        em1.setSn("批量添加员工1sn");
        em1.setSalary(new BigDecimal(100));
        em1.setDeptId(100);

        Employee em2 = new Employee();
        em2.setName("批量添加员工2");
        em2.setSn("批量添加员工2sn");
        em2.setSalary(new BigDecimal(200));
        em2.setDeptId(200);

        employeeList.add(em1);
        employeeList.add(em2);
        employeeMapper.batchSave(employeeList);
    }

    // ------------------------高级查询------------------

    /**
     * @description: 需求：按员工的关键字，工资范围，所属部门来查询
     * @auther: mengxiuze
     * @date: 2019/6/23 11:49
     */
    @Test
    void test6() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyword(" ");
        qo.setMinSalary(new BigDecimal(1000));
        qo.setMaxSalary(new BigDecimal(2000));
        qo.setDeptId(20);
        List<Employee> employeeList = employeeMapper.queryForList(qo);
        for (Employee e : employeeList) {
            System.out.println(e);
        }
    }

    @Test
    void test7() {
        EmployeeMapper employeeMapper = MybatisUtil.getMapper(EmployeeMapper.class);
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyword(" ");
        qo.setMinSalary(new BigDecimal(1000));
        qo.setMaxSalary(new BigDecimal(2000));
        qo.setDeptId(20);
        int count = employeeMapper.queryForCount(qo);
        System.out.println(count);
    }

    /**
     * @description: 分页查询测试
     * @auther: mengxiuze
     * @date: 2019/6/30 11:13
     */
    @Test
    void test8() {
        IEmployeeService service = new EmployeeServiceImpl();
        EmployeeQueryObject qo = new EmployeeQueryObject();
        qo.setKeyword("ww");
        qo.setMinSalary(new BigDecimal(1000));
        qo.setMaxSalary(new BigDecimal(2000));
        qo.setDeptId(20);
        PageResult pageResult = service.getEmployeePage(qo);
        System.out.println(pageResult.getTotalCount());
        for (Object o : pageResult.getResult()){
            System.out.println(o);
        }
    }
}
