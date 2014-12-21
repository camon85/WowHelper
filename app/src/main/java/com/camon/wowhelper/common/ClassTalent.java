package com.camon.wowhelper.common;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Joo-yong on 2014-12-21.
 */
public class ClassTalent {
    @SerializedName("class")
    private String className;
//    specs;
//    talents;
//    glyphs;

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
