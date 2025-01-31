package org.bcits.tariffcalculations;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Tariff {
	static HashMap<Integer, Consumer> map = new HashMap<Integer, Consumer>();
	static Scanner scanner = new Scanner(System.in);
	static long inl;
	static long fnl;
	static double bill;

	public static void main(String[] args) {
		while (true) {

			try {
				System.out.println("choose");
				System.out.println("1.add Consumer");
				System.out.println("2.show  details");
				System.out.println("3.Show all details");

				switch (Integer.parseInt(scanner.nextLine())) {
				case 1:
					try {
						System.out.println("Select the type of Consumer");
						System.out.println("1.RESIDENTIAL");
						System.out.println("2.COMMERECIAL");
						System.out.println("3.INDUSTRY");
						int choice = Integer.parseInt(scanner.nextLine());
						switch (choice) {
						case 1:

							System.out.println("enter the name ");
							String name1 = scanner.nextLine();
							System.out.println("enter the id ");
							int id1 = Integer.parseInt(scanner.nextLine());
							System.out.println("Enter the initial reading ");
							long inl = Integer.parseInt(scanner.nextLine());
							System.out.println("Enter the final reading");
							long fnl = Integer.parseInt(scanner.nextLine());
							bill = BillCalcultor.residentil(inl, fnl);
							System.out.println("bill = "+bill);
							Consumer user1 = new Consumer(name1, id1, "RESIDENTIAL", bill);
							map.put(id1, user1);
							break;
						case 2:
							System.out.println("enter the name ");
							String name2 = scanner.nextLine();
							System.out.println("enter the id ");
							int id2 = Integer.parseInt(scanner.nextLine());
							System.out.println("Enter the initial reading ");
							inl = Integer.parseInt(scanner.nextLine());
							System.out.println("Enter the final reading");
							fnl = Integer.parseInt(scanner.nextLine());
							bill = BillCalcultor.residentil(inl, fnl);
							System.out.println("bill = "+bill);
							Consumer user2 = new Consumer(name2, id2, "COMMERECIAL", bill);
							map.put(id2, user2);
							break;
						case 3:
							System.out.println("enter the name ");
							String name3 = scanner.nextLine();
							System.out.println("enter the id ");
							int id3 = Integer.parseInt(scanner.nextLine());
							System.out.println("Enter the initial reading ");
							inl = Integer.parseInt(scanner.nextLine());
							System.out.println("Enter the final reading");
							fnl = Integer.parseInt(scanner.nextLine());
							bill = BillCalcultor.industry(inl, fnl);
							System.out.println("bill = "+bill);
							Consumer user3 = new Consumer(name3, id3, "INDUSTRY", bill);
							map.put(id3, user3);
							break;

						default:
							System.out.println("wrong choice");
							break;
						}
					} catch (Exception e) {
						System.out.println("enter valid number");
						break;
					}
					break;
				case 2:
					System.out.println("enter coonsumer id");
					int id = Integer.parseInt(scanner.nextLine());
					if(map.containsKey(id)) {
						System.out.println(map.get(id));
					}else {
						System.out.println("consumer with id ="+id +" does not exist");
					}
					break;
				case 3:
					System.out.println(" DETAILS");
					Set keys = map.keySet();
					Iterator itr = keys.iterator();
					while (itr.hasNext()) {
						System.out.println(map.get(itr.next()));
					}
					break;
					
				default:
					System.out.println("invalid");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("enter valid number");
			}
		}
	}

}
