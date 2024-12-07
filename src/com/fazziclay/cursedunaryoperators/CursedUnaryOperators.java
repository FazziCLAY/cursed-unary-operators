package com.fazziclay.cursedunaryoperators;

import java.lang.constant.ConstantDescs;
import java.lang.reflect.Field;
import java.util.function.UnaryOperator;

public class CursedUnaryOperators {
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_FIRST = b -> b;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_SECOND = b -> !!b;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_THIRD = b -> !!!!b;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_EQTRUE = b -> b == true;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_EQNOTFALSE = b -> b != false;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_STRING = b -> Boolean.parseBoolean(b.toString());
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_AND = b -> (b && b);
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_AND_B = b -> (b & b);
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_OR = b -> (b || b);
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_OR_B = b -> (b | b);
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_VALUEOF_EQT = b -> String.valueOf(b).equals("true");
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_CONCAT_EQT = b -> (b+"").equals("true");
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_FORMAT_EQT = b -> (String.format("%s", b)).equals("true");
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_FORMATTED_EQT = b -> ("%s".formatted(b)).equals("true");
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_MEME_FIRST = b -> b.describeConstable().orElseThrow() == ConstantDescs.TRUE;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_HASHCODE = b -> b.hashCode() == 1231;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_COMPARE = b -> Boolean.compare(b, true) == 0;
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_FIRST_T = b -> String.valueOf(b).charAt(0) == 't';
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_TERNARY_TRUE = b -> (b ? true : false);
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_BITWISE_XOR = b -> (b ^ b);
    public static final UnaryOperator<Boolean> BOOLEAN_CURSED_ARRAY_ACCESS = b -> new Boolean[]{b}[0];



    public static void test() throws Exception {
        for (boolean tb : new boolean[]{false, true}) {
            for (Field field : CursedUnaryOperators.class.getFields()) {
                System.out.printf("=== %s ===%n", field.getName());
                @SuppressWarnings("unchecked")
                UnaryOperator<Boolean> operator = (UnaryOperator<Boolean>) field.get(CursedUnaryOperators.class);
                if (operator.apply(tb) != tb) {
                    throw new Exception("Unary operator '%s' return inverted value :<".formatted(field.getName()));
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        test();
        System.out.println("All tests passed!");
    }
}
