import java.util.ArrayList;


public class Student {
	private String name;
	private ArrayList<Double> personalGrades;
	//TODO: You'll probably need to have some more fields here
	/**
	 * makes a new student object
	 * 
	 * @param newName the name of the student
	 */
	public Student(String newName) {
		this.name=newName;
		personalGrades= new ArrayList<Double>();
		
		//TODO: initialize fields here
	}
	/**
	 * gets the name of the student
	 * 
	 * @return the name of the student
	 */
	public String getName() {
		// TODO your code here
		return this.name;
	}
	
	public void addPersonalScores(double grades){
		personalGrades.add(grades);
	}
	
	public double personaverage(){
		double totalScore=0;
		for(int i=0; i<personalGrades.size(); i++){
			if(personalGrades.size()==0){
				return 0;
			}
			
			totalScore=totalScore+this.personalGrades.get(i);
		}
		return totalScore/this.personalGrades.size();
		
	}
	
	//TODO: You'll need to add some new methods here
}
