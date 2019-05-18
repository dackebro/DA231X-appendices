package com.experiments.changes;

import org.apache.commons.codec.digest.DigestUtils;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class MemberTest {
  @Test
  public void initMember_thenSuccess() {
    Member m = new Member("erik", "erik94@erik.com", "2019-03-28T11:31", "pwd");
    assertEquals("erik", m.userName);
    assertEquals("erik94@erik.com", m.email);
    assertEquals("2019-03-28T11:31", m.memberSince);
    assertEquals(false, m.getLoggedOn());
  }

  @Test
  public void initMemberEmail_thenSuccess() {
    Member m = new Member("erik", "erik94@erik.com", "2019-03-28T11:31", "pwd");
    assertEquals("erik94@erik.com", m.email);
  }

  @Test
  public void changePasswordHashCorrect_thenSuccess() {
    Member m = new Member("erik", "erik94@erik.com", "2019-03-28T11:31", "pwd");
    try {
      assertEquals(new String(DigestUtils.sha256("password")),
              m.changePassword("pwd", "password"));
      assertEquals(new String(DigestUtils.sha256("password")),
              m.changePassword("password", "password"));
    } catch (IOException e) {
      fail();
    }
  }

  @Test
  public void changePasswordHashIncorrect_thenFail() {
    Member m = new Member("erik", "erik94@erik.com", "2019-03-28T11:31", "pwd");
    assertThrows(IOException.class, () ->
            m.changePassword("password", "password"));
  }

  @Test
  public void logInCorrectPassword_thenSuccess() {
    Member m = new Member("erik", "erik94@erik.com", "2019-03-28T11:31", "pwd");
    assertTrue(m.logIn("pwd"));
    assertTrue(m.getLoggedOn());
  }

  @Test
  public void logInIncorrectPassword_thenFail() {
    Member m = new Member("erik", "erik94@erik.com", "2019-03-28T11:31", "pwd");
    assertFalse(m.logIn("password"));
    assertFalse(m.getLoggedOn());
  }
}

