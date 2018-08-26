package com.haotu369.jvm.constant;

import java.util.ArrayList;
import java.util.List;

public class ConstantPool {

    private List<ConstantInfo> constantInfos = new ArrayList<ConstantInfo>();

    public ConstantPool() {
    }

    public ConstantInfo getConstantInfo(int index) {
        return constantInfos.get(index);
    }

    public void addConstantInfo(ConstantInfo info) {
        this.constantInfos.add(info);
    }

    public String getUTF8String(int index) {
        return ((UTF8Info) this.constantInfos.get(index)).getValue();
    }

    /**
     * 获取常量池中常量数目
     *
     * @return
     */
    public int getSize() {
        //第0项空出来用于在某些情况下表示不引用任何常量池项目，故-1
        return this.constantInfos.size() - 1;
    }
}
