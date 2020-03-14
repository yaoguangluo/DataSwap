package org.deta.tinos.array;
//�����㷨���ۿ���4��������С�߷�ȱ�ݹ������ۿ��������5�� ���������������򷨺���Java�����汾ʵ�֡�
//˼�룺�㷨���ۿ���4���ۣ�������С�߷�������ۡ�
//ʵ�֣�������
//ʱ�䣺20140101~ 20200314
public class LYG5DWithDoubleQuickSort4D{
	int range;
	int deeps;
	public double[] sort(double[] array, int range, int deeps) {
		this.range= range;
		this.deeps= deeps;
		processDouble(array, 0, array.length- 1, 0);
		return array;
	}

	private void processDouble(double[] array, int leftPoint, int rightPoint, int deep) {
		if(leftPoint< rightPoint){
			int c= rightPoint- leftPoint;
			if(!(c > this.range|| deep> this.deeps)) {//������deep
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
			processDouble(array, leftPoint, pos- 1, deep+ 1);
			processDouble(array, pos+ 1, rightPoint, deep+ 1);
		}
	}

	private int partition(double[] array, int leftPoint, int rightPoint) {
		double x= array[leftPoint]< array[rightPoint]? array[leftPoint]: array[rightPoint];
		int leftPointReflection= leftPoint;
		while(leftPointReflection< rightPoint){
			while(!(array[leftPointReflection]> x|| leftPointReflection>= rightPoint)) {
				leftPointReflection++;
			}
			while(array[rightPoint]> x){
				rightPoint--;
			}
			if(leftPointReflection< rightPoint){
				double temp= array[rightPoint];
				array[rightPoint]= array[leftPointReflection];
				array[leftPointReflection]= temp;
			}
		}
		array[leftPoint]= array[rightPoint];
		array[rightPoint]= x;
		return rightPoint;
	}
}