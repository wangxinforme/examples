package com.job.quartz.service;

public class Test {

    // 模拟了抽奖过程,礼品是iphone的机率为1/12；是mp3 的机率为1/5；是洗衣粉的机率为1/2；剩余是KFC优惠券。
    public static void prizes() {
        int i = (int) (Math.random() * 100); // 得到1-60的随机数
        if (i < 5) { // 在60个数里得到小于5的概率为5比60
            System.out.println("恭喜中了：iphone手机,i=" + i);
        } else if (i < 17) {// 在60个数里得到小于5的概率为12比60
            System.out.println("恭喜中了：mp3,i=" + i);
        } else if (i < 47) {// 在60个数里得到小于5的概率为30比60
            System.out.println("恭喜中了：洗衣粉,i=" + i);
        } else {// 在60个数里得到小于5的概率为13比60
            System.out.println("恭喜中了：KFC优惠券,i=" + i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            prizes();
        }
    }
}
