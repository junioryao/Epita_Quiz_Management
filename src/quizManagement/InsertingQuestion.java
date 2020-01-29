package quizManagement;
import java.sql.SQLException;
import java.util.Scanner;
import dataServiceManagement.TransactionDAO;
/*
 * this class is created only to take input from user regarding 
 * the new inserting record 
 * */
public class InsertingQuestion {
	
	
	Scanner in = new Scanner(System.in);
	String question , topics, right_answer,wrong_answer1,WrongAnswer2 ;
	
	public void collectData(TransactionDAO dao) throws SQLException, Exception
	{
		
		System.out.println("Enter your question");
		question = in.nextLine();
		System.out.println("Choose either COMPUTER SCIENCE OR FOOTBALL as topic , Use uppercase ");
		topics = in.nextLine();
		System.out.println("Enter your Correct answer");
		right_answer = in.nextLine();
		System.out.println("Enter your wrong answer 1");
		wrong_answer1 = in.nextLine();
		System.out.println("Enter your wrong answer 2");
		WrongAnswer2 = in.nextLine();
		
		Question obj_question= new Question(question,topics,right_answer,wrong_answer1,WrongAnswer2);
		dao.insertionOfRecord(obj_question);
	}
}
