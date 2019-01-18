package tsypanov.gson.example;

import java.io.Serializable;
import java.util.regex.Pattern;

public class Rule implements Serializable {
  private Pattern beforebreak;
  private Pattern afterbreak;

  public Pattern getCompiledBeforebreak() {
    return beforebreak;
  }

  public Pattern getCompiledAfterbreak() {
    return afterbreak;
  }

}