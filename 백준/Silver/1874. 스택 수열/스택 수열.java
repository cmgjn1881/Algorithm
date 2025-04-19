
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];
        boolean isPossible = true;
        ArrayList<Character> result = new ArrayList<>();
        Deque<Integer> stack = new ArrayDeque<>();


        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i] = Integer.parseInt(st.nextToken());
        }


        for (int i = 1; i <= arr[0]; i++) {
            stack.push(i);
            result.add('+');
            //System.out.println("+" + i);
        }
        int stackNum = arr[0] + 1;

        for (int num : arr) {

            if (stack.isEmpty()) {
                for (int i = stackNum; i <= num; i++) {
                    stack.push(i);
                    result.add('+');
                }
                stack.pop();
                result.add('-');
                stackNum = num + 1;
                //System.out.println("+" + num);
            }
            else {
                if (stack.peek() == num) {
                    stack.pop();
                    result.add('-');
                    //System.out.println("-" + num);
                }
                else if (stack.peek() < num) {
                    for (int i = stackNum; i <= num; i++) {
                        stack.push(i);
                        result.add('+');
                        //System.out.println("+" + i);
                    }
                    stack.pop();
                    result.add('-');
                    //System.out.println("-" + num);
                    stackNum = num + 1;
                }
                else {
                    isPossible = false;
                    break;
                }
            }
        }

        if (isPossible) {
            for (int i = 0; i < result.size(); i++) {
                System.out.println(result.get(i));
            }
        } else {
            System.out.println("NO");
        }


    }
}
