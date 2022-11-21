import java.util.Scanner;

public class T3 {
    static int[][] map=new int[220][220];

    final static double PI=3.14159265359;

    static void insert(int x,int y,int type){
        map[x][y]|=type;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();

        while (n-->0){
            int op=sc.nextInt(),x=sc.nextInt()+110,y=sc.nextInt()+110;
            if(op==1){
                insert(x,y,0b1100);
                insert(x,y-1,0b1001);
                insert(x-1,y,0b0110);
                insert(x-1,y-1,0b0011);
            }else{
                insert(x,y,0b1111);
                insert(x-1,y,0b1111);
                insert(x,y-1,0b1111);
                insert(x-1,y-1,0b1111);
            }
        }

        double[] table=new double[100];
        table[0b0011]=table[0b0101]=table[0b1001]=table[0b0110]=table[0b1010]=table[0b1100]=PI/4;
        table[0b0111]=table[0b1011]=table[0b1101]=table[0b1110]=PI/6+Math.sqrt(3)/4;
        table[0b1111]=1;

        double ans=0;
        for(int i=0;i<220;++i)
            for(int j=0;j<220;++j){
                ans+=table[map[i][j]];
            }
        System.out.printf("%.5f\n",ans);
    }
}
