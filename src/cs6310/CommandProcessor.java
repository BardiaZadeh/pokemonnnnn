package cs6310;

import java.util.Scanner;

import cs6310.Game.Game;

public class CommandProcessor {
    private Game game;

    public CommandProcessor(Game game) {
        this.game = game;
    }

    public void ProcessCommands(String[] args) {
        var commandLineInput = new Scanner(System.in);
        var delimiter = ",";

        while (true) {
            var wholeInputLine = commandLineInput.nextLine();
            var tokens = wholeInputLine.split(delimiter);

            System.out.println("> " + wholeInputLine);

            if (tokens[0].equals("setseed")) {
                for (var i = 0; i < tokens.length; i++) {
                    System.out.println("token " + i + " is " + tokens[i]);
                }
                //TODO: Input error / format handling

                Integer seed = Integer.parseInt(tokens[1]);
                game.setSeed(seed);
            } else if (tokens[0].equals("removeseed")) {
                for (var i = 0; i < tokens.length; i++) {
                    System.out.println("token " + i + " is " + tokens[i]);
                }
                game.removeSeed();;
            } else if (tokens[0].equals("battle")) {
                for (var i = 0; i < tokens.length; i++) {
                    System.out.println("token " + i + " is " + tokens[i]);
                }

                //TODO: Input error / format handling
                String p1 = tokens[1].toLowerCase();
                String p2 = tokens[2].toLowerCase();

                game.battle(p1, p2);
            } else if (tokens[0].equals("stop")) {
                for (var i = 0; i < tokens.length; i++) {
                    System.out.println("token " + i + " is " + tokens[i]);
                }
                break;
            } else {
                for (var i = 0; i < tokens.length; i++) {
                    System.out.println("token " + i + " is " + tokens[i]);
                }
            }
        }

        System.out.println("simulation terminated");
        commandLineInput.close();
    }
}
