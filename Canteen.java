import java.util.Scanner;

public class Canteen{
	public static void main(String[]args){
		Scanner input = new Scanner(System.in);

		int item, quantity;

		final double BURGER = 80.00;
		final double PIZZA = 120.00;
		final double PASTA = 100.00;
		final double SANDWICH = 70.00;
		final double MILK_TEA = 90.00;

		int totalItems = 0;
		double totalBeforeDiscount = 0.00;
		double totalDiscount = 0.0;
		String orderAgain;
		String isStudent;
		boolean firstOrder = true;

		do{
			if (firstOrder){
				System.out.println("=====\b\tM E N U \b\t   =====");
				System.out.println("1. Burger\t- $80.00");
				System.out.println("2. Pizza\t- $120.00");
				System.out.println("3. Pasta\t- $100.00");
				System.out.println("4. Sandwich\t- $70.00");
				System.out.println("5. Milk Tea\t- $90.00");
				firstOrder = false;
			}
			
			System.out.println();
			System.out.print("Enter item number: ");
			item = input.nextInt();
			System.out.print("Enter quantity: ");
			quantity = input.nextInt();

			if(item<1 || item>5 || quantity<1 || quantity>10){
				System.out.println();
				System.out.println("Invalid order! Please enter a valid item and quantity.");
				System.out.println();
				System.out.print("Do you want to order again? (Y/N): ");
				orderAgain = input.next().toUpperCase();
				continue;
			}

			System.out.print("Are you a student? (Y/N): ");
			isStudent = input.next().toUpperCase();

			double unitPrice = 0.0;
			if(item==1) unitPrice = BURGER;
			else if(item==2) unitPrice = PIZZA;
			else if(item==3) unitPrice = PASTA;
			else if(item==4) unitPrice = SANDWICH;
			else if (item==5) unitPrice = MILK_TEA;

			double subtotal = unitPrice * quantity;
			double discountRate = 0.0;

			if (isStudent.equals("Y") && subtotal >= 500){
				discountRate = 0.15;
			}else if (isStudent.equals("Y")){
				discountRate = 0.10;
			}else if(subtotal >= 500){
				discountRate = 0.05;
			}

			double discount = subtotal*discountRate;
			double orderTotal = subtotal - discount;

			System.out.println();
			System.out.printf("Subtotal: $%.2f%n", subtotal);
			System.out.printf("Discount: $%.2f%n", discount);
			System.out.printf("Order total: $%.2f%n", orderTotal);
			System.out.println();

			totalItems += quantity;
			totalBeforeDiscount += subtotal;
			totalDiscount += discount;

			System.out.print("Do you want to order again? (Y/N): ");
			orderAgain = input.next().toUpperCase();
		}while (orderAgain.equals("Y"));

		System.out.println();
		System.out.println("===== ORDER SUMMARY =====");
		System.out.println("Total items: " + totalItems);
		System.out.printf("Total before discount: $%.2f%n", totalBeforeDiscount);
		System.out.printf("Total discount: $%.2f%n", totalDiscount);
		System.out.printf("Final amount: $%.2f%n", totalBeforeDiscount - totalDiscount);
		System.out.println("Thank you for ordering!");

		input.close();
	}
}