package com.atguigu.exer1;

/**
 * 牌类
 *
 * @author nuonuo
 * @create 2020-09-16 19:39
 */
public class Card {
    public String suit; //花色
    public int rank; //牌值

    public Card() {

    }
    public Card(String suit, int rank) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        return "Card{" +
                "suit='" + suit + '\'' +
                ", rank=" + rank +
                '}';
    }
}
