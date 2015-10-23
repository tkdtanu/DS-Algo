package com.algo;

// you can also use imports, for example:
//import java.util.*;

//you can write to stdout for debugging purposes, e.g.
//System.out.println("this is a debug message");

class Noofisland {
static int temp=0;
public static int solution(int[][] A) {
   // write your code in Java SE 8
   final boolean[][] visited=new boolean[A.length][A[0].length];
   int count=0;
   for(int row=0;row<A.length;row++){
       for(int col=0;col<A[0].length;col++){
           temp=A[row][col];
           if(A[row][col]==temp && !visited[row][col]){
               dfs(row,col,A,visited);
               count++;
           }
       }
       temp=(int)Math.random();
   }
   return count;
}
static void dfs(int row,int col,int[][]A,boolean[][]visited){
   if(row<0 ||row>=A.length ||col<0 || col>=A[0].length){
       return;
   }
   if(visited[row][col]){
       return;
   }
   
   if(temp!=A[row][col]){
       return;
   }
   visited[row][col]=true;
   for(Direction direction:Direction.values()){
       dfs(row+direction.getRowDelta(),col+direction.getColDelta(),A,visited);
   }
}
static enum Direction{
   N(0,-1),E(0,1),S(1,0),W(-1,0);
   int rowDelta;
   int colDelta;
   Direction(int rowDelta,int colDelta){
       this.rowDelta=rowDelta;
       this.colDelta=colDelta;
   }
   public int getRowDelta(){
       return rowDelta;
   }
   public int getColDelta(){
       return colDelta;
   }
}
public static void main(String[] args) {
	 int[][] A={{5, 4, 4}, {4, 3, 4}, {3, 2, 4}, {2, 2, 2}, {3, 3, 4}, {1, 4, 4}, {4, 1, 1}};
	 System.out.println(solution(A));
}
}
