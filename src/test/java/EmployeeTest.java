import com.mxz.mybatis.domain.Employee;
import com.mxz.mybatis.mapper.EmployeeMapper;
import com.mxz.mybatis.util.MybatisUtil;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
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
}
