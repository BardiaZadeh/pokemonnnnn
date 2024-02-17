package cs6310.Battle;

import cs6310.Core.Pokemon;
import cs6310.Skill.Skill;

public class Battle {
    private Pokemon p1;
    private Pokemon p2;
    private boolean isP1sTurn;

    public Battle(Pokemon p1, Pokemon p2) {
        this.p1 = p1;
        this.p2 = p2;
        this.isP1sTurn = true;
    }

    public void startBattle() {
        while (!p1.isFainted() && !p2.isFainted()) {
            if (isP1sTurn) {
                doTurn(p1, p2);
                isP1sTurn = false;
            } else {
                doTurn(p2, p1);
                isP1sTurn = true;
            }
        }
        announceWinner(p1, p2);
    }

    private void announceWinner(Pokemon p1, Pokemon p2) {
        if (p1.isFainted() && !p2.isFainted()) {
            System.out.printf("%s has lost%n", p1.getName());
            System.out.printf("%s has won the battle%n", p2.getName());
            return;
        }

        if (!p1.isFainted() && p2.isFainted()) {
            System.out.printf("%s has lost%n", p2.getName());
            System.out.printf("%s has won the battle%n", p1.getName());
            return;
        }

        throw new IllegalStateException("Game has ended in a draw! Should that be possible?");
    }

    /**
     * When it's main pokemon's turn attack other
     * @param main The Pokemon whose turn it is
     * @param other The Pokemon whose turn it is not
     */
    public void doTurn(Pokemon main, Pokemon other) {
        if (main.shouldAttack()) {
            Skill attack = main.chooseAttack();
            int damage = attack.getPower();

            System.out.printf("%s is attacking with %s for %d damage to %s%n", main.getName(), attack.getName(), damage, other.getName());
            other.battle(main, damage);

        } else {

            Skill defense = main.chooseDefense();

            System.out.printf("%s is attempting to defend with %s%n", main.getName(), defense.getName());
            main.setDefense(defense);
        }
    }
}
