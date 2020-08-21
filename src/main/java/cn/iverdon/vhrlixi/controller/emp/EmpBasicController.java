package cn.iverdon.vhrlixi.controller.emp;

import cn.iverdon.vhrlixi.model.*;
import cn.iverdon.vhrlixi.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author iverdon
 * @date 2020/8/16 22:22
 */
@RestController
@RequestMapping("/emp/basic")
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

    @GetMapping("/")
    public RespPageBean getEmployeeByPage(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size
    ,String keywords){
        return employeeService.getEmployeeByPage(page, size, keywords);
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
}
