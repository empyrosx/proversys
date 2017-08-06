package com.github.empyrosx;

import com.github.database.rider.core.DBUnitRule;
import com.github.database.rider.core.api.connection.ConnectionHolder;
import org.junit.Ignore;
import org.junit.Rule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Connection;
import java.sql.SQLException;

import static com.github.empyrosx.proversys.db.Profiles.HSQLDB;

/**
 * Base Dao test.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/spring-db.xml", "classpath:spring/spring-test-db.xml"})
@Ignore
@ActiveProfiles({HSQLDB})
public class AbstractDaoTest {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Rule
    public DBUnitRule dbUnitRule = DBUnitRule.instance(new ConnectionHolder() {
        public Connection getConnection() throws SQLException {
            return jdbcTemplate.getDataSource().getConnection();
        }
    });
}
