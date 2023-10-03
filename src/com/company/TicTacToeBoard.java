package com.company;


import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;



public class TicTacToeBoard {

    private char[][] ticField;

    private Set<Integer> set = new HashSet<Integer>();

    private char mark = 'X';

    private int currentRound = 1;

    private int currentTurn = 1;

    private int maxTurns = 9;

    private void initializeSetOfRemainingMoves(){
        for (int i = 0; i < 9; i++) {
            set.add(i + 1);
        }
    }

    public void displayBoard() {
        System.out.print("_____________");
        System.out.println();
        for (int i = 0; i < ticField.length; i++) {
            System.out.print("| ");
            for (int j = 0; j < ticField.length; j++) {
                System.out.print(ticField[j][i]);
                System.out.print(" | ");
            }
            System.out.println();
            System.out.print("|___|___|___|");
            System.out.println();
        }
    }

    public char getCurrentPlayerMark()
    {
        return mark;
    }

    public int ticTurn(int selectedBox, int player) {

        if (set.contains(selectedBox)) {

            if (selectedBox == 1) {
                ticField[0][0] = mark;
            }
            if (selectedBox == 2) {
                ticField[1][0] = mark;
            }
            if (selectedBox == 3) {
                ticField[2][0] = mark;
            }
            if (selectedBox == 4) {
                ticField[0][1] = mark;
            }
            if (selectedBox == 5) {
                ticField[1][1] = mark;
            }
            if (selectedBox == 6) {
                ticField[2][1] = mark;
            }
            if (selectedBox == 7) {
                ticField[0][2] = mark;
            }
            if (selectedBox == 8) {
                ticField[1][2] = mark;
            }
            if (selectedBox == 9) {
                ticField[2][2] = mark;
            }
            winningCondition(player);
            set.remove(selectedBox);
            currentTurn++;
            displayBoard();
            if (player == 1) {
                mark = 'O';
                return 2;
            } else {
                mark = 'X';
                return 1;
            }

        } else {
            System.out.println("Box is taken. Pick another one.");
            return player;
        }
    }

    public void winningCondition(int player) {
        for (int i = 0; i < ticField.length; i++) {
            for (int j = 0; j < ticField.length; j++) {
                if (ticField[0][0] == mark && ticField[1][0] == mark && ticField[2][0] == mark ) {
                    showGameResolution();
                } else if (ticField[0][1] == mark && ticField[1][1] == mark && ticField[2][1] == mark ) {
                    showGameResolution();
                } else if (ticField[0][2] == mark && ticField[1][2] == mark && ticField[2][2] == mark ) {
                    showGameResolution();
                } else if (ticField[0][0] == mark && ticField[0][1] == mark && ticField[0][2] == mark ) {
                    showGameResolution();
                } else if (ticField[1][0] == mark && ticField[1][1] == mark && ticField[1][2] == mark ) {
                    showGameResolution();
                } else if (ticField[2][0] == mark && ticField[2][1] == mark && ticField[2][2] == mark ) {
                    showGameResolution();
                } else if (ticField[0][0] == mark && ticField[1][1] == mark && ticField[2][2] == mark ) {
                    showGameResolution();
                } else if (ticField[0][2] == mark && ticField[1][1] == mark && ticField[2][0] == mark ) {
                    showGameResolution();
                }
            }
        }

        if(currentTurn == maxTurns) {
            System.out.println("Your game ends in a draw!");
            playAgain();
        }
    }

    private void showGameResolution(){
        System.out.println("Congratulations player "+mark+" You won!");
        displayBoard();
        playAgain();
    }

    private void playAgain(){
        System.out.println("Do you wish to play again?");
        Scanner scanner = new Scanner(System.in);
        String response = scanner.nextLine();
        if(response.startsWith("y")){
            currentRound++;
            System.out.println("Starting round " + currentRound + "!");
            restartGame();
        }
        else{
            System.out.println("Thanks for playing!");
            System.exit(0);
        }
    }

    public void restartGame(){
        ticField = new char[][]{{'1', '4', '7'}, {'2', '5', '8'}, {'3', '6', '9'}};
        initializeSetOfRemainingMoves();
        currentTurn = 1;

        int player = 1;
        if (currentRound == 1) {
            System.out.println("Welcome! Let's play tic tac toe! Round " + currentRound + "!");

            displayBoard();

            System.out.println("Rules: In this game players take turns putting their mark in empty locations. The first player to get three of their marks in a row wins.");
            System.out.println("Enter the number that corresponds with location you like to choose.");
        }

        while (true){

            System.out.println("Turn "+currentTurn+". Player " + player + "(" + getCurrentPlayerMark() +"): pick a location");
            Scanner playerTurn = new Scanner(System.in);


            while(!playerTurn.hasNextInt()) {
                System.out.println("Invalid entry. Please select a number between 1 and 9.");
                System.out.println("Player" + player + "(" + getCurrentPlayerMark() +"): pick a location");
                playerTurn = new Scanner(System.in);
            }

            int x = playerTurn.nextInt();
            player = ticTurn(x, player);
        }
    }

}

















