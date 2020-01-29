package quizManagement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;
import dataServiceManagement.TransactionDAO;
/*
 * Game manager class is created to perform the gaming action 
 * */
public class Game_manager {
	String s ;
	int ans_1 ;
	Scanner scan = new Scanner(System.in);
	ArrayList<Question> Game_question = new ArrayList<>();

	public void GameProcess(TransactionDAO transactionDAO) throws SQLException, Exception {
		
		System.out.println("Select in which category you would like to perform the game  ");
		System.out.println("1- for COMPUTER SCIENCE");
		System.out.println("2- for FOOTBALL");
		System.out.println("3- To do all" );
		ans_1 = scan.nextInt(); 
		if(ans_1 != 3) {
		transactionDAO.SelectGameType();}
		if(ans_1 == 2) {
		transactionDAO.SelectGameType2();
		}
		if (ans_1 == 1){
		transactionDAO.SelectGameType1();
		}
		this.Game_question = transactionDAO.getDataBaseData();		
		Gaming();
	}
	
	private void Gaming() {	
			s=scan.nextLine();// to skip previous space from scanner pointer
			
			//display every question
			for(Question q:Game_question) {
			System.out.println(q.getQuestion());
			System.out.println(q.getWr_answer_1());
			System.out.println(q.getRight_answer());
			System.out.println(q.getWr_answer_2());
			System.out.println("Write the Right answer completley---- :");
			
			//taking answer from user
			s=scan.nextLine();
			
			//checking answer
			if(s.equals(q.getRight_answer())) {
				System.out.println("Correct Answer");
			}
			else {System.out.println("Wrong Answer");}
			
		}	
			System.out.println("");
			System.out.println("Start Again");
	}

}
