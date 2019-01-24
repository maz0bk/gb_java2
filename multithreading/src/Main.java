public class Main {
    static Object mon = new Object();
    static volatile char currentLetter = 'A';

    public static void main(String[] args) {
       threadCreator('A','B').start();
       threadCreator('B','C').start();
       threadCreator('C','D').start();
       threadCreator('D','A').start();

    }
    private static Thread threadCreator(char threadChar, char nextChar){
        return  new Thread(() ->{
            try{
                for (int i = 0; i < 5; i++) {
                    synchronized (mon)  {
                        while (currentLetter != threadChar){
                            mon.wait();
                        }
                        System.out.print(threadChar);
                        currentLetter = nextChar;
                        mon.notifyAll();
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
    }
}
