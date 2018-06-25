package source;


public class Main {
    
    public static void main(String[] args) {
        
        WorkerListener workerListener = new WorkerListener() {
            @Override
            public void onWorkerStarted(){
                System.out.println("Worker started.");
            }
            @Override
            public void onWorkerStoped(){
                System.out.println("Worker stopped.");
            }
            @Override
            public void onTaskStarted( int taskNumber, String taskName ){
                System.out.println("Task " + taskNumber + " " + taskName + " started.");
            }
            @Override
            public void onTaskCompleted( int taskNumber, String taskName ){
                System.out.println("Task " + taskNumber + " " + taskName + " completed.");
            }
        };
        
        Task task1 = new Task(){
            @Override
            public void run(int taskNumber){
                System.out.println("Running task " + taskNumber);
                for(int i=1;i<4;i++)
                    System.out.println(i);
            }
        };
        
        Task task2 = new Task(){
            @Override
            public void run(int taskNumber){
                System.out.println("Running task " + taskNumber);
                for(int i=3;i>0;i--)
                    System.out.println(i);
            }
        };
        
        Worker newWorker = new Worker("Worker 1");
        
        newWorker.setListener(workerListener);
        newWorker.start();
       
        newWorker.enqueueTask("SomeTask", task1);
        newWorker.enqueueTask("OtherTask", task2);
         
        
        
    }
    
}
