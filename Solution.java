import java.util.*;

class Solution {

	private class MyQueue{
		int[] mData = new int[20100];
		int mHead = 0;
		int mTail = 0;

		void add(int e) {
			mData[mTail++] = e;
		}

		Integer peek(){
			if (isEmpty())
				return null;
			else
				return mData[mHead];
		}

		Integer remove() {
			if (isEmpty())
				return null;
			else {
				return mData[mHead++];
			}
		}

		public boolean isEmpty() { return mHead == mTail; }

		public void clear() {
			mHead = 0;
			mTail = 0;
		}
	}

	private void bfsMark(int[][] arr, int mark, int c, int r) {
		int W = arr[0].length;
		int H = arr.length;
		MyQueue q = new MyQueue();
		q.add(c);
		q.add(r);
		arr[c][r] = mark;
		Date ref = new Date();
		while(q.peek() != null) {
			int i = q.remove();
			int j = q.remove();
			System.out.println("bfsMark mark: i="+i+", j="+j);
			// for (int k = 0; k < H; k++) {
			// 	String s = "";
			// 	for (int l = 0; l < W; l++)
			// 		s += " " + arr[k][l];

			// 	System.out.println(s);
			// }

			if (i>0 && arr[i-1][j] == 1) {
				q.add(i-1);
				q.add(j);
				arr[i-1][j] = mark;
			}
			if (i+1 < H && arr[i+1][j] == 1) {
				q.add(i+1);
				q.add(j);
				arr[i+1][j] = mark;
			} 
			if (j>0 && arr[i][j-1] == 1){
				q.add(i);
				q.add(j-1);
				arr[i][j-1] = mark;
			}
			if (j+1 < W && arr[i][j+1] == 1) {
				q.add(i);
				q.add(j+1);
				arr[i][j+1] = mark;
			}
		}
		System.out.println("TimeWhile: " + (new Date().getTime() - ref.getTime()));
	}

	private void markIsland(int[][] arr, int mark) {
		int W = arr[0].length;
		int H = arr.length;

		for (int i = 0; i < H; i++)
			for (int j = 0; j < W; j++)
				if (arr[i][j]==1){
					System.out.println("bsfMark from: i="+i+", j="+j);
					bfsMark(arr, mark, i, j);
					return;
				}
			}

			private void markIsland2(int[][] arr) {
				int W = arr[0].length;
				int H = arr.length;

				for (int i = 0; i < H; i++)
					for (int j = 0; j < W; j++)
						if (arr[i][j] == 1)
							arr[i][j] = -2;
					}

					private void enqueueIsland(int[][] arr, int mark, MyQueue q) {
						MyQueue tempQ = new MyQueue();

						int W = arr[0].length;
						int H = arr.length;



						for (int i = 0; i<H; i++)
							for (int j = 0; j<W; j++)
								if (arr[i][j] == mark) {
									q.add(i);
									q.add(j);
								}
							}

							private int findStep(int[][] arr, int i, int j) {
								int W = arr[0].length;
								int H = arr.length;


								if (i>0 && arr[i-1][j] > 0)
									return arr[i-1][j];

								if (i+1 < H && arr[i+1][j] > 0)
									return arr[i+1][j];

								if (j>0 && arr[i][j-1] > 0)
									return arr[i][j-1];

								if (j+1 < W && arr[i][j+1] > 0) 
									return arr[i][j+1];

								return -1;
							}

							public int shortestBridge(int[][] A) {
								Date ref = new Date();
								int[][] B = new int[10000][2];
								for (int i = 0; i < B.length; i++)
									for (int j = 0; j < B[0].length; j++)
										B[i][j] = 1;

									System.out.println("Time0: "+(new Date().getTime() - ref.getTime()));

									ref = new Date();
									markIsland(A, -1);
									markIsland2(A);
									System.out.println("Time1: " + (new Date().getTime() - ref.getTime()));

									int W = A[0].length;
									int H = A.length;


									MyQueue q = new MyQueue();


									ref = new Date();
									enqueueIsland(A, -1, q);
									System.out.println("Time2: " + (new Date().getTime() - ref.getTime()));

    	// for (int k = 0; k < H; k++) {
    	// 	String s = "";
    	// 	for (int l = 0; l < W; l++)
    	// 		s += " " + A[k][l];

    	// 	System.out.println(s);
    	// }


									while (q.peek() != null) {
										int i = q.remove();
										int j = q.remove();

										if (i>0 && (A[i-1][j] == 0 || A[i-1][j] == -2)) {
											if (A[i-1][j] == -2)
												return A[i][j];

											q.add(i-1);
											q.add(j);

											if (A[i][j] == -1)
												A[i-1][j] = 1;
											else
												A[i-1][j] = A[i][j] + 1;
										}

										if (i+1 < H && (A[i+1][j] == 0 || A[i+1][j] == -2)) {
											if (A[i+1][j] == -2)
												return A[i][j];

											q.add(i+1);
											q.add(j);

											if (A[i][j] == -1)
												A[i+1][j] = 1;
											else
												A[i+1][j] = A[i][j] + 1;
										} 

										if (j>0 && (A[i][j-1] == 0 || A[i][j-1] == -2)){
											if (A[i][j-1] == -2)
												return A[i][j];

											q.add(i);
											q.add(j-1);

											if (A[i][j] == -1)
												A[i][j-1] = 1;
											else
												A[i][j-1] = A[i][j] + 1;
										}

										if (j+1 < W && (A[i][j+1] == 0 || A[i][j+1] == -2)) {
											if (A[i][j+1] == -2)
												return A[i][j];

											q.add(i);
											q.add(j+1);

											if (A[i][j] == -1)
												A[i][j+1] = 1;
											else
												A[i][j+1] = A[i][j] + 1;
										}
									}

									return 0;
								}

								public static void main (String[] args) {
									int[][] A = {{1,1,1,1,1}, {1, 0, 0, 0, 1}, {1, 0, 1, 0, 1}, {1, 0, 0, 0, 1}, {1, 1, 1, 1, 1}};
									Solution s = new Solution();
									Date ref = new Date();
    	// System.out.println("Steps: " + s.shortestBridge(A));
    	// System.out.println("Time: " + (new Date().getTime() - ref.getTime()));

    	// int[][] B = {{0,1}, {1, 0}};
    	// ref = new Date();
    	// System.out.println("Steps: " + s.shortestBridge(B));
    	// System.out.println("Time: " + (new Date().getTime() - ref.getTime()));

    	// int[][] C = {{0,1,0}, {0,0,0}, {0,0,1}};
    	// ref = new Date();
    	// System.out.println("Steps: " + s.shortestBridge(C));
    	// System.out.println("Time: " + (new Date().getTime() - ref.getTime()));

    	// int[][] D = {{0,0,0,0,0,0,0},{1,0,0,1,0,0,0},{1,1,1,1,0,0,0},{0,0,0,1,0,0,0},{1,0,0,0,0,0,0},{1,1,0,0,0,0,0},{1,0,0,0,0,0,0}};
    	// ref = new Date();
    	// System.out.println("Steps: " + s.shortestBridge(D));
    	// System.out.println("Time: " + (new Date().getTime() - ref.getTime()));

									int[][] E =  {{1,1,1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,1,1,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,0,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,0,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,0,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,0,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,0,1,1,1,1,1,0,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{1,1,1,1,1,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,1,0,0,1,1,1,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,1,1,1,1,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,1,1,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,1,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0,0}};
									ref = new Date();
									System.out.println("Steps: " + s.shortestBridge(E));
									System.out.println("Time: " + (new Date().getTime() - ref.getTime()));
								}
							}