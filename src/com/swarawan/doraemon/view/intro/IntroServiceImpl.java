package com.swarawan.doraemon.view.intro;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.data.GameData;
import com.swarawan.doraemon.model.Character;

import java.util.List;

public class IntroServiceImpl implements IntroService {

    private IntroView view;
    private List<Character> characters;
    private Character player1;
    private Character player2;

    public IntroServiceImpl(IntroView view) {
        this.view = view;
        this.characters = new GameData().allCharacters();
    }

    @Override
    public void getAllCharacters() {
        view.showAllCharacters(characters);
    }

    @Override
    public Character getCharacter(int indexChar) {
        return characters.get(indexChar);
    }

    @Override
    public void getAllPlayers() {
        view.showAllPlayers(player1, player2);
    }

    @Override
    public void setPlayer(Player player, int charIndex) {
        if (player == Player.PLAYER1) {
            player1 = characters.get(charIndex);
        } else {
            player2 = characters.get(charIndex);
        }
    }
}
