package org.deta.tinos.string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

import org.tinos.view.stable.StableData;

public class pinyin{
	public static void main(String argv[]) throws IOException {
		//init
		InputStream inputStreamc= new pinyin().getClass().getResourceAsStream(StableData.WORDS_SOURSE_LINK_POS_CN_TO_CN);
		BufferedReader cReaderc= new BufferedReader(new InputStreamReader(inputStreamc, StableData.UTF8_STRING));	
		InputStream inputStreamp= new pinyin().getClass().getResourceAsStream(StableData.WORDS_SOURSE_LINK_POS_CN_TO_PY);
		BufferedReader cReaderp= new BufferedReader(new InputStreamReader(inputStreamp, StableData.UTF8_STRING));
		//index
		String cInputStringc;
		String cInputStringp;
		Map<String,String> map= new HashMap<>();
		while ((cInputStringp= cReaderp.readLine())!= null) {
			cInputStringc= cReaderc.readLine();	
			String[] words= cInputStringp.split("/")[0].split(" ");
			for(int i=0; i<words.length; i++) {
				if(!map.containsKey(""+ cInputStringc.charAt(i))) {
					if(!cInputStringc.contains("字母")&&!cInputStringc.contains("标点")
							&&!cInputStringc.contains("数字")&&!cInputStringc.contains("数词")) {
						map.put(""+ cInputStringc.charAt(i), words[i]);
					}
				}
			}
		}
			String testValue[]= new String[10000];
			testValue[0]= "瑶光c";//lyg
			testValue[1]= "瑶林a";
			testValue[2]= "瑶光A";//lyl
			testValue[3]= "瑶1a";
			testValue[4]= "b瑶1a3";
			testValue[5]= "A瑶1a";
			testValue[6]= "瑶光b";//lzx
			testValue[7]= "正2兴";//lzx
			testValue[8]= "甜甜";//ltt
			testValue[9]= "正A强";//lzq
			testValue[10]= "正3才";
			testValue[11]= "韵律";
			testValue[12]= "振强";
			testValue[13]= "振旺";
			testValue[14]= "纪元";
			testValue[15]= "正好";
			testValue[16]= "正2才7314";
			testValue[17]= "a瑶1a5";
			testValue[18]= "正2才7";
			testValue[19]= "韵2律";
			testValue[20]= "振强3";
			testValue[21]= "振1旺";
			testValue[22]= "纪2元";
			testValue[23]= "正2好1";
			testValue[24]= "正2才5566";
			testValue[25]= "a瑶1a5";
			for(int i=26;i<10000;i++) {
				testValue[i]= testValue[i%25];
			}
			TimeCheck timeCheck=new TimeCheck();
			timeCheck.begin();
			new LYG4DWithChineseMixStringSort5D().quick4DChineseStringArray(testValue, 0, testValue.length- 1,6, map);
			timeCheck.end();;
			timeCheck.duration();
//			timeCheck.begin();
//			new LYG4DWithChineseMixStringSort2D().quick4DChineseStringArray(testValue, 0, testValue.length- 1,5, map);
//			timeCheck.end();;
//			timeCheck.duration();
//				for(int i=testValue.length-1;i>=0;i--) {
//						System.out.println(testValue[i]);
//					}
			for(int i= 0; i< testValue.length; i++) {
				System.out.println(testValue[i]);
			}
		}
	}