package edu.cnm.deepdive.passphrase.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "diceware")
public class DicewareConfiguration {

  private String wordList;

  public String getWordList() {
    return wordList;
  }

  public void setWordList(String wordList) {
    this.wordList = wordList;
  }
}
