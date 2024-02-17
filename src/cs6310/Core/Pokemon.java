package cs6310.Core;

import cs6310.BattleState.BattleStateFactory;
import cs6310.Skill.ISkillContainer;
import cs6310.Skill.Skill;

import java.util.Random;

/**
 * Template pattern base class for all Pokemon
 */
public abstract class Pokemon {
    public static final int DEFAULT_MAX_HEALTH = 25;

    private int health;
    private int maxHealth;
    private Skill lastDefense;
    private Random rng;

    public Pokemon(Integer seed) {
        this.maxHealth = DEFAULT_MAX_HEALTH;
        this.health = this.maxHealth;
        setSeed(seed);
    }

    public void battle(Object pokemon, int damage) {
        if (pokemon instanceof Pokemon attacker) {
            
            int trueDamage = damage;

            if (lastDefense != null) {
                int damageReduction = lastDefense.getPower();
                trueDamage = Math.max(trueDamage - damageReduction, 0);
                System.out.printf("%s successfully reduced %s's damage by %d with %s%n", getName(), attacker.getName(), damageReduction, lastDefense.getName());
            }

            health = Math.max(health - trueDamage, 0);

            attacker.removeDefense();

            System.out.printf("%s has received %d dmg, remaining hp is %d%n", getName(), trueDamage, health);
        }
    }

    public void setDefense(Skill defense) {
        lastDefense = defense;
    }

    private void removeDefense() {
        lastDefense = null;
    }

    public Skill chooseAttack() {
        ISkillContainer attackSkills = getAttackSkills();

        int choice = rng.nextInt(attackSkills.size());

        return attackSkills.choose(choice);
    }

    public Skill chooseDefense() {
        ISkillContainer defenseSkills = getDefenseSkills();

        int choice = rng.nextInt(defenseSkills.size());

        return defenseSkills.choose(choice);
    }

    public boolean shouldAttack() {
        var state = BattleStateFactory.getBattleState(health, maxHealth);
        return state.shouldAttack(rng);
    }

    public boolean isFainted() {
        return health <= 0;
    }

    public void setSeed(Integer seed) {
        if (seed == null) {
            throw new IllegalArgumentException("Seed cannot be null");
        }
        this.rng = new Random(seed);
    }

    public abstract ISkillContainer getAttackSkills();
    public abstract ISkillContainer getDefenseSkills();
    public abstract String getName();
}
