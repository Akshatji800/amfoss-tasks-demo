import java.util.Scanner;
import java.lang.Math.*;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int n=0;
        n=sc.nextInt();
        int paperreq[]=new int[n];
        int paperavail[]=new int[n];
        int result[]=new int[n];
        for(int i=0;i<n;i++)
        {
            paperreq[i]=sc.nextInt();
        }
        for(int j=0;j<n;j++)
        {
            paperavail[j]=sc.nextInt();
        }
        for(int k=0;k<n;k++)
        {
            result[k]=paperavail[k]/paperreq[k];
        }
        int fresult=result[0];
        for(int l=0;l<n;l++)
        {
            if(fresult>result[l])
            {
                fresult=result[l];
            }
        }
        System.out.println(fresult);
    }
}
