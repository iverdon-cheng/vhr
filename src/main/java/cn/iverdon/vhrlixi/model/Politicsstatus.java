package cn.iverdon.vhrlixi.model;

import java.io.Serializable;

/**
 * @author iverdon
 * @date 2020/8/17 9:06
 */
public class Politicsstatus implements Serializable {
    private Integer id;

    private String name;

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
}
