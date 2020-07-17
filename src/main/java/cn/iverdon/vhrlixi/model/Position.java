package cn.iverdon.vhrlixi.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Position {
    private Integer id;

    private String name;

    private Date createDate;

    private Boolean enabled;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateDate() {
        return createDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd  hh:mm:ss",timezone = "Asia/Shanghai")
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }
}