import cs6310.Battle.BattleBuilder;
import cs6310.CommandProcessor;
import cs6310.Game.Game;
import cs6310.Repo.MockPokemonRepo;
// import cs6310.Repo.PokemonConstructorRepo;

public class Main {
    public static void main(String[] args) {
        System.out.println("Welcome to the thunder dome!");

        var pokemonRepo = new MockPokemonRepo();
        // var pokemonRepo = new PokemonConstructorRepo();
        // pokemonRepo.load("src/cs6310/Pokemon/");
        // pokemonRepo.printPokemon();

        var battleBuilder = new BattleBuilder(pokemonRepo);
        var game = new Game(battleBuilder);

        var methodCaller = new CommandProcessor(game);
        methodCaller.ProcessCommands(args);
    }
}