package org.billboard.validation.phoneNumberValidation;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParenthesesValidator extends PhoneNumberValidator{

    public ParenthesesValidator(PhoneNumberVerification verification) {
        super(verification);
    }

    @Override
    public boolean matches(String number) {
        return super.matches(number) && validateNumberWithParentheses(number);
    }

    public boolean validateNumberWithParentheses(String number){
        //7(747)4690294
        //77474690294
        //7-(747)-469-02-94
        //7-747-469-02-94
        Pattern pattern = Pattern.compile(
                "^\\d?[- .]?((\\(\\d{3}\\))|\\d{3})[- .]?\\d{3}[- .]?(\\d{2}[- .]?){2}$"
        );
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
