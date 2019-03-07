package SideProjects;
import java.util.Scanner;
// simulates the card game Blackjack
public class Blackjack {

	public static void main(String[] args) {
		int userWins = 0;
		int dealerWins = 0;
		Scanner scn = new Scanner(System.in);
		int hand=0;
		//stores the value of the users hand
		boolean drawCard = true;
		//stores if the user wants to draw another card
		boolean wantToPlay = true;
		System.out.println("Welcome to Blackjack! Press enter to start the game");
		scn.nextLine();
		while(wantToPlay){
			int a = (int) ( (Math.random()*13)+2 );
			int b= (int) ( (Math.random()*13)+2 );
			hand = a+b;
			if (hand>21){
				hand-= (int) ( (Math.random()*10)+1 );
			}
			displayHand(hand);
			System.out.println("Would you like to draw a card? Type true or false ");
			drawCard=scn.nextBoolean();
			while(drawCard){
				hand+= (int)( (Math.random()*13)+2 );
				if(hand>21){
					System.out.println("You went over 21. You lose");
					dealerWins++;
				}
				displayHand(hand);
				System.out.println("Would you like to draw another card?"
						+ " Type true or false"); 
				drawCard = scn.nextBoolean();
			}
			if (hand==21){
				System.out.println("You got blackjack. You win!");
				userWins++;
			}else if(hand>21){	
		}
			int dealer = dealerTurn();
			if (dealer>21){
				displayDealerHand(dealer);
				System.out.println("You won against the dealer");
			}
			if(dealer>hand && dealer<21){
				displayDealerHand(dealer);
				System.out.println("You lost against the dealer");
				dealerWins++;
			}else if (dealer<hand){
				displayDealerHand(dealer);
				System.out.println("You won against the dealer");
				userWins++;
			}else if(dealer==hand){
				displayDealerHand(dealer);
				System.out.println("This round ended in a tie");
			}
			System.out.println("Would you like to play again? Type true or false");
			wantToPlay = scn.nextBoolean();
		}
		System.out.println("Current Simulation win totals: ");
		System.out.println("User Wins: "+userWins);
		System.out.println("Dealer Wins: "+dealerWins);
		
	}
	public static void displayHand(int x){
		System.out.println("Your current hand total is: "+x);
	}
	public static void displayDealerHand(int x){
		System.out.println("The dealer's hand total is: "+x);
	}
	public static int dealerTurn(){
		int card1 = (int)( (Math.random()*13) +2);
		int card2 = (int)( (Math.random()*13) +2);
		int dealer = card1+card2;
		
		if(dealer<17){
			while(dealer<=17){
				dealer+= (int)( (Math.random()*13) +2);
			}
		}
		return dealer;
	}
}

