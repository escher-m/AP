// Karishma Sinha 2018339
import java.util.*;
import java.io.*;
import java.lang.*;

public class archlegends
{
	
	public class GFG  
	{ 
    // A user define class to represent a graph. 
    // A graph is an array of adjacency lists. 
    // Size of array will be V (number of vertices  
    // in graph) 
    static class Graph 
    { 
        int V=11; 
        LinkedList<Integer> adjListArray[]; 
          
        // constructor  
        Graph(int V) 
        { 
            this.V = V; 
              
            // define the size of array as  
            // number of vertices 
            adjListArray = new LinkedList[V]; 
              
            // Create a new list for each vertex 
            // such that adjacent nodes can be stored 
            for(int i = 0; i < V ; i++){ 
                adjListArray[i] = new LinkedList<>(); 
            } 
        } 
    } 
      
    // Adds an edge to an undirected graph 
    static void addEdge(Graph graph, int src, int dest) 
    { 
        // Add an edge from src to dest.  
        graph.adjListArray[src].add(dest); 
          
        // Since graph is undirected, add an edge from dest 
        // to src also 
        graph.adjListArray[dest].add(src); 
    } 
       
    // A utility function to print the adjacency list  
    // representation of graph 
    static void printGraph(Graph graph) 
    {        
        for(int v = 0; v < graph.V; v++) 
        { 
            System.out.println("Adjacency list of vertex "+ v); 
            System.out.print("head"); 
            for(Integer pCrawl: graph.adjListArray[v]){ 
                System.out.print(" -> "+pCrawl); 
            } 
            System.out.println("\n"); 
        } 
    } 
       
    // Driver program to test above functions 
    // public static void main(String args[]) 
    // { 
    //     // create the graph given in above figure 
    //     int V = 5; 
    //     Graph graph = new Graph(V); 
    //     addEdge(graph, 0, 1); 
    //     addEdge(graph, 0, 4); 
    //     addEdge(graph, 1, 2); 
    //     addEdge(graph, 1, 3); 
    //     addEdge(graph, 1, 4); 
    //     addEdge(graph, 2, 3); 
    //     addEdge(graph, 3, 4); 
       
    //     // print the adjacency list representation of  
    //     // the above graph 
    //     printGraph(graph); 
    // } 
} 

	public void creategraph()
	{

	}
	abstract class hero
	{
		protected String username;
		protected int level=1;
		protected int xp=0;
		protected double hp=100;
		protected int moves=0;
		protected double aa;
		protected double da;
		public boolean isSpPowOn()
		{

		}
		public void attack(moster m);
		public void defense();
		public void spPower();
		public void levelUp()
		{
			if(xp==20)
			{
				level=2;
				hp=150;
				this.aa+=1;
				this.da+=1;
			}
			else if(xp==40)
			{
				level=3;
				hp=200;
				this.aa+=1;
				this.da+=1;
			}
			else if(xp==60)
			{
				level=4;
				hp=250;
				this.aa+=1;
				this.da+=1;
			}
		}
	}
	class warrior extends hero
	{
		public warrior(String name)
		{
			this.username=name;
			this.aa=10;
			this.da=3;

		}
		@Override
		public void attack(monster m)
		{
			m.hp-=aa;
		}
		@Override
		public void defense()
		{
			this.hp+=da;
		}
		@Override
		public void spPower()
		{
			
			m.hp-=(aa+5);
			this.hp+=(da+5);
		}
	}
	class mage extends hero
	{
		public mage(String name)
		{
			this.username=name;
			this.aa=5;
			this.da=5;

		}
		@Override
		public void attack(monster m)
		{
			m.hp-=this.aa;
		}
		@Override
		public void defense()
		{
			this.hp+=this.da;
		}
		@Override
		public void spPower()
		{
			m.hp-=m.hp*0.05;
		}
	}
	class thief extends hero
	{
		public thief(String name)
		{
			this.username=name;
			this.aa=6;
			this.da=4;

		}
		@Override
		public void attack(monster m)
		{
			m.hp-=this.aa;
		}
		@Override
		public void defense()
		{
			this.hp+=this.da;
		}
		@Override
		public void spPower()
		{
			this.hp+=m.hp*0.3;
			m.hp-=m.hp*0.3;
		}
	}
	class healer extends hero
	{
		public healer(String name)
		{
			this.username=name;
			this.aa=4;
			this.da=8;

		}
		@Override
		public void attack(monster m)
		{
			m.hp-=this.aa;
		}
		@Override
		public void defense()
		{
			this.hp+=this.da;
		}
		@Override
		public void spPower()
		{
			this.hp+=this.hp*0.05;
		}
	}
	abstract class monster
	{
		//protected double;
		protected double mhp;
		protected int levelm;
		protected int positionNode;
		public void attackm(hero h)
		{
			Random rand = new Random();
			double x=rand.nextGaussian(this.mhp*0.26);
			h.hp-=x*this.mhp;
		} 
	}
	class goblin extends monster
	{
		public goblin()
		{
			this.level=1;
			this.mhp=100;
		}
	}
	class zombie extends monster
	{
		public zombie()
		{
			this.level=2;
			this.mhp=100;
		}
	}
	class fiend extends monster
	{
		public fiend()
		{
			this.level=3;
			this.mhp=200;
		}
	}
	class lionfang extends monster
	{
		public lionfang()
		{
			this.level=4;
			this.mhp=250;
		}
		public void attackm(hero h)
		{
			Random rand = new Random();
			int x=rand.nextInt(10);
			if(x==0)
			{
				h.hp/=2;
			}
			
		}
	}

	public static void main(String[] args)
	{
		String usern;
		Scanner input=new Scanner(System.in);
		ArrayList<String> Players=new ArrayList<>();
		
		do
		{
			System.out.println("Welcome to ArchLegends");
			System.out.println("Choose your option");
			System.out.println("1. New User");
			System.out.println("2. Existing User");
			System.out.println("3. Exit");
			
			int ans=input.nextInt();
			switch(ans)
			{
				case 1: 
					System.out.println("Enter Username");
					
					usern=input.next();
					Players.add(usern);
					System.out.println("Choose a Hero");
					System.out.println("1. Warrior");
					System.out.println("2. Thief");
					System.out.println("3. Mage");
					System.out.println("4. Healer");
					int heron=input.nextInt();
					if(heron==1)
					{
						warrior h=new warrior(usern);
						System.out.println("User Creation done. Username: "+ usern+". Hero type: "+"Warrior"+". Log in to play the game. Exiting");
					}
					else if(heron==2)
					{
						thief h=new thief(usern);
						System.out.println("User Creation done. Username: "+ usern+". Hero type: "+"Thief"+". Log in to play the game. Exiting");
					}
					else if(heron==3)
					{
						mage h=new mage(usern);
						System.out.println("User Creation done. Username: "+ usern+". Hero type: "+"Mage"+". Log in to play the game. Exiting");
					}
					else if(heron==4)
					{
						healer h=new healer(usern);
						System.out.println("User Creation done. Username: "+ usern+". Hero type: "+"Healer"+". Log in to play the game. Exiting");
					}
					//System.out.println("User Creation done. Username: "+ usern+". Hero type: "++". Log in to play the game. Exiting");
					break;
					
				case 2: 
					System.out.println("Enter Username");
					usern=input.next();
					for(int i=0;i<Players.size();i++)
					{
						if(Players.get(i).equals(usern))
						{
							System.out.println("User Found... logging in");
							System.out.println("Welcome "+M.get(i));
							System.out.println("You are at the starting location. Choose path:");
							creategraph();
						}
						
					}
					break;
				case 3: break;
				case 4: break;
				case 5: break;
				default: System.out.println("Enter valid option");
					break;
			}

		}
	}
}