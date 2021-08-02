package top.mixedinfos.redis.test;

public class TestDemo {
    public static void main(String [] args){
        int i =1;
        int j = 2;
        switch (i){
            case 2:j=j+1;
            case 1:j=j+1;

            case 3:j=j+1;
            case 4:j=j+1;
            break;
        }
        System.out.println("j的值是："+j);


    }
}
