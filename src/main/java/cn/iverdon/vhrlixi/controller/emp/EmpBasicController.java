package cn.iverdon.vhrlixi.controller.emp;

import cn.iverdon.vhrlixi.model.*;
import cn.iverdon.vhrlixi.service.*;
import cn.iverdon.vhrlixi.utils.POIUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/16 22:22
 */
@RestController
@RequestMapping("/employee/basic")
public class EmpBasicController {
    @Autowired
    EmployeeService employeeService;

    @Autowired
    NationService nationService;

    @Autowired
    PoliticsstatusService politicsstatusService;

    @Autowired
    JobLevelService jobLevelService;

    @Autowired
    PositionService positionService;

    @Autowired
    DepartmentService departmentService;

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size
    , Employee employee, Date[] beginDateScope){
        return employeeService.getEmployeeByPage(page, size, employee,beginDateScope);
    }

    @PostMapping("/")
    public RespBean addEmp(@RequestBody Employee employee){
        if (employeeService.addEmp(employee) == 1){
            return RespBean.ok("添加成功！");
        }
        return RespBean.error("添加失败！");
    }



    @GetMapping("/nations")
    public List<Nation> getAllNations(){
        return nationService.getAllNations();
    }

    @GetMapping("/politicsstatus")
    public List<Politicsstatus> getAllPoliticsstatus(){
        return politicsstatusService.getAllPoliticsstatus();
    }

    @GetMapping("/jobLevels")
    public List<JobLevel> getAllJobLevel(){
        return jobLevelService.getAllJobLevels();
    }

    @GetMapping("/positions")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }

    @GetMapping("/maxWorkID")
    public RespBean maxWorkID(){
        return RespBean.build().setStatus(200)
                .setObj(String.format("%08d",employeeService.maxWorkID()+1));
    }

    @GetMapping("/deps")
    public List<Department> getAllDepartments(){
        return departmentService.getAllDepartments();
    }

    @DeleteMapping("/{id}")
    public RespBean deleteEmpById(@PathVariable Integer id){
        if (employeeService.deleteEmpByEid(id)==1){
            return RespBean.ok("删除成功！");
        }
        return RespBean.error("删除失败！");
    }

    @PutMapping("/")
    public RespBean updateEmp(@RequestBody Employee employee){
        if (employeeService.updateEmp(employee) == 1){
            return RespBean.ok("更新成功！");
        }
        return RespBean.error("更新失败！");
    }

    @GetMapping("/export")
    public ResponseEntity<byte[]> exportData(){
        List<Employee> list = (List<Employee>)employeeService.getEmployeeByPage(null,null,new Employee(),null).getData();
        return POIUtils.employee2Excel(list);
    }

    @PostMapping("/import")
    public RespBean importData(MultipartFile file){
       List<Employee> list = POIUtils.excel2Employee(file,nationService.getAllNations()
               ,politicsstatusService.getAllPoliticsstatus(),departmentService.getAllDepartmentsWithOutChildren()
               ,jobLevelService.getAllJobLevels(),positionService.getAllPosition());
       if (employeeService.addEmps(list) == list.size()){
           return RespBean.ok("上传成功");
       }
            return RespBean.error("上传失败！");
    }
}
