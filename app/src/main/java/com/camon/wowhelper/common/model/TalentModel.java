package com.camon.wowhelper.common.model;

public class TalentModel {
    private String tier;
    private String column;
    private SpellModel spell;

    public String getTier() {
        return tier;
    }

    public void setTier(String tier) {
        this.tier = tier;
    }

    public String getColumn() {
        return column;
    }

    public void setColumn(String column) {
        this.column = column;
    }

    public SpellModel getSpell() {
        return spell;
    }

    public void setSpell(SpellModel spell) {
        this.spell = spell;
    }
}
