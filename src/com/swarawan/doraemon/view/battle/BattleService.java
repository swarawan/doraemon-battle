package com.swarawan.doraemon.view.battle;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.model.Character;

public interface BattleService {

    void drawingFirstPlay();

    Character getCharacter(Player player);

    void attack(Player player, int choosenSkill);
}
