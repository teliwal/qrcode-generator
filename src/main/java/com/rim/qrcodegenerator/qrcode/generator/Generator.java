package com.rim.qrcodegenerator.qrcode.generator;

import com.google.zxing.WriterException;
import com.rim.qrcodegenerator.qrcode.QrCodeGenerationException;
import com.rim.qrcodegenerator.qrcode.models.QrCodeResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Base64;

public abstract class Generator {

    public QrCodeResponse generate(){
        try {
            BufferedImage bufferedImage = this.generateImage();
            return convertToBase64(bufferedImage);
        } catch (WriterException e) {
            throw new QrCodeGenerationException(e);
        }
    }

    public abstract BufferedImage generateImage() throws WriterException;

    private QrCodeResponse convertToBase64(BufferedImage bufferedImage){
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream();) {
            ImageIO.write(bufferedImage, "png", baos);
            baos.flush();
            byte[] imageInByte = baos.toByteArray();
            String image = Base64.getEncoder().encodeToString(imageInByte);
            return new QrCodeResponse(image);
        } catch (IOException e) {
            throw new QrCodeGenerationException(e);
        }
    }
}
