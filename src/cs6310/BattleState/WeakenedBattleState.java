package cs6310.BattleState;

import java.util.Random;

public class WeakenedBattleState implements IBattleState {
    // 50% chance of attack means 5,6,7,8,9 is attack
    public static final int attackIfGreaterThanOrEqualTo = 5;
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
