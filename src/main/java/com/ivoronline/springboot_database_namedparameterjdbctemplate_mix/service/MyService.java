package com.ivoronline.springboot_database_namedparameterjdbctemplate_mix.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Service;

@Service
public class MyService {

  //PROPERTIES
  @Autowired private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

  //=========================================================================================================
  // MIXED STATEMENTS
  //=========================================================================================================
  public int mixedStatements(String name1, Integer age1, String nameNew, String nameOld) {

    String sql = " INSERT INTO PERSON (NAME, AGE) VALUES (:name1, :age1);        "+
                 " UPDATE      PERSON SET NAME = :nameNew WHERE name = :nameOld; ";

    SqlParameterSource parameters = new MapSqlParameterSource()
      .addValue("name1"  , name1  )
      .addValue("age1"   , age1   )
      .addValue("nameNew", nameNew)
      .addValue("nameOld", nameOld);

    return namedParameterJdbcTemplate.update(sql, parameters);

  }

}
