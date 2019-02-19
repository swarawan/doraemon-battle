package com.swarawan.doraemon.view.intro;

import com.swarawan.doraemon.common.Player;
import com.swarawan.doraemon.model.Character;

public interface IntroService {

    void getAllCharacters();

    Character getCharacter(int indexChar);

    void getAllPlayers();

    void setPlayer(Player player, int indexChar);
}
