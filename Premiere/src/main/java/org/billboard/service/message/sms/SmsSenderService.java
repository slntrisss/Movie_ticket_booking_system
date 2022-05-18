package org.billboard.service.message.sms;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.billboard.dto.book.BookedSchedule;
import org.billboard.model.CinemaSeat;
import org.billboard.service.message.MessageSender;
import org.billboard.service.message.sms.config.TwilioConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class SmsSenderService implements MessageSender {
    private final TwilioConfig twilioConfiguration;

    @Autowired
    public SmsSenderService(TwilioConfig twilioConfiguration) {
        this.twilioConfiguration = twilioConfiguration;
    }

    @Override
    public void sendMessage(BookedSchedule bookedSchedule) {
        StringBuilder toNumber = new StringBuilder()
                .append("whatsapp:")
                .append(bookedSchedule.getUser().getPhone());
        StringBuilder fromNumber = new StringBuilder()
                .append("whatsapp:")
                .append(twilioConfiguration.getTrialNumber());
        PhoneNumber to = new PhoneNumber(toNumber.toString());
        PhoneNumber from = new PhoneNumber(fromNumber.toString());
        String message = generateMessage(bookedSchedule);
        Message message1 = Message.creator(to, from, message).create();
        System.out.println(message1.getStatus());
    }
    private String generateMessage(BookedSchedule bookedSchedule){
        StringBuilder sb = new StringBuilder();
        sb.append("*Movie:* ").append(bookedSchedule.getMovieName()).append("\n");
        sb.append("*Cinema:* ").append(bookedSchedule.getCinema().getCinemaName()).append("\n");
        sb.append("*Address:* ").append(bookedSchedule.getCinema().getAddress()).append("\n");
        sb.append("*Cinema hall:* ").append(bookedSchedule.getHall().getHallName()).append("\n");
        sb.append("*Seats:* ").append("\n");
        List<CinemaSeat> seats = bookedSchedule.getReservedSeats();
        for(CinemaSeat cinemaSeat:seats) {
            sb
                    .append("\t*Row:* ")
                    .append(cinemaSeat.getReservedRowNumber()).append(" ")
                    .append("\t*Seat:* ")
                    .append(cinemaSeat.getReservedSeatNumber()).append(" ")
                    .append("\t*Ticket:* ")
                    .append(cinemaSeat.getType()).append(" ")
                    .append("\n");
        }
        sb.append("*Start time:* ")
                .append(formatDate(bookedSchedule.getSchedule().getScheduleDate()))
                .append(", ")
                .append(bookedSchedule.getSchedule().getStartTime()).append("\n");
        sb.append("*Payment date:* ").append(formatDate(bookedSchedule.getPaymentDate())).append("\n");
        sb.append("*Price:* ").append(bookedSchedule.getPrice()).append("\n");
        return sb.toString();
    }
    private String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
        return dateFormat.format(date);
    }
}
