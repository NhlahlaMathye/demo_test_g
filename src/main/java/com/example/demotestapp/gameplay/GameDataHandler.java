package com.example.demotestapp.gameplay;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import java.util.Arrays;

@Service
public class GameDataHandler {

    private static final Logger logger = LoggerFactory.getLogger(GameDataHandler.class);

    public static final String gameResults = "gameResults";
    public static final String gameProgress = "gameProgress";
    private final GamePits[] pits;

    public GameDataHandler(){
        pits = new GamePits[14];
        for (int y = 0; y < 14; y++) {
            pits[y] = new GamePits(y < 7);
        }
    }

    public GamePits getPit(int index){
        if (index >= 0 && index < 14) {
            return  pits[index];
        } else {
            throw new IllegalArgumentException("Expects a valid pit index input");
        }
    }

    public static String gamePlay(GameDataHandler gameData){
        StringBuilder builder = new StringBuilder();
        for (int x = 13; x >= 7; x--) { // allocate number of stones at start
            builder.append(gameData.getPit(x).getStones()).append(" ");
        }
        builder.append("\n");
        for (int y = 0; y <= 6; y++) {
            builder.append(gameData.getPit(y).getStones()).append(" ");
        }
        return builder.toString();
    }

    public void setMove(int moveIndex){
        if(makeValidMove(moveIndex)){
            int stonesToPick = pits[moveIndex].getStones();
            pits[moveIndex].setStones(0);
            int currentLocation = moveIndex;

            logger.info("index location at: " + currentLocation);
            while (stonesToPick > 0){
                currentLocation = (currentLocation + 1) % 14;
                if (currentLocation == 7 && !pits[moveIndex].isPlayer()){
                    currentLocation = (currentLocation + 1) % 14; //
                }
                pits[currentLocation].addStones(1);
                stonesToPick--;
            }
            collectStones(currentLocation);
        }
    }

    public void collectStones(int checkIndex){

        if (checkIndex >= 0 && checkIndex < 14){
            GamePits pit = pits[checkIndex];
            if(pit.getStones() == 1 && checkIndex != 0 && checkIndex != 7){
                int checkOppPitIndex = 14 - checkIndex;
                GamePits oppPit = pits[checkOppPitIndex];

                logger.info("[stones from host :" + pit.getStones() + " opponent stones :" + oppPit.getStones() + "]");
                pits[7].addStones(pit.getStones() + oppPit.getStones());
                pit.setStones(0);
                oppPit.setStones(0);
            }
        }
    }

    public boolean makeValidMove(int checkIndex){
        return checkIndex >= 0 && checkIndex < 14 && pits[checkIndex].getStones() > 0
                && pits[checkIndex].isPlayer() == checkCurrentPlayer();
    }

    public boolean checkCurrentPlayer(){
        return Arrays.stream(pits, 1, 7).anyMatch(pits1 -> pits1.getStones() > 0);
    }

    public boolean checkGameOver(){
        return Arrays.stream(pits, 1, 7).allMatch(pits1 -> pits1.getStones() == 0)
                || Arrays.stream(pits, 8, 14).allMatch(pits1 -> pits1.getStones() == 0);
    }

    public int checkPlayerWon(){
        int p1Stones = pits[7].getStones();
        int p2Stones = pits[0].getStones();

        logger.info("[check winner {player1 stones :" + p1Stones + " player2 stone :" + p2Stones + "} ]");
        if (p1Stones == p2Stones) { return 0; }
        else if (p1Stones > p2Stones) { return 1;}
        else { return 2; }
    }
}
