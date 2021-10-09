import java.util.Scanner;
class Solution
{
    public static void main(String[] args)
    {
        int nm[]=new int[2];
        Scanner sc=new Scanner(System.in);
        for(int a=0;a<2;a++)
        {
            nm[a]=sc.nextInt();
        }
        int n=nm[0];
        boolean flag=false;
        int temp=0;
        int c[]=new int[n];
        for(int i=0;i<n;i++)
        {
           c[i]=sc.nextInt();
        }
        for(int j=0;j<n;j++)
        {
            temp=nm[1]-c[j];
            for(int k=0;k<n;k++)
            {
                if(temp==c[k])
                {
                    flag=true;
                }
            }
            if(flag)
            {
                break;
            }
        }
        if(flag)
        {
            System.out.println("True");
        }
        else
        {
            System.out.println("False");
        }
    }
}
 
