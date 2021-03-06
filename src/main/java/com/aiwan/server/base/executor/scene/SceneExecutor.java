package com.aiwan.server.base.executor.scene;

import com.aiwan.server.base.executor.ICommand;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import org.springframework.stereotype.Component;

import java.util.concurrent.*;

/**
 * 场景线程池
 *
 * @author dengzebiao
 */
@Component
public class SceneExecutor {

    private static final int SCENE_POOL_SIZE = Runtime.getRuntime().availableProcessors() * 4 / 10;

    private static final ThreadPoolExecutor[] SCENE_SERVICE = new ThreadPoolExecutor[SCENE_POOL_SIZE];

    /**
     * 线程池初始化
     */
    public static void initialize() {
        for (int i = 0; i < SCENE_POOL_SIZE; i++) {
            //线程命名
            ThreadFactory nameThreadFactory = new ThreadFactoryBuilder().setNameFormat("userThread-pool-" + i).build();
            RejectedExecutionHandler policy = new ThreadPoolExecutor.DiscardPolicy();
            BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(512);
            SCENE_SERVICE[i] = new ThreadPoolExecutor(1, 1, 0, TimeUnit.SECONDS, queue, nameThreadFactory, policy);
        }

    }

    public void addTask(ICommand command) {
        int modIndex = command.modIndex(SCENE_POOL_SIZE);
        SCENE_SERVICE[modIndex].submit(() -> {
            if (!command.isCanceled()) {
                command.active();
            }
        });
    }


    private int modIndex(String account) {
        return Math.abs(account.hashCode() % SCENE_POOL_SIZE);
    }
}
