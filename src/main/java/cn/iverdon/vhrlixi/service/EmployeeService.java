package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.EmployeeMapper;
import cn.iverdon.vhrlixi.model.Employee;
import cn.iverdon.vhrlixi.model.RespPageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/16 22:27
 */
@Service
public class EmployeeService {
    @Autowired
    EmployeeMapper employeeMapper;

    public RespPageBean getEmployeeByPage(Integer page, Integer size, String keywords) {
        if (page != null && size != null){
            page = (page-1)*size;
        }
        List<Employee> data = employeeMapper.getEmployeeByPage(page, size, keywords);
        Long total = employeeMapper.getTotal(keywords);
        RespPageBean bean = new RespPageBean();
        bean.setData(data);
        bean.setTotal(total);
        return bean;
    }

    public Integer addEmp(Employee employee) {
        return employeeMapper.insertSelective(employee);
    }

    public Integer maxWorkID() {
        return employeeMapper.maxWorkID();
    }
}
