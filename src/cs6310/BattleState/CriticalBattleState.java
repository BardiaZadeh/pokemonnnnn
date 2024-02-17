package cs6310.BattleState;

import java.util.Random;

public class CriticalBattleState implements IBattleState {
    // 30% chance of attack means 7,8,9 is attack
    public static final int attackIfGreaterThanOrEqualTo = 7;
    public static final int maxRollExclusive = 10;

    @Override
    public boolean shouldAttack(Random rng) {
        int roll = rng.nextInt(maxRollExclusive);
        if (roll >= attackIfGreaterThanOrEqualTo) {
            return true;
        }
        return false;
    }
}
