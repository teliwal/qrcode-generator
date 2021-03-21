package com.rim.qrcodegenerator.qrcode.generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.rim.qrcodegenerator.qrcode.QrCodeGenerationException;
import com.rim.qrcodegenerator.qrcode.models.QrCodeRequest;
import com.rim.qrcodegenerator.qrcode.models.UrlQrCodeRequest;
import com.rim.qrcodegenerator.qrcode.models.VcardQrCodeRequest;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.Map;

@Getter
@AllArgsConstructor
public class VcardBasedGenerator extends Generator {

    private VcardQrCodeRequest request;

    @Override
    public BufferedImage generateImage() throws WriterException {
        StringBuilder builder = new StringBuilder("BEGIN:VCARD\nVERSION:3.0\n");
        builder.append("N:" + request.getNom() + " " + request.getPrenom() + "\n");
        builder.append("TEL:" + request.getTelephone() + "\n");
        builder.append("ORG:" + request.getEntreprise() + "\n");
        builder.append("EMAIL:" + request.getEmail() + "\n");
        builder.append("URL:" + request.getSiteInternet() + "\n");
        builder.append("END:VCARD");
        Map<EncodeHintType, ErrorCorrectionLevel> encodingHints = new HashMap<>();
        encodingHints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.L);
        QRCodeWriter barcodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = barcodeWriter.encode(builder.toString(), BarcodeFormat.QR_CODE, 200, 200,
                encodingHints);
        return MatrixToImageWriter.toBufferedImage(bitMatrix);
    }
}
