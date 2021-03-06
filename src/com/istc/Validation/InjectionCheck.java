package com.istc.Validation;

/**
 * SQL注入检测
 */

public class InjectionCheck {
    private static InjectionCheck self;
    private final static String[] SqlStr = {"*","'",";","-","+","/","%","#","\""};//特殊字符

    private InjectionCheck(){
    }

    /**
     * 单例模式 全局唯一的实例
     * @return 注入检测对象
     */
    public static InjectionCheck getInstance(){
        if(self == null){
            synchronized (InjectionCheck.class){
                if(self == null)self = new InjectionCheck();
            }
        }
        return self;
    }

/**
 * 包含有(* ' ; - + / % #)这些符号均会返回错误。
 */	
	private boolean check(final String targetString) {
        if(targetString == null)
            return true;
            String str = targetString.toLowerCase();
        for (String s: SqlStr) {
            if (str.contains(s))
                return false;
        }
        return true;
	}
	
	public boolean isValid(final String targetString){
		return check(targetString);
	}

/**
 * 考虑到输入大量数据时用户不便于修正，(* ' ; - + / % #)这些符号如果出现在大量文本并提交时，会被系统修改为全角符号。
 */		

	public String replaceString(String targetString){
		char[] charArray = targetString.toCharArray();
		for (int i = 0; i < targetString.length(); i++) {
            int charIntValue = (int)charArray[i];
            if (charIntValue >= 33 && charIntValue <= 47) {
                charArray[i] = (char) (charIntValue + 65248);
            }
		}
		return new String(charArray);
	}

}
