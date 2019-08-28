package org.deta.tinos.matrix;
public class MatrixValidation{
	public static boolean matrixCheck(Object[][] objects, String attribute){
		if(attribute.equalsIgnoreCase("boolean")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Boolean)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("int")) {
			for(int i= 0; i<objects.length; i++) {
				for(int j= 0; j<objects[0].length; j++) {
					if(!(objects[i][j] instanceof Integer)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("long")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Long)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("double")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Double)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("float")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Float)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("string")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof String)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("short")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Short)) {
						return false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("byte")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Byte)) {
						return false;
					}
				}
			}
		}
		return true;
	}

	public static Object[][] matrixFix(Object[][] objects, String attribute){
		if(attribute.equalsIgnoreCase("boolean")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Boolean)) {
						objects[i][j]= false;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("int")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Integer)) {
						objects[i][j]= (int)0;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("long")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Long)) {
						objects[i][j]= (long)0;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("double")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Double)) {
						objects[i][j]= (double)0.0;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("float")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Float)) {
						objects[i][j]= (float)0.0;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("string")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof String)) {
						objects[i][j]= "";
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("short")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Short)) {
						objects[i][j]= (short)0;
					}
				}
			}
		}
		if(attribute.equalsIgnoreCase("byte")) {
			for(int i= 0; i< objects.length; i++) {
				for(int j= 0; j< objects[0].length; j++) {
					if(!(objects[i][j] instanceof Byte)) {
						objects[i][j]= (byte)0;
					}
				}
			}
		}
		return objects;
	}
}