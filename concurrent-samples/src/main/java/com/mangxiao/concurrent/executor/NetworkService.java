package com.mangxiao.concurrent.executor;

import lombok.extern.slf4j.Slf4j;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Slf4j(topic = "c.NetworkService")
public class NetworkService implements Runnable{
    private final ServerSocket serverSocket;
    private final ExecutorService pool;

    public NetworkService(int port, int poolSize) throws IOException {
        serverSocket = new ServerSocket(port);
        pool = Executors.newFixedThreadPool(poolSize);
    }
    @Override
    public void run() {
        try {
            log.debug("before execute ...");
            pool.execute(new Handler(serverSocket.accept()));
            log.debug("after execute ...");
        }catch (Exception e){
            log.debug("ERROR :" + e.getMessage());
            pool.shutdown();
        }
    }

    public static void main(String[] args) throws IOException {
        NetworkService ns = new NetworkService(9000,20);
        Thread t1 = new Thread(ns);
        t1.start();
    }
}

@Slf4j(topic = "c.Handler")
class Handler implements Runnable{
    private final Socket socket;
    Handler(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {
        log.debug("handler run...");
    }
}
