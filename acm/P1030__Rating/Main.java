package P1030__Rating;

import java.util.Scanner;
import java.io.File;
import java.util.TreeMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Collections;

/**
 * <p>Title: </p>
 *
 * <p>Description: </p>
 *
 * <p>Copyright: Copyright (c) 2005</p>
 *
 * <p>Company: </p>
 *
 * @author not attributable
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) throws Exception {
        Scanner cin = new Scanner(System.in);
        TreeMap<Integer, Team> teams = new TreeMap<Integer, Team> ();
        ArrayList<ArrayList<Integer>> lists[] = new ArrayList[2];
        for (int i = 0; i < 2; i++) {
            lists[i] = new ArrayList<ArrayList<Integer>> ();
            int N = cin.nextInt();
            cin.nextLine();
            int place = 1;
            for (int j = 1; j <= N; j++) {
                int count = 0;
                ArrayList<Integer> s = new ArrayList<Integer> ();
                String line = cin.nextLine();
                Scanner cin1 = new Scanner(line);
                while (cin1.hasNextInt() == true) {
                    int identifier = cin1.nextInt();
                    s.add(identifier);
                    if (teams.containsKey(identifier) == false) {
                        teams.put(identifier, new Team(i, place));
                    }
                    else {
                        Team temp = teams.get(identifier);
                        temp.both = true;
                        temp.places[i] = place;
                    }
                    count++;
                }
                lists[i].add(s);
                place += count;
            }
        }
        ArrayList<ArrayList<Integer>> overall = new ArrayList<ArrayList<Integer>> ();
        ArrayList<Integer> min[] = new ArrayList[2];
        ArrayList<Integer> max[] = new ArrayList[2];
        ArrayList<Boolean> existBoth = new ArrayList<Boolean> ();
        for (int i = 0; i < 2; i++) {
            min[i] = new ArrayList<Integer> ();
            max[i] = new ArrayList<Integer> ();
        }
        Iterator<Entry<Integer, Team>> iterator = teams.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<Integer, Team> one = iterator.next();
            Team oneTeam = one.getValue();
            if (oneTeam.both == true) {
                boolean power = false;
                for (int i = 0; i < overall.size(); i++) {
                    Team temp = teams.get(overall.get(i).get(0));
                    int sum1 = oneTeam.places[0] + oneTeam.places[1];
                    int sum2 = temp.places[0] + temp.places[1];
                    if (sum1 == sum2) {
                        overall.get(i).add(one.getKey());
                        for (int j = 0; j < 2; j++) {
                            int tempPlace = oneTeam.places[j];
                            if (tempPlace < min[j].get(i)) {
                                min[j].set(i, tempPlace);
                            }
                            if (tempPlace > max[j].get(i)) {
                                max[j].set(i, tempPlace);
                            }
                        }
                        power = true;
                        break;
                    }
                    else if (sum1 < sum2) {
                        ArrayList<Integer> s = new ArrayList<Integer> ();
                        s.add(one.getKey());
                        overall.add(i, s);
                        for (int j = 0; j < 2; j++) {
                            int tempPlace = oneTeam.places[j];
                            min[j].add(i, tempPlace);
                            max[j].add(i, tempPlace);
                        }
                        existBoth.add(i, true);
                        power = true;
                        break;
                    }
                }
                if (power == false) {
                    ArrayList<Integer> s = new ArrayList<Integer> ();
                    s.add(one.getKey());
                    overall.add(s);
                    for (int j = 0; j < 2; j++) {
                        int tempPlace = oneTeam.places[j];
                        min[j].add(tempPlace);
                        max[j].add(tempPlace);
                    }
                    existBoth.add(true);
                }
            }
        }
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < lists[i].size(); j++) {
                boolean power = false;
                int teamId = -1;
                int sum = 0;
                for (int k = 0; k < lists[i].get(j).size(); k++) {
                    int temp = lists[i].get(j).get(k);
                    Team oneTeam = teams.get(temp);
                    if (oneTeam.both == true) {
                        if (teamId == -1) {
                            teamId = temp;
                            sum = oneTeam.places[0] + oneTeam.places[1];
                            power = true;
                        }
                        else if (oneTeam.places[0] + oneTeam.places[1] != sum) {
                            power = false;
                            break;
                        }
                    }
                }
                if (power == true) {
                    ArrayList<Integer> line = null;
                    for (int k = 0; k < overall.size(); k++) {
                        ArrayList<Integer> temp = overall.get(k);
                        if (temp.contains(teamId) == true) {
                            line = temp;
                            break;
                        }
                    }
                    for (int k = 0; k < lists[i].get(j).size(); k++) {
                        int temp = lists[i].get(j).get(k);
                        Team oneTeam = teams.get(temp);
                        if (oneTeam.both == false) {
                            line.add(temp);
                            oneTeam.included = true;
                        }
                    }
                }
            }
        }
        iterator = teams.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<Integer, Team> one = iterator.next();
            Team oneTeam = one.getValue();
            if (oneTeam.both == false && oneTeam.included == false) {
                int tempPlace = oneTeam.places[oneTeam.contest];
                boolean power = true;
                int pos = -1;
                for (int i = 0; i < overall.size(); i++) {
                    if (existBoth.get(i) == true) {
                        if (pos == -1) {
                            if (tempPlace < min[oneTeam.contest].get(i)) {
                                pos = i;
                            }
                            else if (tempPlace >= min[oneTeam.contest].get(i) &&
                                     tempPlace <= max[oneTeam.contest].get(i)) {
                                power = false;
                                break;
                            }
                        }
                        else {
                            if (tempPlace >= min[oneTeam.contest].get(i)) {
                                power = false;
                                break;
                            }
                        }
                    }
                }
                if (power == true) {
                    if (pos == -1) {
                        pos = overall.size();
                    }
                    boolean inserted = false;
                    pos--;
                    while (pos >= 0) {
                        if (existBoth.get(pos) == true) {
                            break;
                        }
                        Team team = teams.get(overall.get(pos).get(0));
                        int place = team.places[team.contest];
                        if (tempPlace == place) {
                            overall.get(pos).add(one.getKey());
                            inserted = true;
                            break;
                        }
                        else if (tempPlace > place) {
                            break;
                        }
                        pos--;
                    }
                    if (inserted == false) {
                        pos++;
                        ArrayList<Integer> s = new ArrayList<Integer> ();
                        s.add(one.getKey());
                        overall.add(pos, s);
                        existBoth.add(pos, false);
                        for (int i = 0; i < 2; i++) {
                            min[i].add(pos, -1);
                            max[i].add(pos, -1);
                        }
                    }
                }
            }
        }
        for (int i = 0; i < overall.size(); i++) {
            ArrayList<Integer> temp = overall.get(i);
            Collections.sort(temp);
            for (int j = 0; j < temp.size(); j++) {
                if (j != 0) {
                    System.out.print(" ");
                }
                System.out.print(temp.get(j));
            }
            System.out.println();
        }
    }
}

class Team {
    boolean both;
    int contest;
    int places[];
    boolean included;
    public Team(int theContest, int thePlace) {
        this.both = false;
        this.contest = theContest;
        this.places = new int[2];
        this.places[theContest] = thePlace;
        this.included = false;
    }
}
