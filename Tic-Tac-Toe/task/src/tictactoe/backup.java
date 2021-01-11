package tictactoe;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Arrays;

public class backup {
    public static void main(String[] args) {
        int rep;
        //do {
        Scanner scan = new Scanner(System.in);
        System.out.print("Enter cells: ");
        String str = scan.nextLine();
        String[] strPart;
        String[][] ticTacToe=new String[3][3];
        strPart = str.split("");

        int t=0;
        for(int i=0;i<3;i++){
            for(int j=0;j<3;j++){
                if(strPart[t].equals("_")){
                    ticTacToe[i][j] =" ";
                }else {
                    ticTacToe[i][j] = strPart[t];

                }
                t++;
            }
        }

        print(ticTacToe);

        readCoordinates(ticTacToe);
        //     checkResult(strPart);

        //     System.out.println();
        //     System.out.println("Repeat 1:");
        //     rep=scan.nextInt();
        // }while(rep ==1);
    }
    public static void readCoordinates(String[][] ticTacToe){
        int x=0,y=0;
        boolean check=false;
        Scanner scan=new Scanner(System.in);

        do{
            try {

                check=false;
                System.out.print("Enter the coordinates: ");
                x = scan.nextInt();
                y = scan.nextInt();

                if ( (x<1 || x>3) || (y<1 || y>3) ){
                    System.out.println("Coordinates should be from 1 to 3!");
                    check=true;
                }else if (ticTacToe[x-1][y-1] != " "){
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
        fillCell(ticTacToe,x-1,y-1);
    }

    public static void fillCell(String[][] ticTacToe, int x, int y){
        ticTacToe[x][y]="X";
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
    public static void checkResult(String[] strPart){
        int empty=0;
        int x=0;
        int o=0;

        for (String s : strPart) {
            if (s.equals("X")) {
                x++;
            }
            if (s.equals("O")) {
                o++;
            }
            if (s.equals("_")) {
                empty++;
            }
        }
        String[] sample={"X","O","_","X","O","_","X","O","X"};
        String result = "";
        String text="";
        if(empty ==0 && (x+1 == o || o+1 == x  )){

            if(strPart[0].equals(strPart[1]) && strPart[0].equals(strPart[2])){
                result=  result.concat(strPart[0]+" wins");
            }else if (strPart[0].equals(strPart[3]) && strPart[0].equals(strPart[6])){
                result=  result.concat(strPart[0]+" wins");
            }else if (strPart[0].equals(strPart[4]) && strPart[0].equals(strPart[8])){
                result=  result.concat(strPart[0]+" wins");
            }else if (strPart[1].equals(strPart[4]) && strPart[1].equals(strPart[7])){
                result=  result.concat(strPart[1]+" wins");
            }else if (strPart[2].equals(strPart[4]) && strPart[2].equals(strPart[6])){
                result=  result.concat(strPart[2]+" wins");
            }else if (strPart[2].equals(strPart[5]) && strPart[2].equals(strPart[8])){
                result=  result.concat(strPart[2]+" wins");
            }else if (strPart[3].equals(strPart[4]) && strPart[3].equals(strPart[5])){
                result=  result.concat(strPart[3]+" wins");
            }else if (strPart[6].equals(strPart[7]) && strPart[6].equals(strPart[8])){
                result=  result.concat(strPart[6]+" wins");
            }else {
                result=  result.concat("Draw");
            }
        } else  if(empty !=0 && ( (x+1 == o || o+1 == x ) || (x==o) ) ){

            if(strPart[0].equals(strPart[1]) && strPart[0].equals(strPart[2])){
                result=  result.concat(strPart[0]+" wins");
            }else if (strPart[0].equals(strPart[3]) && strPart[0].equals(strPart[6])){
                result= result.concat(strPart[0]+" wins");
            }else if (strPart[0].equals(strPart[4]) && strPart[0].equals(strPart[8])){
                result= result.concat(strPart[0]+" wins");
            }else if (strPart[1].equals(strPart[4]) && strPart[1].equals(strPart[7])){
                result= result.concat(strPart[1]+" wins");
            }else if (strPart[2].equals(strPart[4]) && strPart[2].equals(strPart[6])){
                result= result.concat(strPart[2]+" wins");
            }else if (strPart[2].equals(strPart[5]) && strPart[2].equals(strPart[8])){
                result= result.concat(strPart[2]+" wins");
            }else if (strPart[3].equals(strPart[4]) && strPart[3].equals(strPart[5])){
                result= result.concat(strPart[3]+" wins");
            }else if (strPart[6].equals(strPart[7]) && strPart[6].equals(strPart[8])){
                result=result.concat(strPart[6]+" wins");
            }else {
                result= result.concat("Game not finished");
            }
        } else if( ( (empty !=0) && ( x<o+2  || x+2 > o ))  ){
            result=("Impossible");
        }
        if(Arrays.equals(strPart,sample)){
            result=("Impossible");
        }

        System.out.println(result);
    }
}
