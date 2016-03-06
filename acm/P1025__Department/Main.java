package P1025__Department;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.TreeMap;
import java.util.PriorityQueue;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;

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
        PriorityQueue<Element>
            queue = new PriorityQueue<Element> (10, new MyComparator());
        TreeMap<String, Time> roomState = new TreeMap<String, Time> ();
        TreeMap<String, Agent> agents = new TreeMap<String, Agent> ();
        do {
            String code = cin.next();
            if (code.equals(".") == true) {
                break;
            }
            Agent s = new Agent();
            String enterTime = cin.next();
            int hour = Integer.parseInt(enterTime.substring(0, 2));
            int minute = Integer.parseInt(enterTime.substring(3, 5));
            int second = Integer.parseInt(enterTime.substring(6, 8));
            queue.add(new Element(new Time(hour, minute, second), code));
            do {
                String roomNumber = cin.next();
                if (roomNumber.equals("0") == true) {
                    break;
                }
                roomState.put(roomNumber, new Time(0, 0, 0));
                int seconds = cin.nextInt();
                s.roomList.add(new Room(roomNumber, seconds));
            }
            while (true);
            agents.put(code, s);
        }
        while (true); while (queue.isEmpty() == false) {
            Element front = queue.poll();
            String code = front.code;
            Time time = front.time;
            Agent agent = agents.get(code);
            if (agent.state == 1) {
                Time temp = new Time(time);
                temp.add(30);
                Activity act = new Activity(new Time(time), new Time(temp),
                                            "Entry");
                agent.activities.add(act);
                int targetFloor = agent.roomList.get(0).floor;
                agent.past = new Time(temp);
                if (targetFloor == 1) {
                    agent.state = 3;
                }
                else {
                    agent.state = 2;
                    int offset = (int) Math.ceil(temp.second / 5.0) * 5 -
                        temp.second;
                    temp.add(offset);
                }
                queue.add(new Element(temp, code));
            }
            else if (agent.state == 2) {
                if (time.compareTo(agent.past) != 0) {
                    Activity act = new Activity(new Time(agent.past),
                                                new Time(time),
                                                "Waiting in elevator queue");
                    agent.activities.add(act);
                }
                Time temp = new Time(time);
                int targetFloor;
                if (agent.roomList.isEmpty() == false) {
                    targetFloor = agent.roomList.get(0).floor;
                }
                else {
                    targetFloor = 1;
                }
                int diff = Math.abs(agent.floor - targetFloor);
                temp.add(diff * 30);
                Activity act = new Activity(new Time(time), new Time(temp),
                                            "Stay in elevator");
                agent.activities.add(act);
                agent.state = 4;
                queue.add(new Element(temp, code));
                Iterator<Element> iterator = queue.iterator();
                while (iterator.hasNext() == true) {
                    Element one = iterator.next();
                    if (one.time.compareTo(time) != 0) {
                        break;
                    }
                    Agent ag = agents.get(one.code);
                    if (ag.state == 2 && ag.floor == agent.floor) {
                        one.time.add(5);
                    }
                }
            }
            else if (agent.state == 3) {
                Room room = agent.roomList.get(0);
                Time limit = roomState.get(room.roomNumber);
                if (time.compareTo(limit) >= 0) {
                    agent.roomList.remove(0);
                    if (time.compareTo(agent.past) != 0) {
                        Activity act = new Activity(new Time(agent.past),
                            new Time(time),
                            "Waiting in front of room " +
                            room.roomNumber);
                        agent.activities.add(act);
                    }
                    Time temp = new Time(time);
                    temp.add(room.seconds);
                    Activity act = new Activity(new Time(time), new Time(temp),
                                                "Stay in room " +
                                                room.roomNumber);
                    agent.activities.add(act);
                    agent.roomNumber = room.roomNumber;
                    agent.floor = room.floor;
                    agent.state = 5;
                    queue.add(new Element(temp, code));
                    roomState.put(room.roomNumber, new Time(temp));
                }
                else {
                    queue.add(new Element(new Time(limit), code));
                }
            }
            else if (agent.state == 4) {
                if (agent.roomList.isEmpty() == false) {
                    Room room = agent.roomList.get(0);
                    Time temp = new Time(time);
                    temp.add(10);
                    Activity act = new Activity(new Time(time), new Time(temp),
                                                "Transfer from elevator to room " +
                                                room.roomNumber);
                    agent.activities.add(act);
                    agent.past = new Time(temp);
                    agent.state = 3;
                    queue.add(new Element(temp, code));
                }
                else {
                    Time temp = new Time(time);
                    temp.add(30);
                    Activity act = new Activity(new Time(time), new Time(temp),
                                                "Exit");
                    agent.activities.add(act);
                }
            }
            else if (agent.state == 5) {
                if (agent.roomList.isEmpty() == true && agent.floor == 1) {
                    Time temp = new Time(time);
                    temp.add(30);
                    Activity act = new Activity(new Time(time), new Time(temp),
                                                "Exit");
                    agent.activities.add(act);
                }
                else if (agent.roomList.isEmpty() == false &&
                         agent.roomList.get(0).floor == agent.floor) {
                    String targetRoomNumber = agent.roomList.get(0).roomNumber;
                    Time temp = new Time(time);
                    temp.add(10);
                    Activity act = new Activity(new Time(time), new Time(temp),
                                                "Transfer from room " +
                                                agent.roomNumber + " to room " +
                                                targetRoomNumber);
                    agent.activities.add(act);
                    agent.past = new Time(temp);
                    agent.state = 3;
                    queue.add(new Element(temp, code));
                }
                else {
                    Time temp = new Time(time);
                    temp.add(10);
                    Activity act = new Activity(new Time(time), new Time(temp),
                                                "Transfer from room " +
                                                agent.roomNumber +
                                                " to elevator");
                    agent.activities.add(act);
                    agent.past = new Time(temp);
                    agent.state = 2;
                    int offset = (int) Math.ceil(temp.second / 5.0) * 5 -
                        temp.second;
                    temp.add(offset);
                    queue.add(new Element(temp, code));
                }
            }
        }
        Iterator<Entry<String, Agent>> iterator = agents.entrySet().iterator();
        while (iterator.hasNext() == true) {
            Entry<String, Agent> one = iterator.next();
            System.out.println(one.getKey());
            ArrayList<Activity> activities = one.getValue().activities;
            for (int i = 0; i < activities.size(); i++) {
                Activity act = activities.get(i);
                System.out.println(act.start + " " + act.end + " " +
                                   act.description);
            }
            System.out.println();
        }
    }
}

class Agent {
    ArrayList<Room> roomList;
    ArrayList<Activity> activities;
    int state; //0-normal,1-entry,2-wait for elevator,3-wait for room,
    //4-walk out of elevator,5-walk out of room,6-exit

    int floor;
    Time past;
    String roomNumber;
    public Agent() {
        this.roomList = new ArrayList<Room> ();
        this.activities = new ArrayList<Activity> ();
        this.state = 1;
        this.floor = 1;
    }
}

class Room {
    String roomNumber;
    int seconds;
    int floor;
    int number;
    public Room(String theRoomNumber, int theSeconds) {
        this.roomNumber = theRoomNumber;
        this.seconds = theSeconds;
        this.floor = Integer.parseInt(theRoomNumber.substring(0, 2));
        this.number = Integer.parseInt(theRoomNumber.substring(2, 4));
    }
}

class Activity {
    Time start;
    Time end;
    String description;
    public Activity(Time theStart, Time theEnd, String theDescription) {
        this.start = theStart;
        this.end = theEnd;
        this.description = theDescription;
    }
}

class Time
    implements Comparable<Time> {
    int hour;
    int minute;
    int second;
    public Time(int theHour, int theMinute, int theSecond) {
        this.hour = theHour;
        this.minute = theMinute;
        this.second = theSecond;
    }

    public Time(Time a) {
        this.hour = a.hour;
        this.minute = a.minute;
        this.second = a.second;
    }

    public void add(int seconds) {
        this.second += seconds;
        int minutes = this.second / 60;
        this.second %= 60;
        this.minute += minutes;
        int hours = this.minute / 60;
        this.minute %= 60;
        this.hour += hours;
    }

    public int compareTo(Time another) {
        if (this.hour != another.hour) {
            return this.hour - another.hour;
        }
        else if (this.minute != another.minute) {
            return this.minute - another.minute;
        }
        else {
            return this.second - another.second;
        }
    }

    public String toString() {
        String h = this.hour + "";
        if (this.hour < 10) {
            h = "0" + h;
        }
        String m = this.minute + "";
        if (this.minute < 10) {
            m = "0" + m;
        }
        String s = this.second + "";
        if (this.second < 10) {
            s = "0" + s;
        }
        return h + ":" + m + ":" + s;
    }
}

class Element {
    Time time;
    String code;
    public Element(Time theTime, String theCode) {
        this.time = theTime;
        this.code = theCode;
    }
}

class MyComparator
    implements Comparator<Element> {
    public int compare(Element a, Element b) {
        int temp = a.time.compareTo(b.time);
        if (temp != 0) {
            return temp;
        }
        else {
            return a.code.compareTo(b.code);
        }
    }
}
