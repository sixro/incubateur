package yodarescue.util;

import glue.fx.BlockingTask;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

public class SqlQueryTask<T> extends BlockingTask<List<T>> {

  @SuppressWarnings("unused")
  private static final Logger LOG = LoggerFactory.getLogger(SqlQueryTask.class);
  
  private final NamedParameterJdbcTemplate jdbc;
  private final String sql;
  private final Map<String, Object> parameters;
  private final RowMapper<T> rowMapper;
  
  public SqlQueryTask(DataSource dataSource, String sql, Map<String, Object> parameters, RowMapper<T> rowMapper) {
    this(new NamedParameterJdbcTemplate(dataSource), sql, parameters, rowMapper);
  }
  
  public SqlQueryTask(NamedParameterJdbcTemplate jdbc, String sql, Map<String, Object> parameters, RowMapper<T> rowMapper) {
    this(
        "Loading...", 
        "-fx-font-family: \"Tahoma\", \"Helvetica\", serif; -fx-font-size: 0.9em;",
        jdbc,
        sql,
        parameters,
        rowMapper
      );
  }

  public SqlQueryTask(String blockingWindowMessage, String blockingWindowStyles, NamedParameterJdbcTemplate jdbc, String sql, Map<String, Object> parameters, RowMapper<T> rowMapper) {
    super(blockingWindowMessage, blockingWindowStyles);
    this.jdbc = jdbc;
    this.sql = sql;
    this.parameters = parameters;
    this.rowMapper = rowMapper;
  }

  @Override
  protected List<T> call() throws Exception {
      return jdbc.query(sql, parameters, rowMapper);
  }

}
