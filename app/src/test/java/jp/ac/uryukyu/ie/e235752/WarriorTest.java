package jp.ac.uryukyu.ie.e235752;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;

class WarriorTest {
    int defaultWarriorAttack = 4;
    int damageAmount;
    int beforeHP;
    Enemy slime = new Enemy("スライムもどき", 100, 3);
    Warrior demoWarrior = new Warrior("デモ戦士", 10, defaultWarriorAttack);
      
    @BeforeEach
    void warriorAttack() {
        beforeHP = slime.getHitPoint();
        demoWarrior.attackWithWeponSkill(slime);
        damageAmount = beforeHP - slime.getHitPoint();
    }
    @Test
    void firstAttackTest() {
        assertEquals((int)(defaultWarriorAttack * 3/2), damageAmount);
    }
    @Test
    void secondAttackTest() {
        assertEquals((int)(defaultWarriorAttack * 3/2), damageAmount);
    }
    @Test
    void thirdAttackTest() {
        assertEquals((int)(defaultWarriorAttack * 3/2), damageAmount);
    }
}
