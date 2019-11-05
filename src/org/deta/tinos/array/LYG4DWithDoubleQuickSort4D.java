package org.deta.tinos.array;
//基于算法导论快排4衍生极速小高峰缺陷过滤理论快速排序第4代 线性数字数组排序法函数Java完整版本实现。
//思想：算法导论快排4理论，罗瑶光小高峰过滤理论。
//实现：罗瑶光
//时间：20140101~ 20191105
public class LYG4DWithDoubleQuickSort4D{
	public double[] sort(double[] array) {
		processDouble(array, 0, array.length- 1);
		return array;
	}

	private void processDouble(double[] array, int leftPoint, int rightPoint) {
		if(leftPoint< rightPoint){
			int c= rightPoint- leftPoint;
			if(c< 7){ 
				int j;
				for(int i= 1+ leftPoint; i<= leftPoint+ c; i++){
					j= i;
					while(j>= 1+ leftPoint){
						if(array[j]< array[j- 1]){
							double temp= array[j];
							array[j]= array[j- 1];
							array[j- 1]= temp;
						}
						j--;
					}
				}	
				return;
			}
			int pos= partition(array, leftPoint, rightPoint);
			processDouble(array, leftPoint, pos- 1);
			processDouble(array, pos+ 1, rightPoint);
		}
	}

	private int partition(double[] array, int leftPoint, int rightPoint) {
		double x= array[leftPoint]< array[rightPoint]? array[leftPoint]: array[rightPoint];
		int leftPoint1= leftPoint;
		while(leftPoint1< rightPoint){
			while(!(array[leftPoint1]> x|| leftPoint1>= rightPoint)) {
				leftPoint1++;
			}
			while(array[rightPoint]> x){
				rightPoint--;
			}
			if(leftPoint1< rightPoint){
				double temp= array[rightPoint];
				array[rightPoint]= array[leftPoint1];
				array[leftPoint1]= temp;
			}
		}
		array[leftPoint]= array[rightPoint];
		array[rightPoint]= x;
		return rightPoint;
	}
}