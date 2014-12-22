package com.camon.wowhelper.common.constant;


public enum TierEnum {
    TIER_0(15),
    TIER_1(30),
    TIER_2(45),
    TIER_3(60),
    TIER_4(75),
    TIER_5(90),
    TIER_6(100);

    int tierLevel;

    TierEnum(int tierLevel) {
        this.tierLevel = tierLevel;
    }

    public int getTierLevel() {
        return tierLevel;
    }


}
