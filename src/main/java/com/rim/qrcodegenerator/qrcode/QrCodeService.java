package com.rim.qrcodegenerator.qrcode;

import com.rim.qrcodegenerator.qrcode.generator.*;
import com.rim.qrcodegenerator.qrcode.models.*;
import org.springframework.stereotype.Service;

@Service
public class QrCodeService {

    public QrCodeResponse generateQrCode(QrCodeRequest qrCodeRequest) {
        Generator generator = GeneratorFactory.createGenerator(qrCodeRequest);
        return generator.generate();
    }
}
