import java.util.Scanner;

public class T1 {

    static Scanner sc= new Scanner(System.in);

    static class Matrix{
        int[][] val;
        int m,n;
        Matrix(int m,int n){
            this.m=m;
            this.n=n;
            val=new int[m][n];
        }

        Matrix(Matrix[] blk){
            m=blk[0].m*2;
            n=blk[0].n*2;
            val=new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = (i * 2 / m)*2 + (j * 2 / n);
                    val[i][j] = blk[id].val[i % (m / 2)][j % (n / 2)];
                }
            }
        }

        Matrix add(Matrix b){
            Matrix x=new Matrix(m,n);
            for(int i=0;i<m;++i)
                for (int j = 0; j < n; j++) {
                    x.val[i][j]=val[i][j]+b.val[i][j];
                }
            return x;
        }

        Matrix mul(Matrix b){
            Matrix x=new Matrix(m,m);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    for (int k = 0; k < n; k++) {
                        x.val[i][j]+=val[i][k]*b.val[k][j];
                    }
                }
            }
            return x;
        }

        Matrix transpose(){
            Matrix x=new Matrix(n,m);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    x.val[j][i]=val[i][j];
                }
            }
            return x;
        }

        Matrix neg(){
            Matrix x=new Matrix(m,n);
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    x.val[i][j]=-val[i][j];
                }
            }
            return x;
        }

        Matrix[] split() {
            Matrix[] res = new Matrix[4];
            for (int i = 0; i < 4; i++) {
                res[i] = new Matrix(m / 2, n / 2);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    int id = (i * 2 / m)*2 + (j * 2 / n);
                    res[id].val[i % (m / 2)][j % (n / 2)] = val[i][j];
                }
            }
            return res;
        }

        void read(){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    val[i][j]=sc.nextInt();
                }
            }
        }

        void print(){
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    System.out.printf("%d ",val[i][j]);
                }
                System.out.println("");
            }
        }
    }

    public static void main(String[] args) {
        int n=sc.nextInt();
        Matrix a=new Matrix(n,n);
        Matrix b=new Matrix(n,n);
        a.read();
        b.read();
        Matrix[] aBlock=a.split();
        Matrix[] bBlock=b.split();
        Matrix[] res={aBlock[0].add(bBlock[0]),aBlock[1].mul(bBlock[1].transpose()),
                      bBlock[2].mul(aBlock[2].transpose()),aBlock[3].add(bBlock[3].neg())};
        Matrix result=new Matrix(res);
        result.print();

    }
}

