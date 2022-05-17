package org.billboard.repository.daoImpl;

import org.billboard.model.Detail;
import org.billboard.repository.dao.CrudRepository;
import org.billboard.repository.dao.DetailDao;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class DetailDaoImpl implements DetailDao {
    private final JdbcTemplate jdbcTemplate;
    private static final String getDetailsByMovieId = "SELECT * FROM detail WHERE movie_id=?";
    private static final String getAllByMovieId = "SELECT * FROM detail";
    private static final String getAllLanguages = "SELECT language FROM detail WHERE movie_id=?";
    private static final String getReleasedDate = "SELECT d.release_date " +
            "FROM detail d, movie m " +
            "WHERE m.movie_id=d.movie_id " +
            "AND m.movie_id=?";
    private static final String saveDetailByMovieId =
            "insert into detail(country, language, duration, release_date, age_rating, " +
                    "rating, number_of_votes, description, movie_id) " +
                    "values(?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String lastId = "SELECT max(detail_id) FROM detail";

    private static final String getDuration = "SELECT duration FROM detail WHERE movie_id=?";
    private static final String updateDetail = "UPDATE detail SET country=?, " +
            "language=?, duration=?, release_date=?, age_rating=?, rating=?, " +
            "number_of_votes=?, description=? WHERE detail_id=?";

    public DetailDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    public Date getReleasedDate(int movieId){
        return jdbcTemplate.queryForObject(getReleasedDate, Date.class, movieId);
    }

    @Override
    public List<Detail> getAll() {
        return jdbcTemplate.query(getAllByMovieId, new BeanPropertyRowMapper<>(Detail.class));
    }

    @Override
    public Detail getById(int id) {
        return jdbcTemplate.queryForObject(getDetailsByMovieId,
                new BeanPropertyRowMapper<>(Detail.class), id);
    }

    @Override
    public void deleteById(int id) {

    }

    @Override
    public void save(Detail detail, int id) {
        jdbcTemplate.update(saveDetailByMovieId, detail.getCountry(), detail.getLanguage(),
                detail.getDuration(), detail.getReleaseDate(), detail.getAgeRating(),
                detail.getRating(), detail.getNumberOfVotes(), detail.getDescription(),
                id);
    }

    @Override
    public void update(Detail detail) {
        jdbcTemplate.update(updateDetail, detail.getCountry(),
                detail.getLanguage(), detail.getDuration(),
                detail.getReleaseDate(), detail.getAgeRating(),
                detail.getRating(), detail.getNumberOfVotes(),
                detail.getDescription(), detail.getDetailId());
    }

    @Override
    public String getLanguage(int movieId) {
        return jdbcTemplate.queryForObject(getAllLanguages, String.class, movieId);
    }

    @Override
    public Integer getLastId() {
        return jdbcTemplate.queryForObject(lastId, Integer.class);
    }

    @Override
    public Integer getDuration(int movieId) {
        return jdbcTemplate.queryForObject(getDuration, Integer.class, movieId);
    }
}
