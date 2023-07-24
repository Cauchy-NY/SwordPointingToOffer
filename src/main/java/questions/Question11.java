package questions;

public class Question11 {

    public int minArray(int[] numbers) {
        int left = 0, right = numbers.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (numbers[mid] > numbers[right]) {
                left = mid + 1;
            } else if (numbers[mid] < numbers[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return numbers[left];
    }

    public static void main(String[] args) {
        Question11 question11 = new Question11();
        System.out.println(question11.minArray(new int[]{1, 3, 5}));
        System.out.println(question11.minArray(new int[]{3, 4, 5, 1, 2}));
        System.out.println(question11.minArray(new int[]{4, 5, 1, 2, 3}));
        System.out.println(question11.minArray(new int[]{2, 2, 2, 0, 1}));
    }

}
