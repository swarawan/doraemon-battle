package com.swarawan.doraemon.view.intro;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.model.Character;
import com.swarawan.doraemon.model.Skill;
import com.swarawan.doraemon.view.battle.BattleBegin;

import java.util.List;
import java.util.Scanner;

public class Intro implements IntroView {

    private Scanner scanner = new Scanner(System.in);
    private IntroService service;

    public Intro() {
        service = new IntroServiceImpl(this);
    }

    public void start() {
        System.out.println("===== DORAEMON BATTLE =====");
        System.out.println();
        System.out.println();

        playerChoose(1);
        playerChoose(2);
        service.getAllPlayers();
    }

    private void playerChoose(int player) {
        service.getAllCharacters();
        System.out.println();
        System.out.print("Pemain " + player + " pilih karakter: ");

        int choose = scanner.nextInt();
        if (choose < 0 || choose > 3) {
            System.out.println("Input tidak valid");
            System.out.println();
            playerChoose(player);
        }

        Character character = showCharacter(choose);
        System.out.print("Pilih " + character.getName().toUpperCase() + " (y/n) ? ");
        String sure = scanner.next();
        if (sure.equalsIgnoreCase("y")) {
            service.setPlayer(player == 1 ? Player.PLAYER1 : Player.PLAYER2, choose - 1);

            System.out.println();
            System.out.println("Pemain " + player + " memilih " + character.getName().toUpperCase());
            System.out.println();
        } else if (sure.equalsIgnoreCase("n")) {
            System.out.println();
            System.out.println();

            service.getAllCharacters();
            playerChoose(player);
        }
    }

    private Character showCharacter(int choose) {
        Character character = service.getCharacter(choose - 1);
        System.out.println("----- " + character.getName().toUpperCase() + " -----");
        System.out.println("HP : " + character.getHp());
        System.out.println("Mana : " + character.getMana());
        System.out.println("Skills : ");
        for (int i = 1; i < character.getSkills().size() + 1; i++) {
            Skill skill = character.getSkills().get(i - 1);
            System.out.println(i + ". " + skill.getName());
            System.out.println("   " + skill.getDesc());
            System.out.println("   Damage: " + skill.getDamage());
            System.out.println("   Mana consume: " + skill.getManaConsume());
            System.out.println("   Stun Chance: " + skill.getStun().getStunChance() + "%");
            System.out.println("   Stun Duration: " + skill.getStun().getStunDuration() + "s");
            System.out.println();
        }
        return character;
    }

    @Override
    public void showAllCharacters(List<Character> characters) {
        System.out.println("----- Karakter -----");
        for (int i = 1; i < characters.size() + 1; i++) {
            Character character = characters.get(i - 1);
            System.out.println(i + ". " + character.getName());
        }
    }

    @Override
    public void showAllPlayers(Character player1, Character player2) {
        System.out.println();
        System.out.println();
        System.out.println("===== Player 1 : " + player1.getName().toUpperCase() + " =====");
        System.out.println("===== Player 2 : " + player2.getName().toUpperCase() + " =====");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();

        BattleBegin battleBegin = new BattleBegin(player1, player2);
        battleBegin.start();
    }
}
