package cn.iverdon.vhrlixi.model;

import java.io.Serializable;

/**
 * @author iverdon
 * @date 2020/7/11 4:40 下午
 */
public class Department implements Serializable {
    private Integer id;

    private String name;

    private Integer parentId;

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

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }
}
