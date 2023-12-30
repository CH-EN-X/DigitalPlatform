package com.dp.util;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 生成二维码工具类.
 *
 */
public class QrCodeUtils {

    //二维码宽度
    private static final int QRCODE_SIZE = 430;
    //编码
    private static final String CHARSET = "utf-8";
    // 二维码绘制高度偏移量，留出空间写文字描述二维码信息
    private static final int OFFSET_HEIGHT = 25;
    //二维码标题字体
    private static final String TITLE_FONT = "黑体";
    //标题前缀
    private static final String TITLE_PREFIX = "编号：";

    public static byte[] buildQrCodeImage(String content) throws IOException {

// 将 BufferedImage 转换为 ByteArrayOutputStream 流
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ImageIO.write(createImage(content), "png", baos);

// 将 ByteArrayOutputStream 流转换为字节数组
        return baos.toByteArray();
    }

    /**
     * 生成二维码.
     *
     * @param content 扫描成功的内容
     * @return 二维码图片
     */
    private static BufferedImage createImage(String content) {
        BitMatrix bitMatrix = null;
        try {
            bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, QRCODE_SIZE, QRCODE_SIZE);
        } catch (WriterException e) {
            System.out.println("生成二维码异常了");
            throw new RuntimeException("生成二维码信息异常，请稍后重试");
        }

        int width = bitMatrix.getWidth();
        int height = bitMatrix.getHeight();
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {
                image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
            }
        }
        System.out.println("生成二维码成功！");
        //直接返回生成的二维码
        return image;
    }
}