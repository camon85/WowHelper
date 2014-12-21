package com.camon.wowhelper.common;

public enum Constant {
    CLASS_WARRIOR(1, "전사"),
    CLASS_PALADIN(2, "성기사"),
    CLASS_HUNTER(3, "사냥꾼"),
    CLASS_ROGUE(4, "도적"),
    CLASS_PRIEST(5, "사제"),
    CLASS_DEATH_KNIGHT(6, "죽음의 기사"),
    CLASS_SHAMAN(7, "주술사"),
    CLASS_MAGE(8, "마법사"),
    CLASS_WARLOCK(9, "흑마법사"),
    CLASS_MONK(10, "수도사"),
    CLASS_DRUID(11, "드루이드"),
    ;
    int id;
    String name;

    Constant(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
