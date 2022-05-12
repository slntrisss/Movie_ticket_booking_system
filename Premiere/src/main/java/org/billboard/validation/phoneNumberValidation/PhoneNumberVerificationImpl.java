package org.billboard.validation.phoneNumberValidation;

public class PhoneNumberVerificationImpl implements PhoneNumberVerification{
    @Override
    public boolean matches(String number) {
        int count = 0;
        char[] arr = number.toCharArray();
        for(char e: arr){
            if(Character.isDigit(e))
                count++;
        }
        return count == 11 || count == 10;
    }
}
