package org.billboard.service.validator;

import org.billboard.error.exception.InvalidCinemaException;
import org.billboard.model.Cinema;
import org.billboard.repository.dao.CinemaDao;
import org.billboard.validation.phoneNumberValidation.*;
import org.springframework.stereotype.Service;

@Service
public class CinemaValidatorService {
    private final CinemaDao<Cinema> cinemaRepo;

    public CinemaValidatorService(CinemaDao<Cinema> cinemaRepo) {
        this.cinemaRepo = cinemaRepo;
    }

    public boolean validateCinema(Cinema cinema) throws InvalidCinemaException {
        StringBuilder cinemaName = new StringBuilder();
        cinemaName.append("%").append(cinema.getCinemaName()).append("%");
        if(cinemaRepo.exists(cinemaName.toString()))
            throw new InvalidCinemaException("Given cinema name \"" +
                    cinema.getCinemaName() + "\" already exists");
        return phoneVerification(cinema);
    }
    public boolean phoneVerification(Cinema cinema) throws InvalidCinemaException {
        PhoneNumberVerification verification;
        boolean accepted = false;
        if(cinema.getPhone().contains("+")){
            verification = new PrefixValidator(new PhoneNumberVerificationImpl());
            accepted = verification.matches(cinema.getPhone());
        }
        else if(cinema.getPhone().contains("(") || cinema.getPhone().contains(")")){
            verification = new ParenthesesValidator(new PhoneNumberVerificationImpl());
            accepted = verification.matches(cinema.getPhone());
        }
        else {
            verification = new DashValidator(new PhoneNumberVerificationImpl());
            accepted = verification.matches(cinema.getPhone());
        }
        if(!accepted)
            throw new InvalidCinemaException("Given phone number format \"" +
                    cinema.getPhone() + "\" is invalid");

        return true;
    }
}
