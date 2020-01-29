package quizManagement;
/*
 * this class is created only to manage the data or selected data
 * */
public class Question {
	int id ; 
	String question ;
	String topics ;
	String Right_answer;
	String Wr_answer_1;
	String Wr_answer_2;

	public Question(int id, String question, String topics, String right_answer, String wr_answer_1,
			String wr_answer_2) {
		this.id = id;
		this.question = question;
		this.topics = topics;
		Right_answer = right_answer;
		Wr_answer_1 = wr_answer_1;
		Wr_answer_2 = wr_answer_2;
	}

	public Question(String question, String topics,String right_answer, String wrongAnswer1, String wrongAnswer2) {
		this.question = question;
		this.topics = topics ; 
		this.Right_answer = right_answer;
		this.Wr_answer_1 = wrongAnswer1;
		this.Wr_answer_2 = wrongAnswer2;
		
	}
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTopics() {
		return topics;
	}

	public void setTopics(String topics) {
		this.topics = topics;
	}

	public String getRight_answer() {
		return Right_answer;
	}

	public void setRight_answer(String right_answer) {
		Right_answer = right_answer;
	}

	public String getWr_answer_1() {
		return Wr_answer_1;
	}

	public void setWr_answer_1(String wr_answer_1) {
		Wr_answer_1 = wr_answer_1;
	}

	public String getWr_answer_2() {
		return Wr_answer_2;
	}

	public void setWr_answer_2(String wr_answer_2) {
		Wr_answer_2 = wr_answer_2;
	}


	

}
