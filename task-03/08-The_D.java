import java.util.Scanner;
public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();                                                           
        int x=n/2;
        char[][] a=new char[x][n];
        for(int i=0;i<x;i++)
        for(int j=0;j<n;j++)
        //if(i!=(n/2))
        a[i][j]='*';
        //else 
        //a[i][j]='D';
        int y=n-1;
   
        for(int i=0;i<x;i++)
        {
            int k=1;
            y=n/2-i;
            for(int j=0;j<n&&k<=(2*i+1);j++)
            { 
                a[i][y]='D';
                k++;
                y++;
            }
        }
        for(int i=0;i<x;i++)
        {
            for(int j=0;j<n;j++)
            System.out.print(a[i][j]);
            System.out.println();
        }
        for(int i=0;i<n;i++)
        System.out.print("D");
        for(int i=x-1;i>=0;i--)
        {
            System.out.println();
            for(int j=0;j<n;j++)
            System.out.print(a[i][j]);
        }
    } 
}
