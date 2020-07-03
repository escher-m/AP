// Karishma Sinha 2018339
import java.util.*;
import java.io.*;
import java.lang.*;



public class mercury
{
	private float  accBal;
//	public interface basic
//	{
//		public void login();
//		public void categoryView();
//		public void transactionFee();
//		public void reward();
//		public void preward();
//		public void details();
//
//	}
	public static class merchant //implements basic
	{
		private final int mcode;
		private final String mname;
		private int mreward;
		private float mcontri;
		private final String maddress;
		private  ArrayList<item> I=new ArrayList<item>();
		public merchant(int mc,String mn, String ma)
		{
			this.mname=mn;
			this.mcode=mc;
			this.mreward=0;
			this.mcontri=0;
			this.maddress=ma;
			
		}
		
		void additem() 
		{
			Scanner input=new Scanner(System.in); 
			System.out.println("Enter item details");
			System.out.println("item name:");
			String itn=input.next();
			System.out.println("item price:");
			float itp=input.nextFloat();
			System.out.println("item quantity:");
			int itq=input.nextInt();
			System.out.println("item category:");
			String itc=input.next();
			item it=new item(itn,itp,itq,itc);
			this.setI(it);
			
			
			
			it.displayaddition();
			
		}
		
		void edititem() 
		{
			Scanner input=new Scanner(System.in); 
			System.out.println("Choose item by code:");
			for (item item : I) {
				System.out.println(item.icode+ " "+ item.iname+ " "+ item.price+" "+ item.qnt+" "+item.offer+" "+item.category);
			}
			
			int itn=input.nextInt();
			System.out.println("Enter Edit Details:");
			
			System.out.println("Item Price:");
			int itc=input.nextInt();
			System.out.println("Item Quantity:");
			int itd=input.nextInt();
			
			for (item item : I) {
				if(item.icode==itn)
				{
					item.setqnt(itd);
					item.setprice(itc);
				}
			}

		}
		
		
		void offers() 
		{
			Scanner input=new Scanner(System.in); 
			System.out.println("Choose item by code:");
			for (item item : I) {
				System.out.println(item.icode+ " "+ item.iname+ " "+ item.price+" "+ item.qnt+" "+item.offer+" "+item.category);
			}
			
			int itn=input.nextInt();
			System.out.println("Choose Offer");
			System.out.println("1) Buy one get one");
			System.out.println("25% Off");

			int itc=input.nextInt();
			
			if(itc==1) {
				for (item item : I) 
				{
					if(item.icode==itn)
					{
						item.setoffer("Buy one get one");
					}
					
				}
			}
			else if (itc==2) 
			{
				for (item item : I) 
				{
					if(item.icode==itn)
					{
						item.setoffer("25% Off");
					}
					
				}
			}
		}
		
			
		
		public void setI(item iobj)
		{
			I.add(iobj);
		}
		public int getmcode()
		{
			return mcode;
		}
		public String getmname()
		{
			return mname;
		}
		public int getmreward()
		{
			return mreward;
		}
		public float getmcontri()
		{
			return mcontri;
		}
		public String getmaddress()
		{
			return maddress;
		}
		public ArrayList<item> getI()
		{
			return I;
		}
		public void setmreward()
		{
			this.mreward++;
		}
		public void setmcontri(float mmoney)
		{
			this.mcontri+=mmoney;
		}

//		@Override
//		public void login() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void categoryView() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void transactionFee() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void reward() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void preward() {
//			// TODO Auto-generated method stub
//			
//		}
//
//		@Override
//		public void details() {
//			// TODO Auto-generated method stub
//			
//		}

	}
	public static class item
	{
		private static int id=0;
		private final int icode;
		private final String iname;
		private float price;
		private int qnt;
		private String offer;
		private final String category;

		public item(String n, float p, int q,String ct)
		{
			this.icode=++id;
			this.iname=n;
			this.price=p;
			this.qnt=q;
			this.offer="None";
			this.category=ct;
		}
		public item(int icodenew,String n, float p, int q,String ct)
		{
			this.icode=icodenew;
			this.iname=n;
			this.price=p;
			this.qnt=q;
			this.offer="None";
			this.category=ct;
		}
		
		
		public int geticode()
		{
			return icode;
		}
		public String getiname()
		{
			return iname;
		}
		public float getprice()
		{
			return price;
		}
		public int getqnt()
		{
			return qnt;
		}
		public String getoffer()
		{
			return offer;
		}
		public String getcategory()
		{
			return category;
		}
		public void setprice(float p1)
		{
			this.price=p1;
		}
		public void setqnt(int q1)
		{
			this.qnt=q1;
		}
		public void setoffer(String o1)
		{
			this.offer=o1;
		}
		public void displayaddition()
		{
			System.out.println(this.icode+ " "+ this.iname+ " "+ this.price+" "+ this.qnt+" "+this.offer+" "+this.category);
		}
	}
	public static class customer 
	{
		private final int ccode;
		private final String cname;
		private final String caddress;
		private float mainAcc;
		private float creward;
		private int noOfOrdersPlaced;
		private  ArrayList<item> Irecent=new ArrayList<item>();
		//private queueforlast10itemsbought

		public customer(int cc, String cn, String ca)
		{
			this.ccode=cc;
			this.cname=cn;
			this.caddress=ca;
			this.mainAcc=100;
			this.creward=0;
			this.noOfOrdersPlaced=0;
		}
		
		
		
		public int getccode()
		{
			return ccode;
		}
		public String getcname()
		{
			return cname;
		}
		public String getcaddress()
		{
			return caddress;
		}
		public float getmainAccbal()
		{
			return mainAcc;
		}
		public float getcreward()
		{
			return creward;
		}
		public int getnoOfOrdersPlaced()
		{
			return noOfOrdersPlaced;
		}
		public void setmainAccbal(float priceofpurchase)
		{
			if(priceofpurchase<=mainAcc)
			{
				mainAcc-=priceofpurchase;
			}
			else
			{
				mainAcc=0;
			}
		}
		public void setcreward(float cr)
		{
			creward+=cr;
		}
		public void setnoOfOrdersPlaced()
		{
			noOfOrdersPlaced++;
		}
//		@Override
//		public void login() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void categoryView() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void transactionFee() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void reward() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void preward() {
//			// TODO Auto-generated method stub
//			
//		}
//		@Override
//		public void details() {
//			// TODO Auto-generated method stub
//			
//		}
	}
	public static void main(String[] args)
	{
		ArrayList<merchant> M=new ArrayList<>();
		ArrayList<customer> C=new ArrayList<>();

		ArrayList<String> cat =new ArrayList<>();
		merchant m1=new merchant(1, "jack", "add1");
		M.add(m1);
		merchant m2=new merchant(2, "john", "add2");
		M.add(m2);
		merchant m3=new merchant(3, "james", "add3");
		M.add(m3);
		merchant m4=new merchant(4, "jeff", "add4");
		M.add(m4);
		merchant m5=new merchant(5, "joseph", "add5");
		M.add(m5);
		customer c1= new customer(1,"ali","add6");
		C.add(c1);
		customer c2= new customer(2,"Nobby","add7");
		C.add(c2);
		customer c3= new customer(3,"Drake","add8");
		C.add(c3);
		customer c4= new customer(4,"Borat","add9");
		C.add(c4);
		customer c5= new customer(5,"Aladeen","add10");
		
		C.add(c5);
		Scanner input=new Scanner(System.in);
		int item_code=1;
		int ans=0;
		
		do
		{
			System.out.println("Welcome to Mercury");
			System.out.println("1. Enter as Merchant");
			System.out.println("2. Enter as Customer");
			System.out.println("3. See user details");
			System.out.println("4. Company account balance");
			System.out.println("5. Exit");
			ans=input.nextInt();
			switch(ans)
			{
				case 1: 
					System.out.println("Choose merchant");
					for(int i=0;i<M.size();i++)
					{
						System.out.println(M.get(i).getmcode() +" " + M.get(i).getmname());
					}
					int ansm=input.nextInt();
					for(int i=0;i<M.size();i++)
					{
						if(M.get(i).getmcode()==ansm)
						{
							int ansmm=0;
							do
							{
								System.out.println("welcome "+M.get(i).getmname());
								System.out.println("Merchant Menu");
								System.out.println("1. Add item");
								System.out.println("2. Edit item");
								System.out.println("3. Search by category");
								System.out.println("4. Add offer");
								System.out.println("5. Rewards won");
								System.out.println("6. Exit");
								ansmm=input.nextInt();
								switch(ansmm)
								{
									case 1: 
										M.get(i).additem();
										for(int k=0;k<M.size();k++)
										{
										for(int j=0;j<M.get(k).getI().size();j++)
										{
										if(!cat.contains(M.get(k).getI().get(j).getcategory()));
										{
//											System.out.println(M.get(k).getI().get(j).getcategory());
										cat.add(M.get(k).getI().get(j).getcategory());
										
										}
										}
										}
										break;
									case 2: 
										M.get(i).edititem();
										break;
									case 3: 
										System.out.println("choose a category");
										

										int ccount=1;
										for(int j=0;j<cat.size();j++)
										{
										System.out.println(ccount+" "+cat.get(j));
										ccount++;
										}
										int anscat=input.nextInt();
										String catToSearch=cat.get(anscat-1);
										for(int k=0;k<M.size();k++)
										{
										for(int j=0;j<M.get(k).getI().size();j++)
										{
										if(M.get(k).getI().get(j).getcategory().equals(catToSearch))
										{
											M.get(k).getI().get(j).displayaddition();
										}
										}
										}


										break;

										
										
									case 4: 
										M.get(i).offers();
										break;
									case 5: 
										M.get(i).getmreward();
										
									case 6: break;
									default: 
										System.out.println("Error: Enter valid option");
										break;

								}
							}while(ansmm!=6);
						}
					}


					break;
				case 2:
					System.out.println("Choose Customer");
					for(int i=0;i<C.size();i++)
					{
						System.out.println(C.get(i).getccode() + " "+ C.get(i).getcname());
					}
					int ansc=input.nextInt();
					for(int i=0;i<C.size();i++)
					{
						if(C.get(i).getccode()==ansc)
						{
							int anscc=0;
							do
							{
								System.out.println("welcome "+C.get(i).getcname());
								System.out.println("Customer Menu");
								System.out.println("1. Search item");
								System.out.println("2. Checkout Item");
								System.out.println("3. Reward Won");
								System.out.println("4. Print Latest Orders");
								System.out.println("5. Exit");
								anscc=input.nextInt();
								switch(anscc)
								{
									case 1: 
//										
//										for(int k=0;k<M.size();k++)
//										{
//										for(int j=0;j<M.get(k).getI().size();j++)
//										{
////										if(!cat.contains(M.get(k).getI().get(j).getcategory()));
////										{
//////											System.out.println(M.get(k).getI().get(j).getcategory());
////										cat.add(M.get(k).getI().get(j).getcategory());
////										
////										}
//										}
//										}

										int ccount=1;
										for(int j=0;j<cat.size();j++)
										{
										System.out.println(ccount+" "+cat.get(j));
										ccount++;
										}
										System.out.println("choose a category");
										
										int anscat=input.nextInt();
										String catToSearch=cat.get(anscat-1);
										for(int k=0;k<M.size();k++)
										{
											for(int j=0;j<M.get(k).getI().size();j++)
											{
												if(M.get(k).getI().get(j).getcategory().equals(catToSearch))
												{
													M.get(k).getI().get(j).displayaddition();
												}
											}
										}
										
										System.out.println("Enter Item Code");
										int itemToBuy=input.nextInt();
										System.out.println("Enter Item Quantity");
										int itemQuant=input.nextInt();
										
										
										System.out.println("Choose Method of Transaction");
										System.out.println("1. Buy Item");
										System.out.println("2. Add Item To Cart");
										System.out.println("3. Exit");
										int transinp=input.nextInt();
										int trancount=1;
										if(transinp==1) 
										{
											for(int k=0;k<M.size();k++)
											{
												for(int j=0;j<M.get(k).getI().size();j++)
												{
													if(M.get(k).getI().get(j).geticode()==itemToBuy)
													{
//														System.out.println("Item Successfully bought11");
														if(M.get(k).getI().get(j).getqnt()>=itemQuant)
														{
//															System.out.println(C.get(i).);
															if(C.get(i).getmainAccbal()>=((M.get(k).getI().get(j).getprice())*(M.get(k).getI().get(j).getqnt())))
															{
																
																M.get(k).getI().get(j).setqnt(M.get(k).getI().get(j).getqnt()-itemQuant);
																item transItem=new item(trancount,M.get(k).getI().get(j).getiname(),M.get(k).getI().get(j).getprice(),itemQuant, M.get(k).getI().get(j).getcategory());
																C.get(i).Irecent.add(transItem);
																C.get(i).setmainAccbal(((M.get(k).getI().get(j).getprice())*(M.get(k).getI().get(j).getqnt())));
																C.get(i).setnoOfOrdersPlaced();
																System.out.println("Item Successfully bought");
															}
														}
													}
												}
											}
										}
										else if(transinp==2) 
										{
												
										}
										else if(transinp==3) 
										{
											
										}
									
										break;
										case 2: break;
										case 3: break;
										case 4: break;
										case 5: break;
										default: System.out.println("Enter valid option");
										break;
										}
							}while(anscc!=5);
							}}
										
					
				case 3: break;
				case 4: break;
				case 5: break;
				default: System.out.println("Enter valid option");
					break;
			}

		}while(ans!=5);
	}
}	
			