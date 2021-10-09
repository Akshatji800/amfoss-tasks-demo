import java.util.Scanner;
class Solution
{
    public static void checker()
    {
        Scanner sc=new Scanner(System.in);
        int length=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        char ch='a';
        int p=0,flag1=0,flag2=0;
        int result=0;
        for(int i=0;i<=length-1;i++)
        {
            ch=s.charAt(i);
            p=Character.getNumericValue(ch);
            if(p==0)
            {
                flag1++;
            }
            if(p==1)
            {
                flag2++;
            }
        }
        if(flag1!=flag2)
        {
            result=1;
            System.out.println(result);
        }
        else
        {
            if(flag1%2==0 && flag2%2==0)
            {
                result=2;
                System.out.println(result);
            }
            else
            {
                if(flag1%2==1 && flag2%2==1)
                {
                    result=2;
                    System.out.println(result);
                }
            }
        }
    } 
}        
