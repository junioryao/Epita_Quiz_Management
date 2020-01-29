package dataServiceManagement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import quizManagement.Question;

/*The TransactionDAO class is made to perform 7 actions 
 * creation of the database and initialization of the table function createDatabase()
 * insertion of new record into the database    			function insertionOfRecord(Question question) 
 * deletion of record from data base   						function deletionOfRecord(int del)
 * updating record into data base							function updatingOfRecord(int i , String s )
 * Selecting all records from data base 					function SelectGameType() 
 * Selection a specific category from database (COMPUTER SCIENCE)    SelectGameType1()      
 * Selection a specific category from database (Football)   function SelectGameType2()
 * */
public class TransactionDAO {
		ArrayList<Question> table = new ArrayList<>();
		Statement st = null ;
		ResultSet result ;
		
	public  void createDatabase() throws SQLException,Exception {
		//creating Database and table 
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		Class.forName("org.h2.Driver");

			st = connection.createStatement();
			//st.execute("DROP TABLE IF NOT EXISTS Quiz_Game;");
			st.execute("CREATE TABLE IF NOT EXISTS "
					+ "Quiz_Game("
					+ "id MEDIUMINT NOT NULL AUTO_INCREMENT,"
					+ "Question VARCHAR(100), "
					+ "Topics VARCHAR(100), "
					+ "Right_Answer VARCHAR(100), "
					+ "Answer2 VARCHAR(100), "
					+ "Answer3 VARCHAR(100), "
					+ "PRIMARY KEY (id),"
					+ ");");
			result = st.executeQuery("SELECT * FROM Quiz_GAME ; ");
			// initial first records if table is empty 
			if (result.next() == false) { initializeGameQuestions();}
			
			connection.close();
		
	}

	public void initializeGameQuestions() throws SQLException {
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'Who won the 1994 FIFA World Cup?','FOOTBALL','Brazil','France','Chine');");
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'Which of these star soccer players has never played for Real Madrid?','FOOTBALL','Messi','Ronaldo','Zidane');");
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'Anfield is the home of which English Premier League club?','FOOTBALL','Liverpool','Manchester United','West Ham United');");
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'If you need to select all the contents of MS Word, which command will you give?','COMPUTER SCIENCE','Ctrl + A','Ctrl + B','Ctrl + X');");
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'Which among the following is the shortcut key to refresh the active window in your computer system?','COMPUTER SCIENCE','F5','F12','F2');");
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'Who among the following had invented the laser printer?','COMPUTER SCIENCE','Gary Starkweather','Butler Lampson','Ronald Rider');");
	}

	public void insertionOfRecord(Question question) throws SQLException,Exception {
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		st = connection.createStatement();
		st.executeUpdate("INSERT INTO QUIZ_GAME VALUES(null,'"+question.getQuestion()+"','"+question.getTopics()+"','"+question.getRight_answer()+"','"+question.getWr_answer_1()+"','"+question.getWr_answer_2()+"');");
		System.out.println("Question inserted ");
		connection.close();
	}

	public void deletionOfRecord(int del) throws SQLException,Exception{
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		st = connection.createStatement();
		st.executeUpdate("DELETE FROM QUIZ_GAME WHERE ID='"+del+"'");
		connection.close();
	}
	
	public void updatingOfRecord(int i , String s ) throws SQLException,Exception{
		
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		st = connection.createStatement();
		st.executeUpdate("UPDATE QUIZ_GAME SET RIGHT_ANSWER='"+s+"' WHERE ID='"+i+"'");
		connection.close();
		
	}
	
	public void SelectGameType() throws SQLException,Exception{
		table.clear();
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		st = connection.createStatement();
		result = st.executeQuery("SELECT * FROM Quiz_Game");
		result.next();
		do {
			table.add(new Question(result.getInt("id"),
					result.getString("Question"),
					result.getString("Topics"),
					result.getString("right_answer"),
					result.getString("Answer2") ,
					result.getString("Answer3")));
			
		} while (result.next());
		connection.close();		
	}
	
	public void SelectGameType2() throws SQLException,Exception{
		table.clear();
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		st = connection.createStatement();
		result = st.executeQuery("SELECT * FROM Quiz_Game WHERE TOPICS='FOOTBALL'");
		result.next();
		do {
			table.add(new Question(result.getInt("id"),
					result.getString("Question"),
					result.getString("Topics"),
					result.getString("right_answer"),
					result.getString("Answer2") ,
					result.getString("Answer3")));
			
		} while (result.next());
		connection.close();		
	}
	
	public void SelectGameType1() throws SQLException,Exception{
		table.clear();
		Class.forName("org.h2.Driver");
		Connection connection = DriverManager.getConnection("jdbc:h2:~/test","sa","");
		st = connection.createStatement();
		result = st.executeQuery("SELECT * FROM Quiz_Game WHERE TOPICS='COMPUTER SCIENCE'");
		result.next();
		do {
			table.add(new Question(result.getInt("id"),
					result.getString("Question"),
					result.getString("Topics"),
					result.getString("right_answer"),
					result.getString("Answer2") ,
					result.getString("Answer3")));
			
		} while (result.next());
		connection.close();		
	}
	
	public ArrayList<Question> getDataBaseData(){
		return table;		
	}

}

