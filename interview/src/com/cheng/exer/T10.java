package com.cheng.exer;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 牛客网 锤子剪刀布
 * @author nuonuo
 * @create 2021-02-04 12:37
 */
public class T10 {
    private static void win(Record[] records, int win, String gesture) {
        int lose = 1 - win;
        records[win].win++;
        records[lose].lose++;
        int winCount = records[win].winCount.get(gesture);
        records[win].winCount.put(gesture, winCount + 1);
    }

    private static void judge(String a, String b, Record[] records) {
        if (a.equals("B")) {
            if (b.equals("B")) {
                records[0].tie++;
                records[1].tie++;
            } else if (b.equals("C")) {
                win(records, 0, "B");
            } else {
                win(records, 1, "J");
            }
        } else if (a.equals("C")) {
            if (b.equals("B")) {
                win(records, 1, "B");
            } else if (b.equals("C")) {
                records[0].tie++;
                records[1].tie++;
            } else {
                win(records, 0, "C");
            }
        } else {
            if (b.equals("B")) {
                win(records, 0, "J");
            } else if (b.equals("C")) {
                win(records, 1, "C");
            } else {
                records[0].tie++;
                records[1].tie++;
            }
        }
    }

    private static String mostWinGesture(TreeMap<String, Integer> winCount) {
        if (winCount.get("C") >= winCount.get("J")) {
            if (winCount.get("B") >= winCount.get("C")) {
                return "B";
            } else {
                return "C";
            }
        } else {
            if (winCount.get("B") >= winCount.get("J")) {
                return "B";
            } else {
                return "J";
            }
        }
    }

    public static void main(String[] args) {
        Record[] records = new Record[2];
        records[0] = new Record();
        records[1] = new Record();
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        for (int i = 0; i < n; i++) {
            String a = scanner.next();
            String b = scanner.next();
            judge(a, b, records);
        } System.out.format("%d %d %d\n", records[0].win, records[0].tie, records[0].lose);
        System.out.format("%d %d %d\n", records[1].win, records[1].tie, records[1].lose);
        System.out.format(
                mostWinGesture(records[0].winCount) + " " + mostWinGesture(records[1].winCount));
    }

    private static class Record {
        public int win;
        public int tie;
        public int lose;
        TreeMap<String, Integer> winCount;

        Record() {
            this.win = 0;
            this.tie = 0;
            this.lose = 0;
            this.winCount = new TreeMap<>();
            this.winCount.put("B", 0);
            this.winCount.put("C", 0);
            this.winCount.put("J", 0);
        }
    }
}
