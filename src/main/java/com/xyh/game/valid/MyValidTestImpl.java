package com.xyh.game.valid;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class MyValidTestImpl implements ConstraintValidator<MyValidTest, Object> {
    private int length;

    @Override
    public void initialize(MyValidTest constraintAnnotation) {
        length = constraintAnnotation.length();
    }

    @Override
    public boolean isValid(Object s, ConstraintValidatorContext constraintValidatorContext) {
        if(s == null){
            return false;
        }else if(s instanceof String){
            String temp = (String) s;
            if(temp.length()>length){
                return false;
            }else{
                return true;
            }
        }else{
            return false;
        }
    }
}
