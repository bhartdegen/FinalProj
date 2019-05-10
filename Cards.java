/*
 * Program Creator: Brenden Hartdegen - solo project
 * 		The purpose of this program is to play a simple card game known as war. 
 * 		Two players have a deck of random cards, each player takes turns drawing cards.
 * 		Whoever has the higher card is awarded both of the cards and the game continues
 * 		until you run out of cards. If two players have draw the same card then a war 
 * 		occurs. During a war the same rules apply but this time the reward is twice the amount.
 * 
 *   	My program starts the game with a button and then runs through and displays the winner of 
 *  	every hand (52) on the screen. I named a model class Cards and Deck class to hold the cards
 *  	in an ArrayList where i would run through them outputting the greater card as the winner then 
 *  	displaying that in the window. I did not have a lot of time to construct the program as well as
 *  	i had hoped due to the personal issues that came up all this week but eventually i would have 
 *  	liked to add pictures of the cards and an animation where they flip when the button is pushed.
 *  
 *
 */

public class Cards {
	private String suit;
	private String rank;
	private int value;
	
	public Cards(String suit, String rank) {
		this.suit = suit;
		this.rank = rank;
		
		//Determing the value of card based on rank
		if(rank.equals("2")) {
			value = 2;
		} else if(rank.equals("3")) {
			value = 3;
		} else if(rank.equals("4")) {
			value = 4;
		} else if(rank.equals("5")) {
			value = 5;
		} else if(rank.equals("6")) {
			value = 6;
		} else if(rank.equals("7")) {
			value = 7;
		} else if(rank.equals("8")) {
			value = 8;
		} else if(rank.equals("9")) {
			value = 9;
		} else if(rank.equals("10")) {
			value = 10;
		} else if(rank.equals("JACK")) {
			value = 11;
		} else if(rank.equals("QUEEN")) {
			value = 12;
		} else if(rank.equals("KING")) {
			value = 13;
		} else if(rank.equals("ACE")) {
			value = 14;
		}
	}
	
	public String getSuit() {
		return suit;
	}
	public void setSuit(String suit) {
		this.suit = suit;
	}
	public String getRank() {
		return rank;
	}
	public void setRank(String rank) {
		this.rank = rank;
	}
	public int getValue() {
		return value;
	}
	public void setValue(int value) {
		this.value = value;
	}
	public String toString() {
		return rank + " " + suit;
	}

	public Cards copy(Cards card) {
		Cards temp = new Cards(card.getSuit(), card.getRank());
		return temp;
	}
	
	//To compare two cards
	public int isGreater(Cards card) {
		int temp;
		if (value > card.getValue()) {
			temp = 1;
		} else if (value < card.getValue()) {
			temp = 2;
		} else 
			temp = 3;
		return temp;
	}
}


