package org.deta.tinos.fft;
public class LBNFT{
	public final double Pi= 3.1415926535;
	public final double size= 16;
	public final double kPi= (Pi* 2)/ size;
	public double[] swapDifferential(double[] input) {
		double[] output= new double[(int)size];
		for(int i= 0; i< size; i++) {
			for(int j= 1; j< size; j+= (i+ 1)) {
				double k= input[j]/input[j- 1];
				output[j]+= k;
			}
		}
		return output;	
	}
	public static void main(String[] argv) {
		double[] input= new double[16];
		input[0]=1;
		input[1]=-30;
		input[2]=-1000;
		input[3]=30;
		input[4]=1;
		input[5]=30;
		input[6]=1000;
		input[7]=30;
		input[8]=1;
		input[9]=-30;
		input[10]=-1000;
		input[11]=30;
		input[12]=1;
		input[13]=30;
		input[14]=1000;
		input[15]=30;
		double[] output= new LBNFT().swapDifferential(input);
		input= new LBNFT().swapDifferential(output);
		output= input;
		System.out.println(output[0]);
		System.out.println(output[1]);
		System.out.println(output[2]);
		System.out.println(output[3]);
		System.out.println(output[4]);
		System.out.println(output[5]);
		System.out.println(output[6]);
		System.out.println(output[7]);
		System.out.println(output[8]);
		System.out.println(output[9]);
		System.out.println(output[10]);
		System.out.println(output[11]);
		System.out.println(output[12]);
		System.out.println(output[13]);
		System.out.println(output[14]);
		System.out.println(output[15]);
	}
}