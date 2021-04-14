package hust.soict.hedspi.aims;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.order.Order;

public class Aims {

	public static void showMenu() {
		System.out.println("Order Management Application: ");
		System.out.println("--------------------------------"); 
		System.out.println("1. Create new order"); 
		System.out.println("2. Add item to the order"); 
		System.out.println("3. Delete item by id"); 
		System.out.println("4. Display the items list of order"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2-3-4");
	}
	public static void showMenuMedia() {
		System.out.println("Select type of item to add"); 
		System.out.println("--------------------------------"); 
		System.out.println("1. Book"); 
		System.out.println("2. DVD"); 
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
	}
	private static void addDvdToOrder(Order anOrder) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("\tEnter id: ");
		String id = keyboard.nextLine();
		System.out.printf("\tEnter title: ");
		String title = keyboard.nextLine();
		System.out.printf("\tEnter category: ");
		String category = keyboard.nextLine();
		System.out.printf("\tEnter director: ");
		String director = keyboard.nextLine();
		System.out.printf("\tEnter cost: ");
		float cost = keyboard.nextFloat();
		System.out.printf("\tEnter length: ");
		int length = keyboard.nextInt();
		keyboard.nextLine();

		DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, length, director, cost);
		anOrder.addMedia(dvd);
	}

	private static void addBookToOrder(Order anOrder) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("\tEnter id: ");
		String id = keyboard.nextLine();
		System.out.printf("\tEnter title: ");
		String title = keyboard.nextLine();
		System.out.printf("\tEnter category: ");
		String category = keyboard.nextLine();
		System.out.printf("\tEnter cost: ");
		float cost = keyboard.nextFloat();
		Book book = new Book(id, title, category, cost);
		System.out.printf("\tEnter number of authors: ");
		int numberAuthors = keyboard.nextInt();
		while(numberAuthors <= 0) {
			System.err.println("ERR: Number of authors must be than 0!");
			System.out.printf("\tEnter number of authors: ");
			numberAuthors = keyboard.nextInt();
		}
		keyboard.nextLine();
		
		while(numberAuthors > 0) {
			System.out.printf("\tEnter author's name: ");
			String author = keyboard.nextLine();
			book.addAuthor(author);
			numberAuthors--;
		}
		anOrder.addMedia(book);
	}
	private static void removeMediaFromOrder(Order anOrder) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Enter id: ");
		String id = keyboard.nextLine();
		anOrder.removeMedia(id);
	}

	public static void main(String[] args) {
		Scanner keyboard = new Scanner(System.in);
		int option;
		int flagOption = 0;
		Order anOrder = null;
		do {
			showMenu();
			option = keyboard.nextInt();
			switch (option) {
			case 1:
				if(Order.nbOrder < Order.MAX_NUMBERS_ORDERED) {
					anOrder = new Order();
					System.out.println("MSG: An order has been created!");
				}else {
					System.err.println("ERR: You can't creat new order because number of orders is full!");
				}
				flagOption = 1;
				break;
			case 2:
				if(flagOption == 0) {
					System.err.println("ERR: Please create new order first by choosing option 1!");
					break;
				}
				int temp = 0;
				do {
					showMenuMedia();
					temp = keyboard.nextInt();
					switch (temp) {
					case 1:
						keyboard.nextLine();
						addBookToOrder(anOrder);
						break;
					case 2:
						keyboard.nextLine();
						addDvdToOrder(anOrder);
						break;
					case 0:
						System.out.println("MSG: Exit option 2!");
						break;
					default:
						System.err.println("ERR: Wrong option, please choose again!");
					}
				} while (temp != 0);
				break;
			case 3:
				if(flagOption == 0) {
					System.err.println("ERR: Please create new order first by choosing option 1!");
					break;
				}
				keyboard.nextLine();
				removeMediaFromOrder(anOrder);
				break;
			case 4:
				if(flagOption == 0) {
					System.err.println("ERR: Please create new order first by choosing option 1!");
					break;
				}
				if(anOrder.itemsOrdered.isEmpty()) {
					System.err.println("ERR: Order is empty!");
				}else {
					anOrder.print();
				}
				break;
			case 0:
				keyboard.close();
				System.out.println("MSG: Exit Menu!");
				break;
			default:
				System.err.println("ERR: Wrong option,please choose again!");
			}
		} while (option != 0);
	}


}
