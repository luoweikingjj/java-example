package com.example.basic;

public class Role {
    int id; // 角色id
    int blood; // 生命值
    String name; // 角色名称

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBlood() {
        return blood;
    }

    public void setBlood(int blood) {
        this.blood = blood;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // 添加武器属性
    Weapon weapon; // class 作为成员变量
    // 添加盔甲属性
    Armour armour; // class 作为成员变量
    // 添加法术属性
    SpellSkill spellSkill; // interface 作为成员变量

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    public Armour getArmour() {
        return armour;
    }

    public void setArmour(Armour armour) {
        this.armour = armour;
    }

    public SpellSkill getSpellSkill() { // interface 作为返回值类型
        return spellSkill;
    }

    public void setSpellSkill(SpellSkill spellSkill) { // interface 作为方法参数
        this.spellSkill = spellSkill;
    }

    // 攻击方法
    public void attack() {
        System.out.println("使用" + weapon.getName() + ", 造成" + weapon.getHurt() + "点伤害");
    }

    // 穿戴盔甲
    public void wear() {
        // 增加防御,就是增加blood值
        this.blood += armour.getProtect();
        System.out.println("穿上" + armour.getName() + ", 生命值增加" + armour.getProtect());
    }

    // 法术攻击
    public void spellSkillAttack() {
        System.out.print("发动法术攻击:");
        spellSkill.SpellAttack();
        System.out.println("攻击完毕");
    }
}
