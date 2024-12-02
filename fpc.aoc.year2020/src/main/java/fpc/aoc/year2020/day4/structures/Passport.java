package fpc.aoc.year2020.day4.structures;

import lombok.RequiredArgsConstructor;

import java.util.Map;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
public class Passport {

  /**
   * The fields present in the passport
   */
  private final Map<FieldName, String> fields;

  /**
   * @param fields the fields to check
   * @return true if this password contains the provided fields
   */
  public boolean hasFields(Set<FieldName> fields) {
    return this.fields.keySet().containsAll(fields);
  }

  public Optional<String> getField(FieldName fieldName) {
    return Optional.ofNullable(fields.get(fieldName));
  }

  public static PassportBuilder builder() {
    return new PassportBuilder();
  }


}
