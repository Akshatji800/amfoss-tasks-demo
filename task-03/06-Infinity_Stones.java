import java.util.Scanner;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int tcases=sc.nextInt();
        sc.nextLine();
        int nmk[]=new int [3];
        int m[]=new int [10000];
        int mcap[]=new int [10000];
        int tester1=0;
        int tester2=0;
        int check[]=new int [10000];
        int f=0;
        int result[]= new int[tcases];
        for(int i=0;i<tcases;i++)
        {
            nmk[0]=sc.nextInt();
            nmk[1]=sc.nextInt();
            nmk[2]=sc.nextInt();
            sc.nextLine();
            for(int j=0;j<nmk[1];j++)
            {
                m[j]=sc.nextInt();
                tester1=m[j]+tester1;
            }
            sc.nextLine();
            for(int k=0;k<nmk[1];k++)
            {
                mcap[k]=sc.nextInt();
            }
            sc.nextLine();
            for(int y=0;y<mcap.length;y++)
            {
                for(int z=y+1;z<mcap.length;z++)
                {
                    if(mcap[y]<mcap[z])
                    {
                        f=mcap[y];
                        mcap[y]=mcap[z];
                        mcap[z]=f;
                    }
                }
            }
            for(int r=0;r<nmk[2];r++)
            {
                tester2=mcap[r]+tester2;
            }
            if(tester1<=tester2)
            {
                result[i]=1;
            }
            else
            {
                result[i]=0;
            }
            tester1=0;
            tester2=0;
        }
        for(int v=0;v<tcases;v++)
        {
            if(result[v]==1)
            {
                System.out.println("YES");
            }
            if(result[v]==0)
            {
                System.out.println("NO");
            }
        }
    }
}
                
                    
            
