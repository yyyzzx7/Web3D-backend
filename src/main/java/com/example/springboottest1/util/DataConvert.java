package com.example.springboottest1.util;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Arrays;

public class DataConvert {
    public static String StringValue(String expression){
        if(expression == null)
            return "0";
        ScriptEngineManager scriptEngineManager = new ScriptEngineManager();
        ScriptEngine scriptEngine = scriptEngineManager.getEngineByName("nashorn");
        try {
            return String.valueOf(scriptEngine.eval(expression));
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return "0";
    }

    public static double[] StringToDoubleArray(String str){
        if(str == null){
            return new double[0];
        }
        // "[1,0,-1]" --> [1,0,-1] or contains Math.PI / 2
        String[] items = str.replaceAll("\\[", "").replaceAll("\\]", "").replaceAll("\\s", "").split(",");
        double[] result = new double[items.length];
        for (int t = 0; t < items.length; t++) {
            if(items[t].contains("Math.PI")){
                result[t] = Double.parseDouble(StringValue(items[t]));
            }else{
                result[t] = Double.parseDouble(items[t]);
            }
        }
        return result;
    }


    public static String[] StringToStringArray(String str){
        if(str == null)
            return new String[0];
        return Arrays.stream(
                str.substring(1, str.length()-1).replaceAll("\\s", "").split(","))
                .map(e -> e.replaceAll("\"", ""))
                .toArray(String[]::new);
    }
}
