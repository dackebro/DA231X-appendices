package com.experiments.changes;

import org.apache.commons.codec.digest.DigestUtils;
import java.io.IOException;

public class Member {
  public String userName;
  public final String email;
  public final String memberSince;
  private String passwordHash;
  private final boolean admin;
  private boolean loggedOn;

  public Member(String userName, String email, String memberSince, String password) {
    this.userName = userName;
    this.email = email;
    this.memberSince = memberSince;
    this.passwordHash = sha256(password);
    this.admin = false;
    this.loggedOn = false;
  }

  private static String sha256(String s) {
    return new String(DigestUtils.sha256(s));
  }

  private static String sha512(String s) {
    return new String(DigestUtils.sha512(s));
  }

  private void validatePasswordViaHash(String passwordAttempt) throws IOException {
    String hash = sha256(passwordAttempt);
    if (!passwordHash.equals(hash)) {
      throw new IOException("Password don't match");
    }
  }

  public boolean getLoggedOn() {
    return loggedOn;
  }

  private boolean setLoggedOnTrue() {
    loggedOn = true;
    return true;
  }

  public boolean logIn(String password) {
    boolean validated;
    try {
      validatePasswordViaHash(password);
      validated = true;
    } catch (IOException e) {
      validated = false;
    }
    return validated && setLoggedOnTrue();
  }

  public String changePassword(String oldPwd, String newPwd) throws IOException {
    String newHash = sha256(newPwd);
    validatePasswordViaHash(oldPwd);
    passwordHash = newHash;
    return newHash;
  }
}
