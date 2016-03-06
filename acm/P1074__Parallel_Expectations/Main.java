package P1074__Parallel_Expectations;

import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

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
    static String tempVar[];
    static int number;
    static ArrayList<Command> program[] = new ArrayList[2];
    public static void main(String args[]) throws Exception {
        Scanner cin = new Scanner(System.in);
        int test = cin.nextInt();
        for (int t = 1; t <= test; t++) {
            program[0] = new ArrayList<Command> ();
            program[1] = new ArrayList<Command> ();
            tempVar = new String[10];
            number = 0;
            cin.nextLine();
            String temp = cin.nextLine();
            while (temp.equals("END") == false) {
                Command command = new Command(temp);
                program[0].add(command);
                insert(command.resultName);
                insert(command.operandName[0]);
                insert(command.operandName[1]);
                temp = cin.nextLine();
            }
            temp = cin.nextLine();
            while (temp.equals("END") == false) {
                Command command = new Command(temp);
                program[1].add(command);
                insert(command.resultName);
                insert(command.operandName[0]);
                insert(command.operandName[1]);
                temp = cin.nextLine();
            }
            String variables[] = new String[number];
            System.arraycopy(tempVar, 0, variables, 0, number);
            Arrays.sort(variables);
            State state[][] = new State[program[0].size() * 4 +
                1][program[1].size() * 4 + 1];
            state[0][0] = new State(variables, new double[number], 1);
            for (int i = 0; i < state.length; i++) {
                for (int j = 0; j < state[0].length; j++) {
                    State temp1 = null, temp2 = null;
                    if (i > 0) {
                        temp1 = new State(state[i - 1][j]);
                        change(temp1, i, 0);
                        if (j < state[0].length - 1) {
                            temp1.probability /= 2;
                        }
                    }
                    if (j > 0) {
                        temp2 = new State(state[i][j - 1]);
                        change(temp2, j, 1);
                        if (i < state.length - 1) {
                            temp2.probability /= 2;
                        }
                    }
                    if (i > 0 && j > 0) {
                        state[i][j] = State.average(temp1, temp2);
                    }
                    else if (i > 0 && j == 0) {
                        state[i][j] = temp1;
                    }
                    else if (i == 0 && j > 0) {
                        state[i][j] = temp2;
                    }
                }
            }
            if (t != 1) {
                System.out.println();
            }
            double val[] = state[program[0].size() *
                4][program[1].size() * 4].varValue;
            for (int i = 0; i < val.length; i++) {
                System.out.printf("%.4f\n", val[i]);
            }
        }
    }

    public static void change(State st, int n, int index) {
        int comNum = (n - 1) / 4;
        int insNum = (n - 1) % 4;
        Command com = program[index].get(comNum);
        if (insNum == 0 || insNum == 1) {
            if (com.operandName[insNum].equals("") == true) {
                st.R[index * 2 + insNum + 1] = com.constant[insNum];
            }
            else {
                for (int i = 0; i < st.varName.length; i++) {
                    if (st.varName[i].equals(com.operandName[insNum]) == true) {
                        st.R[index * 2 + insNum + 1] = st.varValue[i];
                        break;
                    }
                }
            }
        }
        else if (insNum == 2) {
            if (com.operator == '+') {
                st.R[index * 2 + 1] += st.R[index * 2 + 2];
            }
            else {
                st.R[index * 2 + 1] -= st.R[index * 2 + 2];
            }
        }
        else if (insNum == 3) {
            for (int i = 0; i < st.varName.length; i++) {
                if (st.varName[i].equals(com.resultName) == true) {
                    st.varValue[i] = st.R[index * 2 + 1];
                    break;
                }
            }
        }
    }

    public static void insert(String theName) {
        if (theName.equals("") == false) {
            boolean exist = false;
            for (int i = 0; i < number; i++) {
                if (tempVar[i].equals(theName) == true) {
                    exist = true;
                    break;
                }
            }
            if (exist == false) {
                tempVar[number] = theName;
                number++;
            }
        }
    }
}

class Command {
    String resultName;
    String operandName[] = new String[2];
    double constant[] = new double[2];
    char operator;
    public Command(String str) {
        if (str.indexOf("+") != -1) {
            this.operator = '+';
        }
        else {
            this.operator = '-';
        }
        String part[] = str.split(":=|\\+|-");
        Scanner sc = new Scanner(part[0]);
        this.resultName = sc.next().toLowerCase();
        sc = new Scanner(part[1]);
        if (sc.hasNextDouble() == true) {
            this.constant[0] = sc.nextDouble();
            this.operandName[0] = "";
        }
        else {
            this.operandName[0] = sc.next().toLowerCase();
        }
        sc = new Scanner(part[2]);
        if (sc.hasNextDouble() == true) {
            this.constant[1] = sc.nextDouble();
            this.operandName[1] = "";
        }
        else {
            this.operandName[1] = sc.next().toLowerCase();
        }
    }
}

class State {
    String varName[];
    double varValue[];
    double R[] = new double[5];
    double probability;
    public State(String theVarName[], double theVarValue[],
                 double theProbability) {
        this.varName = new String[theVarName.length];
        this.varValue = new double[theVarValue.length];
        for (int i = 0; i < theVarName.length; i++) {
            this.varName[i] = theVarName[i];
            this.varValue[i] = theVarValue[i];
        }
        for (int i = 1; i <= 4; i++) {
            this.R[i] = 0;
        }
        this.probability = theProbability;
    }

    public State(State a) {
        this(a.varName, a.varValue, a.probability);
        for (int i = 1; i <= 4; i++) {
            this.R[i] = a.R[i];
        }
    }

    public static State average(State a, State b) {
        State c = new State(a.varName, a.varValue,
                            a.probability + b.probability);
        for (int i = 0; i < a.varName.length; i++) {
            c.varValue[i] = (a.varValue[i] * a.probability +
                             b.varValue[i] * b.probability) /
                (a.probability + b.probability);
        }
        for (int i = 1; i <= 4; i++) {
            c.R[i] = (a.R[i] * a.probability + b.R[i] * b.probability) /
                (a.probability + b.probability);
        }
        return c;
    }
}
