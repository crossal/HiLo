import java.util.Scanner;


public class HiLo {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("-----------HiLo Card Game-----------");
		
		int numberOfPlayers = getNumberOfPlayers(scan);
		int gamesPerMatch = getGamesPerMatch(scan);
		
		boolean playing = shouldPlayNewMatch(scan);
		
		while (playing) {
			int[] playerScores = new int[numberOfPlayers];
			Deck deck;
			for (int i = 0; i < gamesPerMatch; i++) {
				
				deck = new Deck();
				deck.shuffle();
				
				Card highestCard = new Card(Suit.DIAMONDS, 1);
				int highestCardPlayerIndex = 0;
				boolean firstPlayerDraw = true;
				boolean draw = false;
				for (int j = 0; j < numberOfPlayers; j++) {
					System.out.print("Player " + (j+1) + " draw card (hit enter)");
					scan.nextLine();
					Card nextCard = deck.draw();
					if (firstPlayerDraw) {
						highestCard = nextCard;
						highestCardPlayerIndex = j;
						firstPlayerDraw = false;
					} else {
						if (nextCard.isHigherThan(highestCard)) {
							highestCard = nextCard;
							highestCardPlayerIndex = j;
							draw = false;
						} else if (nextCard.isEqualTo(highestCard)) {
							draw = true;
						}
					}
					System.out.println(nextCard.toString());
				}
				if (!draw) {
					playerScores[highestCardPlayerIndex]++;
					System.out.println("Player " + (highestCardPlayerIndex+1) + " wins round.");
					System.out.println("");
				} else {
					System.out.println("Round drawn.");
					System.out.println("");
				}
			}
			
			int highestScore = playerScores[0];
			int highestScoreIndex = 0;
			boolean draw = false;
			for (int i = 1; i < playerScores.length; i++) {
				if (playerScores[i] > highestScore) {
					highestScore = playerScores[i];
					highestScoreIndex = i;
					draw = false;
				} else if (playerScores[i] == highestScore) {
					draw = true;
				}
			}
			
			if (!draw) {
				System.out.println("Player " + (highestScoreIndex+1) + " wins the game!");
				System.out.println("");
			} else {
				System.out.println("Game drawn!");
				System.out.println("");
			}
			
			playing = shouldPlayNewMatch(scan);
		}

		
		System.out.println("Game ending...");
	}
	
	public static boolean shouldPlayNewMatch(Scanner scan) {
		System.out.println("Start a match? (y/n)");
		String playingAnswer = scan.nextLine();
		while (!playingAnswer.equalsIgnoreCase("y") && !playingAnswer.equalsIgnoreCase("n")) {
			System.out.println("Please answer y or n..");
			playingAnswer = scan.nextLine();
		}
		return playingAnswer.equalsIgnoreCase("y") ? true : false;
	}
	
	public static int getNumberOfPlayers(Scanner scan) {
		System.out.println("Number of players?");
		String answer;
		int numberOfPlayers = 0;
		boolean foundInt = false;
		while (!foundInt) {
			try {
				answer = scan.nextLine();
				numberOfPlayers = Integer.parseInt(answer);
				if (numberOfPlayers < 2) {
					throw new Exception("Should be at least two players.");
				}
				foundInt = true;
			} catch (Exception e) {
				System.out.println("Try again (" + e + ")");
			}
		}
		return numberOfPlayers;
	}
	
	public static int getGamesPerMatch(Scanner scan) {
		System.out.println("Number of games per match?");
		String answer;
		int numberOfGames = 0;
		boolean foundInt = false;
		while (!foundInt) {
			try {
				answer = scan.nextLine();
				numberOfGames = Integer.parseInt(answer);
				if (numberOfGames < 1) {
					throw new Exception("Should be at least one game per match.");
				}
				foundInt = true;
			} catch (Exception e) {
				System.out.println("Try again (" + e + ")");
			}
		}
		return numberOfGames;
	}
}
