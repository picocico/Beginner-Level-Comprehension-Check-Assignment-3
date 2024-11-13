// PhoneNumberInputクラス（ユーザーから携帯電話番号を入力させるためのクラス）
package org.example;

import java.util.Scanner;

public class PhoneNumberInput {

  private final Scanner scanner;

  // コンストラクタでスキャナーを初期化。
  public PhoneNumberInput() {
    this.scanner = new Scanner(System.in);
  }

  // ユーザーから電話番号を入力させる。
  public String getPhoneNumber() {
    System.out.println("携帯電話番号をハイフンをつけて入力してください（例：090-1234-5678）：");
    return scanner.nextLine();
  }

  // スキャナーを閉じる。
  public void closeScanner() {
    scanner.close();
  }
}
