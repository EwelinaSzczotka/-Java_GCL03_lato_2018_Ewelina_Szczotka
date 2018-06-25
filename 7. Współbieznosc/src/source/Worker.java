package source;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;


public class Worker {
    
    private String workerName;
    private WorkerListener listener;
    private Thread workerThread = null;
    private volatile boolean running;
    private Map<String,Task> m = null;

    
    public Worker(String workerName){
        this.workerName = workerName;
        m = new LinkedHashMap<String,Task>();   
    }
    
    
    private class WorkerThread extends Thread {
        
        public void run(){
            listener.onWorkerStarted();
            int taskNumber = 0;
            while(running){
                
                    Map.Entry<String,Task> nextEntry = null;
                    
                    synchronized(m){
                        Iterator<Map.Entry<String,Task>> i = m.entrySet().iterator();
                        if(i.hasNext()){
                            nextEntry = i.next();
                            i.remove();
                        }
                    }
                    
                    if(nextEntry!=null){
                        String name = nextEntry.getKey();
                        Task task = nextEntry.getValue();
                        taskNumber++;
                        listener.onTaskStarted(taskNumber, name);
                        try{
                            task.run(taskNumber);
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }
                        listener.onTaskCompleted(taskNumber,name);
                        }
                    else{
                        try{
                            synchronized(m){
                                m.wait();
                            }
                        }
                        catch(InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                     
            }
            
            listener.onWorkerStoped();
        }
        
    }
    
    
    void enqueueTask( String taskName, Task task ){
        
        synchronized(m){
            m.put(taskName,task);
            m.notify();
        }
        
    }
    
    void start(){
        if(workerThread == null || !isStarted()) {
            running=true;
            workerThread = new WorkerThread();
            workerThread.setName("Worker "+ workerName + " Thread");
            workerThread.start();
        }
    }
        
    
    void stop(){
        if(workerThread.isAlive()){
            running=false;
            workerThread=null;
        }
    }
    
    void setListener(WorkerListener listener){
        this.listener=listener;
    }
    
    boolean isStarted(){
        return workerThread.isAlive();
    }
    
    boolean isWorking() {
        if(!m.isEmpty())
            return true;
        else return false;
    }
}
