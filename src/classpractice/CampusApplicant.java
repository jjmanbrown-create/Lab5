package classpractice;

public class CampusApplicant {
	
	// Creating private instance variables to store applicant information
	private String studentName;
	private double gpa;
	private int completedCredits;
	private int campusActivities;
	private boolean goodStanding;
	
	// Constructor that initializes applicant informatio
	public CampusApplicant(String name, double thisGpa, int credits, 
			int activities, boolean standing){
		studentName = name;
		gpa = thisGpa;
		completedCredits = credits;
		campusActivities = activities;
		goodStanding = standing;
	}
	// Getter methods that return individual applicant information
	public String getStudentName() {
		return studentName;
	}
	public double getGpa() {
		return gpa;
	}
	
	public int getCredits() {
		return completedCredits;
	}
	
	public int getActivities() {
		return campusActivities;
	}
	
	public boolean isGoodStanding() {
		return goodStanding;
	}
	
	// Method that returns all applicant information as a formatted String
	public String toString() {
		return "\nName: " + studentName + "\nGPA: " + gpa + 
				"\nCredits: " + completedCredits + "\nActivities: " + campusActivities + 
				"\nGood Standing: " + goodStanding;
	}
	
	// Method that checks whether an applicant meets all eligibility requirements
	public boolean isEligible() {
		if(gpa>=3.3 && completedCredits>=30 && campusActivities>=2
				&& goodStanding) {
			
			return true;
		} else {
			
			return false;
		}		
	}
	
	// Method that identifies and displays any eligibility requirements an applicant fails
	public String getEligibilityMessage() {
		
		String problems = "";
		// Checking whether the applicant meets the minimum GPA requirement
		 if (gpa<3.3) {
			problems += "- GPA must be at least 3.3.\n";
		 }
		// Checking whether the applicant has completed enough credits
		 if (completedCredits<30) {
			problems += "- At least 30 completed credits required.\n";
		 }
		 // Checking whether the applicant participates in enough campus activities
		 if (campusActivities<2) {
			problems += "- At least 2 activities required.\n";
		 }
		 // Checking whether the applicant is in good academic standing
		 if (!goodStanding) {
			problems += "- Must be in good academic standing.\n";
		}
		// Returning an eligibility message depending on the applicant's results
		 if (problems.isEmpty()) {
			 return "\n" + studentName + ": Eligible for Research opportunities.";
		 } else {
			 return "\n" + studentName + ": Not Eligible: \n" + problems;
		 }
	}
	// Method that compares two applicants based on their ranking criteria
	public int compareApplicants(CampusApplicant other) {
		if(gpa > other.gpa) {
			return 1;
		} else if(gpa < other.gpa) {
			return -1;
		} else {
			// Comparing applicants based on campus activities when GPAs are equal
			if(campusActivities > other.campusActivities) {
				return 1;
			} else if(campusActivities < other.campusActivities) {
				return -1;
			} else {
				// Using alphabetical order to break ties when GPA and activities are equal
				if(studentName.compareTo(other.studentName) < 0) {
					return 1;
				} else if (studentName.compareTo(other.studentName) > 0) {
					return -1;
				} else {
					 // Returning 0 when both applicants have identical ranking values
					return 0;
				}
			}
		}
	}
}