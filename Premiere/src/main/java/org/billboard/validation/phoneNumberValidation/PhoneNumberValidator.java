package org.billboard.validation.phoneNumberValidation;

public abstract class PhoneNumberValidator implements PhoneNumberVerification{
    private PhoneNumberVerification verification;

    public PhoneNumberValidator() {
    }

    public PhoneNumberValidator(PhoneNumberVerification verification) {
        this.verification = verification;
    }

    @Override
    public boolean matches(String number) {
        return verification.matches(number);
    }
}
