package com.hd.jy.oasm.domain;
//�������ͱ�
public class TBpglxb {
    private int id;

    private String tableType;//������

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