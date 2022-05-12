package org.billboard.validation.phoneNumberValidation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PrefixValidator extends PhoneNumberValidator{

    public PrefixValidator(PhoneNumberVerification verification) {
        super(verification);
    }

    @Override
    public boolean matches(String number) {
        return super.matches(number) && validateNumberWithPrefix(number);
    }

    public boolean validateNumberWithPrefix(String number){
        //+7-(747)-469-02-94
        //7-(747)-469-02-94
        //(747)-469-02-94
        //747-469-02-94
        //7474690294
        //+7-7474690294
        //+77474690294
        Pattern pattern = Pattern.compile("^(\\+?\\d( )?[- .]?)?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?(\\d{2}[- .]?){2}$");
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
