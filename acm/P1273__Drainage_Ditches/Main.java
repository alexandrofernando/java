package P1273__Drainage_Ditches;

import java.util.*;

/**
 * Created by IntelliJ IDEA.
 * User: goalboy
 * Date: 2007-7-9
 * Time: 1:26:11
 * To change this template use File | Settings | File Templates.
 */
public class Main {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt() == true) {
            int N = in.nextInt();
            int M = in.nextInt();
            TreeMap<Integer, Integer> intersections[] = new TreeMap[M + 1];
            for (int i = 1; i <= M; i++) {
                intersections[i] = new TreeMap<Integer, Integer>();
            }
            for (int i = 0; i < N; i++) {
                int start = in.nextInt();
                int end = in.nextInt();
                int capacity = in.nextInt();
                if (capacity == 0) {
                    continue;
                }
                Integer flow = intersections[start].get(end);
                if (flow != null) {
                    intersections[start].put(end, flow + capacity);
                } else {
                    intersections[start].put(end, capacity);
                }
            }
            int result = 0;
            while (true) {
                int previous[] = new int[M + 1];
                LinkedList<Integer> queue = new LinkedList<Integer>();
                queue.offer(1);
                previous[1] = -1;
                boolean find = false;
                while (queue.isEmpty() == false) {
                    int head = queue.poll();
                    if (head == M) {
                        int temp = head;
                        int min = Integer.MAX_VALUE;
                        while (temp != 1) {
                            int pre = previous[temp];
                            int flow = intersections[pre].get(temp);
                            if (flow < min) {
                                min = flow;
                            }
                            temp = pre;
                        }
                        temp = head;
                        while (temp != 1) {
                            int pre = previous[temp];
                            Integer flow = intersections[pre].get(temp);
                            if (flow == min) {
                                intersections[pre].remove(temp);
                            } else {
                                intersections[pre].put(temp, flow - min);
                            }
                            Integer antiFlow = intersections[temp].get(pre);
                            if (antiFlow != null) {
                                intersections[temp].put(pre, antiFlow + min);
                            } else {
                                intersections[temp].put(pre, min);
                            }
                            temp = pre;
                        }
                        result += min;
                        find = true;
                        break;
                    } else {
                        Iterator<Map.Entry<Integer, Integer>> iterator = intersections[head].entrySet().iterator();
                        while (iterator.hasNext() == true) {
                            Map.Entry<Integer, Integer> entry = iterator.next();
                            int end = entry.getKey();
                            if (previous[end] == 0) {
                                previous[end] = head;
                                queue.offer(end);
                            }
                        }
                    }
                }
                if (find == false) {
                    break;
                }
            }
            System.out.println(result);
        }
    }
}
