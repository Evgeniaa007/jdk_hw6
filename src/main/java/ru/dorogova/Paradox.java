package ru.dorogova;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Getter
@AllArgsConstructor
public class Paradox {
    private HashMap<Integer, Boolean> choice; // статистика без изменнеия выбора
    private HashMap<Integer, Boolean> changedChoice; // статистика после смены выбора
    private int doors;
    private int attempts;

    private void paradoxGame(int round){
        Random random = new Random();
        int prizeDoor = random.nextInt(getDoors());
        int choice1 = random.nextInt(getDoors());
        int openDoor = -1;
        int choice2 = -1;

        for (int i = 0; i < getDoors(); i++) {
            if(i != prizeDoor && i != choice1){
                openDoor = i;
            }
        }

        choice2 = choice1;
        choice.put(round,choice2 == prizeDoor);

        for (int i = 0; i < getDoors(); i++) {
            if(i != choice1 && i != openDoor){
                choice2 = i;
            }
        }

        changedChoice.put(round, choice2 == prizeDoor);
    }

    public void gameStart(){
        int win = 0;
        int changedChoiceWin = 0;
        for (int i = 0; i < getAttempts(); i++) {
            paradoxGame(i);
        }
        for(Map.Entry<Integer, Boolean> entry : choice.entrySet()){
            if(entry.getValue()){
                win++;
            }
        }

        for(Map.Entry<Integer, Boolean> entry : changedChoice.entrySet()){
            if(entry.getValue()){
                changedChoiceWin++;
            }
        }

        System.out.println("При сохранении первоначального выбора игрок выиграл " + win + " из " + getAttempts() + " попыток");
        System.out.println("Изменении выбора выбора игрок выиграл " + changedChoiceWin + " из " + getAttempts() + " попыток");
    }
}
