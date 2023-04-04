package exercise;

// BEGIN
public class ListThread implements Runnable{
    private SafetyList safetyList;

    ListThread(SafetyList safetyList) {
        this.safetyList = safetyList;
    }

    public void run() {
        for (int i = 0; i < 1000; i++) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            safetyList.add(i);
        }
    }
}
// END
