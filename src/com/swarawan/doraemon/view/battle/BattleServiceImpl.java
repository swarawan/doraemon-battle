package com.swarawan.doraemon.view.battle;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.model.Character;
import com.swarawan.doraemon.model.Skill;

public class BattleServiceImpl implements BattleService {

    private BattleView view;
    private Character player1;
    private Character player2;

    public BattleServiceImpl(Character player1, Character player2, BattleView view) {
        this.player1 = player1;
        this.player2 = player2;
        this.view = view;
    }

    @Override
    public void drawingFirstPlay() {
        int random = ((int) (Math.random() * 100)) + 1;
        view.setFirstPlay(random % 2 == 0 ? Player.PLAYER1 : Player.PLAYER2);
    }

    @Override
    public Character getCharacter(Player player) {
        return player == Player.PLAYER1 ? player1 : player2;
    }

    @Override
    public void attack(Player player, int choosenSkill) {
        Character attacker = getCharacter(player);
        Skill skill = attacker.getSkills().get(choosenSkill);

        if (attacker.getMana() < skill.getManaConsume()) view.notEnoughMana(player);
        attacker.setMana(attacker.getMana() - skill.getManaConsume());
        view.infoAttack(attacker, choosenSkill);

        if (player == Player.PLAYER1) player1 = attacker;
        else player2 = attacker;

        Character enemy = getCharacter(player == Player.PLAYER1 ? Player.PLAYER2 : Player.PLAYER1);
        enemy.setHp(enemy.getHp() - skill.getDamage());
        view.infoEnemy(enemy);

        if (player == Player.PLAYER1) player2 = enemy;
        else player1 = enemy;


        if (enemy.getHp() < 0) view.enemyDead(attacker, enemy);
        else view.nextRound(player == Player.PLAYER1 ? Player.PLAYER2 : Player.PLAYER1);
    }
}
