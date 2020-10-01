package com.example.basic;

/**
 * 引用类型
 */
public class ReferenceTypeDemo {
    public static void main(String[] args) {
        // 创建Weapon 对象
        Weapon weapon = new Weapon("屠龙刀", 999999);
        // 创建Armour 对象
        Armour armour = new Armour("麒麟甲", 10000);
        // 创建Role 对象
        Role role = new Role();

        // 设置武器属性
        role.setWeapon(weapon);
        // 设置盔甲属性
        role.setArmour(armour);

        // 穿戴盔甲
        role.wear();

        // 攻击
        role.attack();

        // 设置角色法术技能
        role.setSpellSkill(new SpellSkill() {
            @Override
            public void SpellAttack() {
                System.out.println("纵横天下");
            }
        });
        // 发动法术攻击
        role.spellSkillAttack();

        // 设置角色法术技能
        role.setSpellSkill(new SpellSkill() {
            @Override
            public void SpellAttack() {
                System.out.println("逆转乾坤");
            }
        });
        // 发动法术攻击
        role.spellSkillAttack();
    }
}
