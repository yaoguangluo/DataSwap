package org.deta.tinos.string;
import java.util.HashMap;
import java.util.Map;
public class QuickLuoyaoguang4DWithChinese{
	Map<String, Boolean> find= new HashMap<>();
	Map<String,String> map;
	public void quick4DChineseStringArray(String[] a, int lp, int rp, int scale, Map<String, String> map) {
		this.map= map;
		for(int k= 0; k< scale; k++) {
			quick4DString(a, lp, rp, k);
		}
	}

	public void quick4DString(String[] a, int lp, int rp, int scale) {
		if(lp< rp){
			int c= rp- lp; if(c< 17){ 
				int j;
				for(int i= 1+ lp; i<= lp+ c; i++){
					j= i;
					Here:
					while(j>= 1+ lp){
						if(a[j].length()> scale&& a[j- 1].length()> scale) {
							if(a[j].charAt(scale)==a[j-1].charAt(scale)) {
								j--;
								continue Here;
							}
							if(this.map.containsKey(""+ a[j].charAt(scale))&& this.map.containsKey(""+ a[j-1].charAt(scale))){
								conditionSwapChinese(a, scale, j, j-1);
							}else if(!this.map.containsKey(""+ a[j].charAt(scale))&& this.map.containsKey(""+ a[j-1].charAt(scale))) {
								conditionSwap(a, scale, j, j-1);
							}else{
								if(a[j].toLowerCase().charAt(scale)
										< a[j- 1].toLowerCase().charAt(scale)){
									conditionSwap(a, scale, j, j-1);
								}else if(a[j].toLowerCase().charAt(scale)
										== a[j- 1].toLowerCase().charAt(scale)) {
									if(a[j].charAt(scale)> a[j- 1].charAt(scale)) {
										conditionSwap(a, scale, j, j-1);
									}
								}		
							}
						}
						j--;
					}
				}	
				return;
			}
			int pos= partitionString(a, lp, rp, scale);
			quick4DString(a, lp, pos- 1, scale);
			quick4DString(a, pos+ 1, rp, scale);
		}
	}

	private void conditionSwapChinese(String[] a, int scale, int rp, int lp1) {
		String[] js= new String[2];
		js[0]= this.map.get(""+ a[rp].charAt(scale));
		js[1]= this.map.get(""+ a[lp1].charAt(scale));
		for(int k= 0; k< 6; k++) {
			quick4DString(js, 0, 1, k);
		}
		if(!js[0].equalsIgnoreCase(this.map.get(""+ a[rp].charAt(scale)))) {
			conditionSwap(a, scale, rp, lp1);
		}
	}

	private void conditionSwap(String[] a, int scale, int rp, int lp1) {
		boolean find= true;
		for(int p= 0; p< scale; p++) {
			if(a[rp].charAt(p)!= a[lp1].charAt(p)) {
				find= false;
			}
		}
		if(find) {
			String temp= a[rp];
			a[rp]= a[lp1];
			a[lp1]= temp;
		}
	} 
	
	private int partitionString(String[] a, int lp, int rp, int scale) {
		String x= a[lp];
		if(!(a[lp].length()<= scale|| a[rp].length()<= scale)){
			x= a[lp].toLowerCase().charAt(scale)
					< a[rp].toLowerCase().charAt(scale)? a[lp]: a[rp]; 
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
				if(a[lp1].charAt(scale)==a[rp].charAt(scale)) {
					lp1++;
				}else if(this.map.containsKey(""+ a[rp].charAt(scale))&& this.map.containsKey(""+ a[lp1].charAt(scale))){
					String[] js= new String[2];
					js[0]= this.map.get(""+ a[rp].charAt(scale));
					js[1]= this.map.get(""+ a[lp1].charAt(scale));
					for(int k= 0; k< 6; k++) {
						quick4DString(js, 0, 1, k);
					}
					if(!js[0].equalsIgnoreCase(this.map.get(""+ a[rp].charAt(scale)))) {
						conditionSwap(a, scale, rp, lp1);
					}else {
						lp1++;
					}
				}else if(!this.map.containsKey(""+ a[rp].charAt(scale))&& this.map.containsKey(""+ a[lp1].charAt(scale))) {
					boolean find= true;
					for(int p= 0; p< scale; p++) {
						if(a[rp].charAt(p)!= a[lp1].charAt(p)) {
							find= false;
						}
					}
					if(find) {
						String temp= a[rp];
						a[rp]= a[lp1];
						a[lp1]= temp;
					}else {
						lp1++;
					}
				}else{
					if(a[rp].toLowerCase().charAt(scale)
							< a[lp1].toLowerCase().charAt(scale)){
						boolean find= true;
						for(int p= 0; p< scale; p++) {
							if(a[rp].charAt(p)!= a[lp1].charAt(p)) {
								find= false;
							}
						}
						if(find) {
							String temp= a[rp];
							a[rp]= a[lp1];
							a[lp1]= temp;
						}else {
							lp1++;
						}
					}else if(a[rp].toLowerCase().charAt(scale)
							== a[lp1].toLowerCase().charAt(scale)) {
						if(a[rp].charAt(scale)> a[lp1].charAt(scale)) {
							boolean find= true;
							for(int p= 0; p< scale; p++) {
								if(a[rp].charAt(p)!= a[lp1].charAt(p)) {
									find= false;
								}
							}
							if(find) {
								String temp= a[rp];
								a[rp]= a[lp1];
								a[lp1]= temp;
							}else {
								lp1++;
							}
						}
					}	
				}
			}
		}
		if(lp1< rp) {
			a[lp]= a[rp]; a[rp]= x;
		}
		return rp;	
	}

	private boolean innerConditionUp(String[] a, int scale
			, String x, int lp1, int rp) {
		if(lp1>= a.length) {
			return false;
		}
		
		if(a[lp1].length()<= scale|| x.length()<= scale) {
			return true;	
		}
		
		if(!(a[lp1].toLowerCase().charAt(scale)
				> x.toLowerCase().charAt(scale)|| lp1>= rp)) {
			return true;
		}
		return false;	
	}

	private boolean innerConditionDown(String[] a, int scale, String x, int rp) {
		if(rp>= a.length){
			return false;
		}
		if(rp< 0) {
			return false;
		}
		
		if(a[rp].length()<= scale|| x.length()<= scale) {
			return true;	
		}
		
		if(a[rp].toLowerCase().charAt(scale)
				> x.toLowerCase().charAt(scale)) {
			return true;
		}
		return false;	
	}
}
