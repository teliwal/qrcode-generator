package com.rim.qrcodegenerator.qrcode.generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.rim.qrcodegenerator.qrcode.models.AppQrCodeRequest;
import lombok.*;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Getter @AllArgsConstructor
public class AppBasedGenerator extends Generator{

    private AppQrCodeRequest request;

    @Override
    public BufferedImage generateImage() throws WriterException {
        Map<EncodeHintType, ErrorCorrectionLevel> encodingHints
                = new HashMap<>();
        encodingHints.put(EncodeHintType.ERROR_CORRECTION,
                ErrorCorrectionLevel.L);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix =
                barcodeWriter.encode(request.getAppUrl(), BarcodeFormat.QR_CODE, 200, 200,encodingHints);

        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
