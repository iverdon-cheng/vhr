package cn.iverdon.vhrlixi.service;

import cn.iverdon.vhrlixi.mapper.DepartmentMapper;
import cn.iverdon.vhrlixi.model.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/14 14:26
 */
@Service
public class DepartmentService {
    @Autowired
    DepartmentMapper departmentMapper;

    public List<Department> getAllDepartments(){
        return departmentMapper.getAllDepartmentsByParentId(-1);
    }

    public void addDep(Department dep) {
        dep.setEnabled(true);
        departmentMapper.addDep(dep);
    }


    public void deleteDepById(Department dep) {
        departmentMapper.deleteDepById(dep);
    }
}
