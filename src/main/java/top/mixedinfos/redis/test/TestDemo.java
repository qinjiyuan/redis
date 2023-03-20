package top.mixedinfos.redis.test;

import jdk.nashorn.internal.ir.debug.ClassHistogramElement;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TestDemo {
    public static void main(String [] args){
        SimpleDateFormat sdf= new SimpleDateFormat("yyyy-MM-dd");
        String nowDate = sdf.format(new Date());
        String message = "BOSIDENG"+nowDate;
        try{
            MessageDigest md  = MessageDigest.getInstance("MD5");
            md.update(message.getBytes());
            byte[] digest = md.digest();
            int i;
            StringBuilder sb = new StringBuilder();
            for (int offset = 0; offset < digest.length; offset++) {
                i = digest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    sb.append(0);
                sb.append(Integer.toHexString(i));//通过Integer.toHexString方法把值变为16进制
            }
            System.out.println(sb.toString());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
