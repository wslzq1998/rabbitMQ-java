package com.lzq.leetcode.Number;

public class generateMatrix {
    public static int[][] generateMatrix(int n){
        int[][] cnt = new int[n][n];
        int i=0,j=0,k=1;
        int v = 0;
        while(k<=n*n){
            int ii=0;
            while(ii++<n-v){
                cnt[i][j++] = k++;
            }
            if(k==n*n+1) break;
            i++;
            j--;
            v++;
            int jj=0;
            while(jj++<n-v){
                cnt[i++][j] = k++;
            }
            if(k==n*n+1) break;
            i--;
            j--;
            int kk=0;
            while(kk++<n-v){
                cnt[i][j--] = k++;
                ii++;
            }
            if(k==n*n+1) break;
            i--;
            j++;
            v++;
            int ll=0;
            while(ll++<n-v){
                cnt[i--][j] = k++;
            }
            if(k==n*n+1) break;
            i++;
            j++;
        }
        return cnt;
    }

    public static void main(String[] args) {
        int[][] cnt = generateMatrix(20);
        for(int i=0;i<cnt.length;i++){
            for(int j=0;j<cnt[0].length;j++){
                System.out.print(cnt[i][j]+" ");
            }
            System.out.println();
        }
    }

}
