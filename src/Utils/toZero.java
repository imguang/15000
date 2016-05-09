package Utils;

public class toZero {
	public static String toZeroUtil(Object temp){
		if(null == temp || "".equals(temp)){
			return "0";
		} else {
			return temp.toString();
		}
	}
    public static String toEmptyUtil(String temp){
    	if(null == temp || "".equals(temp)){
			return " ";
		} else {
			return temp;
		}
    }
}
