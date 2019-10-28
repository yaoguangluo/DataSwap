package org.deta.tinos.string;
import java.util.HashMap;
import java.util.Map;
public class QuickLuoyaoguang4DWithChineseBackup{
	Map<String, Boolean> find= new HashMap<>();
	Map<String,String> map;
	public void quick4DChineseStringArray(String[] a, int lp, int rp, int scale, Map<String, String> map) {
		this.map= map;
		String[][] js= new String[a.length][2];
		for(int i= 0; i<a.length; i++) {
			js[i][0]= a[i].toString();
			js[i][1]= a[i].toString();
		}
		int k= 0;
		quick4DString(js, lp, rp, k);
		k++;
		boolean find= false;
		int i;
		for(i= 0; i< js.length; i++) {
			if(js[i][0].charAt(k-1)!= js[lp][0].charAt(k-1)){
				find= true;
				quick4DStringSections(js, lp, i- 1, k+ 1, scale);
				lp= i;
				if(i<rp) {
					find= false;
				}
			}
		}
		if(!find) {
			quick4DStringSections(js, lp, i- 1, k+ 1, scale);
		}
		
		for(i=0;i<a.length;i++) {
			a[i]=js[a.length-i-1][0].toString();
		}
	}

	private void quick4DStringSections(String[][] js, int lp, int rp, int k, int scale) {
		if(scale< k) {
			return;
		}
		quick4DString(js, lp, rp, k-1);
		boolean find= false;
		int i;
		for(i= lp; i< rp; i++) {
			if(js[i][0].length()> k&& js[lp][0].length()>k) {
				if(js[i][0].charAt(k-1)!= js[lp][0].charAt(k-1)){
					find= true;
					quick4DStringSections(js, lp, i- 1, k+ 1, scale);
					lp= i;
					if(i<rp) {
						find= false;
					}
				}
			}
		}
		if(!find) {
			quick4DStringSections(js, lp, i- 1, k+ 1, scale);
		}
	}

	public void quick4DString(String[][] js, int lp, int rp, int scale) {
		if(lp< rp){
			int c= rp- lp; if(c< 67){ 
				int j;
				for(int i= 1+ lp; i<= lp+ c; i++){
					j= i;
					while(j>= 1+ lp){
						if(js[j][0].length()> scale&& js[j- 1][0].length()> scale) {
							//当前字符相等
							if(this.map.containsKey(""+ js[j][0].charAt(scale))&& this.map.containsKey(""+ js[j-1][0].charAt(scale))) {
								conditionSwapChinese(js, scale, j, j- 1);//当前都是字
							}else if(!this.map.containsKey(""+ js[j][0].charAt(scale))&& this.map.containsKey(""+ js[j-1][0].charAt(scale))) {
								conditionSwap(js, scale, j, j- 1);//当前不都是字
							}else if(!this.map.containsKey(""+ js[j][0].charAt(scale))&& !this.map.containsKey(""+ js[j-1][0].charAt(scale))) {
								if(js[j][0].toLowerCase().charAt(scale)
										< js[j- 1][0].toLowerCase().charAt(scale)){
									conditionSwap(js, scale, j, j- 1);
								}else if(js[j][0].toLowerCase().charAt(scale)
										== js[j- 1][0].toLowerCase().charAt(scale)) {
									if(js[j][0].charAt(scale)< js[j- 1][0].charAt(scale)) {
										conditionSwap(js, scale, j, j- 1);//加入相等过滤
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
		if(a[rp][0].charAt(scale)== a[lp1][0].charAt(scale)) {
			return;
		}
		//tongzi
		String[][] js= new String[2][2];
		js[0][0]= this.map.get(""+ a[rp][0].charAt(scale));
		js[0][1]= a[rp][0];
		js[1][0]= this.map.get(""+ a[lp1][0].charAt(scale));
		js[1][1]= a[lp1][0];
		if(js[1][0].contains(js[0][0])) {
			conditionSwap(a, scale, rp, lp1);
			return;
		}
		//tongyin
		for(int k= 0; k< 6; k++) {
			quick4DString(js, 0, 1, k);
		}
		//butongzi
		if(!js[0][1].equalsIgnoreCase(a[rp][0])) {
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
			String[] temp= a[rp].clone();
			a[rp]= a[lp1].clone();
			a[lp1]= temp;
		}
	} 

	private int partitionString(String[][] a, int lp, int rp, int scale) {
		String[] x= a[lp].clone();
		int lp1= lp;
		while(lp1< rp){
			while(innerConditionUp(a, scale, x, lp1, rp)){
				lp1++;
			} 
			while(innerConditionDown(a, scale, x, rp)){
				rp--;
			}
			if(lp1< rp){
				String[] temp= a[rp].clone();
				a[rp]= a[lp1].clone();
				a[lp1]= temp;
			}
		}
		a[lp]= a[rp].clone(); a[rp]= x;
		return rp;	
	}

	private boolean innerConditionUp(String[][] a, int scale, String[] x, int lp1, int rp) {
		if(lp1> rp) {
			return false;
		}
		
		if(a[lp1][0].length()<= scale|| x[0].length()<=scale) {
			//return false;
		}
		
		if(this.map.containsKey(""+ a[lp1][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))){
			if(a[lp1][0].charAt(scale)== x[0].charAt(scale)) {
				//return true;//xiang deng
			}
			String[][] js= new String[2][2];
			js[0][0]= this.map.get(""+ x[0].charAt(scale));
			js[0][1]= x[0].toString();
			js[1][0]= this.map.get(""+ a[lp1][0].charAt(scale));
			js[1][1]= a[lp1][0].toString();
			if(js[1][0].contains(js[0][0])) {
				return false;
			}
			for(int k= 0; k< 6; k++) {
				quick4DString(js, 0, 1, k);
			}
			if(!js[0][1].equalsIgnoreCase(x[0])) {//确定a[lp1]小
				return false;
			}//字字
		}else if(!this.map.containsKey(""+ a[lp1][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))) {
			return true;//字符
		}else if(!this.map.containsKey(""+ a[lp1][0].charAt(scale))&& !this.map.containsKey(""+ x[0].charAt(scale))){
			if(a[lp1][0].toLowerCase().charAt(scale)< x[0].toLowerCase().charAt(scale)&& lp1< rp) {
				return true;//符符
			}else if(a[lp1][0].toLowerCase().charAt(scale)== x[0].toLowerCase().charAt(scale)&& lp1< rp) {
				if(a[lp1][0].charAt(scale)<= x[0].charAt(scale)) {
					return true;
				}
			}
		}
		return false;	
	}

	private boolean innerConditionDown(String[][] a, int scale, String[] x, int rp) {
		if(a[rp][0].length()<= scale|| x[0].length()<=scale) {
			return false;
		}
		if(this.map.containsKey(""+ a[rp][0].charAt(scale))&& this.map.containsKey(""+ x[0].charAt(scale))){
			if(a[rp][0].charAt(scale)== x[0].charAt(scale)) {
				return true;
			}
			String[][] js= new String[2][2];
			js[0][0]= this.map.get(""+ a[rp][0].charAt(scale));
			js[0][1]= a[rp][0].toString();
			js[1][0]= this.map.get(""+ x[0].charAt(scale));
			js[1][1]= x[0].toString();
			if(js[1][0].contains(js[0][0])) {
				return false;
			}
			for(int k= 0; k< 6; k++) {
				quick4DString(js, 0, 1, k);
			}
			if(!js[0][1].equalsIgnoreCase(a[rp][0])) {
				return false;
			}
		}else if(!this.map.containsKey(""+ x[0].charAt(scale))&& this.map.containsKey(""+ a[rp][0].charAt(scale))) {
			return true;//字符
		}else if(!this.map.containsKey(""+ x[0].charAt(scale))&& !this.map.containsKey(""+ a[rp][0].charAt(scale))){
			if(a[rp][0].toLowerCase().charAt(scale)> x[0].toLowerCase().charAt(scale)) {
				return true;//符符	
			}
		}
		return false;	
	}
}