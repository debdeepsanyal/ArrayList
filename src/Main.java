import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

record groceryItem(String name, String type, String count){
    public groceryItem(String name){
        this(name,"DAIRY","1");
    }

}

public class Main {
    public static void main(String[] args) {
        Object[] objArray = new Object[3];
        objArray[0] = new groceryItem("milk");
        objArray[1] = new groceryItem("apple","produce","6");
        objArray[2] = "6 oranges";//here, since the array is of type Object, we can insert a String in the array which is usually consisting of groceryItems

        System.out.println(Arrays.toString(objArray));

        ArrayList objList = new ArrayList();//when no type is defined, the ArrayList is of type Object by default
        objList.add(new groceryItem("biscuits","HOME","4"));
        objList.add("3 bananas");

        ArrayList <groceryItem> groceryList = new ArrayList<>();//here we are defining that this ArrayList is of type groceryList
        //in ArrayLists, we do not require a predefined size for the list as we do in arrays
        //groceryList.add("9 oranges");  //this statement is no more valid in this groceryList
        groceryList.add(new groceryItem("cheese"));
        groceryList.add(new groceryItem("granola","breakfast","2"));
        groceryList.add(0,new groceryItem("butter"));//this basically adds the item in the inputted position and shifts the other items in the list accordingly
        groceryList.set(1,new groceryItem("paneer"));//this overwrites the item at inputted position with the new item
        groceryList.remove(2);//removes item at inputted position
        System.out.println(groceryList);

        String [] str = new String[]{"apples","oranges","kiwis","bananas"};

        ArrayList <String> strList = new ArrayList<>(List.of(str));//we are passing the predefined Array to this ArrayList in the form of a list and now we can work on the previous array as an ArrayList
        //its simply a method of populating our ArrayList
        strList.add(1,"berries");
        System.out.println(strList);

        ArrayList<String> arrList = new ArrayList<>(List.of("Sunday","Monday","Tuesday"));//here we are creating an Arraylist of 3 elements
        String [] arrString = arrList.toArray(new String[3]);//making an array out of the arrayList created in the last line 
        System.out.println(Arrays.toString(arrString));

        String [] arr = new String[]{"Hello","World","Java"}; //a string is created
        var original = Arrays.asList(arr);//in this original variable, an Arraylist is created which is backed by the above created array
                                  //which means any changes made to the arraylist will reflect in the array. also implies that this specific arraylist is not resizable. its simply an array which can have access to the methods of an arraylist
        original.set(0,"String");//the first element is changed
        System.out.println(original);//the ArrayList is printed
        System.out.println(Arrays.toString(arr));//the array reflects the same changes made.
                                      //it is worth noting that in this case, we cannot use the .add() function since this ArrayList is not resizable it is basically backing the array arr
        var newArrList = Arrays.asList(1,2,3);//another method to create a list backing an array, here the aarray is passed with the Arrays.asList() method
        //newArrList.add(4);  //this should produce an error
    }
}