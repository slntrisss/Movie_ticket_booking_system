package org.billboard.service.email;

import org.billboard.dto.book.BookedSchedule;
import org.billboard.model.CinemaSeat;
import org.billboard.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class EmailSenderService {
    private final JavaMailSender mailSender;

    @Autowired
    public EmailSenderService(JavaMailSender mailSender) {
        this.mailSender = mailSender;
    }

    public void sendMail(BookedSchedule bookedSchedule){
        User user = bookedSchedule.getUser();
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message);

        try{
            helper.setSubject("Premiere Ticket");
            helper.setFrom("rniyazakhunov@gmail.com");
            helper.setTo(user.getEmail());

            boolean html = true;
            String text = generateMessage(bookedSchedule);
            helper.setText(text, html);

        }catch (MessagingException e){
            e.printStackTrace();
        }

        mailSender.send(message);
    }
    private String generateMessage(BookedSchedule bookedSchedule){
        StringBuilder sb = new StringBuilder();
        sb.append("<p><b>Movie: </b>").append(bookedSchedule.getMovieName()).append("</p>");
        sb.append("<p><b>Cinema: </b>").append(bookedSchedule.getCinema().getCinemaName()).append("</p>");
        sb.append("<p><b>Address: </b>").append(bookedSchedule.getCinema().getAddress()).append("</p>");
        sb.append("<p><b>Cinema hall: </b>").append(bookedSchedule.getHall().getHallName()).append("</p>");
        sb.append("<p><b>Seats: </b>").append("</p>");
        sb.append("<table style=\"margin-left:40px\">");
        List<CinemaSeat> seats = bookedSchedule.getReservedSeats();
        for(CinemaSeat cinemaSeat:seats) {
            sb.append("<tr>")
                    .append("<td><b>Row:<b></td>").append("<td>")
                    .append(cinemaSeat.getReservedRowNumber()).append("</td>")
                    .append("<td><b>Seat:</b></td>")
                    .append("<td>").append(cinemaSeat.getReservedSeatNumber()).append("</td>")
                    .append("<td><b>Ticket:</b></td>")
                    .append("<td>").append(cinemaSeat.getType()).append("</td>")
                    .append("</tr>");
        }
        sb.append("</table>");
        sb.append("<p><b>Start time: </b>")
                .append(formatDate(bookedSchedule.getSchedule().getScheduleDate()))
                .append(", ")
                .append(bookedSchedule.getSchedule().getStartTime()).append("</p>");
        sb.append("<p><b>Payment date: </b>").append(formatDate(bookedSchedule.getPaymentDate())).append("</p>");
        sb.append("<p><b>Price: </b>").append(bookedSchedule.getPrice()).append("</p>");
        return sb.toString();
    }
    private String formatDate(Date date){
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd MMMM, yyyy");
        return dateFormat.format(date);
    }
}
