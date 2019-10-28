package org.deta.tinos.string;
import java.util.HashMap;
import java.util.Map;
public class LYG4DWithChineseMixStringSort2D{
	Map<String, Boolean> find= new HashMap<>();
	Map<String, String> pinyin;
	public void quick4DChineseStringArray(String[] a, int lp, int rp, int scale, Map<String, String> map) {
		this.pinyin= map;
		String[][] kernel= new String[a.length][3];
		for(int i= 0; i< a.length; i++) {
			kernel[i][0]= a[i].toString();
		}
		processKernel(kernel,  lp,  rp,  scale,  0);
		for(int i= 0; i< a.length; i++) {
			 a[i]= kernel[i][0].toString();
		}
	}
	
	private void processKernel(String[][] kernel, int lp, int rp, int scale, int point) {
		int rp1= rp;
		if(point> scale) {
			return;
		}
		processSort(kernel, lp, rp, scale, point);
		int i;
		for(i= lp; i<= rp; i++) {
			if(kernel[i][0].length()> point&& kernel[lp][0].length()> point) {
				if(kernel[i][0].charAt(point)!= kernel[lp][0].charAt(point)){
					rp1= i-1;
					processKernel(kernel, lp, rp1, scale, point+1);
					lp= i;
				}
			}
		}
		if(lp!=rp) {
			processKernel(kernel, lp, i-1, scale, point+1);
		}
	}
	
	private void processSort(String[][] kernel, int lp, int rp, int scale, int point) {
		if(point> scale) {
			return;
		}
		for(int i= lp; i<= rp; i++) {
			Here:
			for(int j= lp; j<= rp; j++) {
				if(i==j) {
					continue Here;
				}
				//que
				if(kernel[i][0].length()<= point|| kernel[j][0].length()<= point) {
					if(kernel[i][0].length()< kernel[j][0].length()) {//长在上
						boolean find= true;
						for(int p= 0; p< scale; p++) {
							//左右
							if(kernel[i][0].length()> p&& kernel[j][0].length()> p) {
								if(kernel[i][0].charAt(p)!= kernel[j][0].charAt(p)) {
									find= false;
								}
							}
//							else{
//								if(!find) {
//									if(kernel[i][0].length()< kernel[j][0].length()) {
//										find= false;
//									}
//								}
//							}
						}
						if(find) {
							String[] temp= kernel[i].clone();
							kernel[i]= kernel[j].clone();
							kernel[j]= temp;
						}
					}
				}else if(pinyin.containsKey(""+ kernel[i][0].charAt(point)) && pinyin.containsKey(""+ kernel[j][0].charAt(point))){
					String[] js= new String[2];
					js[0]= this.pinyin.get(""+ kernel[i][0].charAt(point));
					js[1]= this.pinyin.get(""+ kernel[j][0].charAt(point));
					boolean change= processSortPinYin(js, 3);
					if(change&& i< j) {
						String[] temp= kernel[i].clone();
						kernel[i]= kernel[j].clone();
						kernel[j]= temp;
					}
				}else if(!pinyin.containsKey(""+ kernel[i][0].charAt(point)) && pinyin.containsKey(""+ kernel[j][0].charAt(point))){
					if(i< j) {
						if(!(i== rp || j== rp)) {
							String[] temp= kernel[i].clone();
							kernel[i]= kernel[j].clone();
							kernel[j]= temp;
						}
					}
				}else if(!pinyin.containsKey(""+ kernel[i][0].charAt(point)) && !pinyin.containsKey(""+ kernel[j][0].charAt(point))){
					if(kernel[i][0].toLowerCase().charAt(point)> kernel[j][0].toLowerCase().charAt(point)) {
						if(i< j) {
							String[] temp= kernel[i].clone();
							kernel[i]= kernel[j].clone();
							kernel[j]= temp;
						}
					}else if(kernel[i][0].toLowerCase().charAt(point)== kernel[j][0].toLowerCase().charAt(point)) {
						if(kernel[i][0].charAt(point)> kernel[j][0].charAt(point)) {
							if(i< j) {
								String[] temp= kernel[i].clone();
								kernel[i]= kernel[j].clone();
								kernel[j]= temp;
							}
						}
					}
				}
			}
		}
	}

	private boolean processSortPinYin(String[] kernel, int scale) {
		for(int k= 0; k< scale; k++) {
			if(kernel[0].length()<= k|| kernel[1].length()<= k) {
				if(kernel[0].length()< kernel[1].length()) {//长在上
					return true;
				}
				return false;
			}
			if(kernel[0].toLowerCase().charAt(k)> kernel[1].toLowerCase().charAt(k)) {
				return true;
			}else if(kernel[0].toLowerCase().charAt(k)< kernel[1].toLowerCase().charAt(k)) {
				return false;
			}
		}
		if(kernel[0].length()< kernel[1].length()) {//长在上
			return true;
		}
		return false;
	}
}