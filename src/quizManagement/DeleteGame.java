package quizManagement;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import dataServiceManagement.TransactionDAO;

/*The Delete class is made to perform 1 action
 * selecting the row which has to be deleted 
 *  
 * */
public class DeleteGame {
	int i ;
	ArrayList<Question> all_question = new ArrayList<>();
	Scanner scan = new Scanner(System.in);

	public void deleteProcess(TransactionDAO transactionDAO) throws SQLException, Exception {
	System.out.println("Processing-------------------");
	
	//taking all record from DB
	transactionDAO.SelectGameType();
	
	//assign all records for the arraylist
	this.all_question = transactionDAO.getDataBaseData();
	
	//display all records
	for(Question q:all_question) {
		System.out.println(q.getId()+"-----"+q.getQuestion());
		}
	System.out.println("Select the ID of the question which has to be deleted ");
	
	//record selected
	i=scan.nextInt();
	Deletion(transactionDAO,i);

}
	private void Deletion(TransactionDAO trs ,int i) throws SQLException, Exception {
		
		// deleting the selected record 
		trs.deletionOfRecord(i);
	}
}
