package org.deta.tinos.string;
public class QuickLuoyaoguang4D{
	public void quick4DStringArray(String[] a, int lp, int rp, int scale) {
		if(lp< rp){
			int c= rp- lp; if(c< 7){ int j;
			for(int i= 1+ lp; i<= lp+ c; i++){
				j= i; while(j>= 1+ lp){
					if((a[j].toLowerCase().charAt(0))
							< a[j- 1].toLowerCase().charAt(0)){
						String temp= a[j].toString();
						a[j]= a[j- 1].toString();
						a[j- 1]= temp.toString();
					}
					j--;
				}
			}	
			return;
			}
			int pos= partitionString(a, lp, rp, scale);
			quick4DStringArray(a, lp, pos- 1, scale);
			quick4DStringArray(a, pos+ 1, rp, scale);
		}
	}

	private int partitionString(String[] a, int lp, int rp, int scale) {
		String x= a[lp].toLowerCase().charAt(scale)
				< a[rp].toLowerCase().charAt(scale)? a[lp].toString(): a[rp].toString(); 
				int lp1= lp;
				while(lp1< rp){
					while(!(a[lp1].toLowerCase().charAt(scale)
							> x.toLowerCase().charAt(scale)&& rp< lp1)){
						lp1++;
					} 
					while(a[rp].toLowerCase().charAt(scale)
							> x.toLowerCase().charAt(scale)){
						rp--;
					}
					if(lp1< rp){
						String temp= a[rp].toString();
						a[rp]= a[lp1].toString();
						a[lp1]= temp.toString();
					}
				}
				a[lp]= a[rp].toString(); a[rp]= x.toString();
				return rp;
	}
}
