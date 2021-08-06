package threading;


public class Threading {

    public static void main(String[] args) throws InterruptedException {
        
        final ProducerConsumer pc = new ProducerConsumer();
        
        Thread t1 = new Thread(new Runnable(){
            
            @Override
            public void run() {
                try {
                    pc.produce();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } 
        });
        
        
        Thread t2 = new Thread(new Runnable(){
            
            @Override
            public void run() {
                try {
                    pc.consume();
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            } 
        });
        
        
        
        t1.start();
        t2.start();
        
        t1.join();
        t2.join();
  
    }
    
}
