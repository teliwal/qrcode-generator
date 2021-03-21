package com.rim.qrcodegenerator;

import com.google.zxing.WriterException;
import com.rim.qrcodegenerator.qrcode.models.UrlQrCodeRequest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.awt.image.BufferedImage;

@RestController
public class Controller {

    @GetMapping(value = "qrcode",produces = MediaType.IMAGE_PNG_VALUE)
    public ResponseEntity<BufferedImage> generate() throws WriterException {
        UrlQrCodeRequest urlQrCodeRequest = new UrlQrCodeRequest();
        urlQrCodeRequest.setUrl("https://www.google.fr");
        return null;
        //return ResponseEntity.ok(GeneratorB.generateWithUrl(urlQrCodeRequest));
    }

}
