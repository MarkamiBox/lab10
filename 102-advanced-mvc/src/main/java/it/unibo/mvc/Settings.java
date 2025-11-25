package it.unibo.mvc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public final class Settings{
    private int max = 0; 
    private int min = 0;
    private int attempts  = 0;
    private static final String PATH = "config.yml";

    /**
     * Set the settings getting the info by the path file
     * @return nothing
     * @throws IOException 
    */
    public void SetSetting() throws IOException{
        final InputStream stream = ClassLoader.getSystemResourceAsStream(PATH);
        String line;

        BufferedReader br = new BufferedReader(new InputStreamReader(stream));
        while ((line = br.readLine()) != null) {
            final StringTokenizer st = new StringTokenizer(line, ":");

            if(st.countTokens() >= 2){
                final String firstToken = st.nextToken().trim();
                final String SecondToken = st.nextToken().trim();

                final int value = Integer.parseInt(SecondToken);

                switch (firstToken) {
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
        }
    }

    /**
     * Get the max
     * 
     * @return max
     */
    public int getMax(){
        return this.max;
    }

    /**
     * Get the min
     * 
     * @return min
     */
    public int getMin(){
        return this.min;
    }

    /**
     * Get the attempts
     * 
     * @return attempts
     */
    public int getAttempts(){
        return this.attempts;
    }
}
