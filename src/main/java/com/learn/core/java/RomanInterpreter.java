package com.learn.core.java;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by Admin on 04-07-2016.
 */
public class RomanInterpreter {
    public static void main(String[] args) {

        convertToNumber("MCMXXVIII");
        convertToNumber("XC");
        convertToNumber("MDCCCLXXXVIII");
        convertToRoman(1928);
        convertToRoman(955);
        convertToRoman(700);
        convertToRoman(8888);

    }

    static void convertToRoman(int number){
        Context numericContext = new Context(number);
        NumericToRomanInterpretor numericToRomanInterpretor = new NumericToRomanInterpretor();
        numericToRomanInterpretor.interpret(numericContext);
        System.out.println(number + " = " + numericContext.getRomanValue());
    }


    static Context convertToNumber(String roman){
        Context romanContext = new Context(roman);
        RomanToNumericInterpretor romanToNumericExpression = new RomanToNumericInterpretor() ;
        romanToNumericExpression.interpret(romanContext);
        System.out.println(roman + " = " + romanContext.getIntegerValue());
        return romanContext;
    }
}

class Context {

    private String romanValue="";
    private int integerValue;

    public Context(String romanValue)
    {
        this.romanValue = romanValue;
    }

    public Context(int integerValue)
    {
        this.integerValue = integerValue;
    }

    public String getRomanValue()
    {
        return romanValue;
    }

    public void setRomanValue(String romanValue)
    {
        this.romanValue = romanValue;
    }

    public int getIntegerValue()
    {
        return integerValue;
    }

    public void setIntegerValue(int integerValue)
    {
        this.integerValue = integerValue;
    }

}

abstract class Interpretor{
    ArrayList<Expression> tree = new ArrayList<Expression>();
    Interpretor(){
        tree.add(new ThousandExpression());
        tree.add(new HundredExpression());
        tree.add(new TenExpression());
        tree.add(new OneExpression());
    }

    abstract void interpret(Context context);

    public int interprate(Expression expression, int value,Literal literal,StringBuilder sb){
        if(value == 0){
            return 0;
        }
        if(value == literal.number || value > literal.number){
            sb.append(literal.symbol);
            value = value - literal.number;
        }
        return value;
    }
}

class NumericToRomanInterpretor extends  Interpretor{

    public void interpret(Context context)
    {
        tree.forEach(exp-> {
            int value = context.getIntegerValue();
            int digit = value / exp.multiplier();
            value = value % exp.multiplier();
            context.setIntegerValue(value);
            while(digit>0)
            {
                StringBuilder sb = new StringBuilder(context.getRomanValue());
                for(Literal literal :exp.literals()){
                    digit = interprate(exp,digit,literal,sb);
                }
                context.setRomanValue(sb.toString());
            }
        });

    }




}

class RomanToNumericInterpretor extends Interpretor{

    public void interpret(Context context)
    {
        if (context.getRomanValue().length() == 0)
            return;

        tree.forEach(exp-> {
            if (context.getRomanValue().startsWith(exp.nine().symbol)) {
                context.setIntegerValue(context.getIntegerValue() + (9 * exp.multiplier()));
                context.setRomanValue(context.getRomanValue().substring(2));
            } else if (context.getRomanValue().startsWith(exp.four().symbol)) {
                context.setIntegerValue(context.getIntegerValue() + (4 * exp.multiplier()));
                context.setRomanValue(context.getRomanValue().substring(2));
            } else if (context.getRomanValue().startsWith(exp.five().symbol)) {
                context.setIntegerValue(context.getIntegerValue() + (5 * exp.multiplier()));
                context.setRomanValue(context.getRomanValue().substring(1));
            }

            while (context.getRomanValue().startsWith(exp.one().symbol)) {
                context.setIntegerValue(context.getIntegerValue() + (1 * exp.multiplier()));
                context.setRomanValue(context.getRomanValue().substring(1));
            }
        });


    }


}

abstract class Expression {
    abstract Literal one() ;
    abstract Literal four();
    abstract Literal five();
    abstract Literal nine();
    abstract int multiplier();
    Literal[] literals(){
        return new Literal[]{nine(),five(),four(),one()};
    }

}

class ThousandExpression  extends Expression{
    public Literal one() { return new Literal(1,"M"); }
    public Literal four(){ return new Literal(4,"NM "); }
    public Literal five(){ return new Literal(5,"N"); }
    public Literal nine(){ return new Literal(9,"MZ"); }
    public int multiplier() { return 1000; }
}

class HundredExpression extends Expression{
    public  Literal one() { return new Literal(1,"C"); }
    public  Literal four(){ return new Literal(4,"CD"); }
    public  Literal five(){ return new Literal(5,"D"); }
    public  Literal nine(){ return new Literal(9,"CM"); }
    public  int multiplier() { return 100; }
}

 class TenExpression  extends Expression{
    public Literal one() { return new Literal(1,"X"); }
    public Literal four(){ return new Literal(4,"XL"); }
    public Literal five(){ return new Literal(5,"L"); }
    public Literal nine(){ return new Literal(9,"XC"); }
    public int multiplier() { return 10; }
}

 class OneExpression  extends Expression{
    public Literal one() { return new Literal(1,"I"); }
    public Literal four(){ return new Literal(4,"IV"); }
    public Literal five(){ return new Literal(5,"V"); }
    public Literal nine(){ return new Literal(9,"IX"); }
    public int multiplier() { return 1; }

}

class Literal{
    int number;
    String symbol;
    public Literal(int number, String symbol){
        this.number = number;
        this.symbol = symbol;
    }
}