import java.util.Scanner;

public class T4 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int m=sc.nextInt(),n=sc.nextInt();
        int[][] x=new int[m][n];
        boolean[][] reg=new boolean[m+2][n+2];

        for (int i = 0; i <= m+1; i++) {
            reg[i][0]=reg[i][n+1]=true;
        }

        for (int i = 0; i <= n+1; i++) {
            reg[0][i]=reg[m+1][i]=true;
        }

        int cnt=m*n,px=1,py=1,direction=0;
        int[] dx={1,0,-1,0},dy={0,1,0,-1};

        while(cnt-->0){
            x[px-1][py-1]=sc.nextInt();
            reg[px][py]=true;
            if(reg[px+dx[direction]][py+dy[direction]])
                direction=(direction+1)%4;
            px+=dx[direction];
            py+=dy[direction];
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%d ",x[i][j]);
            }
            System.out.println("");
        }
    }
}
