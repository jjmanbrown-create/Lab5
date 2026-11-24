package classpractice;
/*
* File: Task3.java
* Author: Jalen Brown
* Course: CISC230
* Lab: Lab5
* Date: 11/4/2026
* 
* Description:
*Program is an interactive number guessing game where users select
*a difficulty level and attempt to guess a randomly generated number.
*Uses different number ranges and attempt limits depending on the
*selected difficulty. Provides feedback when guesses are too high
*or too low and awards points based on the number of attempts used.
*Tracks games played, games won, games lost, and total score.
*Allows users to play multiple rounds and displays a final report.
*/
import java.util.Scanner;
import java.util.Random;

public class Task3 {

	public static void main(String[] args) {
		
		// Creating Scanner and Random objects
		Scanner scan = new Scanner(System.in);
		Random rand = new Random();
		
		// Initializing variables used throughout the game
		int difficulty;
		String playAgain;
		int maxNumber = 0;
		int minNumber = 1;
		int maxAttempts = 0;
		int score = 0;
		int gamesPlayed = 0;
		int gamesWon = 0;
		int gamesLost = 0;
		int totalScore = 0;
		int guess = 0;
		int attemptsUsed = 0;
		
		// Creating a do-while loop to allow users to play multiple rounds
		do {
			// Displaying game title and difficulty selection menu
			System.out.println("=========== TOMMIE CODE BREAKER ===========");
			System.out.println("Welcome to the Campus Number Challenge!");
			System.out.println("\nSelect a difficulty level:");
			System.out.println("1. Beginner \n2. Intermediate \n3. Expert");
			System.out.println("Enter your choice: ");
			difficulty = scan.nextInt();
			
			 // Resetting round-specific variables before starting a new game
			attemptsUsed = 0;
			score = 0;
			guess = 0;
			
			// Checking whether the selected difficulty is valid
		while(difficulty != 1 && difficulty !=2
				&& difficulty !=3) {
			System.out.println("Choice is invalid.");
			System.out.println("Select a difficulty level:");
			System.out.println("1. Beginner \n2. Intermediate \n3. Expert");
			System.out.println("Enter your choice: ");
			difficulty = scan.nextInt();
			}
			
		// Setting number range and maximum attempts based on difficulty	
		if(difficulty == 1){
				
				maxNumber = 20;
				minNumber = 1;
				maxAttempts = 6;
				
				System.out.println("Selected difficulty: " + difficulty);
				System.out.println("Number Range: " + minNumber + "-" + maxNumber);
				System.out.println("Maximum Attempts: " + maxAttempts);
											
				} else if(difficulty == 2) {
					
					maxNumber = 50;
					minNumber = 1;
					maxAttempts = 7;
										
					System.out.println("Selected difficulty: " + difficulty);
					System.out.println("Number Range: " + minNumber + "-" + maxNumber);
					System.out.println("Maximum Attempts: " + maxAttempts);
					
				} else if(difficulty == 3) {
					
					maxNumber = 100;
					minNumber = 1;
					maxAttempts = 8;
					
					System.out.println("Selected difficulty: " + difficulty);
					System.out.println("Number Range: " + minNumber + "-" + maxNumber);
					System.out.println("Maximum Attempts: " + maxAttempts);
			}
			
		 // Generating a random secret number within the selected range	
		final int secretNum = rand.nextInt(maxNumber) + minNumber;
			
		 // Allowing the user to guess until they find the number or run out of attempts	
		while(guess != secretNum && attemptsUsed < maxAttempts) {
				System.out.println("\nEnter your number: ");
				guess = scan.nextInt();
				
				 // Checking whether the entered guess is within the allowed number range
				if(guess < minNumber || guess > maxNumber ){
					System.out.println("Number entered is invalid.");
				}
				
				else{
					//Increasing the attempt count for valid guesses
					attemptsUsed++;
					// Checking whether the user guessed correctly
					if(guess == secretNum) {
					System.out.println("\nCorrect!");
					// Calculating score based on the number of attempts used
					score = (maxAttempts - attemptsUsed + 1) * 10;
				} else if(guess > secretNum) {
					System.out.println("Too high! Try a lower number.");
					System.out.println("Attempts remaining: " + (maxAttempts - attemptsUsed));
				} else {
					System.out.println("Too low!. Try a higher number.");
					System.out.println("Attempts remaining: " + (maxAttempts - attemptsUsed));
				}
			}
		}
			// Checking whether the user ran out of attempts without guessing correctly
			if(attemptsUsed == maxAttempts && guess != secretNum) {
				System.out.println("\nYou have run out of attempts.");
			}
			
			 // Displaying the secret number and results for the current round
			System.out.println("Number was: " + secretNum);
			System.out.println("Attempts Used: " + attemptsUsed);
			System.out.println("Round Score: " + score);
			
			// Updating the total number of games played
			gamesPlayed++;
			// Updating the number of games won or lost
			if(guess == secretNum) {
				gamesWon++;
			} else {
				gamesLost = gamesPlayed - gamesWon;
			}
			// Adding the current round score to the overall score
			totalScore += score;
			
			// Displaying whether the user won or lost the current round
			if(guess == secretNum) {
				System.out.println("You won!");
			} else {
				System.out.println("You lost!");
			}
			
			// Displaying the overall game statistics
			System.out.println("=============== FINAL REPORT ===============");
			System.out.println("Games Played: " + gamesPlayed);
			System.out.println("Games Won: " + gamesWon);
			System.out.println("Games Lost: " + gamesLost);
			System.out.println("Total Score: " + totalScore);
			
			// Asking the user whether they would like to play another round
			System.out.println("\nWould you like to play again? (Y/N):");
			playAgain = scan.next();
					
	} 	while(playAgain.equals("Y"));
		
	}
}