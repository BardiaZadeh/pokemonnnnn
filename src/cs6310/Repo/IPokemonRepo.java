package cs6310.Repo;

import cs6310.Core.Pokemon;

public interface IPokemonRepo {
    Pokemon get(String name, Integer seed);
    void load(String directoryPath);
}