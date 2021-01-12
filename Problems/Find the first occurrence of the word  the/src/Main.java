import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scan=new Scanner(System.in);
        String date=scan.nextLine();
        char[] temp=date.toCharArray();
        int firstIndex=-1;
        boolean find=false;
        for(int i = 0 ; i < temp.length-2 ; i++) {
            if (temp[i] == 't' || temp[i] == 'T') {
                if (temp[i+1] == 'h' && temp[i+2] == 'e') {
                    firstIndex=i;
                    find=true;
                    break;
                }
            }else {
                find=false;
            }
        }
        if(find){
            System.out.println(firstIndex);
        }else{
            System.out.println("-1");
        }

    }
}