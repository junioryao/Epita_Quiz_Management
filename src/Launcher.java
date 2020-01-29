

import java.util.Scanner;

import dataServiceManagement.TransactionDAO;
import quizManagement.DeleteGame;
import quizManagement.Game_manager;
import quizManagement.InsertingQuestion;
import quizManagement.Updategame;

public class Launcher {

	@SuppressWarnings("resource")
	public static void main(String[] args) throws Exception {
		
		//Initialize database and inbuilt question 
		TransactionDAO transaction = new TransactionDAO();
		Scanner in = new Scanner(System.in);
		
		//creating object of different task 
		DeleteGame DG = new DeleteGame() ;
		Updategame up = new Updategame();
		InsertingQuestion qm = new InsertingQuestion();
		Game_manager GM = new Game_manager();
		transaction.createDatabase();
		
		//Launching the game 
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("********************");
		System.out.println("Welcome to quiz game,the game is initialized on 2 games "
				+ "categories you can add or remove some questions from the game");
		int ans ;
		do {
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("-----------------------------------------------------------------------");
		System.out.println("1- Create a new question ");
		System.out.println("2- Delete a  question ");
		System.out.println("3- Update a right answer ");
		System.out.println("4- Play the game !!!");
		System.out.println("PRESS 0 TO QUITE THE GAME !!!");
		ans = in.nextInt();
		
		switch (ans) {
		case 1 : qm.collectData(transaction);
				 break;
		case 2 : DG.deleteProcess(transaction);
				 break;
		case 3 : up.updateProcess(transaction);
				 break;
		case 4 : GM.GameProcess(transaction);
				 break;		
		default: //ans=0;
				 break;
		}
		
		}while(ans!=0)	;
		System.out.println("THANK YOU FOR PLAYING ..........................................................");
		
	}}
