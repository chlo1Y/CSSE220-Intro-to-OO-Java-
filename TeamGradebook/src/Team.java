import java.util.ArrayList;


public class Team {
	
	private String teamname;
	private ArrayList<Student>  teamMember;
	private ArrayList<Double>  teamGrade;
	public Team(String name, ArrayList<Student> memberNames) {
		this.teamname=name;
		this.teamMember=memberNames;
		teamGrade= new ArrayList<Double>();
	}
	
	public String getTeamName(){
		return this.teamname;
	}
	
	public ArrayList<Student>  getMembers(){
		return this.teamMember;
	}
	
	public double getAverageTeamScore(){
		double totalScore=0;
		for(int i=0; i<teamGrade.size(); i++){
			totalScore=totalScore+teamGrade.get(i);
			if(teamGrade.size()==0){
				return 0;
			}
		}
		return  totalScore/teamGrade.size();
	}
		
	
	public void addScore(double score){
		teamGrade.add(score);
		for(int i=0; i<teamMember.size(); i++){
			teamMember.get(i).addPersonalScores(score);
		}
		
	}
	
	// You'll need to add methods, constructors and fields here
	
}
