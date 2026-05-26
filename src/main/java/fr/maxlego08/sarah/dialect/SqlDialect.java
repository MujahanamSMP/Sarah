package fr.maxlego08.sarah.dialect;

import fr.maxlego08.sarah.DatabaseConfiguration;
import fr.maxlego08.sarah.DatabaseConnection;
import fr.maxlego08.sarah.conditions.ColumnDefinition;
import fr.maxlego08.sarah.database.Schema;
import fr.maxlego08.sarah.logger.Logger;

import java.util.List;

public interface SqlDialect {

    String quoteIdentifier(String name);

    String qualifyIdentifier(String prefix, String column);

    String driverClassName();

    String jdbcUrl(DatabaseConfiguration configuration);

    String createTableSuffix();

    String columnType(ColumnDefinition column);

    String autoIncrementKeyword(ColumnDefinition column);

    String enumColumnType(ColumnDefinition column);

    String updatedAtDefaultValue();

    String upsertConflictClause(Schema schema);

    String upsertUpdateExpression(String quotedColumn, boolean batch);

    boolean usesUpsertUpdateParameters(boolean batch);

    List<ColumnDefinition> missingColumns(DatabaseConnection connection, Logger logger, String tableName, List<ColumnDefinition> expectedColumns);
}
