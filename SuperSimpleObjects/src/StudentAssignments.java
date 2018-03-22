
public class StudentAssignments {
	String name;
	String assignment;

	public StudentAssignments() {
		name="Studenty McStudenton";	
		assignment="";
	}
	public StudentAssignments(String strings){
		name=strings;
		assignment="";
		
	}

	public void addAssignment(String string, int i) {
		assignment= assignment + string+ "-"+i+" ";
	}

	public void printGradeReport() {
		System.out.println(name+" " + assignment);
		
		
	}

}
