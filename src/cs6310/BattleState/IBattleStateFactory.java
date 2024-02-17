package cs6310.BattleState;

public interface IBattleStateFactory {
    IBattleState getBattleState(int health, int maxHealth);
}