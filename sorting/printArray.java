import java.util.ArrayList;

public class printArray {
    public static String GREEN = "\u001B[32m";
    public static String CYAN = "\u001B[36m";
    public static String RESET = "\u001B[0m";
    public static String YELLOW = "\u001B[33m";
    public static  String PURPLE = "\u001B[35m";
    public static  String RED = "\u001B[31m";
    public static  String BLUE = "\u001B[34m";
    public static void printStep(int counter , ArrayList<Integer> Arr,ArrayList<Boolean>vis) {
        System.out.print(YELLOW+"Step "+counter+" --> "+RESET+RED+"[ "+RESET);
        for (int i = 0; i < Arr.size(); i++) {
            if (vis.get(i)) {
                if(i==Arr.size()-1){
                    System.out.print(GREEN + Arr.get(i) + RESET + " ");
                }
                else{
                    System.out.print(GREEN + Arr.get(i) + RESET + ", ");
                }
                 
            } else {
                if(i==Arr.size()-1){
                    System.out.print(Arr.get(i) + " ");
                }
                else{
                    System.out.print(Arr.get(i) + ", ");
                }
            }
        }
        System.out.print(RED+"]"+RESET);
        System.out.println("\n");
    }
    public static void printStepsRadix (ArrayList<Integer>Arr,int counter){
        System.out.print(YELLOW+"Step "+counter+" --> "+RESET+RED+"[ "+RESET);
        for (int i = 0; i < Arr.size(); i++){
          String s = Arr.get(i).toString();
          for (int j = 0; j <s.length(); j++) {
             if(s.charAt(j)=='-'){
                System.out.print("-");
                continue;
            }
             if(s.length()-j>counter){
                System.out.print(s.charAt(j));
            }
            else{
                System.out.print(GREEN+s.charAt(j)+RESET);
            }
          }
          if(i!=Arr.size()-1)System.out.print(", ");
        }
        System.out.print(RED+" ]"+RESET);
        System.out.println("\n");
    }
    public static void printFristArray(ArrayList<Integer>arr){
        System.out.print(CYAN+"Given Array --> "+RESET );
        System.out.print(RED+"[ "+RESET);
        for (int i = 0; i < arr.size(); i++) {
            if(i==arr.size()-1){
                System.out.print(arr.get(i) + " ");
            }
            else{
                System.out.print(arr.get(i) + ", ");
            }
        }
        System.out.print(RED+"]"+RESET);
        System.out.println("\n");
    }

    public static void printSortedArray(ArrayList<Integer>arr){
        System.out.print(CYAN+"Sorted Array --> "+RESET );
        System.out.print(RED+"[ "+RESET);
        for (int i = 0; i < arr.size(); i++) {
            if(i==arr.size()-1){
                System.out.print(GREEN+arr.get(i) + " "+RESET);
            }
            else{
                System.out.print(GREEN+arr.get(i) + ", "+RESET);
            }
        }
        System.out.print(RED+"]"+RESET);
        System.out.println("\n");
    
    }
    
}
