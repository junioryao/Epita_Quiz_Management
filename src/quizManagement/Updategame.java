package quizManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dataServiceManagement.TransactionDAO;

/*
 * The Update class is made to perform 2 actions 
 * selecting the row where we have to perform the change and 
 * taking the new data for the replacement   
 *  
 * */
public class Updategame {
	int i ;
	String s ;
	ArrayList<Question> all_question = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void updateProcess(TransactionDAO transactionDAO) throws SQLException, Exception {
	System.out.println("Processing-------------------");
	
	//selecting all record from DB
	transactionDAO.SelectGameType();
	
	// saving records into arraylist
	this.all_question = transactionDAO.getDataBaseData();
	
	//Display all record 
	for(Question q:all_question) {
	System.out.println(q.getId()+"-----"+q.getQuestion());
		}
	//selecting row
	System.out.println("Select the ID of the question that you want to update its correct answer : ");
	i=scan.nextInt();
	
	//giving new answer
	System.out.println("Enter the new answer :");
	s=scan.next();
	updating(transactionDAO,i,s);

}
	private void updating(TransactionDAO trs ,int i ,String s) throws SQLException, Exception {
		
		// updating data base 
		trs.updatingOfRecord(i,s);
		System.out.println("Updated...........................");
	}

}
