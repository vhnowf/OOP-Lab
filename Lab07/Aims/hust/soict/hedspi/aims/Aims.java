package hust.soict.hedspi.aims;
import java.util.Scanner;

import hust.soict.hedspi.aims.media.Book;
import hust.soict.hedspi.aims.media.CompactDisc;
import hust.soict.hedspi.aims.media.DigitalVideoDisc;
import hust.soict.hedspi.aims.media.Track;
import hust.soict.hedspi.aims.order.Order;
import hust.soict.hedspi.aims.thread.MemoryDaemon;

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
		System.out.println("3. CD");
		System.out.println("0. Exit"); 
		System.out.println("--------------------------------"); 
		System.out.println("Please choose a number: 0-1-2");
	}
	private static void addDvdToOrder(Order anOrder) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Enter id: ");
		String id = keyboard.nextLine();
		System.out.printf("Enter title: ");
		String title = keyboard.nextLine();
		System.out.printf("Enter category: ");
		String category = keyboard.nextLine();
		System.out.printf("Enter director: ");
		String director = keyboard.nextLine();
		System.out.printf("Enter cost: ");
		float cost = keyboard.nextFloat();
		System.out.printf("Enter length: ");
		int length = keyboard.nextInt();
		keyboard.nextLine();

		DigitalVideoDisc dvd = new DigitalVideoDisc(id, title, category, length, director, cost);
		anOrder.addMedia(dvd);
	}

	private static void addBookToOrder(Order anOrder) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Enter id: ");
		String id = keyboard.nextLine();
		System.out.printf("Enter title: ");
		String title = keyboard.nextLine();
		System.out.printf("Enter category: ");
		String category = keyboard.nextLine();
		System.out.printf("Enter cost: ");
		float cost = keyboard.nextFloat();
		Book book = new Book(id, title, category, cost);
		System.out.printf("Enter number of authors: ");
		int numberAuthors = keyboard.nextInt();
		while(numberAuthors <= 0) {
			System.err.println("ERR: Number of authors must be than 0!");
			System.out.printf("Enter number of authors: ");
			numberAuthors = keyboard.nextInt();
		}
		keyboard.nextLine();
		
		while(numberAuthors > 0) {
			System.out.printf("Enter author's name: ");
			String author = keyboard.nextLine();
			book.addAuthor(author);
			numberAuthors--;
		}
		anOrder.addMedia(book);
	}
	
	private static void addCdToOrder(Order anOrder) {
		Scanner sc = new Scanner(System.in);
		System.out.printf("Enter id: ");
		String id = sc.nextLine();
		System.out.printf("Enter title: ");
		String title = sc.nextLine();
		System.out.printf("Enter category: ");
		String category = sc.nextLine();
		System.out.printf("Enter artist: ");
		String artist = sc.nextLine();
		System.out.printf("Enter cost: ");
		float cost = sc.nextFloat();
		CompactDisc cd = new CompactDisc(id, title, category, artist, cost);
		System.out.printf("Number of tracks: ");
		int count = sc.nextInt();
		while(count <= 0) {
			System.err.println("Number of tracks must be than 0");
			System.out.printf("Number of tracks ");
			count = sc.nextInt();
		}
		sc.nextLine();
		Track track = null;
		String titleTrack;
		int lengthTrack;
		for(int i = 0; i < count; i++) {
			System.out.println("Track " + (i+1));
			System.out.printf("Enter title of track: ");
			titleTrack = sc.nextLine();
			System.out.printf("Enter length of track: ");
			lengthTrack = sc.nextInt();
			track = new Track(titleTrack, lengthTrack);
			cd.addTrack(track);
			sc.nextLine();
		}
		String ask;
		do {
			System.out.printf("You want to listen? (yes/no)");
			ask = sc.nextLine();
			switch (ask) {
			case "yes":
				System.out.println("===============================");
				cd.play();
				System.out.println("===============================");
				break;
			case "no":
				break;
			default:
				System.err.println("ERR: Wrong syntax! Must yes or no");
			}
		} while (ask.equalsIgnoreCase("yes") == false && ask.equalsIgnoreCase("no") == false);
		anOrder.addMedia(cd);
	}
	private static void removeMediaFromOrder(Order anOrder) {
		Scanner keyboard = new Scanner(System.in);
		System.out.printf("Enter id: ");
		String id = keyboard.nextLine();
		anOrder.removeMedia(id);
	}

	public static void main(String[] args) {
//		Creat new MemoryDaemon object		
//		MemoryDaemon daemon = new MemoryDaemon();
//		Thread thread = new Thread(daemon);
//		thread.setDaemon(true);
//		thread.start();		
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
					case 3:
						keyboard.nextLine();
						addCdToOrder(anOrder);
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
