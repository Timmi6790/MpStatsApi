package de.timmi6790.mpstats.api;

import de.timmi6790.mpstats.api.configs.DatabaseConfiguration;
import org.jdbi.v3.core.Jdbi;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;

@Testcontainers
public abstract class AbstractIntegrationTest {
    @Container
    private static final PostgreSQLContainer<?> POSTGRE_SQL_CONTAINER = new PostgreSQLContainer<>(
            DockerImageName
                    .parse("timescale/timescaledb:2.0.0-rc4-pg12")
                    .asCompatibleSubstituteFor("postgres")
    );

    static {
        POSTGRE_SQL_CONTAINER.start();
        DatabaseConfiguration.setupDatabase(
                POSTGRE_SQL_CONTAINER.getJdbcUrl(),
                POSTGRE_SQL_CONTAINER.getUsername(),
                POSTGRE_SQL_CONTAINER.getPassword()
        );
    }

    public static Jdbi jdbi() {
        return Jdbi.create(
                POSTGRE_SQL_CONTAINER.getJdbcUrl(),
                POSTGRE_SQL_CONTAINER.getUsername(),
                POSTGRE_SQL_CONTAINER.getPassword()
        );
    }
}