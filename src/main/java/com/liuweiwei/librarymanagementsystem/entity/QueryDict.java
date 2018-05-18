package com.liuweiwei.librarymanagementsystem.entity;

import com.liuweiwei.librarymanagementsystem.common.entity.QueryBase;

/**
 * @author liuweiwei
 **/
public class QueryDict extends QueryBase {
    private Integer id;
    private String code;
    private String text;
    private String type;
    private String value;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

}
