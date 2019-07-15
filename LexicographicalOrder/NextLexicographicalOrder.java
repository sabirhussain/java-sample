
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class NextLexicographicalOrder {

  public static void main(String[] args) throws IOException {
    try (
        BufferedReader br = new BufferedReader(new FileReader(new File("/Users/sabirhussain/Desktop/testcase1.txt")))) {
      String line = null;

      while ((line = br.readLine()) != null) {
        String result = processLine(line);
        try {
          Thread.sleep(50);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        System.out.println(line + ": " + result);
      }

    }
  }

  static String processLine(String w) {
    if (w.length() == 1)
      return "no answer";

    char[] chars = w.toCharArray();

    return getNextOrder(chars, chars.length - 1, chars.length - 2);
  }

  static String getNextOrder(char[] chars, int i, int j) {
    if (chars[i] > chars[j]) {

      char tmp = chars[i];
      chars[i] = chars[j];
      chars[j] = tmp;

      if (i == j + 1)
        return new String(chars);

      char[] subChars = Arrays.copyOfRange(chars, j + 1, chars.length);
      Arrays.sort(subChars);
      return new StringBuilder().append(Arrays.copyOfRange(chars, 0, j + 1)).append(subChars).toString();
    }

    if (i == 1)
      return "no answer";

    if (j == 0)
      return getNextOrder(chars, (i - 1), (i - 2));
    else
      return getNextOrder(chars, i, --j);
  }

}
