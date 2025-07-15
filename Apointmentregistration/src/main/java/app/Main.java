package app;
import entity.ApointmentEntity;
import service.ApointmentService;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        ApointmentService service = new  ApointmentService();
	        Scanner scanner = new Scanner(System.in);
	        boolean running = true;

	        while (running) {
	            System.out.println("\n ==========Apointment Management System==========");
	            System.out.println("1. Add New  Apointment");
	            System.out.println("2. Update  Apointment");
	            System.out.println("3. Delete  Apointment");
	            System.out.println("4. View  Apointment");
	            System.out.println("5. View All  Apointments");
	            System.out.println("6. Exit");
	           

	            int choice;
	            try {
	                choice = Integer.parseInt(scanner.nextLine());
	            } catch (NumberFormatException e) {
	                System.out.println("Invalid input. Please enter a number between 1 and 6.");
	                continue;
	            }

	            switch (choice) {
	                case 1: // Add New Employee
	                    System.out.print("Enter First Name: ");
	                    String firstName = scanner.nextLine();
	                    System.out.print("Enter Last Name: ");
	                    String lastName = scanner.nextLine();
	                    System.out.print("EnteAaddress: ");
	                    String address = scanner.nextLine();
	                    System.out.print("Enter apointment Date (YYYY-MM-DD): ");
	                    String AptDateStr = scanner.nextLine();
	                    Date aptDate;
	                    try {
	                        aptDate = Date.valueOf(AptDateStr);
	                    } catch (IllegalArgumentException e) {
	                        System.out.println("incorrect.");
	                        break;
	                    }
	                    service.createApointment(firstName, lastName, address,aptDate);
	                    break;

	                case 2: // Update Employee
	                    System.out.print("Enter  Apointment ID to update: ");
	                    int updateId;
	                    try {
	                        updateId = Integer.parseInt(scanner.nextLine());
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid ID format.");
	                        break;
	                    }
	                    System.out.print("Enter New First Name: ");
	                    String newFirstName = scanner.nextLine();
	                    System.out.print("Enter New Last Name: ");
	                    String newLastName = scanner.nextLine();
	                    System.out.print("Enter New Address: ");
	                    String newAddress = scanner.nextLine();
	                    System.out.print("Enter New  Apointment Date (YYYY-MM-DD): ");
	                    String newAptDateStr = scanner.nextLine();
	                    Date newADate;
	                    try {
	                        aptDate = Date.valueOf(newAptDateStr);
	                    } catch (IllegalArgumentException e) {
	                        System.out.println("Invalid date format. Use YYYY-MM-DD.");
	                        break;
	                    }
	                    service.updateApointment(updateId, newFirstName, newLastName, newAddress, aptDate);
	                    break;

	                case 3: // Delete Employee
	                    System.out.print("Enter  Apointment ID to delete: ");
	                    int deleteId;
	                    try {
	                        deleteId = Integer.parseInt(scanner.nextLine());
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid ID format.");
	                        break;
	                    }
	                    service.deleteApointment(deleteId);
	                    break;

	                case 4: // View Employee by ID
	                    System.out.print("Enter Apointment ID to view: ");
	                    int viewId;
	                    try {
	                        viewId = Integer.parseInt(scanner.nextLine());
	                    } catch (NumberFormatException e) {
	                        System.out.println("Invalid ID format.");
	                        break;
	                    }
	                    ApointmentEntity emp = service.findApointment(viewId);
	                    if (emp != null) {
	                        System.out.println("\nID: " + emp.getApt_id() + ",\n Name: " + emp.getFirstName() + " " + 
	                                          emp.getLastName() + ",\n address: " + emp.getAddress() + ", \nApointment Date: " + 
	                                          emp.getAptDate());
	                    } else {
	                        System.out.println("Apointment with ID " + viewId + " not found.");
	                    }
	                    break;

	                case 5: // View All Employees
	                    List<ApointmentEntity> apointments = service.findAllApointments();
	                    if (apointments.isEmpty()) {
	                        System.out.println("No employees found.");
	                    } else {
	                        System.out.println("\nAll apointments:");
	                        for (ApointmentEntity e : apointments) {
	                            System.out.println("ID: " + e.getApt_id() + ", Name: " + e.getFirstName() + " " + 
	                                              e.getLastName() + ", Address " + e.getAddress() + ", Apointment Date: " + 
	                                              e.getAptDate());
	                        }
	                    }
	                    break;

	                case 6: // Exit
	                    running = false;
	                    service.shutdown();
	                    System.out.println("Exiting application.");
	                    break;

	                default:
	                    System.out.println("Invalid choice. ");
	            }
	        }
	        scanner.close();
	    }

}
