package com.smart.sperms;

import com.alibaba.fastjson.JSON;
import com.smart.sperms.api.protocol.DataBody103;
import com.smart.sperms.api.protocol.MsgPayload;
import com.smart.sperms.utils.DateUtils;
import com.smart.sperms.utils.XxteaUtils;
import org.junit.Test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.*;

public class TestUtils {

    @Test
    public void testMqttMsg() {
        String message = "{\"code\": 0, \"data\": {\"firmwareVersion\":\"1.0.0\",\"softwareVersion\":\"1.0.0\"}, \"protocol\": 101}";
        String key = "25fd36gfegl";
        try {
//            String encryptData = XxteaUtils.encryptToHexString(message, key);
            String encryptData = "05fe7873a1b25a2f2dfcac147f1cef84362fb410041851709aac71978cf0d886fb1760a94e2ef8912d7716c2ef4da45e33907b633464694e182804d6c11d8315960b3ac586821b40d83f236d5d57bdae683dbe0588ae0f0da6132f095ea03c3e4dbb69c01642fad88972d383a93a9a349bb1aa0b05809c87595fb98b54f2d5f4734cf4195352d92b9c768999d3b8f4c543adddc05c4c7ec5";
            System.out.println("encryptPayload = "+ encryptData);

            String decryptData = XxteaUtils.decryptFromHexString(encryptData, key);
            System.out.println("decryptPayload = "+ decryptData);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testStr() {
        String decryptToken = "sperms:201908301123311";
        boolean isOk = decryptToken.matches("^sperms:\\d{14}$");
        System.out.println("isOk = "+ isOk);
    }

    @Test
    public void testImg() {
        String imgBase64 =
                "/9j/4AAQSkZJRgABAQAAAQABAAD/2wBDAAEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
                "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/2wBDAQEBAQEBAQEBAQEBAQEBAQEBAQEB" +
                "AQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQEBAQH/wAARCABIAEgDASIA" +
                "AhEBAxEB/8QAHwAAAQUBAQEBAQEAAAAAAAAAAAECAwQFBgcICQoL/8QAtRAAAgEDAwIEAwUFBAQA" +
                "AAF9AQIDAAQRBRIhMUEGE1FhByJxFDKBkaEII0KxwRVS0fAkM2JyggkKFhcYGRolJicoKSo0NTY3" +
                "ODk6Q0RFRkdISUpTVFVWV1hZWmNkZWZnaGlqc3R1dnd4eXqDhIWGh4iJipKTlJWWl5iZmqKjpKWm" +
                "p6ipqrKztLW2t7i5usLDxMXGx8jJytLT1NXW19jZ2uHi4+Tl5ufo6erx8vP09fb3+Pn6/8QAHwEA" +
                "AwEBAQEBAQEBAQAAAAAAAAECAwQFBgcICQoL/8QAtREAAgECBAQDBAcFBAQAAQJ3AAECAxEEBSEx" +
                "BhJBUQdhcRMiMoEIFEKRobHBCSMzUvAVYnLRChYkNOEl8RcYGRomJygpKjU2Nzg5OkNERUZHSElK" +
                "U1RVVldYWVpjZGVmZ2hpanN0dXZ3eHl6goOEhYaHiImKkpOUlZaXmJmaoqOkpaanqKmqsrO0tba3" +
                "uLm6wsPExcbHyMnK0tPU1dbX2Nna4uPk5ebn6Onq8vP09fb3+Pn6/9oADAMBAAIRAxEAPwD/AD/6" +
                "9O+DHwb+JX7QnxQ8JfBr4Q+HP+Er+IXje8u7Hwz4f/tXRNFGoXFjpeoaxe79V8QalpekWMdrpmmX" +
                "t7LNf38EXlQsiM87Rxv5jXUeCPGnir4beM/CvxB8Da1eeHfF/gvX9I8UeF9esGVLzSde0S/g1HS9" +
                "Qg3q8bPbXdvFIYpkeCVQ0M8UkLyo3PilinhMUsDKhDGvD1lg54qFSphYYr2dRYeWJp0qlKrUoKr7" +
                "N1oUqkKkqanGFSM2pqKntPZ1PZOCq8kvZOopOmqnLLkdRRkpOHNyuSi1Jx5kpJ2ZX8WeFPEvgPxV" +
                "4k8EeMdFvvDvirwjrmreGvE2ganCYNS0XX9Ev7nTNW0q+hJPlXVhe2k9tOgJUSRttdlKu3P1/Qj+" +
                "1/8As6a5/wAFRPhn8E/+Cg37Hfw5m8TfFj4iXuk/Bv8Aay+D3hCNRdeGvjJoWl29pZePMX10bPTf" +
                "DOo6bHYw6preq6tbWNh4Wu/h1rmsSJqNx43v7ftPgd/wbefHfxVplvq37QPx38EfCOW4toLlfCng" +
                "vw9e/FDxFayOw87TNd1GXV/BXhvTL2FQxa40HU/FenFvLEdzIHYr+dLxY4Py3JqGN4qzfB5BmlOd" +
                "bBZpklSVXFZjg80wdWeHx1CGBwkMRjK2GVaHPhMZGi6OIwlTD4mNTlqq3jLiDLqWGjVx+Ip4SvFy" +
                "pYjCycp1qWIpylCrBUqcZ1JQ5oqVOpy8s6coTvZ6/wA3VFf2Af8AENV8Bv7O8oftNfFn+1fLx9t/" +
                "4RTwX/Z3m4Pz/wBl7PtPl5wfK/tbdjK+dn5q+Pvjl/wbg/Hjwnpt3q/wA+Ongj4vPa2090fCvjHw" +
                "/e/C7xJdyIziHTNCv11jxp4a1O8lXyyLnXtW8KaeGMoknjCIX83AePHhTmGJjhYcUQwtSUlGE8wy" +
                "7NcFh5XaXNLF4jBww1GPeWIq00ldtpJswo8WZBWqezWPVOV7J1qNelB62v7SdNQiut5yjZbs/ng8" +
                "J+FPEnjzxV4b8EeDdFvvEXivxdrmk+GfDOgaZCbjUta1/W7+DTNI0qxgBBlur++uIbaBCQDLIoZg" +
                "uXrqvjD8IPiN8Avib4t+D/xa8Onwr8QPBN7bWHibQDqmi6yLC5u9Ns9WtAmq+H9S1TSL6O506+s7" +
                "yKawv54vLnRGdZllQftr+yR+z1rn/BMH4Z/Gv9vz9r34dT+Gvi34Bv8AVPg3+yd8IPF8Q+0+IvjD" +
                "rel3ttqHj9lsrpLTU/DGmaX9ui0zWtL1a4sNQ8MWvxA1jSJJNTi8Dahc/hL4y8YeKPiH4v8AFHj3" +
                "xrrV54h8W+Mte1bxP4n17UHV73V9e1q/udR1TUbllVUEt3eXM0zJEqQx7ljhjSJEWvsMk4kqcRZ5" +
                "m0cq+p4jhnKaNHBPN6cpVnmef1XTxNelltelWeHqZdlmDlTpYquoVHXzHEPD0KsPqOLVT0sLjXjc" +
                "ViFh/ZzwOHjCl9Yi3J18XJqco0Jxm4So0KSSqSs3KtNwjJeyqKXNUUUV9eeiFfY/7DH7FfxO/bu+" +
                "O+kfB74fumi6RbQrr3xH+IF7aSXWj+APBMF1Bb3us3FsssB1XV72WWPTvDHh2K4gn1nWZoo7i80/" +
                "Q7bXfEFn8cV/fp/wRp/ZM0z9lr9ijwHq17psMPxK+PWnaP8AF34iak0MYvxaa9p5u/h/4Vkla2hu" +
                "4bXwp4TvLRptKuXmWw8W6v4yuLZ1W+kU/lfi/wCIEvD3hKrjsH7Oec5lWWXZNCooyhSryhVnXx1S" +
                "nK6nTwNGPOoSUoTxM8JSqxdKc2eDxDm7yjL5VafK8TWl7HDJpNKbU3Kq4u940oxvZ3TqOnGScZTZ" +
                "9rfstfsofA39jX4Uab8JPgb4Vi0TSIBBc+IfEF4Yrvxf458QJAIbnxP4z1xbe3k1fV7woxjjjjt9" +
                "H0m1ZNJ8PaXp2iQWenR/Q5OST6/4n+mP/wBZNfX/AOxvq3wt0rx3r8vxFn0K0v5NJtl8J6h4lazj" +
                "0m2uVupjqiJcahiztNSuIPsws55WjkaBb62gl82YxS8f+1TqHw31P4t3lz8NG0qXTf7H0+PXLrQh" +
                "b/2Le+JVudTN5c6e9ofsk6tZNp0d1cWmYJ75LmUvJOZpW/hXNeHa2P4N/wCIkZjxbgMwzPM86rYP" +
                "F5PXryq53KfPXi8VWnOvKpKpL2KrOi6KhDBVKFVYjWNFfldfByqZY86rZhRq1q2JlTqYaU3LFSlz" +
                "VE6km5XcnyqfK42VKcJc+nK/m+q7H7xz68/i4H8l9+nckmVjgEdz/LL89Pw/E8kqc/Rn7KWpfDXS" +
                "/i7a3HxNfSYtO/sa/TQrrXhb/wBiWfiU3Ni1lc6hJeD7HAosU1JLW5uyIIL6S1k3pcCCVfjuHsqh" +
                "n+e5Xk1TMMLlcMzx2HwcsxxsuXC4SNao4e2rNyimklaMXOEZT5YSqwUnUPLwdBYzF0MNKtToKvVh" +
                "Sdaq7U6alOUeaWq20srq7snJLmkfmp+1P+yh8Ef2xvhVqfwn+N3haPWdLm8658PeILIw2fi/wPr7" +
                "wyxW3ifwbrbW9xJpeq23y+bDLFc6Pq1sDpXiLS9S0aS60+X+A79tv9jT4m/sNfHTWvg98QSmr6bL" +
                "Cdc+HnjyytJLXR/H3gq4urmCw1y1t3lnbTNUtpLeTTvEnh+W4uJtG1qC5ggvdR0aXR9evP8AVC/b" +
                "P1b4Vat4+0KT4cTaDeX8Wjzp4tv/AAy1nJpFzdG6Y6Wj3Onk2V3qcEH2gX08LySLA9ha3MxlhEK/" +
                "zt/8Fkf2TdL/AGn/ANizx1rljp0EvxJ+Aenaz8XPh/qQiT7a2naJYS3nxE8KpKttPdS2vijwpp9x" +
                "NBpds0X2/wAW6P4Nlndkswh/ffDbjXGeE/iNiuAMXn2Gz7hPE5pSyypi8LU58DhMdilRVDNMGnVq" +
                "Rw3JXqRw2cYeFWVJWxE3OtXw1Kcvr8kzKpw9nE8pqYuGLwFSvGjKpCV6NOpUcVDEU7ykoWk+TEQU" +
                "uVXm25TpxlL+CSiiiv7yP1c7/wCE3g4fET4rfDH4fFio8cfEDwV4OLAkFR4l8Tadom4EEEEC9ByD" +
                "kccgnNf6hkEEFrBDa2sMVvbW8UcFvbwRpDBBBCgjhhhhjCpFFFGoSONAERAEUBRz/mafslxpL+1f" +
                "+zFFIoeOT9oD4KxurAFWRviZ4ZVlIOQQysQQcgg4ORnP+izrfwr8O2jyXtrpFi1qWDPELOA/ZiWf" +
                "JUGIkwkgYOcx7lViQVav47+lB7PE5rwZgsRjJ4aFPBZxWoxWHVaM6tfFYGnV5m8RSUJcuHo8id07" +
                "tKSk9fzbjuXNXy2m6jilSxEl7t03KpCLeskk7U1b5K93d+70wuBnHJ/Tv7/Tp7jPevnKDwP4cIJO" +
                "laeckbc2dt6uM/6o9t3fOdo55Na8HgbwwQc6Npxxg5+xW/8AtYP+pPXvnsQOcHP8rzyzCRv/AMKF" +
                "aVv+oKPmnvjdPhfr3e7/AD9042u6smu/J/nPTu/xbZ7gWxknr/Plv8/QgcYGa5bAJPXt+b/p0/DH" +
                "Q4ryq38A+FiWzoumEbQD/oNoMqd2OPI6HbyM/gc1ow/D7wkCP+JDpe4hjuOn2eeSw6+Rn8euDnOW" +
                "yOGph8DBS/22s2tn9Tiu/fGfq+j2uyOWmr++3a32Er/FbXnd9OW9tla+r173/P6n/E/nVa6gt7q2" +
                "uLO6ghuba6hlt7m2uIkmt7i3mSSOaCeGRWjlhmjLRyRSK0ckbSI6spIbkG+HvhEgk6Hpf1On2hOM" +
                "np+49cd/zycQf8K+8Ij5v7C0rgjn+z7QngtjH+j+38uSFNcqp4JarF101ZprCRWqbs7/AFy66u+r" +
                "Tv1vInTe+umy9dtfKP4dU7/5oPxR8In4ffFD4keASxY+CfHfjDwiWYksx8OeI9W0YsScklvsAJPX" +
                "J5z96ivQf2rY0g/ap/aZhjUKkXx8+M0aKoAVUj+JXipVVQAAAFIAAGAOAMCiv9dsrrTxWV5diar5" +
                "qmIwODrVJWtedWg5zdru15a216a3Vz+icPJzoUZyd5SpUpN924Tbe73t59Fd2u5/2SP+Tsv2Xv8A" +
                "s4P4J/8AqzvC9f6XRKEFTggggggkEcgggjBBycg56nrkk/5kv7OnifRPBH7Q/wABfGniS8XT/D/h" +
                "L4x/C3xPr2oOrsljomg+PND1XVLxkQM7LbWVpNOyoC5VAFBY1/pmWV5Z6lZ2mo6dd21/YX1tBeWN" +
                "9ZTxXNneWdzEk1td2lzBJJDcW1zC6TQTwu8UsTJJG7IwY/xt9K+NWOb8G1eSXspZfm1ONVxlyOpD" +
                "FYWUoKW3NGNSEnG90nB7b/m/H0f9oy6TUuX2NeKktrqqm1dq17O9t9t7mDqGkrA7T2ozCTlowD+5" +
                "JL5IBOTGcHA52EkEhcYrQALkZyeAe5GC4A64HvnsTznBPYYGCOx4I7Ec9R+J/M9cnONNYrCzSRD9" +
                "2Tll/ufM3T/ZPPX7oyM43V/K9PGznDkqS95W5ZapNXkrPX4tL36rS/Mry+AU1azvpa17u7TfZ9rW" +
                "vv1adxLcFhj+9gZ77cjqeeu3/wAeAxw2dOLA3sTxhVHvgn8+VP4e3JoxAgHuThRjp1wTyc4Ax9SR" +
                "yDk1bBCrgnp+py+cD/vn9MkkE1x1ZqTaT0W7+cvPyb+b6qRF3r/Vu2l/8/W5IWzn0H+LDJ56+3OP" +
                "XJya5bOfT/67cn8Py55zmgtnPp/9duT+H5c85zWffX9np1neahqF3bWGn2FtPeX19eTxW1nZ2dtH" +
                "LNc3d3czukNtbW8MbzTzzOkUUSvJK4RGauW7k+WKbu0kkm3JtySSW+ullve3xNEXvdLfRN9tWl1d" +
                "29Ulvfu1p/myftY/8nW/tOf9l/8AjR/6szxZRWB+0L4n0Xxt+0H8dvGfhy7F/wCH/Fvxg+J3ifQb" +
                "5UdFvdF13xz4i1XS7tUkCugubK7t5gjgOokCuAwIJX+weSwnSybKqVSEoVKeW4CFSE4uM4ThhlGU" +
                "JResZRlpKL1Urp6n9F4VOOGw6kmpKhRUk0001Tmmmnqmne6eqdk7vU8fr1/w1+0L+0F4L0az8OeD" +
                "vjr8X/CmgWClLDQvDXxO8caHo1kjMzslnpel69a2dsrOWcrDCoLMzEFiWYorrxGFwuLgqeKw1DEw" +
                "UlJQxFGnWgpJNKSjUjJKSWz3s2r7t6Tp06i5akITV72nGMldXSdpJq/nvq9Xq3u/8NW/tU/9HMfH" +
                "z/w83xJ/+aej/hq39qnp/wANMfHzH/ZZviT7/wDUzn+vU8nnJRXH/YuTf9CjLP8Awgwnl/068l+G" +
                "9tc/quG/6B6H/gmn5/3f6u9W7tt/4ar/AGp85/4aW+PWex/4XL8SM/8AqT/1/E0v/DVn7VH/AEcv" +
                "8e//AA8vxI/+aeiij+xMl/6FGWf+G/Cf/Kv67sPquF/6BqH/AIJp/wDyI3/hqn9qX/o5X48/+Hk+" +
                "I/8A809YXiT9oD4++M9Gu/DvjH44/FzxVoN+qpfaH4k+JnjbW9GvVR1dFu9M1TXbuzuVV1V1WaFw" +
                "rhWHzDdRRVwyjKaU4VKeV5fTqU5RnCcMDhYzhOLTjKEo0lKMotJxkndO1ndczaw+Hi040KKaaaap" +
                "U001s01G6a6a3XdvU8jooor0DY//2Q==";
        saveImage("1001", 1, imgBase64);
    }

    private void saveImage(String eId, int type, String imgBase64) {
        Date curDate = new Date();
        long timeMs = curDate.getTime();
        String timeDir = DateUtils.parseDateToStr(curDate, "yyyyMMdd");

        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replaceAll("-", "");
        String imgName = "IMG103_"+ eId +"_"+ type +"_"+ timeMs +"_"+ uuid +".jpg";

        String IMG_STORE_PATH = "/opt/file_store/images";
        IMG_STORE_PATH += File.separator + eId + File.separator + timeDir + File.separator +imgName;

        OutputStream out = null;
        try {
            File imgFile = new File(IMG_STORE_PATH);
            if(imgFile.exists()) {
                System.out.println("image is exists... FILE_PATH = "+ IMG_STORE_PATH);
                return;
            }

            byte[] imgByte = Base64.getDecoder().decode(imgBase64);

            File fileParent = imgFile.getParentFile();
            if(!fileParent.exists()){
                fileParent.mkdirs();
            }

            out = new FileOutputStream(imgFile);
            out.write(imgByte);
            out.flush();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if(out != null) {
                    out.close();
                    out = null;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    @Test
    public void testJsonMsg() {
        String msgBody = "{\"protocol\":103, \"code\": 0, \"data\": [{\"type\":1, \"count\":5, \"startTime\":\"2019-11-01 16:38:22\",\"endTime\":\"2019-11-01 16:38:30\"},{\"type\":2, \"count\":5, \"startTime\":\"2019-11-01 16:38:22\",\"endTime\":\"2019-11-01 16:38:30\"}]}";
        MsgPayload payload = JSON.parseObject(msgBody, MsgPayload.class);
        String dataStr = String.valueOf(payload.getData());
        Object dataBody = JSON.parseArray(dataStr, DataBody103.class);
        payload.setData(dataBody);

        List<DataBody103> dataList = (ArrayList<DataBody103>)payload.getData();
        System.out.println(" dataStr = " + dataStr);
    }
}
