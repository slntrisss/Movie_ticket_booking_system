package org.billboard.validation.phoneNumberValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DashValidator extends PhoneNumberValidator{

    public DashValidator(PhoneNumberVerification verification){
        super(verification);
    }

    @Override
    public boolean matches(String number) {
        return super.matches(number) && validateNumberWithDashes(number);
    }

    public boolean validateNumberWithDashes(String number){
        //202 555 0125
        //7-747-469-02-94
        //7 747 469 02 94
        // ^\\d{1}[- .]?(\\d{3}[- .]?){2}\\d{2}[- .]?\\d{2}$
        Pattern pattern = Pattern.compile("^\\d?[- .]?(\\d{3}[- .]?){2}(\\d{2}[- .]?){2}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
