import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
        boolean find = false;
        boolean passFind = false;

        char[] temp = url.toCharArray();

        String attributes1 = "";


        int attributeIndex = 0;
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] == '?' && find == false) {
                attributeIndex = i;
                find = true;
            } else if (find){
                attributes1 +=(temp[i]);
            }
        }

        String[] attributes2 = attributes1.split("&");
        String[] tempAtr = new String[2];

        int i = attributes2.length;
        int j = 2;

        String[][]  attributes3 = new String[i][j];
        int iPass = 0;
        int jPass = 0;
        for (int k=0; k<i;k++){
            tempAtr = attributes2[k].split("=");
            for (int l=0; l<tempAtr.length; l++){
                if (tempAtr[l] != "") {
                    attributes3[k][l] = tempAtr[l];
                }
                if (tempAtr[l].equals("pass")) {
                    iPass = k;
                    jPass = l;
                    passFind = true;
                }
            }
        }

        for (int k=0; k<i;k++){
            for (int l=0; l<j;l++){
                if (attributes3[k][l]== null) {
                    System.out.print("not found");
                } else {
                    System.out.print(attributes3[k][l]);
                }
                if (l==0){
                    System.out.print(" : ");
                }
            }
            System.out.println();
        }
        if(passFind){
            System.out.print("password : "+attributes3[iPass][jPass+1]);
        }


    }
}