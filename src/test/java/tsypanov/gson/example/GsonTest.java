package tsypanov.gson.example;

import com.google.gson.Gson;
import org.junit.Test;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.regex.Matcher;

import static org.junit.Assert.assertEquals;

public class GsonTest {

  @Test
  public void name() throws Exception {
    try (InputStream resourceAsStream = getClass().getResourceAsStream("/rule.json")) {
      Rule rule = new Gson().fromJson(new InputStreamReader(resourceAsStream), Rule.class);

      assertEquals(2, getBreaks(rule));
    }
  }

  private int getBreaks(Rule rule) {
    int result = 0;
    String paragraph = "<br7>\n\n<br5>\n\nother";

    Matcher bbm = rule.getCompiledBeforebreak().matcher(paragraph);
    Matcher abm = rule.getCompiledAfterbreak().matcher(paragraph);

    if (!abm.find())
      return result;

    while (bbm.find()) {
      int bbe = bbm.end();
      int abs = abm.start();
      while (abs < bbe) {
        boolean found = abm.find();
        if (!found)
          return result;
        abs = abm.start();
      }
      if (abs == bbe)
        result++;
    }

    return result;
  }
}
