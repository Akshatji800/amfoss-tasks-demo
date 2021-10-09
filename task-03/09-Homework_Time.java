import java.util.Scanner;
class Solution
{
    public static void main(String[] args)
    {
        long mod=1000000007;
        Scanner sc=new Scanner(System.in);
        long result[]=new long[10000001];
        result[0]=1;
        result[1]=2;
        result[2]=3;
        int t=0;
        t=sc.nextInt();
        long n=0;
        long reverse=0;
        long p=0;
        int q=0;
        long fresult[]=new long[t];
        for(int i=3;i<10000001;i++)
        {
            result[i]=(result[i-1]+result[i-2]+result[i-3])%mod;
        }
        for(int j=0;j<t;j++)
        {
            q=sc.nextInt();
            n=result[q-1];
            while(n!=0)
            {
                p=n%10;
                reverse=(reverse*10)+p;
                n=n/10;
            }
            fresult[j]=reverse;
            reverse=0;
        }
        for(int w=0;w<t;w++)
        {
            System.out.println(fresult[w]);
        }
    }
}
