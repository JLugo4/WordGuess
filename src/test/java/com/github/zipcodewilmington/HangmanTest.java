package com.github.zipcodewilmington;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.File;

/**
 * @author xt0fer
 * @version 1.0.0
 * @date 5/27/21 11:02 AM
 */
public class HangmanTest {
@Test
public void TestGame(String word, String letterGuess){
    String expected = word;
    String actual = word;

    Assert.assertEquals(expected, actual);
}

}
