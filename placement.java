// Karishma Sinha 2018339
import java.util.*;
import java.io.*;
import java.lang.*;

public class placement
{
	
	public static boolean check_all_placed(ArrayList<Student> student_list)
	{
		boolean collective_placement_status=true;
		for(int i=0;i<student_list.size();i++)
		{
			if(student_list.get(i).get_isPlaced()==false)
			{
				collective_placement_status=false;
				break;
			}
		}
		return collective_placement_status;
	}



	public static class Student
	{
		private final int roll;
		private final float cgpa;
		private final String stream;
		private boolean isPlaced;
		private String placed_in_company;

		public Student(float c,String s,int r)
		{
			this.cgpa=c;
			this.stream=s;
			this.roll=r;
			this.isPlaced=false;
		}

		public float get_cgpa()
		{
			return this.cgpa;
		}
		public int get_roll()
		{
			return this.roll;
		}
		public String get_stream()
		{
			return this.stream;
		}
		public boolean get_isPlaced()
		{
			return this.isPlaced;
		}
		public void set_isPlaced(boolean b)
		{
			this.isPlaced=b;
		}
		public void set_placed_in_company(String comp)
		{
			this.placed_in_company=comp;
		}

		public String get_placed_in_company()
		{
			return this.placed_in_company;
		}

		public void display_details()
		{
			System.out.println(this.roll);
			System.out.println(this.cgpa);
			System.out.println(this.stream);
			if(this.isPlaced==false)
			{
				System.out.println("Placement Status: Not Placed");
			}
			else
			{
				System.out.println("Placement Status: Placed");
				System.out.println(this.placed_in_company);

			}
		}
	}

	public static class Company
	{
		private final String name;
		private final int no_of_courses;
		private String[] eligible_courses;
		private int req_students;
		//private int[] scores;
		private ArrayList<student_marks> m;
		private String app_status;


		public Company(String nm,int nc, String[] ec, int rs)
		{
			this.name= nm;
			this.no_of_courses=nc;
			this.eligible_courses=ec;
			this.req_students=rs;
			this.app_status="OPEN";
		}
		public int get_noc()
		{
			return this.no_of_courses;
		}
		public String get_name()
		{
			return this.name;
		}
		public int get_req_students()
		{
			return this.req_students;
		}
		public String[] get_courses()
		{
			return this.eligible_courses;
		}
		// public void set_scores(int[] eligible_scores)
		// {
		// 	this.scores=eligible_scores;
		// }
		public void set_marks(ArrayList<student_marks> mm)
		{
			this.m= mm;
		}
		public String get_app_status()
		{
			return this.app_status;
		}
		public ArrayList<student_marks> get_tech_marks()
		{
			return this.m;
		}
		public void display_company_details()
		{
			System.out.println(this.name);
			System.out.println("Course Criteria");
			//System.out.println("Number Of Eligible Courses= "+this.no_of_courses);
			for(int i=0;i<this.no_of_courses;i++)
			{
				System.out.println(this.eligible_courses[i]);
			}
			System.out.println("Number Of Required Students = "+ this.req_students);
			System.out.println("Application Status= "+this.get_app_status());
			

			// if(this.isPlaced==false)
			// {
			// 	System.out.println("Placement Status: Not Placed");
			// }
			// else
			// {
			// 	System.out.println("Placement Status: Placed");
			// 	System.out.println(this.placed_in_company);

			// }
		}
		public ArrayList<student_marks> sort_marks()
		{
			int max=-1;
			for (int i = 0; i < m.size()-1; i++)
	        {
	            
	            int max_idx = i;
	            for (int j = i+1; j < m.size(); j++)
	            	if (m.get(j).get_m() == m.get(max_idx).get_m())
	            	{
	            		if(m.get(j).get_cgpa1()> m.get(max_idx).get_cgpa1())
	            			max_idx=j;
	            	}
	                else if (m.get(j).get_m()> m.get(max_idx).get_m())
	                    max_idx = j;
	 
	            
	            Collections.swap(m,max_idx,i);
	        }
			return m;
		}
			
		public void place_students(ArrayList<Student> sl)
		{
			ArrayList<student_marks> sortedm= sort_marks();
			if(req_students<=sortedm.size())
			{
				for(int i=0;i<req_students;i++)
				{
					for(int j=0;j<sl.size();j++)
					{
						if(sortedm.get(i).get_roll1()==sl.get(j).get_roll())
						{
							sl.get(j).set_isPlaced(true);
							sl.get(j).set_placed_in_company(name);
						}
					}
					
				}
				app_status="CLOSED";
			}
		}
	}


	public static class student_marks
	{
		private final int roll1;
		private final float cgpa1;
		private int marks1;

		//public void sort_marks(int num)
		public student_marks(int r1,float c1,int m1)
		{
			this.roll1=r1;
			this.cgpa1=c1;
			this.marks1=m1;
		}
		public int get_m()
		{
			return this.marks1;
		}
		public int get_roll1()
		{
			return this.roll1;
		}
		public float get_cgpa1()
		{
		    return this.cgpa1;
		}

	}


	public static void main(String[] args)
	{
	 	Scanner input=new Scanner(System.in);
	 	int n=input.nextInt();
	 	int roll_count=1;
	 	ArrayList<Student> l= new ArrayList<>();
	 	for(int i=0;i<n;i++)
	 	{
	 		float student_cgpa=input.nextFloat();
	 		String student_stream=input.next();
	 		int student_roll=roll_count;
	 		roll_count++;
	 		Student s = new Student(student_cgpa,student_stream,student_roll);
	 		l.add(s);
	 	} 
	 	List<Company> comp_list= new ArrayList<>();
	 	boolean all_placed=check_all_placed(l);
	 	do
	 	{
	 		
	 		int queryNo=input.nextInt();
	 		if(queryNo==8)
	 		{
	 			int displayRoll=input.nextInt();
	 			for(int i=0;i<l.size();i++)
				{
					if(l.get(i).get_roll()==displayRoll)
					{
						l.get(i).display_details();
						break;
					}
				}
	 		}
	 		else if(queryNo==1)
	 		{
	 			String cnm=input.next();
	 			System.out.print("Number Of Eligible Courses= ");
	 			int noec=input.nextInt();
	 			String[] course_names= new String[noec];
	 			//int[] eligible_students= new int[l.size()+1];
	 			//eligible_students[0]=-1;
	 			ArrayList<student_marks> sm=new ArrayList<>();
	 			for(int i=0;i<noec;i++)
	 			{
	 				course_names[i]=input.nextLine();
	 			}

	 			System.out.print("Number Of Required Students= ");
	 			int nors=input.nextInt();
	 			Company c= new Company(cnm,noec,course_names,nors);
	 			comp_list.add(c);
	 			c.display_company_details();

	 			System.out.print("Enter scores for technical round.");
	 			for(int k=0;k<noec;k++)
	 			{
	 				for(int j=0;j<l.size();j++)
					{
						if(l.get(j).get_stream()==course_names[k])
						{
							//eligible_students[j+1]=l;
							System.out.print("Enter score for Roll no. "+l.get(j).get_roll());
							int mrk=input.nextInt();
							student_marks obj= new student_marks(l.get(j).get_roll(),l.get(j).get_cgpa(),mrk);
							sm.add(obj);
						}
					}
	 			}
	 			c.set_marks(sm);
	 			c.place_students(l);
	 		}
	 		else if(queryNo==5)
	 		{
	 			for(int i=0;i<comp_list.size();i++)
	 			{
	 				if(comp_list.get(i).get_app_status()=="OPEN")
	 				{
	 					System.out.println(comp_list.get(i).get_name());
	 				}
	 			}
	 		}
	 		else if(queryNo==4)
	 		{
	 			int count=0;
	 			for(int i=0;i<l.size();i++)
	 			{
	 				if(l.get(i).get_isPlaced()==false)
	 				{
	 					count++;
	 					//System.out.println(comp_li.get(i).name);
	 				}
	 			}
	 			System.out.println(count+" students left.");
	 		}
	 		else if(queryNo==7)
	 		{
	 			String comp_to_display=input.next();
	 			for(int i=0;i<comp_list.size();i++)
	 			{
	 				if(comp_list.get(i).get_name()==comp_to_display)
	 				{
	 					comp_list.get(i).display_company_details();
	 				}
	 			}
	 		}
	 		else if(queryNo==9)
	 		{
	 			int roll_to_check=input.nextInt();
	 			int check=-1;
	 			for(int i=0;i<l.size();i++)
	 			{
	 				if(l.get(i).get_roll()==roll_to_check)
	 				{
	 					check=1;
	 					break;
	 				}
	 			}
	 			if(check==-1)
	 			{
	 				System.out.println("No student with the given roll number has an account");
	 			}
	 			for(int i=0;i<comp_list.size();i++)
	 			{
	 				for(int j=0;j<comp_list.get(i).get_tech_marks().size();j++)
	 				{
	 					if(comp_list.get(i).get_tech_marks().get(j).get_roll1()==roll_to_check)
	 					{
	 						System.out.println(comp_list.get(i).get_name() + comp_list.get(i).get_tech_marks().get(j).get_m());
	 					}
	 				}
	 			
	 			}
	 		}
	 		else if(queryNo==6)
	 		{
	 			String comp_students=input.next();
	 			for(int i=0;i<l.size();i++)
	 			{
	 				if(l.get(i).get_placed_in_company()==comp_students)
	 				{
	 					System.out.println(l.get(i).roll);
	 				}
	 			}
	 		}
	 		else if(queryNo==2)
	 		{
	 			System.out.println("Accounts removed for ");
	 			for(int i=0;i<l.size();i++)
	 			{
	 				if(l.get(i).get_isPlaced()==true)
	 				{
	 					System.out.println(l.get(i).get_roll());
	 					l.remove(i);
	 				}
	 			}
	 		}
	 		else if(queryNo==3)
	 		{
	 			System.out.println("Accounts removed for ");
	 			for(int i=0;i<comp_list.size();i++)
	 			{
	 				if(comp_list.get(i).get_app_status()=="CLOSED")
	 				{
	 					System.out.println(comp_list.get(i).get_name());
	 					l.remove(i);
	 				}
	 			}
	 		}
	 		else
	 		{
	 			System.out.println("Enter valid query");
	 		}

            all_placed=check_all_placed(l);
	 	}while(all_placed==false);
	}
}
