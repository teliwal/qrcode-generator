package com.rim.qrcodegenerator.qrcode.models;

import lombok.*;

@Getter  @AllArgsConstructor @NoArgsConstructor
public class  QrCodeResponse {

    private String image;

    public boolean isGenerated(){
        return image != null;
    }
}
