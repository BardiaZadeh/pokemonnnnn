package cs6310.Repo;

import cs6310.Core.Pokemon;
import cs6310.Pokemon.Bulbasaur;
import cs6310.Pokemon.Charmander;
import cs6310.Pokemon.Pikachu;
import cs6310.Pokemon.Squirtle;

//TODO: Delete this class once PokemonRepo is ready
public class MockPokemonRepo implements IPokemonRepo {

    @Override
    public Pokemon get(String name, Integer seed) {
        if (name.equals("pikachu")) {
            return new Pikachu(seed);
        }

        if (name.equals("squirtle")) {
            return new Squirtle(seed);
        }

        if (name.equals("charmander")) {
            return new Charmander(seed);
        }

        if (name.equals("bulbasaur")) {
            return new Bulbasaur(seed);
        }

        throw new IllegalArgumentException("Don't recognize that pokemon");
    }

    @Override
    public void load(String directoryPath) {
        throw new UnsupportedOperationException("Unimplemented method 'load'");
    }
    
}
