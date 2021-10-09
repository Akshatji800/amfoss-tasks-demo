import java.util.Scanner;
import java.io.*;
import java.lang.Math.*;
class Task12
{
    int b=0;
    int c=0;
    double l1=0;
    double r1=(Math.PI)/2;
    public double tasker(double x)
    {
        return (x*x + b*x + c)/Math.sin(x);

    }
    double finder(double left, double right) 
    {
    double mid = (left + right)/2;
    double ans = tasker(mid);
    double ansl = tasker(mid - 0.0000001);
    double ansr = tasker(mid + 0.0000001);
    if(ansl < ans) 
    {
        if(Math.abs(ansl - ans) <= 0.0000000000001)
        {
            return ans;
        }
        return finder(left, mid);
    }
    else
    {
        if(Math.abs(ansr - ans) <= 0.0000000000001)
        {
            return ans;
        }
        return finder(mid, right);
    }
}
    public void main()
    {
        double result=0;
        Scanner input1=new Scanner(System.in);
        int cases=input1.nextInt();
        while(cases!=0)
        {
            b=input1.nextInt();
            c=input1.nextInt();
            result=finder(l1,r1);
            cases=cases-1;
            System.out.println(result);
        }
    }
}
class Main
{
    public static void main(String[] args)throws IOException
    {
        Task12 a=new Task12();
        a.main();
    }
}
