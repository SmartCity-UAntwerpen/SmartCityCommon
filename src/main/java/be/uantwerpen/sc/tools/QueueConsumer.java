package be.uantwerpen.sc.tools;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.BlockingQueue;

/**
 * Created by Niels on 4/05/2016.
 */

//RCore
// Todo Probably not intended to be in Tools, perhaps deprecated?
    /*
public class QueueConsumer implements Runnable
{
    private CCommandSender sender;
    private QueueService queueService;
    private DataService dataService;

    @Value("${sc.core.ip:localhost}")
    private String serverIP;

    @Value("#{new Integer(${sc.core.port}) ?: 1994}")
    private int serverPort;

    private boolean lockGranted = false;
    private boolean first = true;

    private BlockingQueue<String> jobQueue;

    public QueueConsumer(QueueService queueService, CCommandSender sender, DataService dataService)
    {
        this.queueService = queueService;
        this.sender = sender;
        this.dataService = dataService;
    }

    @Deprecated
    public void setServerCoreIP(String ip, int port)
    {
        this.serverIP = ip;
        this.serverPort = port;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            try {
                //System.out.println("Consumer wants to consume");
                Thread.sleep(100);

                if(dataService.getNextNode() != -1) {
                    if (!lockGranted) {
                        //Robot already has permission?
                        if (!(dataService.hasPermission() == dataService.getNextNode())) {
                            Terminal.printTerminal("Millis: " + dataService.getMillis() + " ,linkMillis: " + (dataService.getLinkMillis() - 150));
                            if (dataService.getMillis() > dataService.getLinkMillis() - 200) {
                                //Pause robot
                                sender.sendCommand("DRIVE PAUSE");
                                Terminal.printTerminal("PAUSED");
                                //Ask for permission
                                RestTemplate rest = new RestTemplate();
                                boolean response = false;
                                Terminal.printTerminal("Lock Requested");
                                while (!response) {
                                    response = rest.getForObject("http://" + serverIP + ":" + serverPort + "/point/requestlock/" + dataService.getNextNode(), boolean.class);

                                    if (!response) {
                                        Terminal.printTerminal("Lock Denied: " + dataService.getNextNode());
                                        Thread.sleep(200);
                                    }
                                }
                                //response true -> Lock granted
                                Terminal.printTerminal("Lock Granted: " + dataService.getNextNode());
                                lockGranted = true;
                                dataService.setPermission((int)(long)dataService.getNextNode());
                                Terminal.printTerminal("Permission: " + dataService.hasPermission() + " ,NextNode: " + dataService.getNextNode());
                                sender.sendCommand("DRIVE RESUME");
                                Terminal.printTerminal("RESUMED");
                            }
                        } else {
                            lockGranted = true;
                        }
                    }
                }

                if(queueService.getContentQueue().size() == 0){
                    //System.out.println("queue is empty");
                }else{
                    //If robot not busy
                    if(!dataService.robotBusy) {
                        Terminal.printTerminal(queueService.getContentQueue().toString());
                        String s = queueService.getJob();
                        Terminal.printTerminal("Sending: " + s);
                        sender.sendCommand(s);
                        //change looking coordinate when turning
                        if(dataService.getCurrentLocation()!=-1)
                            if(dataService.getMap().changeLookingDir(dataService.getCurrentLocation(), dataService.getTag())!=null)
                                dataService.setLookingCoordiante(dataService.getMap().changeLookingDir(dataService.getCurrentLocation(), dataService.getTag()));
                        System.out.println("coordinate: "+dataService.getLookingCoordiante());

                        if(!s.contains("DRIVE DISTANCE")) {
                            dataService.robotBusy = true;
                            dataService.setLocationVerified(false);
                        }
                        if(s.contains("DRIVE FOLLOWLINE")){
                            //Next Link
                            if(first) {
                                first = false;
                                Terminal.printTerminal("Setting up");
                            }else{
                                dataService.nextLink();
                            }

                            //TODO when sending manual commands calling getNextNode will crash the program
                            //When changing link reset permission
                            if(dataService.hasPermission() == dataService.getNextNode()){
                                //Leave permission
                            }else {
                                dataService.setPermission(-1);
                                Terminal.printTerminal("Permission reset");
                                lockGranted = false;
                            }

                            //Unlock point
                            RestTemplate rest = new RestTemplate();
                            rest.getForObject("http://" + serverIP + ":" + serverPort + "/point/setlock/" + dataService.getPrevNode() + "/0", Boolean.class);
                        }
                    }
                }
                //System.out.println("CrunchifyBlockingConsumer: Message - " + queueService.getJob() + " consumed.");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}
*/
