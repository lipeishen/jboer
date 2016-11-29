package com.dcits.djk.manager.single.model;

public class BhSysBaseDictionary {
    private String dictId;

    private String dictName;

    private String dictParentId;

    private String dictParentName;

    public String getDictId() {
        return dictId;
    }

    public void setDictId(String dictId) {
        this.dictId = dictId == null ? null : dictId.trim();
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictParentId() {
        return dictParentId;
    }

    public void setDictParentId(String dictParentId) {
        this.dictParentId = dictParentId == null ? null : dictParentId.trim();
    }

    public String getDictParentName() {
        return dictParentName;
    }

    public void setDictParentName(String dictParentName) {
        this.dictParentName = dictParentName == null ? null : dictParentName.trim();
    }
}