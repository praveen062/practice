package com.project;

import java.util.Scanner;

import org.apache.curator.CuratorZookeeperClient;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.framework.api.CreateBuilder;
import org.apache.curator.framework.api.WatchesBuilder;
import org.apache.curator.framework.recipes.atomic.CachedAtomicLong;
import org.apache.curator.framework.recipes.atomic.DistributedAtomicLong;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.curator.retry.RetryNTimes;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.apache.zookeeper.ZooKeeper;

import io.netty.handler.ssl.ClientAuth;

public class Main {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		 String ZOO_SERVER = "localhost:2181";
		 final String COUNTER_PATH = "/TinyUrl/counter";
		 String COUNTER_PATH2 = "/TinyUrl/counter/a";
		long SPAN = 10;
		
		final CuratorFramework client;
		DistributedAtomicLong count;
		client = CuratorFrameworkFactory.newClient(ZOO_SERVER,
				new ExponentialBackoffRetry(1000, 3));
		
		
		

		client.start();
		CreateBuilder cb = client.create();
		try {
		cb.withMode(CreateMode.PERSISTENT_WITH_TTL);
		cb.withTtl(1)
		.forPath(COUNTER_PATH2);
		client.setData().forPath(COUNTER_PATH2, "".getBytes());
		}catch (Exception e) {
			// TODO: handle exception
			System.out.println(e);
		}
		
		count = new DistributedAtomicLong(client, COUNTER_PATH2,
				new RetryNTimes(10, 10));
		CachedAtomicLong c = new CachedAtomicLong(count, 10);
		c.next().postValue();
		Watcher watcher = new Watcher() {
			
			public void process(WatchedEvent event) {
				// TODO Auto-generated method stub
				System.out.println(event.toString()+" "+event.getPath());
				try {
					System.out.println(client.getChildren().forPath(COUNTER_PATH));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		client.watchers().add().usingWatcher(watcher).forPath(COUNTER_PATH2);
		System.out.println(client.getChildren().forPath(COUNTER_PATH));
	
		System.out.println("count is "+c.next().postValue());
		
		Scanner s = new Scanner(System.in);
		String st = s.next();
		while(st != "t") {
			st = s.next();
		}
	}

}
