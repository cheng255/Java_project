package com.atguigu.exer1;

import java.util.ArrayList;
import java.util.List;

/**
 * @author nuonuo
 * @create 2020-09-16 19:48
 */
public class Player {
    public String name;
    public List<Card> handCards;

    public Player(String name) {
        this.name = name;
        handCards = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", handCards=" + handCards +
                '}';
    }
}
