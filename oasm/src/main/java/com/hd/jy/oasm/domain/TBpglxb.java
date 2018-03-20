package com.hd.jy.oasm.domain;
//评估类型表
public class TBpglxb {
    private int id;

    private String tableType;//表类型

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTableType() {
        return tableType;
    }

    public void setTableType(String tableType) {
        this.tableType = tableType == null ? null : tableType.trim();
    }
}