package com.atguigu.exer1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-09-16 19:41
 */
public class Game {
    public static void main(String[] args) {
        List<Card> cards = new ArrayList<>();// 一副扑克牌（除大小王）
        List<Player> players = new ArrayList<>();
        initCards(cards); //初始化牌
        initPlayer(players); //初始化玩家
        Collections.shuffle(cards);//洗牌

        System.out.println("发牌前: " + cards);
        //发牌
        licensing(cards, players);

        System.out.println("发牌后: " + cards);

        System.out.println(players);




    }

    private static void licensing(List<Card> cards, List<Player> players) {
        int n = 2;
        for (int i = 0; i < n; i++) { //发n张牌
            for(Player player : players) { // 每人依次抽
                player.handCards.add(cards.remove(0)); // 从前面开始抽牌
            }
        }
    }


    private static void initPlayer(List<Player> players) {
        players.add(new Player("周润发"));
        players.add(new Player("小汪"));
        players.add(new Player("小明"));
        players.add(new Player("小李"));
    }

    // 初始化牌
    private static void initCards(List<Card> cards) {
        for (String suit : new String[] {"♠", "♣", "♥", "♦"}) {
            for (int i = 1; i <= 5; i++) {
                cards.add(new Card(suit, i));
            }
        }
    }
    // 洗牌

}
