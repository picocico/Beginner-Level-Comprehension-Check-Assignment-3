// Mainクラス（ユーザーから携帯電話番号を入力させ、その番号が有効な携帯電話番号かどうかを確認する）
package org.example;

public class Main {

  public static void main(String[] args) {
    // PhoneNumberInputクラスのインスタンスを作成し、ユーザーからの入力を受け取る。
    PhoneNumberInput input = new PhoneNumberInput();
    // PhoneNumberValidatorクラスのインスタンスを作成し、電話番号の検証を行う。
    PhoneNumberValidator validator = new PhoneNumberValidator();
    String phoneNumber;

    try {
      while (true) {
        // ユーザーから電話番号を取得。
        phoneNumber = input.getPhoneNumber();

        // ハイフンの入力漏れを確認。
        if (!phoneNumber.matches("^\\d{2,4}-\\d{2,4}-\\d{4}$") &&
            !phoneNumber.matches("^\\+\\d{1,3}-\\d{1,4}-\\d{1,10}-\\d{1,10}$") &&
            !phoneNumber.matches("^\\+\\d{1,3}-\\d{1,2}-\\d{1,3}-\\d{1,3}-\\d{1,3}-\\d{1,3}$") &&
            !phoneNumber.matches("^\\+\\d{1,3}-\\d{1,3}-\\d{1,10}$")) {
          System.out.println(
              "電話番号にハイフンが含まれていません。正しい形式で入力してください（例：080-9012-3456 :");
          continue;
        }

        // 入力された電話番号が携帯電話番号かどうかを確認。
        if (validator.isMobilePhoneNumber(phoneNumber)) {
          System.out.println("有効な携帯電話番号です。");
          break;
          // 入力された電話番号が固定電話番号かどうかを確認。
        } else if (validator.isFixedPhoneNumber(phoneNumber)) {
          System.out.println(
              "こちらは固定電話番号です。携帯電話番号を入力してください（例：080-9012-3456）:");
          // 入力された電話番号が国際電話番号かどうかを確認。
        } else if (validator.isInternationalPhoneNumber(phoneNumber)) {
          System.out.println(
              "こちらは国際電話番号です。携帯電話番号を入力してください（例：070-7890-1234）:");
          // 入力された電話番号が無効な場合のメッセージを表示。
        } else {
          System.out.println("無効な携帯電話番号です。");
        }
      }
    } finally {
      // スキャナーを閉じてリソースを解放。
      input.closeScanner();
    }
  }
}




