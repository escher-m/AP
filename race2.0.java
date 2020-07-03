// Karishma Sinha 2018339
import java.util.*;
import java.io.*;
import java.lang.*;


//Inheritance
//polymorphism
//exception handling
//define own exceptions
public class race
{
	public static abstract class tile
	{
		protected String bf;
		//protected int toccur;
		protected int x;
		//protected int bite=0;
		//public abstract void message();
		public int retx()
		{
			return x;
		}
		public String retbf()
		{
			return bf;
		}
	}
	public static class Snake extends tile
	{
		public Snake(int _x)
		{
			//this.toccur=to;
			this.x=_x;
			this.bf="Backward";
		}
		// @Override
		// public void message()
		// {
		// 	System.out.println(">>>		Hiss...! I am a Snake, you can go back "+x+" tiles!");
		// }
	}
	public static class Vulture extends tile
	{
		public Vulture(int _x)
		{
			//this.toccur=to;
			this.x=_x;
			this.bf="Backward";
		}
		// @Override
		// public void message()
		// {
		// 	System.out.println(">>>		Yapping...! I am a Vulture, you can go back "+x+" tiles!");
		// }
	}
	public static class Cricket extends tile
	{
		public Cricket( int _x)
		{
			//this.toccur=to;
			this.x=_x;
			this.bf="Backward";
		}
		// @Override
		// public void message()
		// {
		// 	System.out.println(">>>		Chirp...! I am a Cricket, you can go back "+x+" tiles!");
		// }
	}
	public static class Trampoline extends tile
	{
		public Trampoline(int _x)
		{
			//this.toccur=to;
			this.x=_x;
			this.bf="Forward";
		}
		// @Override
		// public void message()
		// {
		// 	//System.out.println(">>>		");
		// 	System.out.println(">>>		PingPong! I am a Trampoline, you can advance "+x+" tiles!");
		// }
	}
	public static class White extends tile
	{
		public White()
		{
			//this.toccur=to;
			this.x=0;
			this.bf="None";
		}
		// @Override
		// public void message()
		// {
		// 	System.out.print("I am a White tile!");
		// }
	}
	static class SnakeBiteException extends RuntimeException
	{

	    public SnakeBiteException(String message)
	    {
	        super(message);
	    }
	}
	static class VultureBiteException extends RuntimeException
	{

	    public VultureBiteException(String message)
	    {
	        super(message);
	    }
	}
	static class CricketBiteException extends RuntimeException
	{

	    public CricketBiteException(String message)
	    {
	        super(message);
	    }
	}
	static class TrampolineException extends RuntimeException
	{

	    public TrampolineException(String message)
	    {
	        super(message);
	    }
	}
	static class GameWinnerException extends RuntimeException
	{

	    public GameWinnerException(String message)
	    {
	        super(message);
	    }
	}
	public static class Player implements Serializable
	{
		private int ptotaltiles;
		private String pname;
		private tile[] ptrack;
		private int pct=0;
		public Player(String pn, int ptt, tile[] pt)
		{
			this.pname=pn;
			this.ptotaltiles=ptt;
			this.ptrack=new tile[this.ptotaltiles];
			for(int i=0;i<ptotaltiles;i++)
			{
				this.ptrack[i]=pt[i];
			}
		}

		public int getpct()
		{
			return this.pct;
		}
		public String getpname()
		{
			return pname;
		}
		public void setpct(int ct)
		{
			this.pct=ct;
		}

	}

	public static void main(String[] args) throws Exception
	{
		Scanner input=new Scanner(System.in);
		ArrayList players=new ArrayList(Player)<>;

		boolean gameOngoing=true;
		System.out.println(">>> Enter total number of tiles on the racetrack (length)");
		int totalTiles=input.nextInt();
		System.out.println(">>> Setting up the race track...");
		Random rand = new Random(); 
        int ranS = rand.nextInt(totalTiles/4);
        int ranC = rand.nextInt(totalTiles/4);
        int ranV = rand.nextInt(totalTiles/4);
        System.out.println(">>> Danger: There are "+ranS+", "+ranC+", "+ranV+" numbers of Snakes, Cricket, and Vultures respectively on your track!");
        int ranT = rand.nextInt(totalTiles/4);
        System.out.println(">>> Good News: There are "+ranT+" number of Trampolines on your track!");
        int ranW=totalTiles-(ranS+ranC+ranV+ranT);
        int xS=rand.nextInt(totalTiles/10)+1;
        int xC=rand.nextInt(totalTiles/10)+1;
        int xV=rand.nextInt(totalTiles/10)+1;
        int xT=rand.nextInt(totalTiles/10)+1;
        System.out.println(">>> Good News: Each Trampoline can help you advance by "+xT+" number of Tiles");
        tile[] track= new tile[totalTiles];
        int[] checkWhite= new int[totalTiles];
        //white=1
        //snake=2
        //vulture=4
        //cricket=3
        //trampoline=5
        for(int i=0;i<totalTiles;i++)
        {
        	checkWhite[i]=1;
        }
        int assign=0;
        while(assign<ranS)
        {
        	int y=rand.nextInt(totalTiles);

        	if(checkWhite[y]==1)
        	{
        		track[y]=new Snake(xS);
        		assign++;
        		checkWhite[y]=2;
        	}

        }
        assign=0;
        while(assign<ranC)
        {
        	int y=rand.nextInt(totalTiles);

        	if(checkWhite[y]==1)
        	{
        		track[y]=new Cricket(xC);
        		assign++;
        		checkWhite[y]=3;
        	}

        }
        assign=0;
        while(assign<ranV)
        {
        	int y=rand.nextInt(totalTiles);

        	if(checkWhite[y]==1)
        	{
        		track[y]=new Vulture(xV);
        		assign++;
        		checkWhite[y]=4;
        	}

        }
        assign=0;
        while(assign<ranT)
        {
        	int y=rand.nextInt(totalTiles);

        	if(checkWhite[y]==1)
        	{
        		track[y]=new Trampoline(xT);
        		//track[y]=
        		assign++;
        		checkWhite[y]=5;
        	}

        }
        for(int i=0;i<totalTiles;i++)
        {
            if(checkWhite[i]==1)
            {
               track[i]=new White(); 
            }
        }
        System.out.println(">>> Enter Player Name");
        String name=input.next();
        boolean found =false;
        for(int i=0;i<players.size();i++)
		{
						//System.out.println(M.get(i).getmcode() + M.get(i).getmname());
			if(players.get(i).getpname().equals(name))
			{
				found=true;
				FileInputStream fis=new FileInputStream(f);
				ObjectInputStream ois=new ObjectInputStream(fis);
				Player p=(Player)ois.readObject();

			}
		}
		if(found==false)
		{
			Player p=new Player(name,totalTiles,track);
			players.add(p);
		}


        System.out.println(">>> Starting the game with "+name+" at Tile-1");
        System.out.println(">>> Control transferred to Computer for rolling the Dice for "+name);
        System.out.println(">>> Hit enter to start the game");
        //find out enter fn
        System.out.println(">>> Game Started ===================================>");
        int croll=0;
        int ctile=1;
        int roll;
        int tsb=0;
        int tcb=0;
        int tvb=0;
        int tt=0;
        boolean pass25=false;
        boolean pass50=false;
        boolean pass75=false;
		while(gameOngoing)
		{
			roll=rand.nextInt(6)+1;
			croll++;
			if(ctile==1)
			{
				if(roll!=6)
				{
					System.out.println(">>>[Roll-"+croll+"]: "+name+" rolled "+roll+" at Tile-"+ctile+", OOPs you need 6 to start");
					//croll++;
				}
				else
				{
					System.out.println(">>>[Roll-"+croll+"]: "+name+" rolled "+roll+" at Tile-"+ctile+". You are out of the cage! You get a free roll");
					//croll++;
					roll=rand.nextInt(6)+1;
					croll++;
					int newctile=ctile+roll;
					System.out.println(">>>[Roll-"+croll+"]: "+name+" rolled "+roll+" at Tile-"+ctile+", landed on Tile "+newctile);
					ctile+=roll;
				}
			}
			else
			{
				int newctile=ctile+roll;
				System.out.println(">>>[Roll-"+croll+"]: "+name+" rolled "+roll+" at Tile-"+ctile+", landed on Tile "+newctile);
					ctile+=roll;
			}
			if(ctile!=1)
			{
				if(ctile>=totalTiles)
				{
					System.out.println(">>>		"+name+" moved to Tile-"+totalTiles);
					System.out.println(">>>		"+name+" wins the race in "+croll+" rolls!");
					System.out.println(">>>		Total Snake Bites= "+tsb);
					System.out.println(">>>		Total Vulture Bites= "+tvb);
					System.out.println(">>>		Total Cricket Bites= "+tcb);
					System.out.println(">>>		Total Trampolines= "+tt);
					gameOngoing=false;
					//System.out.println()
				}
				else
		        {
		            System.out.println(">>>		Trying to shake Tile-"+ctile);
    				//System.out.println(">>>		");
    				//System.out.println(track[ctile-1].retx());
    				if(track[ctile-1] instanceof Snake)
    				{
    					try
    					{
    						throw new SnakeBiteException(">>>		Hiss...! I am a Snake, you can go back "+xS+" tiles!");
    					}
    					catch(RuntimeException e)
    					{
    						System.out.println(e.getMessage());
    					}
    				}
    				else if(track[ctile-1] instanceof Vulture)
    				{
    					try
    					{
    						throw new VultureBiteException(">>>		Yapping...! I am a Vulture, you can go back "+xV+" tiles!");
    					}
    					catch(RuntimeException e)
    					{
    						System.out.println(e.getMessage());
    					}
    				}
    				else if(track[ctile-1] instanceof Cricket)
    				{
    					try
    					{
    						throw new CricketBiteException(">>>		Chirp...! I am a Cricket, you can go back "+xC+" tiles!");
    					}
    					catch(RuntimeException e)
    					{
    						System.out.println(e.getMessage());
    					}
    				}
    				else if(track[ctile-1] instanceof Trampoline)
    				{
    					try
    					{
    						throw new TrampolineException(">>>		PingPong! I am a Trampoline, you can advance "+xT+" tiles!");
    					}
    					catch(RuntimeException e)
    					{
    						System.out.println(e.getMessage());
    					}
    				}
    				//track[ctile-1].message();
    				if(checkWhite[ctile-1]==2)
    					tsb++;
    				else if(checkWhite[ctile-1]==3)
    					tcb++;
    				else if(checkWhite[ctile-1]==4)
    					tvb++;
    				else if(checkWhite[ctile-1]==5)
    					tt++;
    				if(track[ctile-1].retbf().equals("Backward"))
    				{
    					if(track[ctile-1].retx()>=ctile)
    					{
    						ctile=1;
    					}
    					else
    					{
    						ctile-=track[ctile-1].retx();
    					}
    					//ctile-=track[ctile-1].retx();
    				}
    				else
    				{
    					ctile+=track[ctile-1].retx();
    				}
    				if(ctile>=totalTiles)
    				{
    					System.out.println(">>>		"+name+" moved to Tile-"+totalTiles);
    					System.out.println(">>>		"+name+" wins the race in "+croll+" rolls!");

    					System.out.println(">>>		Total Snake Bites= "+tsb);
    					System.out.println(">>>		Total Vulture Bites= "+tvb);
    					System.out.println(">>>		Total Cricket Bites= "+tcb);
    					System.out.println(">>>		Total Trampolines= "+tt);
    					gameOngoing=false;
    					//System.out.println()
    					try
    					{
    						throw new GameWinnerException(">>>		"+name+" wins the race in "+croll+" rolls!");
    					}
    					catch(RuntimeException e)
    					{
    						System.out.println(e.getMessage());
    					}
    				}
    				else
    				System.out.println(">>>		"+name+" moved to Tile-"+ctile);
    				if(ctile>=.25*totalTiles&&pass25==false)
    				{
    					pass25=true;
    					System.out.println(">>> 1. Continue");
    					System.out.println("    2. Save");
    					int cos=input.nextInt();
    					if(cos==2)
    					{
    						//players.add(name);
    						p.setpct(ctile);
    						File f=new File("gamestatus.txt");
    						FileOutputStream fos=new FileOutputStream(f);
    						ObjectOutputStream oos= new ObjectOutputStream(fos);
    						oos.writeObject(p);
    						gameOngoing=false;
    						break;
    					}

    				}
    				else if(ctile>=.50*totalTiles&&pass50==false)
    				{
    					pass50=true;
    					System.out.println(">>> 1. Continue");
    					System.out.println("    2. Save");
    					int cos=input.nextInt();
    					if(cos==2)
    					{
    						//players.add(name);
    						p.setpct(ctile);
    						File f=new File("gamestatus.txt");
    						FileOutputStream fos=new FileOutputStream(f);
    						ObjectOutputStream oos= new ObjectOutputStream(fos);
    						oos.writeObject(p);
    						gameOngoing=false;
    						break;
    					}
    					
    				}
    				else if(ctile>=.75*totalTiles&&pass75==false)
    				{
    					pass75=true;
    					System.out.println(">>> 1. Continue");
    					System.out.println("    2. Save");
    					int cos=input.nextInt();
    					if(cos==2)
    					{
    						//players.add(name);
    						p.setpct(ctile);
    						File f=new File("gamestatus.txt");
    						FileOutputStream fos=new FileOutputStream(f);
    						ObjectOutputStream oos= new ObjectOutputStream(fos);
    						oos.writeObject(p);
    						gameOngoing=false;
    						break;
    					}
    					
    				}

		        }
				
			}
			
		}
	}
	
}