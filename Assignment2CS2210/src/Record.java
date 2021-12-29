
public class Record {
	

	private String configuration; // private String instance variable that represents the configuration key given as input
	private int score; 			  // private int instance variable that represents the score value given as input
	
	/**
	* Constructor
	* returns the new record with the specified configurations and score
	* @param String config is used as the key attribute for every Record object
	* @param int score is used as the value attribute for every Record object
	*/
	public Record(String config, int score) {
		configuration = config;
		this.score =score;

	}
	
	
	/**
	* Public getter method that returns the configuration stored in this record
	* @return String configuration which is the configuration stored in the record
	*/
	public String getConfig() {
		return configuration;
	}
	
	/**
	* Public getter method that returns the score
	* @return int score which is the score stored in the record
	*/
	public int getScore() {
		return score;
	}

}
