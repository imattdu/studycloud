package com.matt.springcloud.lb;

import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author matt
 * @create 2021-05-12 10:36
 */
@Component
public class MyLB implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement() {
        int current;
        int next;
        do {
            current = this.atomicInteger.get();
            // 2147483647: Integer.MAX_VALUE
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        } while(!this.atomicInteger.compareAndSet(current, next));
        System.out.println(next + "访问");
        return next;
    }

    @Override
    public ServiceInstance instances(List<ServiceInstance> serviceInstances) {

        int index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
