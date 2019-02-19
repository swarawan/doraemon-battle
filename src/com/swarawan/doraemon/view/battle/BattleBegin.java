package com.swarawan.doraemon.view.battle;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.model.Character;
import com.swarawan.doraemon.model.Skill;

import java.util.Scanner;

public class BattleBegin implements BattleView {

    private Scanner scanner = new Scanner(System.in);
    private BattleService service;
    private int round = 1;
    private Player firstPlayer;

    public BattleBegin(Character player1, Character player2) {
        this.service = new BattleServiceImpl(player1, player2, this);
    }

    public void start() {
        System.out.println("===== BATTLE BEGIN =====");
        service.drawingFirstPlay();
    }

    private void showBattleInfo(Player player) {
        Character character = service.getCharacter(player);

        System.out.println("===== ROUND " + round);
        System.out.println(character.getName().toUpperCase().toUpperCase() + " (" + character.getHp() + "/" + character.getMana() + ")");
        showSkills(player);
    }

    private void showSkills(Player player) {
        Character character = service.getCharacter(player);

        for (int i = 1; i < character.getSkills().size() + 1; i++) {
            Skill skill = character.getSkills().get(i - 1);
            System.out.println(i + ". " + skill.getName() + " (dmg:" + skill.getDamage() + ", mana consume: " + skill.getManaConsume() + ")");
        }

        System.out.print("Pilih Skill (1..4) : ");
        int choosenSkill = scanner.nextInt();
        if (choosenSkill < 1 || choosenSkill > 5) {
            System.out.println("Skill tidak ditemukan");
            showSkills(player);
        }
        service.attack(player, choosenSkill - 1);
    }

    @Override
    public void setFirstPlay(Player player) {
        this.firstPlayer = player;
        showBattleInfo(player);
    }

    @Override
    public void notEnoughMana(Player player) {
        System.out.println("--> Not enough mana");
        showSkills(player);
    }

    @Override
    public void enemyDead(Character attacker, Character enemy) {
        String info = String.format("===== %s WIN =====", attacker.getName());
        System.out.println(info);
        System.out.println();
    }

    @Override
    public void nextRound(Player nextPlayer) {
        if (firstPlayer == nextPlayer) round++;

        showBattleInfo(nextPlayer);
    }

    @Override
    public void infoAttack(Character character, int choosenSkill) {
        Skill skill = character.getSkills().get(choosenSkill);
        String infoAttack = String.format("--> %s menggunakan %s, dengan damage %d",
                character.getName().toUpperCase(), skill.getName().toUpperCase(), skill.getDamage());
        System.out.println(infoAttack);
        System.out.println();
    }

    @Override
    public void infoEnemy(Character character) {
        String infoDamage = String.format("--> %s terkena serangan...", character.getName());
        System.out.println(infoDamage);

        String infoEnemy = String.format("%s (%d / %d)", character.getName().toUpperCase(), character.getHp(), character.getMana());
        System.out.println(infoEnemy);
        System.out.println();
    }
}
