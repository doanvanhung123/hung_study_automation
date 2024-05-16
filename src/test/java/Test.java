import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
//        int[] cards = {3, 3, 4, 4, 5, 5, 6, 6, 7, 7, 8, 8, 9};
        int[] cards = {1,1,1, 2,2,2, 3, 4, 5, 5, 6, 6,  7, 10, 8, 9};
        if (hasThreeConsecutivePairs(cards)) {
            System.out.println("Bộ bài có 3 đôi thông.");
        } else {
            System.out.println("Bộ bài không có 3 đôi thông.");
        }
    }

    public static boolean hasThreeConsecutivePairs(int[] cards) {
        // Sắp xếp lá bài theo giá trị
        Arrays.sort(cards);
        List<Integer> list = new ArrayList<>();
        // Kiểm tra xem có 3 đôi thông hay không
        for(int i =1;i<cards.length;i++){
            if(cards[i]==cards[i-1] && cards[i] != cards[i+1]){
                list.add(cards[i]);
            }
        }
        if(list.size()<3){
            return false;
        } else {
            for (int i = 1; i < list.size() - 1; i++) {
                if (list.get(i) == list.get(i - 1) + 1 && list.get(i) == list.get(i + 1) - 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
