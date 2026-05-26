package fr.maxlego08.sarah;

import fr.maxlego08.sarah.conditions.ColumnDefinition;
import fr.maxlego08.sarah.database.DatabaseType;
import fr.maxlego08.sarah.dialect.SqlDialect;
import fr.maxlego08.sarah.dialect.SqlDialects;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class PostgreSqlMigrationDialectTest {

    @Test
    public void testPostgreSqlMissingColumnsRequiresConnection() {
        SqlDialect dialect = SqlDialects.from(DatabaseType.POSTGRESQL);
        assertThrows(NullPointerException.class, () -> dialect.missingColumns(null, null, "users", Arrays.asList(new ColumnDefinition("name", "VARCHAR"))));
    }
}
