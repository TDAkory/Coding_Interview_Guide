package _04_Recursion.and.DP;

/* O(logN)计算Fabonacci
 * 暴力递归： return F(n-1)+F(n+2) 复杂度：O(N^2)
 * 顺序求值： 复杂度：O(N)
 * O(logN) 矩阵乘法 (F(n),F(n-1))=(F(n-1),F(n-2))*R    R={(1,1),(1,0)}
 * 因此需要求解矩阵乘方，O(logN) 解乘方
 * */
public class _01_Fibonacci {
	
	/*矩阵m的p次方，复杂度O(logN) */
	public  int[][] matrixPower(int[][] m, int p){
		int[][] res = new int[m.length][m[0].length];
		//res为单位矩阵
		for(int i=0;i<res.length;i++){
			res[i][i]=1;
		}
		int[][] tmp = m;
		for(;p!=0;p>>=1){
			if((p&1)!=0){
				res = muliMatrix(res,tmp);
			}
			tmp = muliMatrix(tmp,tmp);
		}
		return res;
	}
	
	//计算矩阵乘积
	public int[][] muliMatrix(int[][] n1,int [][] n2){
		int[][] res = new int[n1.length][n2[0].length];
		for(int i=0;i<n1.length;i++){
			for(int j=0;j<n2.length;j++){
				for(int k=0;k<n2.length;k++){
					res[i][j] += n1[i][k]*n2[k][j];
				}
			}
		}
		return res;
	}

}
