// PhoneNumberValidatorクラス（携帯電話番号の形式を検証するためのクラス）
package org.example;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

  // 携帯電話番号の正規表現パターンを定義。
  public static final String MOBILE_PHONE_NUMBER_PATTERN = "^(070|080|090)-\\d{4}-\\d{4}$";
  // 固定電話番号の正規表現パターンを定義。
  public static final String FIXED_PHONE_NUMBER_PATTERN = "^(0[1-9]{1,3})-\\d{1,4}-\\d{4}$";
  // 国際電話番号の正規表現パターンを定義。
  public static final String INTERNATIONAL_PHONE_NUMBER_PATTERN =
      "^\\+\\d{1,3}-\\d{1,4}-\\d{1,4}-\\d{1,10}$"//アメリカ、イギリス、オーストラリア、インド等の国際電話番号
          + "|^\\+\\d{1,3}-\\d{1,2}-\\d{1,3}-\\d{1,3}-\\d{1,3}-\\d{1,3}$"//フランスの国際電話番号
          + "|^\\+\\d{1,3}-\\d{1,3}-\\d{1,10}$";//ドイツの国際電話番号

  // 携帯電話番号かどうかを検証。
  public boolean isMobilePhoneNumber(String phoneNumber) {
    return isValid(phoneNumber, MOBILE_PHONE_NUMBER_PATTERN);
  }

  // 固定電話番号かどうかを検証。
  public boolean isFixedPhoneNumber(String phoneNumber) {
    return isValid(phoneNumber, FIXED_PHONE_NUMBER_PATTERN);
  }

  // 国際電話番号かどうかを検証。
  public boolean isInternationalPhoneNumber(String phoneNumber) {
    return isValid(phoneNumber, INTERNATIONAL_PHONE_NUMBER_PATTERN);
  }

  // 指定されたパターンに基づいて電話番号が有効かどうかを検証。
  private boolean isValid(String phoneNumber, String pattern) {
    if (phoneNumber == null || phoneNumber.isEmpty()) {
      return false;
    }

    Pattern compiledPattern = Pattern.compile(pattern);
    Matcher matcher = compiledPattern.matcher(phoneNumber);
    return matcher.matches();
  }
}

