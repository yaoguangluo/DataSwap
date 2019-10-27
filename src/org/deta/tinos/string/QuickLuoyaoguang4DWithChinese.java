package org.deta.tinos.string;
import java.util.HashMap;
import java.util.Map;
public class QuickLuoyaoguang4DWithChinese{
	Map<String, Boolean> find= new HashMap<>();
	Map<String,String> map;
	public void quick4DChineseStringArray(String[] a, int lp, int rp, int scale, Map<String, String> map) {
		this.map= map;
		String[][]js= new String[a.length][2];
		for(int i=0;i<a.length;i++) {
			js[i][0]=a[i];
			js[i][1]=a[i];
		}
		for(int k= 0; k< scale; k++) {
			quick4DString(js, lp, rp, k);
		}
		for(int i=0;i<a.length;i++) {
			a[i]=js[i][0].toString();
			
		}
	}

	public void quick4DString(String[][] js, int lp, int rp, int scale) {
		if(lp< rp){
			int c= rp- lp; if(c< 17){ 
				int j;
				for(int i= 1+ lp; i<= lp+ c; i++){
					j= i;
					Here:
					while(j>= 1+ lp){
						if(js[j][0].length()> scale&& js[j- 1][0].length()> scale) {
							//当前字符相等
							if(js[j][0].charAt(scale)== js[j- 1][0].charAt(scale)) {
								conditionSwap(js, scale, j, j- 1);
							}else if(this.map.containsKey(""+ js[j][0].charAt(scale))&& this.map.containsKey(""+ js[j-1][0].charAt(scale))){
								conditionSwapChinese(js, scale, j, j- 1);//当前都是字
							}else if(this.map.containsKey(""+ js[j][0].charAt(scale))&& !this.map.containsKey(""+ js[j-1][0].charAt(scale))) {
								conditionSwap(js, scale, j, j- 1);//当前不都是字
							}else{//都不是字
								if(js[j][0].toLowerCase().charAt(scale)
										< js[j- 1][0].toLowerCase().charAt(scale)){
									conditionSwap(js, scale, j, j- 1);
								}else if(js[j][0].toLowerCase().charAt(scale)
										== js[j- 1][0].toLowerCase().charAt(scale)) {
									if(js[j][0].charAt(scale)< js[j- 1][0].charAt(scale)) {
										conditionSwap(js, scale, j, j- 1);
									}
								}		
							}
						}
						j--;
					}
				}	
				return;
			}
			int pos= partitionString(js, lp, rp, scale);
			quick4DString(js, lp, pos- 1, scale);
			quick4DString(js, pos+ 1, rp, scale);
		}
	}

	private void conditionSwapChinese(String[][] a, int scale, int rp, int lp1) {
		String[][] js= new String[2][2];
		js[0][0]= this.map.get(""+ a[rp][0].charAt(scale));
		js[0][1]= a[rp][0];
		js[1][0]= this.map.get(""+ a[lp1][0].charAt(scale));
		js[1][1]= a[lp1][0];
		for(int k= 0; k< 6; k++) {
			quick4DString(js, 0, 1, k);
		}
		if(js[0][1].equalsIgnoreCase(a[rp][0])) {
			conditionSwap(a, scale, rp, lp1);
		}
	}

	private void conditionSwap(String[][] a, int scale, int rp, int lp1) {
		boolean find= true;
		for(int p= 0; p< scale; p++) {
			if(a[rp][0].charAt(p)!= a[lp1][0].charAt(p)) {
				find= false;
			}
		}
		if(find) {
			String[] temp= a[rp];
			a[rp]= a[lp1];
			a[lp1]= temp;
		}
	} 
	
	private int partitionString(String[][] a, int lp, int rp, int scale) {
		String[] x= a[lp];
		if(!(a[lp][0].length()<= scale|| a[rp][0].length()<= scale)){
			x= a[lp][0].toLowerCase().charAt(scale)
					< a[rp][0].toLowerCase().charAt(scale)? a[lp]: a[rp]; 
		}
		int lp1= lp;
		while(lp1< rp){
			while(innerConditionUp(a, scale, x, lp1, rp)){
				lp1++;
			} 
			while(innerConditionDown(a, scale, x, rp)){
				rp--;
			}
			if(lp1< rp){	
					boolean find= true;
					for(int p= 0; p< scale; p++) {
						if(a[rp][0].charAt(p)!= a[lp1][0].charAt(p)) {
							find= false;
						}
					}
					if(find) {
						String[] temp= a[rp];
						a[rp]= a[lp1];
						a[lp1]= temp;
					}else {
						lp1++;
					}
			}
		}
		if(lp1< rp) {
			a[lp]= a[rp]; a[rp]= x;
		}
		return rp;	
	}

	private boolean innerConditionUp(String[][] a, int scale
			, String[] x, int lp1, int rp) {
		if(lp1>= a.length) {
			return false;
		}
			
		if(a[lp1][0].length()<= scale|| x[0].length()<= scale) {
			return true;	
		}
		
		if(this.map.containsKey(""+ a[lp1][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))){
			String[][] js= new String[2][2];
			js[0][0]= this.map.get(""+ a[lp1][0].charAt(scale));
			js[0][1]=""+ a[lp1][0].charAt(scale);
			js[1][0]= this.map.get(""+ x[0].charAt(scale));
			js[1][1]=""+ x[0].charAt(scale);
			for(int k= 0; k< 6; k++) {
				quick4DString(js, 0, 1, k);
			}
			if(js[0][0].equalsIgnoreCase(this.map.get(""+ a[lp1][0].charAt(scale)))) {
				return true;
			}
		}else if(!this.map.containsKey(""+ a[lp1][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))) {
			return true;
		}else if(!(a[lp1][0].toLowerCase().charAt(scale)> x[0].toLowerCase().charAt(scale)|| lp1>= rp)) {
			return true;
		}else if(a[lp1][0].toLowerCase().charAt(scale)== x[0].toLowerCase().charAt(scale)) {
			if(a[lp1][0].charAt(scale)< x[0].charAt(scale)&& lp1< rp) {
				return true;
			}
		}
		return false;	
	}

	private boolean innerConditionDown(String[][] a, int scale, String[] x, int rp) {
		if(rp>= a.length){
			return false;
		}
		
		if(rp< 0) {
			return false;
		}
		
		if(a[rp][0].length()<= scale|| x[0].length()<= scale) {
			return true;	
		}
		
		if(this.map.containsKey(""+ a[rp][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))){
			String[][] js= new String[2][2];
			js[0][0]= this.map.get(""+ a[rp][0].charAt(scale));
			js[0][1]=""+ a[rp][0].charAt(scale);
			js[1][0]= this.map.get(""+ x[0].charAt(scale));
			js[1][1]=""+ x[0].charAt(scale);
			for(int k= 0; k< 6; k++) {
				quick4DString(js, 0, 1, k);
			}
			if(!js[0][0].equalsIgnoreCase(this.map.get(""+ a[rp][0].charAt(scale)))) {
				return true;
			}
		}else if(!this.map.containsKey(""+ a[rp][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))) {
			return true;
		}else if(a[rp][0].toLowerCase().charAt(scale)> x[0].toLowerCase().charAt(scale)) {
			return true;
		}else if(a[rp][0].toLowerCase().charAt(scale)== x[0].toLowerCase().charAt(scale)) {
			if(a[rp][0].charAt(scale)> x[0].charAt(scale)) {
				return true;
			}
		}
		return false;	
	}
}
