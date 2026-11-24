package classpractice;
/*
* File: Task2.java
* Author: Jalen Brown
* Course: CISC230
* Lab: Lab5
* Date: 11/4/2026
* 
* Description:
*Program creates and compares multiple campus applicants based on
*their GPA, completed credits, campus activities, and good standing.
*Displays applicant information and determines whether each applicant
*meets the eligibility requirements. Uses methods to compare applicants
*and select the best eligible applicant based on ranking criteria.
*Also includes multiple test cases to verify eligibility, comparisons,
*and the final applicant selection.
*/

public class Task2 {

	public static void main(String[] args) {
		
		// Creating CampusApplicant objects with different
		CampusApplicant applicant1 = new CampusApplicant("Alice", 3.8, 60, 5, true);
		CampusApplicant applicant2 = new CampusApplicant("Bob", 3.8, 65, 5, true);
		CampusApplicant applicant3 = new CampusApplicant("Charlie", 3.6, 70, 6, true);
		CampusApplicant applicant4 = new CampusApplicant("David", 3.9, 25, 7, true);
		CampusApplicant applicant5 = new CampusApplicant("Emma", 3.3, 30, 2, true);
		CampusApplicant applicant6 = new CampusApplicant("Frank", 2.9, 20, 1, false);
		CampusApplicant applicant7 = new CampusApplicant("Grace", 3.8, 60, 7, true);
		CampusApplicant applicant8 = new CampusApplicant("Alice", 3.8, 60, 5, true);
		
		// Displaying information for all applicants
		System.out.println("================ APPLICANT INFORMATION ================");
		
		System.out.println(applicant1.toString());
		System.out.println(applicant2.toString());
		System.out.println(applicant3.toString());
		System.out.println(applicant4.toString());
		System.out.println(applicant5.toString());
		System.out.println(applicant6.toString());
		System.out.println(applicant7.toString());
		System.out.println(applicant8.toString());
		
		// Displaying eligibility messages for the first four applicants
		System.out.println("============ ELIGIBILITY REPORT ============");
		
		System.out.println(applicant1.getEligibilityMessage());
		System.out.println(applicant2.getEligibilityMessage());
		System.out.println(applicant3.getEligibilityMessage());
		System.out.println(applicant4.getEligibilityMessage());
		
		// Selecting and displaying the best eligible applicant
		System.out.println("============ FINAL SELECTION ============");
						
		CampusApplicant winner = selectBestApplicant(applicant1, applicant2, applicant3, applicant4);
		
		 // Checking whether an eligible applicant was found
		if(winner != null) {
			System.out.println("Selected Applicant: " + winner.getStudentName());
			} else {
			System.out.println("No eligible applicants found.");
		}
		
			// Running test cases to verify applicant methods and selection logic	
			System.out.println("============ APPLICANT TEST REPORT ============");
			// Testing whether an applicant meets all eligibility requirements
			System.out.println("TC1: Eligible Applicant \nExpected: true" + " \nActual: "+ applicant1.isEligible());
			System.out.println("\nTC2: Multiple Eligibility Failures \nExpected: false" + 
			" \nActual: " + applicant6.isEligible() + "\n" + applicant6.getEligibilityMessage());
			System.out.println("\nTC3: Different GPAs \nExpected: 1 \nActual: " + applicant1.compareApplicants(applicant3));
			// Testing comparison between applicants with the same GPA but different activities
			System.out.println("\nTC4: Same GPA, Different Activities \nExpected: -1 \nActual: " + applicant1.compareApplicants(applicant7));
			// Testing alphabetical comparison when applicants have the same ranking values
			System.out.println("\nTC5: Alphabetical Tie-Breaker \nExpected: 1 \nActual: " + applicant1.compareApplicants(applicant2));
			// Testing reverse alphabetical comparison between two applicants
			System.out.println("\nTC6: Reverse Alphabetical Comparison \nExpected: -1 \nActual: " + applicant2.compareApplicants(applicant1));
			
			// Testing selection when the highest GPA applicant is ineligible
			CampusApplicant tc7 = selectBestApplicant(applicant1, applicant2, applicant3, applicant4);
			
			System.out.println("\nTC7: Highest GPA but Ineligible");
			System.out.println("Expected: Alice");
			
			 // Displaying the actual selected applicant
			if(tc7 !=null) {
				System.out.println("Actual: " + tc7.getStudentName());
			} else {
				System.out.println("Actual: No eligible applicants found.");
			}
								
			// Testing selection when no eligible applicants are provided
			CampusApplicant tc8 = selectBestApplicant(applicant4, applicant6, null, null);
			
			System.out.println("\nTC8: No Eligible Applicants");
			System.out.println("Expected: No Eligible Applicants");
			// Checking whether the selection method returns null
			if(tc8 != null) {
				System.out.println("Actual: " + tc8.getStudentName());
			} else {
				System.out.println("Actual: No eligible applicants found");
			}
			 // Testing applicants with identical ranking values
			System.out.println("\nTC9: Identical Ranking Values \nExpected: 0 \nActual: " + applicant1.compareApplicants(applicant8));
			// Testing an applicant who meets the minimum eligibility requirements
			System.out.println("\nTC10: Minimum Eligibility Requirements \nExpected: true \nActual: " + applicant5.isEligible());
			// Indicating that all applicant information and test cases have finished printing
			System.out.println("============== PRINTING COMPLETED ==============");
	}
	
	// Method that selects the best eligible applicant from four possible applicants
	public static CampusApplicant selectBestApplicant(CampusApplicant
			applicant1, CampusApplicant applicant2, CampusApplicant applicant3,
			CampusApplicant applicant4) {
		CampusApplicant best = null;
		
		// Checking whether the first applicant exists and is eligible
		if(applicant1 != null) {
			if(applicant1.isEligible()) {
				best = applicant1;
			}
		}
		// Checking the second applicant and comparing them with the current best
		if(applicant2 !=null) {
			if(applicant2.isEligible()) {
				if(best == null) {
					best = applicant2;
			}  else {
				if(applicant2.compareApplicants(best) == 1) {
					best = applicant2;
				}
			} 
		}
	}
		// Checking the third applicant and comparing them with the current best
		if(applicant3 !=null) {
			if(applicant3.isEligible()) {
				if(best == null) {
					best = applicant3;
			}  else {
				if(applicant3.compareApplicants(best) == 1) {
					best = applicant3;
				}
			} 
		}
	}
		// Checking the fourth applicant and comparing them with the current best
		if(applicant4 !=null) {
			if(applicant4.isEligible()) {
				if(best == null) {
					best = applicant4;
			}  else {
				if(applicant4.compareApplicants(best) == 1) {
					best = applicant4;
				}
			} 
		}
	}
		// Returning the highest-ranked eligible applicant or null if none qualify
		return best;
}
}