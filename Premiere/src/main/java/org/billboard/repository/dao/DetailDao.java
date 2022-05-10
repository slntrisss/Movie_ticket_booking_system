package org.billboard.repository.dao;

import java.util.Date;

public interface DetailDao {
    Date getReleasedDate(int movieId);
}
