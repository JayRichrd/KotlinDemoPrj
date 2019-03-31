import kotlinx.coroutines.*

/**
 * @author : jiangyu
 * @date   : 2019-03-31
 * @desc   : xxx
 */
fun main(args: Array<String>) = runBlocking<Unit> {
//    val job1 = GlobalScope.launch {
//        run("job1")
//    }

//    val job2 = GlobalScope.launch {
//        run("job2")
//    }

//    delay(2000L)
//    job1.join()
//    println("主协程结束.")
    withTimeout(200L){
        run("Job3")
    }
}

suspend fun run(name: String) {
    //启动一个协程
    for (i in 0..100) {
        // 打印协程执行次数
        println("子协程{$name}执行第${i}次")
        // 随机生成挂起时间
        val sleepTime = (20 * Math.random()).toLong()
        println("sleepTime = $sleepTime")
        // 协程挂起
        delay(sleepTime)
    }
}