import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;


public class Main {
    public static void main(String[] args) {
        int[] list = new int[]{1, 2, 3, 4};
        ArrayList<Integer> list1 = (ArrayList<Integer>) Arrays.stream(list).boxed().collect(Collectors.toList());
        ArrayList<ArrayList<Integer>> bufferlist = new ArrayList<>();
        dfs(list1, new ArrayList<>(), bufferlist);
        for (int i = 0; i < bufferlist.size(); i++)
        {
            System.out.println(bufferlist.get(i));
        }
    }
    static void dfs(ArrayList<Integer> list, ArrayList<Integer> newlist, ArrayList<ArrayList<Integer>> bufferlist)
    {
        if(list.size()==1)
        {
            newlist.add(list.getFirst());
            ArrayList<Integer> addlist = new ArrayList<>(newlist);
            bufferlist.add(addlist);
            newlist.remove(list.getFirst());
        }
        else {
            for (int i = 0; i < list.size(); i++) {
                Integer object = list.get(i);
                newlist.add(object);
                list.remove(object);
                dfs(list, newlist, bufferlist);
                newlist.remove(object);
                list.add(i, object);
            }
        }
    }
}