package org.deta.tinos.array;
//基于算法导论快排4衍生极速小高峰缺陷过滤理论快速排序第4代 线性数字数组排序法函数Java完整版本实现。
//思想：算法导论快排4理论，罗瑶光小高峰过滤理论。
//实现：罗瑶光
//时间：20140101~ 20191105
public class LYG4DWithDoubleQuickSort4D{
	public double[] sort(double[] a) {
		quick2ds(a, 0, a.length- 1);
		return a;
	}

	private void quick2ds(double[] a, int lp, int rp) {
		if(lp< rp){
			int c= rp- lp; if(c< 7){ 
				int j;
				for(int i= 1+ lp; i<= lp+ c; i++){
					j= i;while(j>= 1+ lp){
						if(a[j]< a[j- 1]){
							double temp= a[j];
							a[j]= a[j- 1];
							a[j- 1]= temp;
						}
						j--;
					}
				}	
				return;
			}
			int pos= partition(a, lp, rp);
			quick2ds(a, lp, pos- 1);
			quick2ds(a, pos+ 1, rp);
		}
	}

	private int partition(double[] a, int lp, int rp) {
		double x= a[lp]< a[rp]? a[lp]: a[rp];
		int lp1= lp;
		while(lp1< rp){
			while(!(a[lp1]> x|| lp1>= rp)) {
				lp1++;
			}
			while(a[rp]> x){
				rp--;
			}
			if(lp1< rp){
				double temp= a[rp];
				a[rp]= a[lp1];
				a[lp1]= temp;
			}
		}
		a[lp]= a[rp];
		a[rp]= x;
		return rp;
	}
}