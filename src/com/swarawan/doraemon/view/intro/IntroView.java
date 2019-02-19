package com.swarawan.doraemon.view.intro;

import com.swarawan.doraemon.model.Character;

import java.util.List;

public interface IntroView {

    void showAllCharacters(List<Character> characters);

    void showAllPlayers(Character player1, Character player2);
}
