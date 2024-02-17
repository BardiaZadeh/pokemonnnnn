package cs6310.Battle;

import cs6310.Core.Pokemon;
import cs6310.Repo.IPokemonRepo;

/**
 * Responsible for keeping track of the seed value before any battle has started
 * Seed is null when unitialized
 */
public class BattleBuilder {
    private Integer seed;
    private IPokemonRepo pokemonRepo;
    private Pokemon p1;
    private Pokemon p2;

    public BattleBuilder(IPokemonRepo pokemonRepo) {
        this.pokemonRepo = pokemonRepo;
    }

    public void setSeed(Integer seed) {
        this.seed = seed;
    }

    public int getSeed() {
        return this.seed;
    }

    public void removeSeed() {
        this.seed = null;
    }

    public void setP1(String name) {
        p1 = pokemonRepo.get(name, seed);
    }

    public void setP2(String name) {
        p2 = pokemonRepo.get(name, seed + 1);
    }

    public Battle build() {
        if (seed == null) {
            throw new IllegalStateException("Seed must be initialized first");
        }

        if (p1 == null || p2 == null) {
            throw new IllegalStateException("Must set pokemon p1 and pokemon p2 first");
        }

        return new Battle(p1, p2);
    }
}
