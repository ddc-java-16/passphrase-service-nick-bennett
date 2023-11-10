package edu.cnm.deepdive.passphrase.configuration;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.regex.Pattern;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties(prefix = "file-storage")
@Configuration
public class FileStorageConfiguration {

  /** Flag controlling use of application home directory as file storage parent directory. */
  private boolean applicationHome = true;
  /** Base file-storage directory (relative to application home or working directory). */
  private String directory = "uploads";
  /** Pattern used to construct and extract subdirectory structure, based on filename. */
  private Pattern subdirectoryPattern = Pattern.compile("^(.{4})(.{2})(.{2}).*$");
  /** Allowed MIME types for uploaded files. */
  private Set<String> whitelist = Set.of();
  /** Properties used in construction of filename. */
  private FilenameProperties filename;

  public boolean isApplicationHome() {
    return applicationHome;
  }

  public void setApplicationHome(boolean applicationHome) {
    this.applicationHome = applicationHome;
  }

  public String getDirectory() {
    return directory;
  }

  public void setDirectory(String directory) {
    this.directory = directory;
  }

  public Pattern getSubdirectoryPattern() {
    return subdirectoryPattern;
  }

  public void setSubdirectoryPattern(Pattern subdirectoryPattern) {
    this.subdirectoryPattern = subdirectoryPattern;
  }

  public Set<String> getWhitelist() {
    return whitelist;
  }

  public void setWhitelist(Set<String> whitelist) {
    this.whitelist = whitelist;
  }

  public FilenameProperties getFilename() {
    return filename;
  }

  public void setFilename(
      FilenameProperties filename) {
    this.filename = filename;
  }

  public static class FilenameProperties {

    /** Name to use if original filename is not provided in upload. */
    private String unknown;
    /** Format string used in generation of filename. */
    private String format;
    /** Upper bound on random number used in filenames to avoid name collisions. */
    private int randomizerLimit;
    private TimestampProperties timestamp;

    public String getUnknown() {
      return unknown;
    }

    public void setUnknown(String unknown) {
      this.unknown = unknown;
    }

    public String getFormat() {
      return format;
    }

    public void setFormat(String format) {
      this.format = format;
    }

    public int getRandomizerLimit() {
      return randomizerLimit;
    }

    public void setRandomizerLimit(int randomizerLimit) {
      this.randomizerLimit = randomizerLimit;
    }

    public TimestampProperties getTimestamp() {
      return timestamp;
    }

    public void setTimestamp(
        TimestampProperties timestamp) {
      this.timestamp = timestamp;
    }

    public static class TimestampProperties {

      private String format;
      private String timeZone;

      public String getFormat() {
        return format;
      }

      public void setFormat(String format) {
        this.format = format;
      }

      public String getTimeZone() {
        return timeZone;
      }

      public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
      }

    }

  }

}
