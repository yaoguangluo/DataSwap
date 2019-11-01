package org.deta.tinos.string;
import java.util.HashMap;
import java.util.Map;
public class LYG4DWithChineseMixStringSort6D{
	Map<String, Boolean> find= new HashMap<>();
	Map<String, String> pinyin;
	public void quick4DChineseStringArray(String[] a, int lp, int rp, int scale, Map<String, String> map) {
		this.pinyin= map;
		processKernel(a, lp, rp, scale, 0);
	}

	private void processKernel(String[] kernel, int lp, int rp, int scale, int point) {
		int rp1= rp;
		if(point> scale) {
			return;
		}
		processQS4DLYG4D(kernel, lp, rp, scale, point);
		int i;
		for(i= lp; i<= rp; i++) {
			if(!(kernel[i].length()<= point|| kernel[lp].length()<= point)) {
				if(kernel[i].charAt(point)!= kernel[lp].charAt(point)){
					rp1= i- 1;
					processKernel(kernel, lp, rp1, scale, point+1);
					lp= i;
				}
			}
		}
		if(lp!= rp) {
			processKernel(kernel, lp, i-1, scale, point+1);
		}
	}

	private void processSort(String[] kernel, int lp, int rp, int scale, int point) {
		if(point> scale) {
			return;
		}
		for(int i= lp; i<= rp; i++) {
			Here:
			for(int j= i; j<= rp; j++) {
				if(i==j) {
					continue Here;
				}
				if(kernel[i].length()<= point|| kernel[j].length()<= point) {
					if(kernel[i].length()< kernel[j].length()) {
						boolean find= true;
						for(int p= 0; p< scale; p++) {
							if(!(kernel[i].length()<= p|| kernel[j].length()<= p)) {
								if(kernel[i].charAt(p)!= kernel[j].charAt(p)) {
									find= false;
								}
							}
						}
						if(find) {
							String temp= kernel[i].toString();;
							kernel[i]= kernel[j].toString();;
							kernel[j]= temp;
						}
					}
					continue Here;
				}else if(!(!pinyin.containsKey(""+ kernel[i].charAt(point)) 
						|| !pinyin.containsKey(""+ kernel[j].charAt(point)))){
					String[] js= new String[2];
					js[0]= this.pinyin.get(""+ kernel[i].charAt(point));
					js[1]= this.pinyin.get(""+ kernel[j].charAt(point));
					boolean change= processSortPinYin(js, 3);
					if(!(!change|| i>= j)) {
						String temp= kernel[i].toString();;
						kernel[i]= kernel[j].toString();;
						kernel[j]= temp;
					}
					continue Here;
				}else if(!(pinyin.containsKey(""+ kernel[i].charAt(point)) 
						|| !pinyin.containsKey(""+ kernel[j].charAt(point)))){
					if(i< j) {
						if(!(i== rp+1 || j== rp+1)) {
							String temp= kernel[i].toString();
							kernel[i]= kernel[j].toString();
							kernel[j]= temp;
						}
					}
					continue Here;
				}else if(!(pinyin.containsKey(""+ kernel[i].charAt(point)) 
						|| pinyin.containsKey(""+ kernel[j].charAt(point)))){
					if(kernel[i].toLowerCase().charAt(point)
							> kernel[j].toLowerCase().charAt(point)) {
						if(i< j) {
							String temp= kernel[i].toString();
							kernel[i]= kernel[j].toString();
							kernel[j]= temp;
						}
						continue Here;
					}
					if(kernel[i].toLowerCase().charAt(point)
							== kernel[j].toLowerCase().charAt(point)) {
						if(kernel[i].charAt(point)> kernel[j].charAt(point)) {
							if(i< j) {
								String temp= kernel[i].toString();
								kernel[i]= kernel[j].toString();
								kernel[j]= temp;
							}
						}
					}
				}
			}
		}
	}

	private void processQS4DLYG4D(String[] kernel, int lp, int rp, int scale, int point) {
		if(lp< rp){
			int c= rp- lp; 
			if(c< 7){	
				processSort(kernel, lp, rp, scale, point);
				return;
			}
			int pos= partition(kernel, lp, rp, scale, point);
			processQS4DLYG4D(kernel, lp, pos- 1, scale, point);
			processQS4DLYG4D(kernel, pos+ 1, rp, scale, point);
		}
	}

	private boolean findSmall(String[] kernel, int scale, int point, int i, int j, int rp) {
		
		if(kernel[i].length()<= point|| kernel[j].length()<= point) {
			if(kernel[i].length()< kernel[j].length()) {
				boolean find= true;
				for(int p= 0; p< scale; p++) {
					if(!(kernel[i].length()<= p|| kernel[j].length()<= p)) {
						if(kernel[i].charAt(p)!= kernel[j].charAt(p)) {
							find= false;
						}
					}
				}
				if(find) {
					return true;
				}
				return false;
			}
			return false;
		}else if(!(!pinyin.containsKey(""+ kernel[i].charAt(point))
				|| !pinyin.containsKey(""+ kernel[j].charAt(point)))){
			String[] js= new String[2];
			js[0]= this.pinyin.get(""+ kernel[i].charAt(point));
			js[1]= this.pinyin.get(""+ kernel[j].charAt(point));
			boolean change= processSortPinYin(js, 3);
			if(!(!change|| i>= j)) {
				return true;
			}
			return false;
		}else if(!(pinyin.containsKey(""+ kernel[i].charAt(point))
				|| pinyin.containsKey(""+ kernel[j].charAt(point)))){
			if(kernel[i].toLowerCase().charAt(point)
					> kernel[j].toLowerCase().charAt(point)) {
				if(i< j) {
					return true;
				}
				return false;
			}else if(kernel[i].toLowerCase().charAt(point)
					== kernel[j].toLowerCase().charAt(point)) {
				if(kernel[i].charAt(point)> kernel[j].charAt(point)) {
					if(i< j) {
						return true;
					}
					return false;
				}
				return false;
			}
			return false;
		}else if(!(pinyin.containsKey(""+ kernel[i].charAt(point))
				|| !pinyin.containsKey(""+ kernel[j].charAt(point)))){
			if(i< j) {
				if(!(i== rp || j== rp)) {
					return true;
				}
				return false;
			}
			return false;
		}
		return false;
	}

	private boolean findSmallWithTwoChar(String x1, String x2, int scale, int point) {
		if(x1.length()<= point|| x2.length()<= point) {
			if(x1.length()< x2.length()) {
				boolean find= true;
				for(int p= 0; p< scale; p++) {
					if(!(x1.length()<= p|| x2.length()<= p)) {
						if(x1.charAt(p)!= x2.charAt(p)) {
							find= false;
						}
					}
				}
				if(find) {
					return true;
				}
				return false;
			}
			return false;
		}else if(!(!pinyin.containsKey(""+ x1.charAt(point)) 
				|| !pinyin.containsKey(""+ x2.charAt(point)))){
			String[] js= new String[2];
			js[0]= this.pinyin.get(""+ x1.charAt(point));
			js[1]= this.pinyin.get(""+x2.charAt(point));
			boolean change= processSortPinYin(js, 3);
			if(change) {
				return true;
			}
			return false;
		}else if(!(pinyin.containsKey(""+ x1.charAt(point)) 
				|| pinyin.containsKey(""+ x2.charAt(point)))){
			if(x1.toLowerCase().charAt(point)> x2.toLowerCase().charAt(point)) {
				return true;
			}else if(x1.toLowerCase().charAt(point)== x2.toLowerCase().charAt(point)) {
				if(x1.charAt(point)> x2.charAt(point)) {
					return true;
				}
				return false;
			}
			return false;
		}else if(!(pinyin.containsKey(""+ x1.charAt(point)) 
				|| !pinyin.containsKey(""+ x2.charAt(point)))){
				return true;
		}
		return false;
	}

	private int partition(String[] a, int lp, int rp, int scale, int point) {
		String x= findSmall(a, scale, point, lp, rp, rp)? a[rp]: a[lp];
		int lp1= lp;
		int count= 0;
		int lastCount= 0;
		while(lp1< rp) {
			while(!(findSmallWithTwoChar(a[lp1], x, scale, point)|| lp1>= rp)) {
				lp1++;
				count++;
			} 
			while(findSmallWithTwoChar(a[rp], x, scale, point)){
				rp--;
				count++;
			}
			if(lp1< rp){
				String temp= a[rp].toString();;
				a[rp]= a[lp1].toString();;
				a[lp1]= temp;
			}
			if(count!= lastCount) {
				lastCount= count;
			}else {
				rp--;
			}
		}
		a[lp]=a[rp].toString();a[rp]=x;
		return rp;
	}

	private boolean processSortPinYin(String[] kernel, int scale) {
		for(int k= 0; k< scale; k++) {
			if(kernel[0].length()<= k|| kernel[1].length()<= k) {
				if(kernel[0].length()< kernel[1].length()) {
					return true;
				}
				return false;
			}
			if(kernel[0].toLowerCase().charAt(k)> kernel[1].toLowerCase().charAt(k)) {
				return true;
			}
			if(kernel[0].toLowerCase().charAt(k)< kernel[1].toLowerCase().charAt(k)) {
				return false;
			}
		}
		if(kernel[0].length()< kernel[1].length()) {
			return true;
		}
		return false;
	}
}