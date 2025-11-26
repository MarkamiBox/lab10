package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.StringTokenizer;

/**
 * Settings.
 */
public final class Settings {
    private static final String FILE = "config.yml";
    private static final int DEFAULT_MIN = 10;
    private static final int DEFAULT_MAX = 60;
    private static final int DEFAULT_ATTEMPS = 1;
    private int max; 
    private int min;
    private int attempts;

    /**
     * Set the settings getting the info by the path file.
     * 
     * @throws IOException expception
     */
    public void setSetting() throws IOException {
        final InputStream stream = ClassLoader.getSystemResourceAsStream(FILE);
        if (stream == null) {
            setDefault();
            return;
        }
        try (BufferedReader br = new BufferedReader(new InputStreamReader(stream, StandardCharsets.UTF_8))) {
            String line = br.readLine();
            while (line != null) {
                final StringTokenizer st = new StringTokenizer(line, ":");
                if (st.countTokens() >= 2) {
                    final String keyToken = st.nextToken().trim();
                    final String valueToken = st.nextToken().trim();
                    final int value = Integer.parseInt(valueToken);

                    switch (keyToken) {
                        case "minimum":
                            this.min = value;
                            break;
                        case "maximum":
                            this.max = value;
                            break;
                        case "attempts":
                            this.attempts = value;
                            break;
                        default:
                            break;
                    }
                }
                line = br.readLine();
            }
        }
    }

    /**
     * Sets default values.
     */
    public void setDefault() {
        this.min = DEFAULT_MIN;
        this.max = DEFAULT_MAX;
        this.attempts = DEFAULT_ATTEMPS;
    }

    /**
     * Get the max.
     * 
     * @return max
     */
    public int getMax() {
        return this.max;
    }

    /**
     * Get the min.
     * 
     * @return min
     */
    public int getMin() {
        return this.min;
    }

    /**
     * Get the attempts.
     * 
     * @return attempts
     */
    public int getAttempts() {
        return this.attempts;
    }
}
