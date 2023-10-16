package com.example.demotestapp.controller;

import com.example.demotestapp.gameplay.GameDataHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class GameController {

    private final GameDataHandler gameData = new GameDataHandler();

    @GetMapping("/")
    public String startGame(){
        return "index";
    }

    @PostMapping("/play")
    public String playGame(@RequestParam(name = "index", required = false) int index, Model model) {

        if (!gameData.checkGameOver()) {
            int currentPlayer = gameData.checkCurrentPlayer() ? 1 : 2;
            if (gameData.makeValidMove(index - 1)) {
                gameData.setMove(index - 1);
                model.addAttribute(GameDataHandler.gameProgress,
                "Player" + currentPlayer + " can play." + "\n" + GameDataHandler.gamePlay(gameData));
            } else {
                model.addAttribute(GameDataHandler.gameProgress, "Invalid move. enter valid selection.");
            }
        } else {
            model.addAttribute(GameDataHandler.gameProgress, "Game over!");
            int winner = gameData.checkPlayerWon();
            if (winner == 0) {
                model.addAttribute(GameDataHandler.gameResults, "draw");
            } else {
                model.addAttribute(GameDataHandler.gameResults, "Player " + winner + " won");
            }
        }
        return "index";
    }
}
