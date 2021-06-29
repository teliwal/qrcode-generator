package com.rim.qrcodegenerator.qrcode.models;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class QrCodeRequest {

    private RequestType type = RequestType.TEXT;

    private TextQrCodeRequest textQrCodeRequest = new TextQrCodeRequest();

    private UrlQrCodeRequest urlQrCodeRequest = new UrlQrCodeRequest();

    private VcardQrCodeRequest vcardQrCodeRequest = new VcardQrCodeRequest();

    private AppQrCodeRequest appQrCodeRequest = new AppQrCodeRequest();

}
