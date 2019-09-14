package org.deta.tinos.tree;

import org.deta.tinos.string.QuickLuoyaoguang4D;

import timeProcessor.TimeCheck;

public class TreeLuoyaoguang4D{
	public static void main(String[] argv) {
		String[] testValue= new String[2500];
		testValue[0]= "caÂÞcded";
		testValue[1]= "baÂÞcded";
		testValue[2]= "ÑþBcedd";
		testValue[3]= "CaÂÞcded";
		testValue[4]= "ÑþAb";
		testValue[5]= "bCaef";
		testValue[6]= "BCAe";
		for(int i= 7; i< 2500; i++) {
			testValue[i]= ""+ Math.random();
		}
		TimeCheck imeCheck2= new TimeCheck();
		imeCheck2.begin();
		Node head= new Node();
		TreeLuoyaoguang4D.sort(head, testValue, 3);
		imeCheck2.end();
		imeCheck2.duration();

		testValue= new String[2500];
		testValue[0]= "caÂÞcded";
		testValue[1]= "baÂÞcded";
		testValue[2]= "ÑþBcedd";
		testValue[3]= "CaÂÞcded";
		testValue[4]= "ÑþAb";
		testValue[5]= "bCaef";
		testValue[6]= "BCAe";
		for(int i= 7; i< 2500; i++) {
			testValue[i]= ""+ Math.random();
		}
		imeCheck2= new TimeCheck();
		imeCheck2.begin();
		new QuickLuoyaoguang4D().quick4DStringArray(testValue, 0
				,testValue.length- 1, 3);
		imeCheck2.end();
		imeCheck2.duration();
		
	}

	private static void sort(Node head, String[] testValue, int scale) {
		for(int i= 0; i< testValue.length; i++) {
			addNode(head, testValue[i], scale);	
		}
	}

	private static void addNode(Node head, String testValue, int scale) {
		Node temp= head;
		if(null== temp.value) {
			temp.value= testValue;
		}else {
			for(int i= 0; i< scale- 1; i++) {
				if(temp.value.toLowerCase().charAt(i)
						< testValue.toLowerCase().charAt(i)) {
					boolean find= true;
					for(int p= 0; p< scale; p++) {
						if(temp.value.charAt(p)!= testValue.charAt(p)) {
							find= false;
						}
					}
					if(find) {
						if(temp.left!= null) {
							addNode(head.left, testValue, scale);	
						}else {
							temp.left= new Node();
							temp.left.value= testValue;
						}
					}
				}else {
					boolean find= true;
					for(int p= 0; p< scale; p++) {
						if(temp.value.charAt(p)!= testValue.charAt(p)) {
							find= false;
						}
					}
					if(find) {
						if(temp.left!= null) {
							addNode(head.left, testValue, scale);	
						}else {
							temp.left= new Node();
							temp.left.value= testValue;
						}
					}
				}
			}
		}
	}	
}

class Node{
	String value;
	public Node left;
	public Node right;
}