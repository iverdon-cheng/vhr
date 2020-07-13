package cn.iverdon.vhrlixi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author iverdon
 * @date 2020/7/11 4:42 下午
 */
public class Employee implements Serializable {

    private Integer id;

    private String name;

    private String gender;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date birthday;

    private String idCard;

    private String wedlock;

    private Integer nationId;

    private String nativePlace;

    private Integer politicId;

    private String email;

    private String phone;

    private String address;

    private Integer departmentId;

    private Integer jobLevelId;

    private Integer posId;

    private String engageFrom;

    private String tiptopDegree;

    private String specialty;

    private String school;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginDate;

    private String workState;

    private String workId;

    private Double contractTerm;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date conversionTime;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date notWorkDate;

    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Shanghai")
    private Date beginContract;

    private Integer workAge;


}
