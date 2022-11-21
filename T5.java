import java.util.Scanner;

public class T5 {
    static int[][] map;
    static int[][][] upCnt,downCnt;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        map=new int[n][n];
        upCnt=new int[n][n][4];
        downCnt=new int[n][n][4];

        int[] dx={0,-1,-1,-1};
        int[] dy={-1,-1,0,1};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j]=sc.nextInt();
            }
        }

        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for(int k=0;k<4;++k)
                    if(i+dx[k]<n&&i+dx[k]>=0&&j+dy[k]>=0&&j+dy[k]<n)
                        if(map[i+dx[k]][j+dy[k]]==1)
                            upCnt[i][j][k]=upCnt[i+dx[k]][j+dy[k]][k]+1;
        for (int i = n-1; i >=0; --i)
            for (int j = n-1; j >=0; --j)
                for(int k=0;k<4;++k)
                    if(i-dx[k]<n&&i-dx[k]>=0&&j-dy[k]>=0&&j-dy[k]<n)
                        if(map[i-dx[k]][j-dy[k]]==1)
                            downCnt[i][j][k]=downCnt[i-dx[k]][j-dy[k]][k]+1;
        int cnt=0;
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                for(int k=0;k<4;++k)
                    if(map[i][j]==0&&upCnt[i][j][k]+downCnt[i][j][k]>=4){
                        System.out.printf("%d %d\n",i+1,j+1);
                        cnt++;
                        break;
                    }
        if(cnt==0)
            System.out.println(-1);
    }
}
