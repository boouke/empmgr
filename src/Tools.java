public class Tools {
    private long startTime;

    public void stopwatchStart() {
        startTime = System.nanoTime();
    }

    public String stopwatchStop() {
        long endTime = System.nanoTime();
        long elapsedTime = endTime - startTime;

        double seconds = (double) elapsedTime / 1_000_000_000.0;
        double milliseconds = (double) elapsedTime / 1_000_000.0;

        return String.format("%.3f", seconds) + " s (" + String.format("%.3f", milliseconds) + " ms)";
    }
}