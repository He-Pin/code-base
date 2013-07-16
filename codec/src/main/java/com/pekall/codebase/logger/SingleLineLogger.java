package com.pekall.codebase.logger;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * author: hepin1989@gmail.com
 */
public class SingleLineLogger {
    private static int LENGTH = 80;
    private static final String APPENDBLANK = "     ";
    private static final char ANGLER_SEG = '+';
    private static final char BOUNDER_V_SEG = '|';
    private static final char BOUNDER_H_SEG = '-';
    private static final String HEAD_START_MARK = ">>>>>>";
    private static final String HEAD_END_MARK = "<<<<<<";
    private static final ExecutorService worker;
    static{
        worker = Executors.newSingleThreadExecutor();
    }


    public static int getLENGTH() {
        return LENGTH;
    }

    public static String LogDATA(String ...strings){
        //clean the data;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buildStartOrEndBound());
        stringBuilder.append('\n');
        for(String s : strings){
            stringBuilder.append(buildLine(s));
        }
        stringBuilder.append(buildStartOrEndBound());
        stringBuilder.append('\n');
        return stringBuilder.toString();


    }

    public static void SlogDATA(final String ...strings){
        worker.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(LogDATA(strings));
            }
        });
    }

    public static void SlogBounderLine(){
        worker.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(buildStartOrEndBound());
            }
        });
    }

    public static void SlogDataLine(final String...strings){
        worker.execute(new Runnable() {

            @Override
            public void run() {
                System.out.println(LogDataLine(strings));
            }
        });
    }

    public static String LogDataLine(String ...strings){
        StringBuilder stringBuilder = new StringBuilder();
        for(String s : strings){
            stringBuilder.append(buildLineWithoutEND(s));
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }


    public static void SlogHEAD(String ...strings){
        System.out.println(LogHEAD(strings));
    }

    public static String LogHEAD(String ...strings){
        //clean the data;
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(buildStartOrEndBound());
        stringBuilder.append('\n');
        for(String s : strings){
            stringBuilder.append(buildLine(HEAD_START_MARK+s+HEAD_END_MARK));
        }
        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }



    public static void setLENGTH(int lENGTH) {
        LENGTH = lENGTH;
    }


    private static StringBuilder buildStartOrEndBound(){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.setLength(0);
        stringBuilder.append(ANGLER_SEG);
        for (int i = 0; i < LENGTH-3; i++) {
            stringBuilder.append(BOUNDER_H_SEG);
        }
        stringBuilder.append(ANGLER_SEG);
        return stringBuilder;
    }

    private static StringBuilder buildLine(String insertString){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BOUNDER_V_SEG);
        stringBuilder.append(APPENDBLANK);
        stringBuilder.append(insertString);
        int n = stringBuilder.length();
        if (n > LENGTH - 1) {
            stringBuilder.delete(LENGTH - 2, n -1);
        }else {
            for(int i = 1,l = LENGTH - n - 1;i < l;i++){
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append(BOUNDER_V_SEG);
        stringBuilder.append('\n');
        return stringBuilder;

    }

    private static StringBuilder buildLineWithoutEND(String insertString){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BOUNDER_V_SEG);
        stringBuilder.append(APPENDBLANK);
        stringBuilder.append(insertString);
        int n = stringBuilder.length();
        if (n > LENGTH - 1) {
            stringBuilder.delete(LENGTH - 2, n -1);
        }else {
            for(int i = 1,l = LENGTH - n - 1;i < l;i++){
                stringBuilder.append(' ');
            }
        }
        stringBuilder.append(BOUNDER_V_SEG);
        return stringBuilder;
    }
}
