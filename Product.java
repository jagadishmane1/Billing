package com.demo;



	import java.awt.List;
	import java.text.SimpleDateFormat;
	import java.util.ArrayList;
	import java.util.Calendar;
	import java.util.Date;
	import java.util.Scanner;

	public class Product 
	{
		private String  id ;
		private String pname ;
		private int qty ;
		private double price ;
		private double totalprice ;
		
		
		static String customername;

		//Costructor
		public Product(String id , String pname,int qty,double price,double totalprice) 
		{
			this.id = id ;
			this.pname = pname ;
			this.qty = qty ;
			this.price = price ;
			this.totalprice = totalprice ;	
		}
		public String getId() {
			return id;
		}
		public String getPname() {
			return pname;
		}
		public int getQty() {
			return qty;
		}
		public double getPrice() {
			return price;
		}
		public double getTotalprice() {
			return totalprice;
		}
		
		
		public static void displayFormat() 
		{
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("Customer Name : " + customername);
			System.out.println("\n Product ID \t\tName \t\tQuantity \t\tRate \t\t Total Price \n");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
		}
		
		
		public void display() 
		{
			System.out.format(" \n   %-9s            %-9s        %5d            %9.2f          %14.2f\'"
					,id,pname,qty,price,totalprice);
		}
		
		
		public static void main(String[] args) 
		{
			//Vaiables
			String Id = null ;
			String ProductName = null ;
			int Quantity  = 0;
			double Price  = 0.0;
			double TotalPrice = 0.0;
			double overAllPrice = 0.0 ;
			double cgst,sgst,subtotal = 0.0 ,discount = 0.0;
			char choice = '\0';
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t  "
					+ "    ****************** Invoice Bill *******************");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\t\t\t\t\t"+" "+" "+"      Vedansh Mart  ");
			System.out.println("\t\t\t\t    "+"    "+"Opposite Chandan Nagar Bus Stop");
			System.out.println("\t\t\t\t\t3/98 Chandan Nagar Pune 411014 ");
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println(" GSTIN: 098665417KJHGF"+"\t\t\t\t\t\t        \tContact: (+91)  8459855638");
			// Format of Date And Time 
			SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			Date date = new Date();
			Calendar cal  = Calendar.getInstance();
			String[] days = new String[]{"Sunday","Monday","Tuesday","Wednesday","Thursday","Friday","Saturday"};
			System.out.println(" Date; "+formatter.format(date)+"  "+days[cal.get(cal.DAY_OF_WEEK)-1]
					+"\t\t\t\t\t\t         (+91)  9373650955");
			Scanner scan = new Scanner(System.in);
			//Create Coustumer Class Object
			//Creating an ArrayList Ti store the product
			System.out.print(" Enter Custumer Name : ");
			 customername = scan.nextLine();

			ArrayList<Product> product = new ArrayList<Product>();
			do
			{
				//Read  Input Values
				System.out.println("\n Enter the Product details : \n");
				System.out.print(" Product Id : ");
				Id = scan.nextLine();
				System.out.print(" Product Name : ");
				ProductName = scan.nextLine();
				System.out.print(" Quantity : ");
				Quantity =scan.nextInt();
				System.out.print(" Price ( Per Unit ) : ");
				Price = scan.nextDouble();
				//Calculate Total Price for Perticular Product
				TotalPrice = Price*Quantity ;
				//Calculate Overall Price
				overAllPrice = overAllPrice + TotalPrice ;
				//Create product class Object And add it to the List 
				product.add(new Product(Id, ProductName,Quantity,Price,TotalPrice));
				//Ask for Continue Shopping ?
				System.out.print(" Want to add more items ? (y Or n): ");
				//Read a Character Y or N
				choice =scan.next().charAt(0);
				System.out.println("");
				//Read Remaining Character , Don't Store (No use)
				scan.nextLine();
			}
			while(choice == 'y'  ||  choice =='Y');
			//Display All Product with  its Properties
			Product.displayFormat();
			for(Product p : product) 
			{
				p.display();
			}
			
			System.out.println("\n\n\t\t\t\t\t\t\t\t\t\t                      Total Amount (Rs.)    :"+overAllPrice);
			discount = overAllPrice *2/100 ;
			System.out.println("\n\t\t\t\t\t\t\t\t\t\t                      Discount (Rs.)        :"+discount);
			subtotal = overAllPrice - discount ;
			System.out.println("\n\t\t\t\t\t\t\t\t\t\t                      Subtotal              :"+subtotal);
			//Calculating Tax
			sgst = overAllPrice * 4 / 100 ;
			System.out.println("\n\t\t\t\t\t\t\t\t\t\t                      SGST (%)              :"+sgst);
			cgst = overAllPrice * 4 / 100 ;
			System.out.println("\n\t\t\t\t\t\t\t\t\t\t                      CGST (%)              :"+cgst);
			//Calculating Amount to Be paid By Buyer 
			System.out.println("---------------------------------------------------------------------------------------------------------------------------------------------------------");
			System.out.println("\n\t\t\t\t\t\t\t\t\t\t                      Invoice Total         :" + (subtotal+cgst+sgst));
			System.out.println("\t\t\t\t------------------Thanks You For Shopping !! --------------------");
			System.out.println("\t\t\t\t                          Visit Agian");
			scan.close();	

		}
	


}
