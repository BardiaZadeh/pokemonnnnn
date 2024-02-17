package cs6310.Game;

import cs6310.Battle.Battle;
import cs6310.Battle.BattleBuilder;

public class Game {
    private BattleBuilder battleBuilder;

    public Game(BattleBuilder battleBuilder) {
        this.battleBuilder = battleBuilder;
    }

    public void setSeed(Integer seed) {
        battleBuilder.setSeed(seed);
    }

    public void removeSeed() {
        battleBuilder.removeSeed();
    }

    public void battle(String p1, String p2) {
        battleBuilder.setP1(p1);
        battleBuilder.setP2(p2);

        Battle battle = battleBuilder.build();

        battle.startBattle();
    }

    public void stop() {

    }
}
