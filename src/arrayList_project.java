import java.util.*;

public class arrayList_project {
    private static Scanner sc = new Scanner(System.in);//scanner is declared outside main so that it can be called in other methods too//
    public static void main(String[] args) {
        boolean t = true;
        ArrayList<String> groceries = new ArrayList<>();//declaring an ArrayList of datatype String
        while(t){
            printAction();
            switch (Integer.parseInt(sc.next())){//this takes the input from the printAction method, it takes a number input but as a
                //string hence the Integer.ParseInt function is used to convert the String to an int
                case 1 -> addItems(groceries);
                case 2 -> removeItems(groceries);
                default -> t=false;
            }
        }
        groceries.sort(Comparator.naturalOrder());//sorting the ArrayList
        System.out.println(groceries);


    }
    public static void addItems(ArrayList<String> groceries){
        int i,j;
        System.out.println("Add item(s), separated by a comma (,)");
        String [] str = sc.next().split(",");//String input is being accepted and the values are being passed to Array str, delimited by commas
                                         //so now we have an array of the elements inputted
        for(i=0;i< str.length;i++){//loop to check if a method is inputted more than once
            String element = str[i].trim();//element stores the individual array elements, trimming the extra white spaces
            if(groceries.indexOf(element)<0){//checking if the value stored in element is already in the groceries ArrayList, if its not there
                                      //it'll return -1 (which is <0), hence it is a unique element
                groceries.add(element);//if the element is unique we will pass it to the ArrayList
            }
        }


    }
    public static void removeItems(ArrayList<String> groceries){
        System.out.println("Enter the items to be deleted, separate them with a comma (,)");
        String[] str = sc.next().split(",");
        groceries.removeAll(List.of(str));//function to remove the inputted elements(which is stored in the array str using the split function)
    }

    public static void printAction(){//method simply for informing the user
        String s = """
                Press 0 to exit
                Press 1 to add items to the list
                Press 2 to remove items from the list""";
        System.out.println(s + " ");
    }
}
