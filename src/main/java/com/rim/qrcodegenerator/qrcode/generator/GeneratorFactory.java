package com.rim.qrcodegenerator.qrcode.generator;

import com.rim.qrcodegenerator.qrcode.QrCodeGenerationException;
import com.rim.qrcodegenerator.qrcode.models.QrCodeRequest;
import com.rim.qrcodegenerator.qrcode.models.RequestType;

public class GeneratorFactory {

    public static Generator createGenerator(QrCodeRequest qrCodeRequest){
        if(qrCodeRequest.getType() == RequestType.TEXT) {
            return new TextBasedGenerator(qrCodeRequest.getTextQrCodeRequest());
        }
        if(qrCodeRequest.getType() == RequestType.URL){
            return new UrlBasedGenerator(qrCodeRequest.getUrlQrCodeRequest());
        }
        if(qrCodeRequest.getType() == RequestType.VCARD){
            return new VcardBasedGenerator(qrCodeRequest.getVcardQrCodeRequest());
        }
        if(qrCodeRequest.getType() == RequestType.APP){
            return new AppBasedGenerator(qrCodeRequest.getAppQrCodeRequest());
        }
        throw new QrCodeGenerationException();
    }
}
