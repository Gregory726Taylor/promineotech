package projects;

import java.math.BigDecimal;

import java.util.List;
import java.util.Objects;
import java.util.Scanner;

import projects.entity.Project;
import projects.exception.DBException;
import projects.service.ProjectService;
/*
 * An application that uses user input to insert a row into my project table in my projects database
 * */

public class ProjectsApp {
	
	private ProjectService projectService = new ProjectService();
	private Scanner scanner = new Scanner(System.in);
	Integer difficulty;

	// @formatter:off
	private List<String> operations = List.of(
			"1) Add a project"
	);
	// formatter:on
	
	public static void main(String[] args) {
		new ProjectsApp().processUserSelections();	
	}
	
	//Uses the selection input by the user to create a project. If the user doesn't select the option and presses Enter, it exits the program
	private void processUserSelections() {
		boolean done = false;
		
		while(!done) {
			try {
				int selection = getUserSelection();
				
				switch (selection) {
					case -1:
						done = menuExit();
						break;
					case 1:
						createProject();
						break;
					
					default: 
						System.out.println("\n" + selection + " is not a vaild selection. Try again.");
				}

			} catch (Exception e) {
				System.out.println("\nError: " + e + " Try again.");
			}
		}
	}

	//Adds a row into the project table in the database using the input from the user
	private void createProject() {
		int i = 0;

		String projectName = getStringInput("Enter the project name");
		BigDecimal estimatedHours = getDecimalInput("Enter the estimated hours");
		BigDecimal actualHours = getDecimalInput("Enter the actual hours");
		Integer validateDifficulty = getIntInput("Enter the project difficulty (1-5)");
		//Validates that the project difficulty level input by the user is between 1 and 5 
		while (i >= 0) {
			if (validateDifficulty >= 1 && validateDifficulty <= 5) {
				difficulty = validateDifficulty;
				i = -1;
			} else {
				validateDifficulty = getIntInput("Enter a valid project difficulty value (1-5)");
			}
		}
		String notes = getStringInput("Enter the project notes");
		
		Project project = new Project();
		
		//Sets the values of the object from the Project class
		project.setProjectName(projectName);
		project.setEstimatedHours(estimatedHours);
		project.setActualHours(actualHours);
		project.setDifficulty(difficulty);
		project.setNotes(notes);
		
		//Passes the project object into the Project Service class 
		Project dbProject = projectService.addProject(project);
		System.out.println("You have successfully created project: " + dbProject);
		
	}

	//Converts the String input by the user into a BigDecimal
	private void getDecimalInput(String prompt) {
		String input = getStringInput(prompt);
		
		//Returns null if there was no input of the user
		if (Objects.isNull(input)) {
			return;
		}
		
		try {
			return new BigDecimal(input).setScale(2);
		} catch (NumberFormatException e) {
			
		}
	}

	//Prints that the user is exiting the menu and returns true to exit the while loop 
	private boolean menuExit() {
		System.out.println("Exiting the menu.");
		return true;
	}

	//Prints the operation and gets the operation that is selected by the user 
	private int getUserSelection() {
		printOperations();
		Integer input = getIntInput("Enter a menu selection");
		
		//Returns null if the user did not input data, but if they did it return the input
		return Objects.isNull(input) ? -1 : input; 
	}

	//Converts the String input by the user to an Integer
	private Integer getIntInput(String prompt) {
		String input = getStringInput(prompt);
		
		if (Objects.isNull(input)) {
			return null;
		}
		
		try {
			return Integer.valueOf(input);
		} catch (NumberFormatException e) {
			throw new DbException(input + " is not a valid number.");
		}
	}

	//Prompts the user for information about the project and gets the user's input
	private String getStringInput(String prompt) {
		System.out.print(prompt + ": ");
		String input = scanner.nextLine();
		return input.isBlank() ? null : input.trim();
	}

	//Prints out the operation
	private void printOperations() {
		System.out.println("\nThese are the available selections. Press the Enter key to quit:");
		
		for (String operation : operations) {
			System.out.println(operation);
		}
	}

}