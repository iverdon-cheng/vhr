package cn.iverdon.vhrlixi.mapper;

import cn.iverdon.vhrlixi.model.Employee;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/16 22:34
 */
public interface EmployeeMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Employee record);

    int insertSelective(Employee record);

    Employee selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Employee record);

    int updateByPrimaryKey(Employee record);

    List<Employee> getEmployeeByPage(@Param("page") Integer page, @Param("size") Integer size, @Param("keyword") String keywords);

    Long getTotal(String keywords);

    Integer addEmp(Employee employee);

    Integer maxWorkID();
}
