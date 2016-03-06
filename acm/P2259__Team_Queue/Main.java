package P2259__Team_Queue;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.LinkedList;
import java.io.FileReader;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2006</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader stdin = new BufferedReader(new InputStreamReader(System.
                in));
        int test = 1;
        while (true) {
            String line = stdin.readLine();
            StringTokenizer st = new StringTokenizer(line);
            int t = Integer.parseInt(st.nextToken());
            if (t == 0) {
                break;
            }
            int teamNumbers[] = new int[1000000];
            for (int i = 0; i < t; i++) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                int number = Integer.parseInt(st.nextToken());
                for (int j = 0; j < number; j++) {
                    int element = Integer.parseInt(st.nextToken());
                    teamNumbers[element] = i;
                }
            }
            System.out.println("Scenario #" + test);
            test++;
            int positions[] = new int[1000];
            for (int i = 0; i < positions.length; i++) {
                positions[i] = -1;
            }
            ArrayList<Team> queue = new ArrayList<Team>();
            while (true) {
                line = stdin.readLine();
                st = new StringTokenizer(line);
                String command = st.nextToken();
                if (command.equals("ENQUEUE") == true) {
                    int x = Integer.parseInt(st.nextToken());
                    if (positions[teamNumbers[x]] < 0) {
                        Team team = new Team(teamNumbers[x]);
                        team.link.add(x);
                        queue.add(team);
                        positions[teamNumbers[x]] = queue.size() - 1;
                    } else {
                        queue.get(positions[teamNumbers[x]]).link.add(x);
                    }
                } else if (command.equals("DEQUEUE") == true) {
                    Team first = queue.get(0);
                    int head = first.link.removeFirst();
                    System.out.println(head);
                    if (first.link.isEmpty() == true) {
                        for (int i = 0; i < queue.size(); i++) {
                            positions[queue.get(i).id]--;
                        }
                        queue.remove(0);
                    }
                } else {
                    break;
                }
            }
            System.out.println();
        }
    }
}


class Team {
    int id;
    LinkedList<Integer> link;
    public Team(int ID) {
        this.id = ID;
        this.link = new LinkedList<Integer>();
    }
}
