
import java.util.ArrayList;

/**
 * Created by namjune on 2016-08-14.
 */
public class KmpEx {
  public static void main(String[] args) {
    String strings = "ABC ABCDAB ABCDABCDABDE";
    String pattern = "ABCDABD";
    int startIndex = 0;
    int searchCount = 0;
    ArrayList<Integer> startIndexList = new ArrayList<>();
    KmpAlgorithm kmpAlgorithm = new KmpAlgorithm(pattern.length());
    kmpAlgorithm.fail(pattern);
    kmpAlgorithm.printFail(strings, pattern);

    startIndex = kmpAlgorithm.search(strings, pattern, startIndex);
    if (startIndex == -1) {
      System.out.println("Ž����� ����.");
    } else {
      System.out.println("Ÿ���� �����ε��� : " + startIndex + "\n");
      searchCount++;
      startIndexList.add(startIndex);
      while (startIndex + (pattern.length() - 1) != strings.length()) {  //Ÿ���� ������ ���� ��� �ߺ��˻�.
        startIndex = kmpAlgorithm.search(strings, pattern, startIndex + 1);
        if (startIndex == -1) {
          break;
        }
        System.out.println("Ÿ���� �����ε��� : " + startIndex + "\n");
        searchCount++;
        startIndexList.add(startIndex);
      }
      System.out.println("Ž������");
      System.out.println("\"" + strings + "\"" + "���� " + "\"" + pattern + "\" " + searchCount + "�� �˻��Ϸ�. ������ġ : " + startIndexList);
    }
  }
}