package cs6310.Repo;

import cs6310.Core.Pokemon;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class PokemonRepo implements IPokemonRepo {
    //Stores key value pairs of PokemonNames to PokemonObjects
    final private Map<String, Pokemon> pokemonMap;

    public PokemonRepo() {
        pokemonMap = new HashMap<>();
    }

    //This method is only used by BattleBuilder for getting the Pokemon objects for battle
    @Override
    public Pokemon get(String name, Integer seed) {
        if (!pokemonMap.containsKey(name)) {
            throw new RuntimeException("Pokemon : " + name + " is not found in Pokemon Repo");
        }
        Pokemon pokemon = pokemonMap.get(name);
        pokemon.setSeed(seed);
        return pokemon;
    }

    //Responsible for loading all Pokemon child classes from the input directoryPath
    @Override
    public void load(String directoryPath) {
        File folder = new File(directoryPath);
        File[] javaFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".java"));

        if (javaFiles != null) {
            for (File javaFile : javaFiles) {
                try {
                    String className = javaFile.getName().replace(".java", "");
                    Class<?> pokemonClass = Class.forName("cs6310.Pokemon." + className);

                    // Make sure the loaded class extends Pokemon
                    if (Pokemon.class.isAssignableFrom(pokemonClass)) {
                        Constructor<?> constructor = pokemonClass.getDeclaredConstructor(Integer.class);
                        constructor.setAccessible(true);
                        //Initialise all Pokemons in cs6310.Pokemon package with seed as 0
                        Pokemon pokemon = (Pokemon) constructor.newInstance(0);
                        pokemonMap.put(className.toLowerCase(), pokemon);
                    }
                } catch (ClassNotFoundException | NoSuchMethodException |
                         InstantiationException | IllegalAccessException |
                         InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public void printPokemon() {
        //TODO: Remove debug sysouts before submission
        pokemonMap.forEach((name, pokemon) -> {
            System.out.println("Found pokemon : " + name + " with value : " + pokemon.toString());
        });
    }
}
