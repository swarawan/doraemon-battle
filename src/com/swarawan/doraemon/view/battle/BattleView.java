package com.swarawan.doraemon.view.battle;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.model.Character;

public interface BattleView {

    void setFirstPlay(Player player);

    void notEnoughMana(Player player);

    void enemyDead(Character attacker, Character enemy);

    void nextRound(Player nextPlayer);

    void infoAttack(Character character, int choosenSkill);

    void infoEnemy(Character character);
}
