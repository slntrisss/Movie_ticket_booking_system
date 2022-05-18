package org.billboard.service.message;

import org.billboard.dto.book.BookedSchedule;

public interface MessageSender {
    void sendMessage(BookedSchedule bookedSchedule);
}
