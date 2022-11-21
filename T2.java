import java.util.Scanner;

public class T2 {

    static Scanner sc=new Scanner(System.in);

    static class Cell{
        int m,n;
        int[][] table;
        Cell(int m,int n){
            this.m=m;
            this.n=n;
            table=new int[m][n];
        }

        void read(){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    table[i][j]=sc.nextInt();
                }
            }
        }

        int isWhite(int x,int y){
            if(x<0||x>=m||y<0||y>=n)
                return 1;
            return 1-table[x][y];
        }

        int getSum(int x,int y){
            return isWhite(x-1,y)+isWhite(x,y-1)+isWhite(x+1,y)+isWhite(x,y+1);
        }
    }

    public static void main(String[] args) {
        int n=sc.nextInt(),ans=0;
        Cell x=new Cell(n,n);
        x.read();
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                if(x.isWhite(i,j)==0)
                    ans+=x.getSum(i,j);

        System.out.println(ans);
    }
}
