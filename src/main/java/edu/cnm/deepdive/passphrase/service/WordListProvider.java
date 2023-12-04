package edu.cnm.deepdive.passphrase.service;

import edu.cnm.deepdive.passphrase.configuration.DicewareConfiguration;
import jakarta.persistence.criteria.CriteriaBuilder.In;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
public class WordListProvider implements WordProvider {

  private final List<String> words;

  @Autowired
  public WordListProvider(DicewareConfiguration configuration) {
    Resource resource = new ClassPathResource(configuration.getWordList());
    try (Stream<String> stream =
        new BufferedReader(new InputStreamReader(resource.getInputStream())).lines()) {
      words = stream
          .map(String::strip)
          .filter((line) -> !line.isEmpty())
          .collect(Collectors.toList());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }

  @Override
  public List<String> words() {
    return words;
  }

}
