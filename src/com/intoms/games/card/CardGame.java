/**
 * 
 */
package com.intoms.games.card;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * CopyRight by 2016 Mfish All Right Reserved
 * 
 * @author hy Create on 2016年11月22日下午4:25:34
 */
public class CardGame {
	private final int PLAY_NUM = 4;
	private final String[] types = { "方块", "黑桃", "红桃", "梅花" };
	private final String[] values = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A" };

	// cards是游戏中剩余的扑克牌
	private List<String> cards = new LinkedList<String>();
	// 玩家的数量,最多四个
	private String[] players = new String[PLAY_NUM];
	// 定义所有玩家手上的扑克牌
	@SuppressWarnings("unchecked")
	private List<String>[] playesCards = new List[PLAY_NUM];

	/**
	 * 初始化扑克牌
	 */
	public void initCards() {
		for (int i = 0; i < types.length; i++) {
			for (int j = 0; j < values.length; j++) {
				cards.add(types[i] + values[j]);
			}
		}
		Collections.shuffle(cards); // 随机洗牌
	}

	/**
	 * 初始化玩家
	 */
	public void initPlays(String... names) { // 这里是一种独特的写法
		if (names.length > PLAY_NUM || names.length < 2) {
			System.out.println("玩家数量不对");
			return;
		} else {
			for (int i = 0; i < names.length; i++) {
				players[i] = names[i];
			}
		}
	}

	/**
	 * 初始化玩家手上的扑克牌,开始玩家手上的欧克牌为空 程序使用的一个长度为0，的linkedList来表示
	 */
	public void initPlaysCards() {
		for (int i = 0; i < players.length; i++) {
			if (players[i] != null && !players[i].equals("")) {
				playesCards[i] = new LinkedList<String>();
			}
		}
	}

	/**
	 * 输出全部的扑克牌
	 */
	public void showAllCards() {
		for (String card : cards) {
			System.out.print(card + " ");
		}
	}

	/**
	 * 分配扑克派给每名玩家
	 */
	public void diliverCardToPlay(String name) {
		// 查询指定元素在数组中的索引
		int firstPos = findNamesIndex(name, players);
		// 给玩家后面的人发牌
		for (int i = firstPos; i < PLAY_NUM; i++) {
			if(players[i]!=null){
				playesCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
		// 给玩家前面的人发牌
		for (int i = 0; i < firstPos; i++) {
			if(players[i]!=null){
				playesCards[i].add(cards.get(0));
				cards.remove(0);
			}
		}
	}

	/**
	 * 不考虑重名的现象
	 * 
	 * @param name
	 * @param obj
	 * @return
	 */
	public int findNamesIndex(String name, Object[] obj) {
		for (int i = 0; i < obj.length; i++) {
			if (obj[i].equals(name)) {
				return i;
			} else {
				continue;
			}
		}
		return 0;
	}
	
	/***
	 * 輸出玩家手裏的撲克牌
	 */
	public void showPlaysCards(){
		for(int i=0;i<PLAY_NUM ;i++){
			if(players[i] != null){
				//輸出玩家
				System.out.print(players[i]+":");
				//遍历玩家手里的牌
				for(String card:playesCards[i]){
					System.out.println(card + "\t");
				}
				System.out.print("\t");
			}
		}
	}
	
	public static void main(String[] args) {
		CardGame cGame  = new CardGame() ;
		for(;;){
			try {
				cGame.initPlays("电脑玩家","胡羽");
				cGame.initCards();
				cGame.initPlaysCards();
				System.out.println("-----------------------------");
				cGame.diliverCardToPlay("胡羽");
				cGame.showPlaysCards();
				System.out.println("-----------------------------");
				cGame.diliverCardToPlay("电脑玩家");
				cGame.showPlaysCards();
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
