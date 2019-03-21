import java.util.Scanner;

public class Treesort {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Dict tree = new DictBinTree();

        while(input.hasNextInt()){
            tree.insert(input.nextInt());
        }

        int[] arr = tree.orderedTraversal();

        for(int i = 0; i < arr.length; i++){
            System.out.println(arr[i]);
        }
    }
}
