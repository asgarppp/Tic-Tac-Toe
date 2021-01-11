package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        String[][] ticTacToe=new String[3][3];
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                ticTacToe[i][j] =" ";
            }
        }
        print(ticTacToe);

        int player=1;
        int p1=0;
        int p2=0;
        boolean check=true;
        int result;
        int winner=0;
        do {
            readCoordinates(ticTacToe, player);
            if (player == 1) {
                 player = 2;
                 p1++;
            } else if (player == 2) {
                 player = 1;
                 p2++;
            }

            if (p1 > 2) {
                result = checkResult(ticTacToe);
                //System.out.println("if 1 it should end:" + result);
                if(result==1){
                    check=false;

                }

            }

        }while(check);

    }
    public static void readCoordinates(String[][] ticTacToe,int player){
        int x=0,y=0;
        boolean check;
        Scanner scan=new Scanner(System.in);
        do{
            try {

                check=false;
                System.out.print("Enter the coordinates: ");
                x = Integer.parseInt(scan.next());
                y = Integer.parseInt(scan.next());

                if ( (x<1 || x>3) || (y<1 || y>3) ){
                     System.out.println("Coordinates should be from 1 to 3!");
                     check=true;
                }else if (ticTacToe[x-1][y-1].equals("X") || ticTacToe[x-1][y-1].equals("O")){
                     System.out.println("This cell is occupied! Choose another one!");
                     check=true;
                }
            }
            catch (InputMismatchException e){
                System.out.println("You should enter numbers!");
                scan.nextLine();
                check=true;
            }
        }while(check);
        fillCell(ticTacToe,x-1,y-1,player);
    }

    public static void fillCell(String[][] ticTacToe, int x, int y,int player){
        if(player==1){
            ticTacToe[x][y]="X";
        } else if(player==2){
            ticTacToe[x][y]="O";
        }
        print(ticTacToe);
    }

    public static void print(String[][] ticTacToe){
        System.out.printf("---------%n");
        for(int i=0;i<3;i++){
            System.out.print("| ");
            for(int j=0;j<3;j++){
                System.out.printf("%s ",ticTacToe[i][j]);
                if(j==2){
                    System.out.print("|");
                    System.out.println();
                }
            }
        }
        System.out.printf("---------%n");
    }

    public static int checkResult(String[][] array){

        String result = "";
        int X=0,O=0;
        int status = 0;  // if return 1 ended game.


        int countX = 0; // amount of X's in a row
        int countO = 0; // amount of O's in a row

        for (int y = 0; y <= 2; y++) { // for all horizontal rows
            countX = 0;
            countO = 0;
            for (int x = 0; x <= 2; x++) { // loop through all x-coordinates
                String value = array[x][y];
                if (value.equals("X")) { // if the value at that coordinate equals "X", add 1 to the count
                    countX++;
                }
                if (value.equals("O")) { // same here
                    countO++;
                }
            }
            if (countX == 3) { // if the count is 3 (thus 3 X's in a row), X has won
                result= "X wins";
                status = 1;
            }
            if (countO == 3) { // same here
                result=  "O wins";
                status = 1;
            }
        }

        // Same thing, but for all vertical columns
        for (int x = 0; x <= 2; x++) {
            countX = 0;
            countO = 0;
            for (int y = 0; y <= 2; y++) {
                String value = array[x][y];
                if (value.equals("X")) {
                    countX++;
                }
                if (value.equals("O")) {
                    countO++;
                }
            }
            if (countX == 3) {
                result=  "X wins";
                status = 1;
            }
            if (countO == 3) {
                result=  "O wins";
                status = 1;
            }
        }

        // Same thing, but for diagonal
        countX = 0;
        countO = 0;
        for (int i = 0; i <= 2; i++) {
            String value = array[i][i];
            if (value.equals("X")) {
                countX++;
            }
            if (value.equals("O")) {
                countO++;
            }
        }
        if (countX == 3) {
            result= "X wins";
            status = 1;
        }
        if (countO == 3) {
            result=  "O wins";
            status = 1;
        }

        // Same thing, but for other diagonal
        countX = 0;
        countO = 0;
        for (int i = 0; i <= 2; i++) {
            String value = array[i][2-i];
            if (value.equals("X")) {
                countX++;
            }
            if (value.equals("O")) {
                countO++;
            }
        }
        if (countX == 3) {
            result=  "X wins";
            status = 1;
        }
        if (countO == 3) {
            result=  "O wins";
            status = 1;
        }
        if (result=="" && getNumberOfMoves(array) == 9) { // if the number of moves equals 9, the game is over and it is a draw
            result=  "Draw";
            status = 1;
        }
        if(result !="") {
            System.out.println(result);
        }
        return status;

    }

    public static int getNumberOfMoves(String[][] ticTacToe){
        int counter=0;
        for(int i=0;i<3;i++) {
            for (int j = 0; j < 3; j++) {
                if ( (ticTacToe[i][j].equals("X") ) || (ticTacToe[i][j].equals("O")) ) {
                    counter++;
                }
            }
        }
        return counter;
    }
}
